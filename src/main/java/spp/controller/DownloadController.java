package spp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spp.service.download.dto.generator.DownloadDtoGenerator;
import java.io.*;

import static spp.service.utils.CsvGenerationUtil.*;

/**
 * Created by admin on 01.05.2017.
 */

@RequestMapping("/download")
@RestController
public class DownloadController {

    private static final String APPLICATION_PDF = "application/pdf";
    public final static String TEXT_CSV = "text/csv";

    @Autowired
    private DownloadDtoGenerator generator;

    @RequestMapping(value = "/csv/vacancy/{id}", method = RequestMethod.GET,  produces = TEXT_CSV)
    public @ResponseBody
    byte[] downloadCsvVacancyById(@PathVariable("id") Long id) throws IOException {
        return generateVacanciesInCSV
                (generator.getVacancyDownloadDtoById(id))
                .toByteArray();
    }

    @RequestMapping(value = "/csv/user/{id}", method = RequestMethod.GET,  produces = TEXT_CSV)
    public @ResponseBody
    byte[] downloadCsvUserById(@PathVariable("id") Long id) throws IOException {
        return generateUserInCSV(generator
                        .getUserDownloadDtoById(id)
                ).toByteArray();
    }

    @RequestMapping(value = "/csv/project/{id}", method = RequestMethod.GET,  produces = TEXT_CSV)
    public @ResponseBody
    byte[] downloadCsvProjectById(@PathVariable("id") Long id) throws IOException {
        return generateProjectInCSV(generator
                        .getProjectDownloadDtoById(id)
                ).toByteArray();
    }

    @RequestMapping(value = "/csv/resume/{id}", method = RequestMethod.GET)
    public @ResponseBody
    byte[] downloadCsvResumeById(@PathVariable("id") Long id) throws IOException {
        return generateResumeInCSV(generator
                        .getResumeDownloadDtoById(id)
                ).toByteArray();
    }
}
