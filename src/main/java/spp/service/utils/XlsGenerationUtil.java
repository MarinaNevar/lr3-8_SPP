
package spp.service.utils;

import org.apache.poi.hssf.usermodel.*;
import spp.dto.download.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class XlsGenerationUtil {

    public static ByteArrayOutputStream generateVacanciesInXls(VacancyDownloadDto object) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("vacancy");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("ownerName"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("title"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("about"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("projectTitle"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("creationDate"));


        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue(object.getOwnerName());
        cell = row.createCell(1);
        cell.setCellValue(object.getTitle());
        cell = row.createCell(2);
        cell.setCellValue(object.getAbout());
        cell = row.createCell(3);
        cell.setCellValue(object.getProjectTitle());
        cell = row.createCell(4);
        cell.setCellValue(object.getCreationDate().toString());

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateResumeInXls(ResumeDownloadDto object) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Resume");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("title"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("creationDate"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("ownerName"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("about"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("expJson"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("skillsJson"));


        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue(object.getTitle());
        cell = row.createCell(1);
        cell.setCellValue(object.getCreationDate());
        cell = row.createCell(2);
        cell.setCellValue(object.getOwnerName());
        cell = row.createCell(3);
        cell.setCellValue(object.getAbout());
        cell = row.createCell(4);
        cell.setCellValue(object.getExpJson());
        cell = row.createCell(5);
        cell.setCellValue(object.getSkillsJson());

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateProjectInXls(ProjectDownloadDto object) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Project");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("title"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("about"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("ownerName"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("creationDate"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("vacancies"));

        List<VacancyDownloadDto> vacancy = object.getVacancies();

        for (int i = 0; i < vacancy.size(); i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0);
            cell.setCellValue(object.getTitle());
            cell = row.createCell(1);
            cell.setCellValue(object.getAbout());
            cell = row.createCell(2);
            cell.setCellValue(object.getOwnerName());
            cell = row.createCell(3);
            cell.setCellValue(object.getCreationDate());
            cell = row.createCell(4);
            cell.setCellValue(vacancy.get(i).toString());
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateUserInXls(UserDownloadDto object) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("User");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("userName"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("resumes"));

        List<ResumeDownloadDto> resumes = object.getResumes();

        for (int i = 0; i < resumes.size(); i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0);
            cell.setCellValue(object.getUserName());
            cell = row.createCell(1);
            cell.setCellValue(resumes.get(i).toString());
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }
}

