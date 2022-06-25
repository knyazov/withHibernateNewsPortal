package multilng.withhibernate.services.impl;

import multilng.withhibernate.entities.News;
import multilng.withhibernate.repositories.NewsRepository;
import multilng.withhibernate.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

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
}
