package multilng.withhibernate.repositories;

import multilng.withhibernate.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {

    //List<News> findNewsByPublication_id(Long id);

}
