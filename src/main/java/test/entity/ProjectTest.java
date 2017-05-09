package test.entity;

import org.junit.Test;
import spp.entity.Project;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by admin on 09.05.2017.
 */
public class ProjectTest {
    @Test
    public void setId() throws Exception {
        Project project = new Project();
        project.setId(1L);
        assertEquals(1L, project.getId());
    }

    @Test
    public void setOwnerId() throws Exception {
        Project project = new Project();
        project.setOwnerId(1L);
        assertEquals(1L, project.getOwnerId());
    }

    @Test
    public void setTitle() throws Exception {
        Project project = new Project();
        project.setTitle("Test");
        assertEquals("Test", project.getTitle());
    }

    @Test
    public void setAboutJson() throws Exception {
        Project project = new Project();
        project.setAboutJson("{test}");
        assertEquals("{test}", project.getAboutJson());
    }

    @Test
    public void setCreationDate() throws Exception {
        Project project = new Project();
        Date date = new Date();
        project.setCreationDate(date);
        assertEquals(date, project.getCreationDate());
    }

}