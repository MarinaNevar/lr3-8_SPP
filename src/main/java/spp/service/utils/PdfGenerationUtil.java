/*
package spp.service.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.apache.commons.lang3.StringUtils;
import spp.entity.Vacancy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

    synchronized static public ByteArrayOutputStream getVacancyDocument(Vacancy vacancy) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;

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
}
*/
