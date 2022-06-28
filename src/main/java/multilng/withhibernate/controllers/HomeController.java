package multilng.withhibernate.controllers;

import multilng.withhibernate.entities.News;
import multilng.withhibernate.entities.Publications;
import multilng.withhibernate.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private NewsService newsService;



    @GetMapping(value = "/")
    private String indexPage(Model model) {
        model.addAttribute("allPublications", newsService.getAllPublications());
        model.addAttribute("allNews", newsService.getAllNews());
        return "index";
    }

    @GetMapping(value = "/{id}")
    private String newsByPublication(Model model,
                                     @PathVariable Long id) {
        model.addAttribute("allPublications", newsService.getAllPublications());
        model.addAttribute("allNews", newsService.getNewsByPublicationId(id));
        return "index";
    }

    @GetMapping(value = "/addNews")
    private String addNewsGet(Model model) {
        List<Publications> publicationsList = newsService.getAllPublications();
        model.addAttribute("publications", publicationsList);
        return "addNews";
    }

    @PostMapping(value = "/addNews")
    private String addNewsPost(Model model,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "short_content") String short_content,
                           @RequestParam(name = "content") String content,
                           @RequestParam(name = "picture_url") String picture_url,
                           @RequestParam(name = "publication_id") Long id){
        if (newsService.isExist(id)){
            Publications publication = newsService.getPublication(id);
            News news = new News();
            news.setContent(content);
            news.setPicture_url(picture_url);
            news.setShort_content(short_content);
            news.setTitle(title);
            news.setPublications(publication);

            newsService.addNews(news);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    private String publicationsPage(@PathVariable Long id,
                                    Model model){
        model.addAttribute("allPublications", newsService.getAllPublications());
        model.addAttribute("getNewsByPub", newsService.getNewsById(id));
        return "newsByPublication";
    }
}
