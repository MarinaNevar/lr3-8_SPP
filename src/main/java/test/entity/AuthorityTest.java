package test.entity;

import org.junit.Test;
import spp.entity.Authority;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 09.05.2017.
 */
public class AuthorityTest {
    @Test
    public void setId() throws Exception {
        Authority authority = new Authority();
        authority.setId(1L);
        assertEquals(1L, authority.getId());
    }

    @Test
    public void setName() throws Exception {
        Authority authority = new Authority();
        authority.setName("Test");
        assertEquals("Test", authority.getName());
    }

}