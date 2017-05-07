package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.entity.Project;
import spp.repository.ProjectRepository;

import java.util.List;

/**
 * Created by admin on 07.05.2017.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }
}
