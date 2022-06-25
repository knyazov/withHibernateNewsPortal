package multilng.withhibernate.repositories;

import multilng.withhibernate.entities.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PublicationsRepository extends JpaRepository<Publications, Long> {

}
