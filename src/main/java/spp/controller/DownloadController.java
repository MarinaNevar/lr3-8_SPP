package spp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import spp.dto.UserDto;
import spp.service.download.dto.generator.DownloadDtoGenerator;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static spp.service.utils.CsvGenerationUtil.*;

/**
 * Created by admin on 01.05.2017.
 */

@RequestMapping("/download")
@RestController
public class DownloadController {

    private static final String APPLICATION_PDF = "application/pdf";

    @Autowired
    private DownloadDtoGenerator generator;

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

    @RequestMapping(value = "/csv/vacancy/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Resource downloadCsvVacancyById(@PathVariable("id") Long id) throws IOException {
        return new InputStreamResource(
                new ByteArrayInputStream(generateVacanciesInCSV(generator
                        .getVacancyDownloadDtoById(id)
                ).toByteArray()));
    }

    @RequestMapping(value = "/csv/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Resource downloadCsvUserById(@PathVariable("id") Long id) throws IOException {
        return new InputStreamResource(
                new ByteArrayInputStream(generateUserInCSV(generator
                        .getUserDownloadDtoById(id)
                ).toByteArray()));
    }

    @RequestMapping(value = "/csv/project/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Resource downloadCsvProjectById(@PathVariable("id") Long id) throws IOException {
        return new InputStreamResource(
                new ByteArrayInputStream(generateProjectInCSV(generator
                        .getProjectDownloadDtoById(id)
                ).toByteArray()));
    }

    @RequestMapping(value = "/csv/resume/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Resource downloadCsvResumeById(@PathVariable("id") Long id) throws IOException {
        return new InputStreamResource(
                new ByteArrayInputStream(generateResumeInCSV(generator
                        .getResumeDownloadDtoById(id)
                ).toByteArray()));
    }
}
