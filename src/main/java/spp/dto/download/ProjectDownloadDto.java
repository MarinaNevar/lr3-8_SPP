package spp.dto.download;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import spp.entity.Project;
import spp.entity.Vacancy;

import java.util.Collections;
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
    private String title = StringUtils.EMPTY;
    private String about  = StringUtils.EMPTY;
    private String ownerName = StringUtils.EMPTY;
    private Date creationDate = new Date();
    private List<VacancyDownloadDto> vacancies = Collections.EMPTY_LIST;

    public ProjectDownloadDto(String ownerName, Project project, List<VacancyDownloadDto> vacancies) {
        this.title = project.getTitle();
        this.about = project.getAboutJson();
        this.ownerName = ownerName;
        this.creationDate = project.getCreationDate();
        this.vacancies = vacancies;

    }
}
