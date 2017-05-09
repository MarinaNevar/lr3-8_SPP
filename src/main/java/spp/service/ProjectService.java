package spp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.entity.Project;
import spp.repository.ProjectRepository;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 07.05.2017.
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final UserService userService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getById(Long id) {
        return projectRepository.findById(id);
    }

    public List<Project> getAllByOwnerId(Long id) {
        return projectRepository.findAllByOwnerId(id);
    }

    public Project save(Project project, HttpSession httpSession) {
        project.setOwnerId(userService.getCurrentUser(httpSession).getId());
        project.setCreationDate(new Date());
        return projectRepository.save(project);
    }

    public void delete(Long id) {
       projectRepository.delete(id);
    }
}
