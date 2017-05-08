package spp.service.utils;


import au.com.bytecode.opencsv.CSVWriter;
import spp.dto.download.*;
;
import spp.entity.Vacancy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.*;

public class CsvGenerationUtil {

    public static ByteArrayOutputStream generateVacanciesInCSV(VacancyDownloadDto object) throws IOException {
        String[] fileHeader = null;
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
        String[] fileHeader = null;
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
        String[] fileHeader = null;
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
                object.getVacancies().toString()

        });
        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateUserInCSV(UserDownloadDto object) throws IOException {
        String[] fileHeader = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream, Charset.forName("cp1251"));
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<>();
        vacanciesInString.add(new String[]{
                object.getUserName(),
                object.getResumes().toString()

        });
        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }


}
