package spp.service.download.dto.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spp.dto.download.ProjectDownloadDto;
import spp.dto.download.ResumeDownloadDto;
import spp.dto.download.UserDownloadDto;
import spp.dto.download.VacancyDownloadDto;
import spp.entity.Project;
import spp.entity.Resume;
import spp.entity.User;
import spp.entity.Vacancy;
import spp.service.ProjectService;
import spp.service.ResumeService;
import spp.service.UserService;
import spp.service.VacancyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 07.05.2017.
 */
@Service
public class DownloadDtoGenerator {

    private final ProjectService projectService;

    private final VacancyService vacancyService;

    private final UserService userService;

    private final ResumeService resumeService;


    @Autowired
    public DownloadDtoGenerator(ProjectService projectService, VacancyService vacancyService, UserService userService, ResumeService resumeService) {
        this.projectService = projectService;
        this.vacancyService = vacancyService;
        this.userService = userService;
        this.resumeService = resumeService;
    }

    public ProjectDownloadDto getProjectDownloadDtoById(Long id) {
        Project project = projectService.getById(id);
        User user = userService.getOne(project.getOwnerId());
        List<VacancyDownloadDto> vdd = new ArrayList<>();
        vacancyService.getByOwnerId(id)
                .stream()
                .forEach(vacancy -> vdd.add(new VacancyDownloadDto(
                        user.getName(),
                        project.getTitle(),
                        vacancy)
                ));
        return new ProjectDownloadDto(user.getName(), project, vdd);
    }

    public UserDownloadDto getUserDownloadDtoById(Long id) {
        User user = userService.getOne(id);
        List<ResumeDownloadDto> rdd = new ArrayList<>();
        resumeService.getByOwnerId(id)
                .stream()
                .forEach(resume -> rdd.add(new ResumeDownloadDto(
                        user.getName(),
                        resume)
                ));
        return new UserDownloadDto(user.getName(), rdd);
    }

    public ResumeDownloadDto getResumeDownloadDtoById(Long id) {
        Resume resume = resumeService.getById(id);
        return new ResumeDownloadDto(
                userService
                        .getOne(resume.getOwnerId())
                        .getName(),
                resume
        );
    }

    public VacancyDownloadDto getVacancyDownloadDtoById(Long id) {
        Vacancy vacancy = vacancyService.getById(id);
        return new VacancyDownloadDto(
                userService
                        .getOne(vacancy.getOwnerId())
                        .getName(),
                projectService
                        .getById(vacancy.getProjectId())
                        .getTitle(),
                vacancy);
    }
}
