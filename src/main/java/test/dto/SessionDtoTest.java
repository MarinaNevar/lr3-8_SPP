package test.dto;

import org.junit.Test;
import spp.dto.SessionDto;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 09.05.2017.
 */
public class SessionDtoTest {
    @Test
    public void setName() throws Exception {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setName("test");
        assertEquals("test", sessionDto.getName());
    }

    @Test
    public void setBody() throws Exception {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setBody("test");
        assertEquals("test", sessionDto.getBody());
    }

}