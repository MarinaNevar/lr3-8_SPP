package spp.repository;

import spp.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findAllByOrderByCreationDateAsc();

    List<Resume> findAllByOwnerId(Long id);
}
