package multilng.withhibernate.controllers;

import multilng.withhibernate.services.NewsService;
import multilng.withhibernate.services.PublicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private PublicationsService publicationsService;

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/")
    private String indexPage(Model model) {
        model.addAttribute("allPublications", publicationsService.getAllPublications());
        model.addAttribute("allNews", newsService.getAllNews());
        return "index";
    }

    @GetMapping(value = "/{id}")
    private String publicationsPage(@PathVariable Long id,
                                    Model model){
        model.addAttribute("getNewsByPub", newsService.getNewsByPublication(id));
        return "redirect:/";
    }
}
