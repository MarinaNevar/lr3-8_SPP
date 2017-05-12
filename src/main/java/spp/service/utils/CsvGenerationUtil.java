package spp.service.utils;


import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.lang3.StringUtils;
import spp.dto.download.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CsvGenerationUtil {
    private CsvGenerationUtil() {}

    public static ByteArrayOutputStream generateVacanciesInCSV(VacancyDownloadDto object) throws IOException {
        String[] fileHeader = {"OwnerName", "Title", "About", "ProjectTitle","CreationDate"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream, Charset.forName("cp1251"));
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<>();
        vacanciesInString.add(new String[]{
                object.getOwnerName(),
                object.getTitle(),
                object.getAbout(),
                object.getProjectTitle(),
                object.getCreationDate().toString(),
                });
        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateResumeInCSV(ResumeDownloadDto object) throws IOException {
        String[] fileHeader = {"Title", "CreationDate", "OwnerName", "About","ExpJson","SkillsJson"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream, Charset.forName("cp1251"));
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<>();
        vacanciesInString.add(new String[]{
                object.getTitle(),
                object.getCreationDate().toString(),
                object.getOwnerName(),
                object.getAbout(),
                object.getExpJson(),
                object.getSkillsJson()
        });
        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateProjectInCSV(ProjectDownloadDto object) throws IOException {
        String[] fileHeader = {"Title", "CreationDate", "OwnerName", "About","Vacancies"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream, Charset.forName("cp1251"));
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<>();
        vacanciesInString.add(new String[]{
                Optional.ofNullable(object.getTitle())
                        .orElse(StringUtils.EMPTY),
                Optional.ofNullable(object.getCreationDate())
                        .map(Date::toString)
                        .orElse(StringUtils.EMPTY),
                Optional.ofNullable(object.getOwnerName())
                        .orElse(StringUtils.EMPTY),
                Optional.ofNullable(object.getAbout())
                        .orElse(StringUtils.EMPTY),
                Optional.ofNullable(object.getVacancies())
                        .map(List::toString)
                        .orElse(StringUtils.EMPTY)

        });
        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateUserInCSV(UserDownloadDto object) throws IOException {
        String[] fileHeader = {"UserName", "resumes"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream, Charset.forName("cp1251"));
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<>();
        String resumes = "";
        for (ResumeDownloadDto o: object.getResumes()) {
            resumes+=o.toString();
        }
        vacanciesInString.add(new String[]{
                object.getUserName(),
                resumes

        });
        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    //TODO generateStatisticInCSV


}
