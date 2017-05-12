package service.utils;

import com.itextpdf.text.DocumentException;
import org.junit.Before;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import spp.dto.download.ResumeDownloadDto;
import spp.dto.download.UserDownloadDto;
import spp.dto.download.VacancyDownloadDto;
import spp.entity.Vacancy;
import spp.service.utils.CsvGenerationUtil;
import spp.service.utils.PdfGenerationUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PdfGenerationUtilTest {
    static VacancyDownloadDto vacancyDownloadDto;
    static Vacancy vacancy ;
    private ByteArrayOutputStream stream;
    @BeforeClass
    public static void initialize(){
        vacancy = new Vacancy(1,1,"Java Junior","good",1,new Date());
        vacancyDownloadDto = new VacancyDownloadDto("dima","bank",vacancy);
    }

    @Before
    public void start(){
        stream = new ByteArrayOutputStream();
    }
    @Test
    public void PdfGenerationNotNullTest() throws IOException ,DocumentException{
        stream = PdfGenerationUtil.getVacancyDocument(vacancyDownloadDto);
        assertNotNull(stream);

    }
    @Test(expected = Exception.class)
    public void PdfGenerationTest() throws IOException ,DocumentException{
        stream = PdfGenerationUtil.getVacancyDocument(null);

    }
    @Test
    public void CreateFileVacancyPdf()throws Exception{

        File file=new File("csvVacancyTest.pdf");
        stream = PdfGenerationUtil.getVacancyDocument(vacancyDownloadDto);
        stream.writeTo(new FileOutputStream("csvVacancyTest.pdf"));
        assertTrue(file.exists());

    }

}
