package ua.com.alevel.view.controller.open;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.alevel.persistence.entity.user.Doctor;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.service.api.CovidApiStatisticsService;
import ua.com.alevel.service.user.DoctorCrudService;
import ua.com.alevel.service.vaccinationdetails.VaccinationCenterService;
import ua.com.alevel.service.vaccinationdetails.VaccineService;

import javax.servlet.Filter;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/open")
public class OpenController {

    private final CovidApiStatisticsService apiService;
    private final VaccinationCenterService vaccinationCenterService;
    private final DoctorCrudService doctorCrudService;
    private final VaccineService vaccineService;

    public OpenController(CovidApiStatisticsService apiService, VaccinationCenterService vaccinationCenterService, DoctorCrudService doctorCrudService, VaccineService vaccineService) {
        this.apiService = apiService;
        this.vaccinationCenterService = vaccinationCenterService;
        this.doctorCrudService = doctorCrudService;
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAllAttributes(apiService.getData());
        return "pages/open/dashboard_open";
    }

    @GetMapping("/centres")
    public String centresPage(Model model,
                              @RequestParam(value = "page", required = false) Integer pageNumber,
                              @RequestParam(value = "size", required = false) Integer pageSize,
                              @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        if (pageNumber == null) pageNumber = 1;
        if (pageSize == null) pageSize = 9;

        Page<VaccinationCenter> centres = vaccinationCenterService.getPage(pageNumber, pageSize);
        List<Vaccine> vaccineList = vaccineService.findAll();

        int[] pageSizeItems = new int[]{9, 18, 36, 72};
        int[] pageIndex = IntStream.range(1, centres.getTotalPages() + 1).toArray();

        long startCount = (long) centres.getNumber() * centres.getSize() + 1;
        long endCount = (long) (centres.getNumber() + 1) * centres.getSize();

        if (endCount > centres.getTotalElements()) {
            endCount = centres.getTotalElements();
        }

        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("totalItems", centres.getTotalElements());
        model.addAttribute("vaccines", vaccineList);

        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSizeItems", pageSizeItems);
        model.addAttribute("currentPage", centres.getNumber());
        model.addAttribute("currentSize", centres.getSize());
        model.addAttribute("centres", centres);
        model.addAttribute("totalPage", centres.getTotalPages());
        model.addAttribute("pageUrlPrefix", "/open/centres?page=");
        model.addAttribute("pageUrlPostfix", "&size=");

        return "pages/open/all_centers";
    }

    @GetMapping("centres/{id}")
    public String centersDetails(@PathVariable Long id, Model model,
                                 @RequestParam(value = "page", required = false) Integer pageNumber,
                                 @RequestParam(value = "size", required = false) Integer pageSize,
                                 @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        if (pageNumber == null) pageNumber = 1;
        if (pageSize == null) pageSize = 10;

        Optional<VaccinationCenter> vaccinationCenter = vaccinationCenterService.findById(id);
        //Page<Doctor> doctors = doctorCrudService.getPage(pageNumber, pageSize);
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

        model.addAttribute("pageUrlPrefix", "/open/centres/" + id + "?page=");
        model.addAttribute("pageUrlPostfix", "&size=");

        return "pages/open/centers_details";

    }


}
