package spp.dto.download;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
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
    private String ownerName = StringUtils.EMPTY;
    private String title = StringUtils.EMPTY;
    private String about = StringUtils.EMPTY;
    private String projectTitle = StringUtils.EMPTY;
    private Date creationDate = new Date();

    public VacancyDownloadDto(String ownerName, String projectTitle, Vacancy vacancy) {
        this.title = vacancy.getTitle();
        this.projectTitle = projectTitle;
        this.creationDate = vacancy.getCreationDate();
        this.ownerName = ownerName;
        this.about = vacancy.getAboutJson();

    }
}
