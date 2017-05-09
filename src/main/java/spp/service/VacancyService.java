package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.repository.VacancyRepository;
import spp.entity.Vacancy;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

import static com.google.common.primitives.UnsignedInts.min;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();
    }

    public List<Vacancy> getFiveLast() {
        List<Vacancy> vacancies = vacancyRepository.findAllByOrderByCreationDateAsc();
        return vacancies.subList(0, min(5, vacancies.size() - 1));
    }

    public List<Vacancy> getByOwnerId(Long id) {
        return vacancyRepository.findAllByOwnerId(id);
    }

    public Vacancy getById(Long id) {
        return vacancyRepository.findOne(id);
    }

    public Vacancy save(Vacancy vacancy, HttpSession httpSession) {
        vacancy.setOwnerId(userService.getCurrentUser(httpSession).getId());
        vacancy.setCreationDate(new Date());
        return vacancyRepository.save(vacancy);
    }

    public void delete(Long id) {
        vacancyRepository.delete(id);
    }
}
