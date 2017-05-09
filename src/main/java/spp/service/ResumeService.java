package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.entity.Vacancy;
import spp.repository.ResumeRepository;
import spp.entity.Resume;

import java.util.List;

import static com.google.common.primitives.UnsignedInts.min;

/**
 * Created by admin on 01.05.2017.
 */
@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public List<Resume> getAll() {
        return resumeRepository.findAll();
    }

    public List<Resume> getFiveLast() {
        List<Resume> resumes = resumeRepository.findAllByOrderByCreationDateAsc();
        return resumes.subList(0, min(5, resumes.size() - 1));
    }

    public List<Resume> getByOwnerId(Long id) {
        return resumeRepository.findAllByOwnerId(id);
    }

    public Resume getById(Long id) {
        return resumeRepository.findById(id);
    }

    public Resume save(Resume resume) {
        return resumeRepository.save(resume);
    }

    public void delete(Long id) {
        resumeRepository.delete(id);
    }
}
