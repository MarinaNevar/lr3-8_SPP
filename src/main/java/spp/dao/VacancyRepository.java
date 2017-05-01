package spp.dao;

import spp.domain.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> findAllByOrderByCreationDateAsc();
}
