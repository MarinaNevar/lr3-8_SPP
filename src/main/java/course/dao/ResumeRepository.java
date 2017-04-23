package course.dao;

import course.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 23.04.2017.
 */
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
