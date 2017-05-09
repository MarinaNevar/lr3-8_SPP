package test.dto;

import org.junit.Test;
import spp.dto.UserDto;
import static org.junit.Assert.assertEquals;



/**
 * Created by admin on 09.05.2017.
 */
public class UserDtoTest {
    @Test
    public void setId() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        assertEquals(1L, userDto.getId().longValue());
    }

    @Test
    public void setName() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setName("test");
        assertEquals("test", userDto.getName());
    }

    @Test
    public void setAuthorityId() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setAuthorityId(1L);
        assertEquals(1L, userDto.getAuthorityId().longValue());
    }

}