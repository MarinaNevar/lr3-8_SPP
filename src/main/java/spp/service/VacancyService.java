package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.repository.VacancyRepository;
import spp.entity.Vacancy;

import java.util.List;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();
    }

    public List<Vacancy> getFiveLast() {
        return vacancyRepository.findAllByOrderByCreationDateAsc();
    }

    public List<Vacancy> getByOwnerId(Long id) {
        return vacancyRepository.findAllByOwnerId(id);
    }

    public Vacancy getById(Long id) {
        return vacancyRepository.findOne(id);
    }
}
