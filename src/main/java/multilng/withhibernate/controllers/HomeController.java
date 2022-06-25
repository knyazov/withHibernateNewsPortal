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

    @GetMapping(value = "/{p_id}")
    private String indexPage(Model model,
                             @PathVariable Long p_id) {
        if (p_id != null) {
            model.addAttribute("allPublications", publicationsService.getAllPublications());
            model.addAttribute("newsByPublications", newsService.getNewsByPublication(p_id));
        } else {
            model.addAttribute("allPublications", publicationsService.getAllPublications());
            model.addAttribute("allNews", newsService.getAllNews());
        }
        return "index";
    }
}
