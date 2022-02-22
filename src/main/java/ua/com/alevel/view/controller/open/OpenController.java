package ua.com.alevel.view.controller.open;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.service.api.CovidApiStatisticsService;

@Controller
@RequestMapping("/open")
public class OpenController {

    private final CovidApiStatisticsService apiService;

    public OpenController(CovidApiStatisticsService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAllAttributes(apiService.getData());
        return "pages/open/dashboard_open";
    }

    @GetMapping("/vaccination/centres")
    public String vaccinationCentresAll(Model model) {
        model.addAllAttributes(apiService.getData());
        return "pages/open/vaccination_centers_open";
    }
}
