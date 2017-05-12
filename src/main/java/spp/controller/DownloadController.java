package spp.controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spp.service.download.dto.generator.DownloadDtoGenerator;
import java.io.*;

import static spp.service.utils.CsvGenerationUtil.*;
import static spp.service.utils.PdfGenerationUtil.*;
import static spp.service.utils.XlsGenerationUtil.*;

/**
 * Created by admin on 01.05.2017.
 */

@RequestMapping("/download")
@RestController
public class DownloadController {

    private static final String APPLICATION_PDF = "application/pdf";
    private final static String TEXT_CSV = "text/csv";
    private final static String APPLICATION_XLS = "application/vnd.ms-excel";

    private final DownloadDtoGenerator generator;

    @Autowired
    public DownloadController(DownloadDtoGenerator generator) {
        this.generator = generator;
    }

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

    @RequestMapping(value = "/csv/resume/{id}", method = RequestMethod.GET,  produces = TEXT_CSV)
    public @ResponseBody
    byte[] downloadCsvResumeById(@PathVariable("id") Long id) throws IOException {
        return generateResumeInCSV(generator
                        .getResumeDownloadDtoById(id)
                ).toByteArray();
    }

    @RequestMapping(value = "/pdf/vacancy/{id}", method = RequestMethod.GET,  produces = APPLICATION_PDF)
    public @ResponseBody
    byte[] downloadPdfVacancyById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return getVacancyDocument
                (generator.getVacancyDownloadDtoById(id))
                .toByteArray();
    }

    @RequestMapping(value = "/pdf/user/{id}", method = RequestMethod.GET,  produces = APPLICATION_PDF)
    public @ResponseBody
    byte[] downloadPdfUserById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return getUserDocument(generator
                .getUserDownloadDtoById(id)
        ).toByteArray();
    }

    @RequestMapping(value = "/pdf/project/{id}", method = RequestMethod.GET,  produces = APPLICATION_PDF)
    public @ResponseBody
    byte[] downloadPdfProjectById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return getProjectDocument(generator
                .getProjectDownloadDtoById(id)
        ).toByteArray();
    }

    @RequestMapping(value = "/pdf/resume/{id}", method = RequestMethod.GET,  produces = APPLICATION_PDF)
    public @ResponseBody
    byte[] downloadPdfResumeById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return getResumeDocument(generator
                .getResumeDownloadDtoById(id)
        ).toByteArray();
    }

    @RequestMapping(value = "/xls/vacancy/{id}", method = RequestMethod.GET,  produces = APPLICATION_XLS)
    public @ResponseBody
    byte[] downloadXlsVacancyById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return generateVacanciesInXls(generator.getVacancyDownloadDtoById(id))
                .toByteArray();
    }

    @RequestMapping(value = "/xls/user/{id}", method = RequestMethod.GET,  produces = APPLICATION_XLS)
    public @ResponseBody
    byte[] downloadXlsUserById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return generateUserInXls(generator
                .getUserDownloadDtoById(id)
        ).toByteArray();
    }

    @RequestMapping(value = "/xls/project/{id}", method = RequestMethod.GET,  produces = APPLICATION_XLS)
    public @ResponseBody
    byte[] downloadXlsProjectById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return generateProjectInXls(generator
                .getProjectDownloadDtoById(id)
        ).toByteArray();
    }

    @RequestMapping(value = "/xls/resume/{id}", method = RequestMethod.GET,  produces = APPLICATION_XLS)
    public @ResponseBody
    byte[] downloadXlsResumeById(@PathVariable("id") Long id) throws IOException, DocumentException {
        return generateResumeInXls(generator
                .getResumeDownloadDtoById(id)
        ).toByteArray();
    }
}
