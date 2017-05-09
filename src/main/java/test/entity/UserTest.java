package test.entity;

import org.junit.Test;
import spp.entity.User;

import static org.junit.Assert.*;

/**
 * Created by admin on 09.05.2017.
 */
public class UserTest {
    @Test
    public void setId() throws Exception {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    public void setName() throws Exception {
        User user = new User();
        user.setName("test");
        assertEquals("test", user.getName());
    }

    @Test
    public void setPassword() throws Exception {
        User user = new User();
        user.setPassword("test");
        assertEquals("test", user.getPassword());
    }

    @Test
    public void setAuthorityId() throws Exception {
        User user = new User();
        user.setAuthorityId(1L);
        assertEquals(1L, user.getAuthorityId());
    }

}