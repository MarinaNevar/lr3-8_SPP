package spp.dto.download;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
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
    private String title = StringUtils.EMPTY;
    private Date creationDate = new Date();
    private String ownerName = StringUtils.EMPTY;
    private String about = StringUtils.EMPTY;
    private String expJson = StringUtils.EMPTY;
    private String skillsJson = StringUtils.EMPTY;

    public ResumeDownloadDto(String ownerName, Resume resume) {
        this.title = resume.getTitle();
        this.creationDate = resume.getCreationDate();
        this.ownerName = ownerName;
        this.about = resume.getAbout();
        this.expJson = resume.getExpJson();
        this.skillsJson = resume.getSkillsJson();
    }

    @Override
    public String toString() {
        return "ResumeDownloadDto{" +
                "title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", ownerName='" + ownerName + '\'' +
                ", about='" + about + '\'' +
                ", expJson='" + expJson + '\'' +
                ", skillsJson='" + skillsJson + '\'' +
                '}';
    }
}
