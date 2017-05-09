package test.dto.download;

import org.junit.Test;
import spp.dto.download.ProjectDownloadDto;
import spp.entity.Project;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by admin on 09.05.2017.
 */
public class ProjectDownloadDtoTest {

    @Test
    public void setAbout() throws Exception {
        ProjectDownloadDto project = new ProjectDownloadDto();
        project.setAbout("Test");
        assertEquals("Test", project.getAbout());
    }

    @Test
    public void setOwnerName() throws Exception {
        ProjectDownloadDto project = new ProjectDownloadDto();
        project.setOwnerName("Test");
        assertEquals("Test", project.getOwnerName());
    }

    @Test
    public void setVacancies() throws Exception {
        ProjectDownloadDto project = new ProjectDownloadDto();
        project.setTitle("Test");
        assertEquals("Test", project.getTitle());
    }

    @Test
    public void setTitle() throws Exception {
        ProjectDownloadDto project = new ProjectDownloadDto();
        project.setTitle("Test");
        assertEquals("Test", project.getTitle());
    }

    @Test
    public void setCreationDate() throws Exception {
        ProjectDownloadDto project = new ProjectDownloadDto();
        Date date = new Date();
        project.setCreationDate(date);
        assertEquals(date, project.getCreationDate());
    }
}