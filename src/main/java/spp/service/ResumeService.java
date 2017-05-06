package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.repository.ResumeRepository;
import spp.entity.Resume;

import java.util.List;

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
        return resumeRepository.findAllByOrderByCreationDateAsc();
    }
}
