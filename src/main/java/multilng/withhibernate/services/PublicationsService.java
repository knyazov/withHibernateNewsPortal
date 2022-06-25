package multilng.withhibernate.services;

import multilng.withhibernate.entities.Publications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublicationsService {
    List<Publications> getAllPublications();
}
