package spp.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spp.dto.UserDto;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
@RequestMapping("/download")
public class DownloadController {

    private static final String APPLICATION_PDF = "application/pdf";


    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public @ResponseBody
    Resource downloadC(HttpServletResponse response) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);


        UserDto userDto = new UserDto("test", 1L);
        oos.writeObject(userDto);

        oos.flush();
        oos.close();

        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        response.setContentType(String.valueOf(APPLICATION_PDF));
        response.setHeader("Content-Disposition", "inline; filename=" + userDto.getName());
        return new InputStreamResource(is);
    }
}
