package multilng.withhibernate.services.impl;

import multilng.withhibernate.entities.News;
import multilng.withhibernate.entities.Publications;
import multilng.withhibernate.repositories.NewsRepository;
import multilng.withhibernate.repositories.PublicationsRepository;
import multilng.withhibernate.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private PublicationsRepository publicationsRepository;


    @Override
    public News addNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.getReferenceById(id);
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public boolean isExist(Long id) {
        return newsRepository.existsById(id);
    }

    @Override
    public List<Publications> getAllPublications() {
        return publicationsRepository.findAll();
    }

    @Override
    public Publications addPublication(Publications publication) {
        return publicationsRepository.save(publication);
    }

    @Override
    public Publications savePublication(Publications publication) {
        return publicationsRepository.save(publication);
    }

    @Override
    public Publications getPublication(Long id) {
        return publicationsRepository.getReferenceById(id);
    }
}
