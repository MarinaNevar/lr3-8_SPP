/*
package spp.service.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class PdfGenerationUtil {

    private static UserService userService = new UserService();
    private static VacancyService vacancyService = new VacancyService();
    private static ResumeService resumeService = new ResumeService();
    private EducationsService educationsService = new EducationsService();
    private WorkExperienceService workExperienceService = new WorkExperienceService();

    private static int FONT_SIZE_SMALL = 10;
    private static int FONT_SIZE_NORMAL = 14;
    private static int FONT_SIZE_BIG = 20;
    private static int VERTICAL_SPACE_TINY = 5;
    private static int VERTICAL_SPACE_SMALL = 20;
    private static int VERTICAL_SPACE_MEDIUM = 50;
    private static int VERTICAL_SPACE_BIG = 80;
    private static int HEIGHT_SMALL_LINE = FONT_SIZE_SMALL + 1;
    private static int HEIGHT_NORMAL_LINE = FONT_SIZE_NORMAL + VERTICAL_SPACE_TINY + 2;
    private static int HEIGHT_BIG_LINE = FONT_SIZE_NORMAL + VERTICAL_SPACE_TINY;

    private static final String TEMPLATE = "templates\\template.jpg";
    private static final String TEMPLATE_LANDSCAPE = "templates\\template-landscape.jpg";
    private static final String FONT = "fonts/times.ttf";

    private final static Font SMALL_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_SMALL);
    private final static Font NORMAL_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_NORMAL);
    private final static Font NORMAL_BOLD_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_NORMAL, Font.BOLD);
    private final static Font BIG_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_BIG, Font.BOLD);
    private final static Font BIG_BOLD_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_BIG + 2, Font.BOLD);

    synchronized static public ByteArrayOutputStream getResumeDocument(Resume resume) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;
        User user = resume.getEmployee();

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Resume"));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph(" ");
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(BIG_BOLD_FONT);
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        paragraph.add(new Chunk(user.getName() + " " + user.getSurname()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        paragraph.add(new Chunk(user.getContactInfo()));
        document.add(paragraph);

        document.add(new LineSeparator());
        paragraph = new Paragraph();
        paragraph.setFont(BIG_FONT);
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Summary"));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        paragraph.add(new Chunk(resume.getSummary()));
        document.add(paragraph);

        if (StringUtils.isNotBlank(resume.getDescription())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Description"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getDescription()));
            document.add(paragraph);
        }

        if (StringUtils.isNotBlank(resume.getSkills())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Skills"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getSkills()));
            document.add(paragraph);
        }

        if (StringUtils.isNotBlank(resume.getInterests())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Interests"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getInterests()));
            document.add(paragraph);
        }

        if (!resume.getEducations().isEmpty()) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Education"));
            document.add(paragraph);
            document.add(new LineSeparator());

            for (Education education : resume.getEducations()) {
                paragraph = new Paragraph();
                paragraph.setFont(NORMAL_BOLD_FONT);
                paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
                paragraph.add(new Chunk(education.getUniversity()));
                document.add(paragraph);

                paragraph = new Paragraph();
                paragraph.setFont(NORMAL_FONT);
                paragraph.add(new Chunk(StringUtils.capitalize(education.getDegree()) + " in " +
                        education.getSpecialty() + " field."));
                document.add(paragraph);

                paragraph = new Paragraph();
                paragraph.setFont(NORMAL_FONT);
                paragraph.add(new Chunk("From " + education.getStartDate() + " to " + education.getEndDate() + "."));
                if (StringUtils.isBlank(education.getDescription())) {
                    paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
                }
                document.add(paragraph);

                if (StringUtils.isNotBlank(education.getDescription())) {
                    paragraph = new Paragraph();
                    paragraph.setFont(NORMAL_FONT);
                    paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
                    paragraph.add(new Chunk(education.getDescription()));
                    document.add(paragraph);
                }
            }
        }

        if (!resume.getWorkExperiences().isEmpty()) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Work experience"));
            document.add(paragraph);
            document.add(new LineSeparator());

            for (WorkExperience workExperience : resume.getWorkExperiences()) {
                paragraph = new Paragraph();
                paragraph.setFont(NORMAL_BOLD_FONT);
                paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
                paragraph.add(new Chunk(workExperience.getCompanyName()));
                document.add(paragraph);

                paragraph = new Paragraph();
                paragraph.setFont(NORMAL_FONT);
                paragraph.add(new Chunk(StringUtils.capitalize(workExperience.getPosition())));
                document.add(paragraph);

                paragraph = new Paragraph();
                paragraph.setFont(NORMAL_FONT);
                paragraph.add(new Chunk("From " + workExperience.getStartDate() + " to " + workExperience.getEndDate() + "."));
                if (StringUtils.isBlank(workExperience.getDescription())) {
                    paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
                }
                document.add(paragraph);

                if (StringUtils.isNotBlank(workExperience.getDescription())) {
                    paragraph = new Paragraph();
                    paragraph.setFont(NORMAL_FONT);
                    paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
                    paragraph.add(new Chunk(workExperience.getDescription()));
                    document.add(paragraph);
                }
            }
        }

        if (StringUtils.isNotBlank(resume.getReferences())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("References"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(resume.getReferences()));
            document.add(paragraph);
        }

        document.add(new LineSeparator());
        document.close();
        return stream;
    }

    public static ByteArrayOutputStream getVacancyDocument(Vacancy vacancy) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;
        User user = vacancy.getEmployer();

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Vacancy"));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph(" ");
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(BIG_BOLD_FONT);
        paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
        paragraph.add(new Chunk(vacancy.getTitle()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.setSpacingAfter(VERTICAL_SPACE_MEDIUM);
        paragraph.add(new Chunk(vacancy.getSummary()));
        document.add(paragraph);

        if (StringUtils.isNotBlank(vacancy.getDescription())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Description"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(vacancy.getDescription()));
            document.add(paragraph);
        }

        if (StringUtils.isNotBlank(vacancy.getRequiredSkills())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Required skills"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(vacancy.getRequiredSkills()));
            document.add(paragraph);
        }

        if (StringUtils.isNotBlank(vacancy.getRequiredExperience())) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Required experience"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(vacancy.getRequiredExperience()));
            document.add(paragraph);
        }

        if (user.getContactInfo() != null) {
            document.add(new LineSeparator());
            paragraph = new Paragraph();
            paragraph.setFont(BIG_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
            paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
            paragraph.add(new Chunk("Contact info"));
            document.add(paragraph);
            document.add(new LineSeparator());

            paragraph = new Paragraph();
            paragraph.setFont(NORMAL_FONT);
            paragraph.setSpacingAfter(VERTICAL_SPACE_SMALL);
            paragraph.add(new Chunk(user.getContactInfo()));
            document.add(paragraph);
            document.add(new LineSeparator());
        }

        document.close();
        return stream;
    }

    public static ByteArrayOutputStream getUsersReport() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        Image image;
//        PdfContentByte canvas = writer.getDirectContentUnder();
//        Image image = Image.getInstance(ByteArrayOutputStream.class.getResource(TEMPLATE_LANDSCAPE));
//        image.scaleAbsolute(PageSize.A4.rotate());
//        image.setAbsolutePosition(0, 0);
//        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Users"));
        document.add(paragraph);
        document.add(new LineSeparator());

        PdfPTable table = new PdfPTable(8);
        table.setSpacingBefore(VERTICAL_SPACE_TINY);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.2f, 1.9f, 1.3f, 1, 1, 3, 3, 0.7f});
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell("N");
        table.addCell("Email");
        table.addCell("User type");
        table.addCell("Name");
        table.addCell("Surname");
        table.addCell("About");
        table.addCell("Contact info");
        table.addCell("Is admin");

        java.util.List<User> users = userService.getAllUsers();

        int i = 1;
        for (User user : users) {
            table.addCell(new Phrase(String.valueOf(i++), NORMAL_FONT));
            table.addCell(new Phrase(user.getEmail(), NORMAL_FONT));
            table.addCell(new Phrase(user.getUserType().toString(), NORMAL_FONT));
            table.addCell(new Phrase(user.getName(), NORMAL_FONT));
            table.addCell(new Phrase(user.getSurname(), NORMAL_FONT));
            if (StringUtils.isNotEmpty(user.getAbout())) {
                table.addCell(new Phrase(user.getAbout(), NORMAL_FONT));
            } else {
                table.addCell("");
            }
            if (StringUtils.isNotEmpty(user.getContactInfo())) {
                table.addCell(new Phrase(user.getContactInfo(), NORMAL_FONT));
            } else {
                table.addCell("");
            }
            table.addCell(String.valueOf(user.getIsAdmin()));
        }

        document.add(table);
        document.close();
        return stream;
    }

    public static ByteArrayOutputStream getResumesReport() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        Image image;
//        PdfContentByte canvas = writer.getDirectContentUnder();
//        Image image = Image.getInstance(ByteArrayOutputStream.class.getResource(TEMPLATE_LANDSCAPE));
//        image.scaleAbsolute(PageSize.A4.rotate());
//        image.setAbsolutePosition(0, 0);
//        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Resumes"));
        document.add(paragraph);
        document.add(new LineSeparator());

        PdfPTable table = new PdfPTable(6);
        table.setSpacingBefore(VERTICAL_SPACE_TINY);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.3f, 2.3f, 3f, 3f, 3f, 3f});
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell("N");
        table.addCell("Employee");
        table.addCell("Summary");
        table.addCell("Skills");
        table.addCell("Education");
        table.addCell("Work experience");

        java.util.List<Resume> resumes = resumeService.getAllResumes();

        int i = 1;
        for (Resume resume : resumes) {
            table.addCell(new Phrase(String.valueOf(i++), NORMAL_FONT));
            table.addCell(new Phrase(resume.getEmployee().getEmail(), NORMAL_FONT));
            table.addCell(new Phrase(resume.getSummary(), NORMAL_FONT));
            if (StringUtils.isNotEmpty(resume.getSkills())) {
                table.addCell(new Phrase(resume.getSkills(), NORMAL_FONT));
            } else {
                table.addCell("");
            }
            Iterator<Education> educationIterator = resume.getEducations().iterator();
            if (!educationIterator.hasNext()) {
                table.addCell("");
            } else {
                PdfPCell cell = new PdfPCell();
                while (educationIterator.hasNext()) {
                    Education education = educationIterator.next();
                    cell.addElement(new Phrase(education.getUniversity() + " - ", NORMAL_BOLD_FONT));
                    cell.addElement(new Phrase(education.getDegree() + " in " + education.getSpecialty(), NORMAL_FONT));
                    cell.addElement(new Phrase(" "));
                }
                table.addCell(cell);
            }
            Iterator<WorkExperience> workExperienceIterator = resume.getWorkExperiences().iterator();
            if (!workExperienceIterator.hasNext()) {
                table.addCell("");
            } else {
                PdfPCell cell = new PdfPCell();
                while (workExperienceIterator.hasNext()) {
                    WorkExperience workExperience = workExperienceIterator.next();
                    cell.addElement(new Phrase(workExperience.getCompanyName() + " - ", NORMAL_BOLD_FONT));
                    cell.addElement(new Phrase(workExperience.getPosition(), NORMAL_FONT));
                    cell.addElement(new Phrase(" "));
                }
                table.addCell(cell);
            }
        }

        document.add(table);
        document.close();
        return stream;
    }

    public static ByteArrayOutputStream getVacanciesReport() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        Image image;
//        PdfContentByte canvas = writer.getDirectContentUnder();
//        Image image = Image.getInstance(ByteArrayOutputStream.class.getResource(TEMPLATE_LANDSCAPE));
//        image.scaleAbsolute(PageSize.A4.rotate());
//        image.setAbsolutePosition(0, 0);
//        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Vacancies"));
        document.add(paragraph);
        document.add(new LineSeparator());

        PdfPTable table = new PdfPTable(7);
        table.setSpacingBefore(VERTICAL_SPACE_TINY);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.3f, 3f, 3f, 3f, 3f, 3f, 3f});
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell("N");
        table.addCell("Employer");
        table.addCell("Title");
        table.addCell("Summary");
        table.addCell("Salary");
        table.addCell("Required skills");
        table.addCell("Required experience");

        java.util.List<Vacancy> vacancies = vacancyService.getAllVacancies();

        int i = 1;
        for (Vacancy vacancy : vacancies) {
            table.addCell(new Phrase(String.valueOf(i++), NORMAL_FONT));
            table.addCell(new Phrase(vacancy.getEmployer().getEmail(), NORMAL_FONT));
            table.addCell(new Phrase(vacancy.getTitle(), NORMAL_FONT));
            table.addCell(new Phrase(vacancy.getSummary(), NORMAL_FONT));
            if (StringUtils.isNotBlank(vacancy.getSalary())) {
                table.addCell(new Phrase(vacancy.getSalary(), NORMAL_FONT));
            } else {
                table.addCell("");
            }
            if (StringUtils.isNotBlank(vacancy.getRequiredSkills())) {
                table.addCell(new Phrase(vacancy.getRequiredSkills(), NORMAL_FONT));
            } else {
                table.addCell("");
            }
            if (StringUtils.isNotBlank(vacancy.getRequiredExperience())) {
                table.addCell(new Phrase(vacancy.getRequiredExperience(), NORMAL_FONT));
            } else {
                table.addCell("");
            }
        }

        document.add(table);
        document.close();
        return stream;
    }

}
*/
