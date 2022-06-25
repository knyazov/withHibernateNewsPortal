package multilng.withhibernate.services;

import multilng.withhibernate.entities.News;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewsService {
    News addNews(News news);
    List<News> getAllNews();
    News getNewsById(Long id);
    void deleteNews(Long id);
    News saveNews(News news);
    boolean isExist(Long id);
}
