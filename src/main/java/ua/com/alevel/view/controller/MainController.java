package ua.com.alevel.view.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.persistence.entity.user.Admin;
import ua.com.alevel.persistence.entity.user.Doctor;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.persistence.repository.user.AdminRepository;
import ua.com.alevel.persistence.repository.user.DoctorRepository;
import ua.com.alevel.persistence.repository.user.PatientRepository;

@Controller
@AllArgsConstructor
@RequestMapping()
public class MainController {

    private final DoctorRepository doctorRepository;
    private final AdminRepository adminRepository;
    private final PatientRepository patientRepository;

    @GetMapping
    public String dashboard(Model model) {
        return redirectUser();
    }

    public String redirectUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        Doctor doctor = doctorRepository.findByEmail(userEmail);
        Admin admin = adminRepository.findByEmail(userEmail);
        Patient patient = patientRepository.findByEmail(userEmail);
        if (doctor != null) {
            return "redirect:/doctor/dashboard";
        } else if (admin != null) {
            return "redirect:/admin/dashboard";
        } else if (patient != null) {
            return "redirect:/patient/dashboard";
        }else {
            return "redirect:/open";
        }
    }
}
