
package spp.service.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import spp.dto.download.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PdfGenerationUtil {


    public static ByteArrayOutputStream getVacancyDocument(VacancyDownloadDto object) throws DocumentException, IOException {
            ByteArrayOutputStream stream= new ByteArrayOutputStream();;
        try {

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, stream);
            document.open();
            document.add(new Paragraph(CsvGenerationUtil.generateVacanciesInCSV(object).toString()));
            document.close();

        }
        catch (DocumentException e){
            Logger.getLogger(PdfGenerationUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stream;
    }

    public static ByteArrayOutputStream getResumeDocument(ResumeDownloadDto object) throws DocumentException, IOException {
            ByteArrayOutputStream stream= new ByteArrayOutputStream();;
        try {

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, stream);
            document.open();
            document.add(new Paragraph(CsvGenerationUtil.generateResumeInCSV(object).toString()));
            document.close();

        }
        catch (DocumentException e){
            Logger.getLogger(PdfGenerationUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stream;
    }

    public static ByteArrayOutputStream getProjectDocument(ProjectDownloadDto object) throws DocumentException, IOException {
            ByteArrayOutputStream stream= new ByteArrayOutputStream();;
        try {

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, stream);
            document.open();
            document.add(new Paragraph(CsvGenerationUtil.generateProjectInCSV(object).toString()));
            document.close();

        }
        catch (DocumentException e){
            Logger.getLogger(PdfGenerationUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stream;
    }

    public static ByteArrayOutputStream getUserDocument(UserDownloadDto object) throws DocumentException, IOException {
            ByteArrayOutputStream stream= new ByteArrayOutputStream();;
        try {

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, stream);
            document.open();
            document.add(new Paragraph(CsvGenerationUtil.generateUserInCSV(object).toString()));
            document.close();

        }
        catch (DocumentException e){
            Logger.getLogger(PdfGenerationUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stream;
    }

    //TODO getStatisticDocument



}
