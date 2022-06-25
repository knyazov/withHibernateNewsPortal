package multilng.withhibernate.services.impl;

import multilng.withhibernate.entities.Publications;
import multilng.withhibernate.repositories.PublicationsRepository;
import multilng.withhibernate.services.PublicationsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublicationsImpl implements PublicationsService {
    @Autowired
    private PublicationsRepository publicationsRepository;

    @Override
    public List<Publications> getAllPublications() {
        return publicationsRepository.findAll();
    }
}
