package service.utils;

/**
 * Created by Дмитрий Криволап on 10.05.2017.
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import spp.dto.download.ResumeDownloadDto;
import spp.dto.download.UserDownloadDto;
import spp.dto.download.VacancyDownloadDto;
import spp.entity.Vacancy;
import spp.service.utils.CsvGenerationUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CsvGenerationUtilTest {
    static Vacancy vacancy ;

    static List<ResumeDownloadDto> list  ;

    static VacancyDownloadDto vacancyDownloadDto;
    static ResumeDownloadDto rdto1,rdto2,rdto3;

    static UserDownloadDto userDownloadDto;

    private ByteArrayOutputStream stream;

    @BeforeClass
    public static void initialize(){

        list = new ArrayList<>();

        rdto1 = new ResumeDownloadDto("rdto1",new Date(),"rdto1","rdto1","rdto1","rdto1");
        rdto2 = new ResumeDownloadDto("rdto2",new Date(),"rdto2","rdto2","rdto2","rdto2");
        rdto3 = new ResumeDownloadDto("rdto3",new Date(),"rdto3","rdto3","rdto3","rdto3");

        list.add(rdto1);
        list.add(rdto2);
        list.add(rdto3);

        userDownloadDto = new UserDownloadDto("dima",list);

        vacancy = new Vacancy(1,1,"Java Junior","good",1,new Date());
        vacancyDownloadDto = new VacancyDownloadDto("dima","bank",vacancy);
    }

    @Before
    public void start(){
        stream = new ByteArrayOutputStream();
    }

    @Test
    public void CsvGenerationVacancyTest() throws  IOException{

        stream = CsvGenerationUtil.generateVacanciesInCSV(vacancyDownloadDto);
        String result = stream.toString();
        assertEquals("\"OwnerName\",\"Title\",\"About\",\"ProjectTitle\",\"CreationDate\"\n" +
                "\"dima\",\"Java Junior\",\"good\",\"bank\",\"Wed May 10 01:21:24 MSK 2017\"\n",result);

    }

    @Test
    public void CsvGenerationUserTest() throws IOException{
        stream = CsvGenerationUtil.generateUserInCSV(userDownloadDto);
        String result = stream.toString();
        assertEquals("\"UserName\",\"resumes\"\n" +
                "\"dima\",\"ResumeDownloadDto{title='rdto1', creationDate=Wed May 10 01:42:33 MSK 2017, ownerName='rdto1', about='rdto1', expJson='rdto1', skillsJson='rdto1'}ResumeDownloadDto{title='rdto2', creationDate=Wed May 10 01:42:33 MSK 2017, ownerName='rdto2', about='rdto2', expJson='rdto2', skillsJson='rdto2'}ResumeDownloadDto{title='rdto3', creationDate=Wed May 10 01:42:33 MSK 2017, ownerName='rdto3', about='rdto3', expJson='rdto3', skillsJson='rdto3'}\"\n",result);

    }

    @Test
    public void notNullVacancyTest() throws IOException{
        stream =CsvGenerationUtil.generateVacanciesInCSV(vacancyDownloadDto);
        assertNotNull(stream);

    }
    @Test
    public void notNullUserTest() throws IOException{
        stream =CsvGenerationUtil.generateUserInCSV(userDownloadDto);
        assertNotNull(stream);

    }
    @Test(expected = Exception.class)
    public void ExeptionTest()throws IOException{
        stream = CsvGenerationUtil.generateVacanciesInCSV(null);
    }
    @Test
    public void CreateFileUserCsv()throws IOException{

        File file=new File("csvUserTest.csv");
        stream =CsvGenerationUtil.generateUserInCSV(userDownloadDto);
        stream.writeTo(new FileOutputStream("csvUserTest.csv"));
        assertTrue(file.exists());

    }
    @Test
    public void CreateFileVacancyCsv()throws IOException{

        File file=new File("csvVacancyTest.csv");
        stream =CsvGenerationUtil.generateVacanciesInCSV(vacancyDownloadDto);
        stream.writeTo(new FileOutputStream("csvVacancyTest.csv"));
        assertTrue(file.exists());

    }


}
