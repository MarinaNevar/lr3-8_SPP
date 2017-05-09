package test.dto.download;

import org.junit.Test;
import spp.dto.download.ResumeDownloadDto;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 09.05.2017.
 */
public class ResumeDownloadDtoTest {

    @Test
    public void setExpJson() throws Exception {
        ResumeDownloadDto resume = new ResumeDownloadDto();
        resume.setExpJson("{test}");
        assertEquals("{test}", resume.getExpJson());
    }

    @Test
    public void setSkillsJson() throws Exception {
        ResumeDownloadDto resume = new ResumeDownloadDto();
        resume.setSkillsJson("{test}");
        assertEquals("{test}", resume.getSkillsJson());
    }


    @Test
    public void setOwnerName() throws Exception {
        ResumeDownloadDto resume = new ResumeDownloadDto();
        resume.setOwnerName("test");
        assertEquals("test", resume.getOwnerName());
    }

    @Test
    public void setTitle() throws Exception {
        ResumeDownloadDto resume = new ResumeDownloadDto();
        resume.setTitle("Test");
        assertEquals("Test", resume.getTitle());
    }

    @Test
    public void setAbout() throws Exception {
        ResumeDownloadDto resume = new ResumeDownloadDto();
        resume.setAbout("{test}");
        assertEquals("{test}", resume.getAbout());
    }

    @Test
    public void setCreationDate() throws Exception {
        ResumeDownloadDto resume = new ResumeDownloadDto();
        Date date = new Date();
        resume.setCreationDate(date);
        assertEquals(date, resume.getCreationDate());
    }

}