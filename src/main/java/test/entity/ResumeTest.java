package test.entity;

import org.junit.Test;
import spp.entity.Project;
import spp.entity.Resume;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by admin on 09.05.2017.
 */
public class ResumeTest {

    @Test
    public void setExpJson() throws Exception {
        Resume resume = new Resume();
        resume.setExpJson("{test}");
        assertEquals("{test}", resume.getExpJson());
    }

    @Test
    public void setSkillsJson() throws Exception {
        Resume resume = new Resume();
        resume.setSkillsJson("{test}");
        assertEquals("{test}", resume.getSkillsJson());
    }

    @Test
    public void setId() throws Exception {
        Resume resume = new Resume();
        resume.setId(1L);
        assertEquals(1L, resume.getId());
    }

    @Test
    public void setOwnerId() throws Exception {
        Resume resume = new Resume();
        resume.setOwnerId(1L);
        assertEquals(1L, resume.getOwnerId());
    }

    @Test
    public void setTitle() throws Exception {
        Resume resume = new Resume();
        resume.setTitle("Test");
        assertEquals("Test", resume.getTitle());
    }

    @Test
    public void setAbout() throws Exception {
        Resume resume = new Resume();
        resume.setAbout("{test}");
        assertEquals("{test}", resume.getAbout());
    }

    @Test
    public void setCreationDate() throws Exception {
        Resume resume = new Resume();
        Date date = new Date();
        resume.setCreationDate(date);
        assertEquals(date, resume.getCreationDate());
    }

}