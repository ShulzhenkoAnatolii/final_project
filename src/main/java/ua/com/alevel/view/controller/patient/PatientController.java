package ua.com.alevel.view.controller.patient;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.facade.user.PatientFacade;
import ua.com.alevel.facade.vaccinationdetails.RecordingFacade;
import ua.com.alevel.persistence.entity.user.Doctor;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.service.api.CovidApiStatisticsService;
import ua.com.alevel.service.user.DoctorCrudService;
import ua.com.alevel.service.user.PatientCrudService;
import ua.com.alevel.service.vaccinationdetails.VaccinationCenterService;
import ua.com.alevel.service.vaccinationdetails.VaccineService;
import ua.com.alevel.util.RecordTimeUtil;
import ua.com.alevel.view.dto.request.PatientDto;
import ua.com.alevel.view.dto.request.RecordDto;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private Patient currentPatient;
    private Long selectedClinicId;
    private Long selectedDoctorId;
    private Long selectedVaccineId;
    private List<Doctor> doctors;
    private List<Vaccine> vaccines;
    private String email;
    private static final LocalDate MIN_DATE = LocalDate.now().plusDays(1);
    private static final LocalDate MAX_DATE = LocalDate.now().plusWeeks(3);

    private final CovidApiStatisticsService apiService;
    private final VaccinationCenterService vaccinationCenterService;
    private final DoctorCrudService doctorCrudService;
    private final PatientCrudService patientCrudService;
    private final VaccineService vaccineService;
    private final PatientFacade patientFacade;
    private final RecordingFacade recordingFacade;

    public PatientController(CovidApiStatisticsService apiService, VaccinationCenterService vaccinationCenterService,
                             DoctorCrudService doctorCrudService, PatientCrudService patientCrudService, VaccineService vaccineService, PatientFacade patientFacade, RecordingFacade recordingFacade) {
        this.apiService = apiService;
        this.vaccinationCenterService = vaccinationCenterService;
        this.doctorCrudService = doctorCrudService;
        this.patientCrudService = patientCrudService;
        this.vaccineService = vaccineService;
        this.patientFacade = patientFacade;
        this.recordingFacade = recordingFacade;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAllAttributes(apiService.getData());
        return "pages/patient/patient_dashboard";
    }

    @GetMapping("/centres")
    public String centresPage(Model model, HttpServletRequest request,
                              @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNumber,
                              @RequestParam(value = "size", required = false, defaultValue = "9") Integer pageSize,
                              @RequestParam(value = "vaccine", required = false) List<Long> vaccinesParam
    ) {

        Page<VaccinationCenter> centres = vaccinationCenterService.getPage(pageNumber, pageSize, vaccinationCenterService.checkedVaccines(vaccinesParam));
        List<Vaccine> vaccineList = vaccineService.findAll();

        String vaccineParam;
        int[] pageSizeItems = new int[]{9, 18, 36, 72};
        int[] pageIndex = IntStream.range(1, centres.getTotalPages() + 1).toArray();
        long startCount = (long) centres.getNumber() * centres.getSize() + 1;
        long endCount = (long) (centres.getNumber() + 1) * centres.getSize();

        if (endCount > centres.getTotalElements()) {
            endCount = centres.getTotalElements();
        }
        if (vaccinesParam == null || vaccinesParam.isEmpty()) {
            vaccineParam = "";
        } else {
            vaccineParam = "&vaccines" + request.getParameter("vaccines");
        }

        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("vaccines", vaccineList);
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSizeItems", pageSizeItems);

        model.addAttribute("centres", centres);
        model.addAttribute("currentPage", centres.getNumber());
        model.addAttribute("currentSize", centres.getSize());
        model.addAttribute("totalItems", centres.getTotalElements());
        model.addAttribute("totalPage", centres.getTotalPages());

        model.addAttribute("pageUrlPrefix", "/patient/centres?page=");
        model.addAttribute("pageUrlPostfix", "&size=");
        model.addAttribute("url", "/patient/centres?page=1&size=" + pageSize);
        model.addAttribute("vaccineParam", vaccineParam);

        return "pages/patient/all_centers";
    }

    @GetMapping("centres/{id}")
    public String centersDetails(@PathVariable Long id, Model model,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") Integer pageNumber,
                                 @RequestParam(value = "size", required = false, defaultValue = "4") Integer pageSize) {

        Optional<VaccinationCenter> vaccinationCenter = vaccinationCenterService.findById(id);
        Page<Doctor> doctors = doctorCrudService.getDoctorsPageByVaccinationCenter(vaccinationCenter.get(), pageNumber, pageSize);

        int[] pageSizeItems = new int[]{10, 25, 50, 100};
        int[] pageIndex = IntStream.range(1, doctors.getTotalPages() + 1).toArray();

        long startCount = (long) doctors.getNumber() * doctors.getSize() + 1;
        long endCount = (long) (doctors.getNumber() + 1) * doctors.getSize();

        if (endCount > doctors.getTotalElements()) {
            endCount = doctors.getTotalElements();
        }

        if (vaccinationCenter.isPresent()) {
            model.addAttribute("vaccines", vaccinationCenter.get().getVaccines());
            model.addAttribute("address", vaccinationCenter.get().getAddress());
        }

        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSizeItems", pageSizeItems);

        model.addAttribute("totalItems", doctors.getTotalElements());
        model.addAttribute("doctors", doctors);
        model.addAttribute("currentPage", doctors.getNumber());
        model.addAttribute("currentSize", doctors.getSize());
        model.addAttribute("totalPage", doctors.getTotalPages());

        model.addAttribute("pageUrlPrefix", "/patient/centres/" + id + "?page=");
        model.addAttribute("pageUrlPostfix", "&size=");

        return "pages/patient/centers_details";
    }

    @GetMapping("/account")
    public String patientAccount(Model model) {
        Patient patient = patientCrudService.findByEmail(patientCrudService.getCurrentUser().getName());

        model.addAttribute("patient", patient);
        model.addAttribute("created", patient.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        model.addAttribute("patientCurrentAge", patientCrudService.getTheCurrentAgeOfThePatient(patient));

        return "pages/patient/patient_account";
    }

    @GetMapping("/account/edit")
    public String getPatientAccountEdit(Model model, @ModelAttribute PatientDto patientDto) {
        email = patientCrudService.getCurrentUser().getName();
        Patient patient = patientCrudService.findByEmail(email);

        model.addAttribute("patient", patient);

        return "pages/patient/patient_account_edit";
    }

    @PostMapping("/account/edit")
    public String patientAccountEdit(Model model, @ModelAttribute PatientDto patientDto) {
        patientFacade.update(patientDto, email);

        return "redirect:/patient/account";
    }

    @GetMapping("/recording")
    public String vaccinationRegistration(Model model, @ModelAttribute RecordDto recordForm) {
        currentPatient = patientFacade.findByEmail(patientCrudService.getCurrentUser().getName());
        List<VaccinationCenter> clinics = vaccinationCenterService.findAll();
        List<LocalTime> timetable = RecordTimeUtil.init();
        model.addAttribute("patient", currentPatient);
        model.addAttribute("timeList", timetable);
        model.addAttribute("vaccines", vaccines);
        model.addAttribute("doctors", doctors);
        model.addAttribute("clinics", clinics);
        model.addAttribute("selectedClinicId", selectedClinicId);
        model.addAttribute("selectedDoctorId", selectedDoctorId);
        model.addAttribute("selectedVaccineId", selectedVaccineId);
        model.addAttribute("MIN_DATE", MIN_DATE);
        model.addAttribute("MAX_DATE", MAX_DATE);
        model.addAttribute("created", currentPatient.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        model.addAttribute("updated", currentPatient.getUpdated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return "pages/patient/patient_recording";
    }

    @PostMapping("/recording/create")
    public String createRecord(@ModelAttribute RecordDto recordForm) {
        recordForm.setPatientId(currentPatient.getId());
        recordForm.setDoctorId(selectedDoctorId);
        recordForm.setVaccineId(selectedVaccineId);
        recordForm.setVaccinationCenterId(selectedClinicId);
        recordingFacade.create(recordForm);
        return "redirect:/patient/recording";
    }

    @PostMapping("/recording/update")
    public String updateRecording(@RequestParam(value = "selectedClinicId", required = false) Long clinicId,
                                  @RequestParam(value = "selectedDoctorId", required = false) Long doctorId,
                                  @RequestParam(value = "selectedVaccineId", required = false) Long vaccineId
    ) {
        selectedClinicId = clinicId;
        selectedDoctorId = doctorId;
        selectedVaccineId = vaccineId;
        vaccinationCenterService.findById(selectedClinicId).ifPresentOrElse((clinic) -> {
            doctors = clinic.getDoctors();
            vaccines = clinic.getVaccines();
        }, () -> {
            doctors = null;
            vaccines = null;
        });
        return "redirect:/patient/recording";
    }

}
