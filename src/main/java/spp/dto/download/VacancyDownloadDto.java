package spp.dto.download;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spp.entity.Vacancy;

import java.util.Date;

/**
 * Created by admin on 07.05.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancyDownloadDto {
    private String ownerName;
    private String title;
    private String about;
    private String projectTitle;
    private Date creationDate;

    public VacancyDownloadDto(String ownerName, String projectTitle, Vacancy vacancy) {
        this.title = vacancy.getTitle();
        this.projectTitle = projectTitle;
        this.creationDate = vacancy.getCreationDate();
        this.ownerName = ownerName;
        this.about = vacancy.getAboutJson();

    }
}
