package test.dto.download;

import org.junit.Test;
import spp.dto.download.UserDownloadDto;

import static org.junit.Assert.*;

/**
 * Created by admin on 09.05.2017.
 */
public class UserDownloadDtoTest {
    @Test
    public void setUserName() throws Exception {
        UserDownloadDto userDownloadDto =  new UserDownloadDto();
        userDownloadDto.setUserName("test");
        assertEquals("test", userDownloadDto.getUserName());
    }

    @Test
    public void setResumes() throws Exception {
        UserDownloadDto userDownloadDto =  new UserDownloadDto();
        userDownloadDto.setUserName("test");
        assertEquals("test", userDownloadDto.getUserName());
    }

}