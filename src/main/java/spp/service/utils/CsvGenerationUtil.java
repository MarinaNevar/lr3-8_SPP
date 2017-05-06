package spp.service.utils;


import au.com.bytecode.opencsv.CSVWriter;
import spp.entity.Vacancy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.*;

public class CsvGenerationUtil {

    public static ByteArrayOutputStream generateVacanciesInCSV(Vacancy vacancy) throws IOException {
        String[] fileHeader = {"N", "CreationDate", "Title", "Text"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream, Charset.forName("cp1251"));
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<>();
        vacanciesInString.add(new String[]{
                Long.toString(vacancy.getId()),
                vacancy.getCreationDate().toString(),
                vacancy.getTitle(),
                vacancy.getAboutJson()});

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }
}
