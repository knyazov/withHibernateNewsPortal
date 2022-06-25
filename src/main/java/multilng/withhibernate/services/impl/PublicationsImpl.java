package multilng.withhibernate.services.impl;

import multilng.withhibernate.entities.Publications;
import multilng.withhibernate.repositories.PublicationsRepository;
import multilng.withhibernate.services.PublicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationsImpl implements PublicationsService {
    @Autowired
    private PublicationsRepository publicationsRepository;

    @Override
    public List<Publications> getAllPublications() {
        return publicationsRepository.findAll();
    }
}
