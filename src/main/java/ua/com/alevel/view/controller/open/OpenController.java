package ua.com.alevel.view.controller.open;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/open")
public class OpenController {

    @GetMapping
    public String dashboard(Model model) {
        return "pages/open/dashboard_open";
    }
}
