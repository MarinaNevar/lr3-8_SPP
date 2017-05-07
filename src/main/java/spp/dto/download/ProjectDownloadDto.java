package spp.dto.download;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spp.entity.Project;
import spp.entity.Vacancy;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 07.05.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDownloadDto {
    private String title;
    private String about;
    private String ownerName;
    private Date creationDate;
    private List<VacancyDownloadDto> vacancies;

    public ProjectDownloadDto(String ownerName, Project project, List<VacancyDownloadDto> vacancies) {
        this.title = project.getTitle();
        this.about = project.getAboutJson();
        this.ownerName = ownerName;
        this.creationDate = project.getCreationDate();
        this.vacancies = vacancies;

    }
}
