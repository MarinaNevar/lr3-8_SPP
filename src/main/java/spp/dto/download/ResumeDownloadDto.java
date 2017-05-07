package spp.dto.download;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spp.entity.Resume;
import spp.entity.Vacancy;

import java.util.Date;

/**
 * Created by admin on 07.05.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDownloadDto {
    private String title;
    private Date creationDate;
    private String ownerName;
    private String about;
    private String expJson;
    private String skillsJson;

    public ResumeDownloadDto(String ownerName, Resume resume) {
        this.title = resume.getTitle();
        this.creationDate = resume.getCreationDate();
        this.ownerName = ownerName;
        this.about = resume.getAbout();
        this.expJson = resume.getExpJson();
        this.skillsJson = resume.getSkillsJson();
    }
}
