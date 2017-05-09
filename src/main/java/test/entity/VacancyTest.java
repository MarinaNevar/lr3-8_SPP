package test.entity;

import org.junit.Test;
import spp.entity.Project;
import spp.entity.Vacancy;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by admin on 09.05.2017.
 */
public class VacancyTest {

    @Test
    public void setProjectId() throws Exception {
        Vacancy vacancy = new Vacancy();
        vacancy.setProjectId(1L);
        assertEquals(1L, vacancy.getProjectId());
    }


    @Test
    public void setId() throws Exception {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(1L);
        assertEquals(1L, vacancy.getId());
    }

    @Test
    public void setOwnerId() throws Exception {
        Vacancy vacancy = new Vacancy();
        vacancy.setOwnerId(1L);
        assertEquals(1L, vacancy.getOwnerId());
    }

    @Test
    public void setTitle() throws Exception {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle("Test");
        assertEquals("Test", vacancy.getTitle());
    }

    @Test
    public void setAboutJson() throws Exception {
        Vacancy vacancy = new Vacancy();
        vacancy.setAboutJson("{test}");
        assertEquals("{test}", vacancy.getAboutJson());
    }

    @Test
    public void setCreationDate() throws Exception {
        Vacancy vacancy = new Vacancy();
        Date date = new Date();
        vacancy.setCreationDate(date);
        assertEquals(date, vacancy.getCreationDate());
    }

}