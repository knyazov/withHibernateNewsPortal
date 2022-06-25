package multilng.withhibernate.controllers;

import multilng.withhibernate.services.PublicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PublicationsService publicationsService;


    @GetMapping(value = "/")
    private String indexPage(Model model){
        model.addAttribute("allPublications", publicationsService.getAllPublications());
        return "index";
    }
}
