package test.entity;

import org.junit.Test;
import spp.entity.Responded;

import static org.junit.Assert.*;

/**
 * Created by admin on 09.05.2017.
 */
public class RespondedTest {
    @Test
    public void setId() throws Exception {
        Responded responded = new Responded();
        responded.setId(1L);
        assertEquals(1L, responded.getId());
    }

    @Test
    public void setProjectId() throws Exception {
        Responded responded = new Responded();
        responded.setProjectId(1L);
        assertEquals(1L, responded.getProjectId());
    }

    @Test
    public void setVacancyId() throws Exception {
        Responded responded = new Responded();
        responded.setVacancyId(1L);
        assertEquals(1L, responded.getVacancyId());
    }

    @Test
    public void setUserId() throws Exception {
        Responded responded = new Responded();
        responded.setUserId(1L);
        assertEquals(1L, responded.getUserId());
    }

    @Test
    public void setResumeId() throws Exception {
        Responded responded = new Responded();
        responded.setResumeId(1L);
        assertEquals(1L, responded.getResumeId());
    }

}