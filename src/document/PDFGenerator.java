package document;

import bean.Certificate;
import bean.Course;
import bean.User;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Антон on 04.05.2016.
 */
public class PDFGenerator implements DocumentGenerator {
    private static final int PRICELIST_COLUMNS_COUNT = 4;
    private static final int STUDENTLIST_COLUMNS_COUNT = 5;
    private static final int LECTURERLIST_COLUMNS_COUNT = 5;
    private static String IMAGE_PATH = "G:\\Univer\\LearngSite\\src\\resources\\portal.png";
    private static BaseFont BASE_FONT;

    private static final PDFGenerator instance = new PDFGenerator();

    private PDFGenerator() {
        try {
            BASE_FONT = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static PDFGenerator getInstance(){return instance;}

    public  void generatePriceList(OutputStream outputStream, List<Course> courseList){

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            document.open();

            Paragraph title = new Paragraph("Pricelist of courses of Learning Site:");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(PRICELIST_COLUMNS_COUNT);

            PdfPCell indexTitleCell = new PdfPCell(Phrase.getInstance(10, "№", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell nameCourseTitleCell = new PdfPCell(Phrase.getInstance(10, "Course name", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell technologyTitleCell = new PdfPCell(Phrase.getInstance(10, "Technology", new Font(BASE_FONT, Font.DEFAULTSIZE,Font.BOLD)));
            PdfPCell priceTitleCell = new PdfPCell(Phrase.getInstance(10, "Price", new Font(BASE_FONT,  Font.DEFAULTSIZE, Font.BOLD )));

            table.addCell(indexTitleCell);
            table.addCell(nameCourseTitleCell);
            table.addCell(technologyTitleCell);
            table.addCell(priceTitleCell);

            int index = 0;

            for(Course course : courseList) {
                PdfPCell indexCell = new PdfPCell(Phrase.getInstance(String.valueOf(++index)));
                PdfPCell courseNameCell = new PdfPCell(Phrase.getInstance(course.getName()));
                PdfPCell technologyCell = new PdfPCell(Phrase.getInstance(course.getTechnology()));
                PdfPCell priceCell = new PdfPCell(Phrase.getInstance(String.valueOf(course.getPrice())));
                table.addCell(indexCell);
                table.addCell(courseNameCell);
                table.addCell(technologyCell);
                table.addCell(priceCell);
            }
            document.add(table);

            PdfContentByte canvas = writer.getDirectContentUnder();
            Image image = null;
            try {
                image = Image.getInstance(IMAGE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image != null) {
                image.scaleAbsolute(PageSize.A4.getWidth(), PageSize.A4.getHeight());
                image.setAbsolutePosition(0, 0);
                canvas.saveState();
                PdfGState pdfGState = new PdfGState();
                pdfGState.setFillOpacity(0.2f);
                canvas.setGState(pdfGState);
                canvas.addImage(image);
                canvas.restoreState();
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateListOfStudents(OutputStream outputStream,  List<User> studentList) {

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            document.open();

            Paragraph title = new Paragraph("List of students:");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(STUDENTLIST_COLUMNS_COUNT);

            PdfPCell indexTitleCell = new PdfPCell(Phrase.getInstance(10, "№", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell nameStudentTitleCell = new PdfPCell(Phrase.getInstance(10, "Name", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell surnameStudentTitleCell = new PdfPCell(Phrase.getInstance(10, "Surname", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell phoneStudentTitleCell = new PdfPCell(Phrase.getInstance(10, "Phone", new Font(BASE_FONT, Font.DEFAULTSIZE,Font.BOLD)));
            PdfPCell emailStudentTitleCell = new PdfPCell(Phrase.getInstance(10, "Email", new Font(BASE_FONT,  Font.DEFAULTSIZE, Font.BOLD )));

            table.addCell(indexTitleCell);
            table.addCell(nameStudentTitleCell);
            table.addCell(surnameStudentTitleCell);
            table.addCell(phoneStudentTitleCell);
            table.addCell(emailStudentTitleCell);

            int index = 0;

            for(User student : studentList) {
                PdfPCell indexCell = new PdfPCell(Phrase.getInstance(String.valueOf(++index)));
                PdfPCell studentNameCell = new PdfPCell(Phrase.getInstance(student.getName()));
                PdfPCell studentSurnameCell = new PdfPCell(Phrase.getInstance(student.getSurname()));
                PdfPCell studentPhoneCell = new PdfPCell(Phrase.getInstance(student.getPhone()));
                PdfPCell studentEmailCell = new PdfPCell(Phrase.getInstance(student.getEmail()));
                table.addCell(indexCell);
                table.addCell(studentNameCell);
                table.addCell(studentSurnameCell);
                table.addCell(studentPhoneCell);
                table.addCell(studentEmailCell);
            }
            document.add(table);

            PdfContentByte canvas = writer.getDirectContentUnder();
            Image image = null;
            try {
                image = Image.getInstance(IMAGE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image != null) {
                image.scaleAbsolute(PageSize.A4.getWidth(), PageSize.A4.getHeight());
                image.setAbsolutePosition(0, 0);
                canvas.saveState();
                PdfGState pdfGState = new PdfGState();
                pdfGState.setFillOpacity(0.2f);
                canvas.setGState(pdfGState);
                canvas.addImage(image);
                canvas.restoreState();
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateCertificate(OutputStream outputStream, Certificate certificate) {
        Document document = new Document();
        try{
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(Chunk.NEWLINE);
            Paragraph title =  new Paragraph("Certificate");
            title.setAlignment(Element.ALIGN_CENTER);
            title.setFont(new Font(BASE_FONT,20, Font.BOLD));
            document.add(title);
            Phrase data = new Phrase("For student " + certificate.getStudent().getName() + " " + certificate.getStudent().getSurname() + ". He successfully finished course " + certificate.getCourse().getName() + " on technology " + certificate.getCourse().getTechnology() + ". " + certificate.getData());
            document.add(data);
            Paragraph date = new Paragraph(certificate.getDate().toString());
            date.setAlignment(Element.ALIGN_RIGHT);
            document.add(date);
            Paragraph logo = new Paragraph("Learning site 2016");
            logo.setAlignment(Element.ALIGN_BOTTOM);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);



            PdfContentByte canvas = writer.getDirectContentUnder();
            Image image = null;
            try {
                image = Image.getInstance(IMAGE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image != null) {
                image.scaleAbsolute(PageSize.A4.getWidth(), PageSize.A4.getHeight());
                image.setAbsolutePosition(0, 0);
                canvas.saveState();
                PdfGState pdfGState = new PdfGState();
                pdfGState.setFillOpacity(0.2f);
                canvas.setGState(pdfGState);
                canvas.addImage(image);
                canvas.restoreState();
            }
            document.close();
        }catch (DocumentException e){
            e.printStackTrace();
        }

    }

    @Override
    public void generateRecommendation(OutputStream outputStream,User student) {
        Document document = new Document();
        try{
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            Paragraph title =  new Paragraph("Recomendation");
            title.setAlignment(Element.ALIGN_CENTER);
            title.setFont(new Font(BASE_FONT, 20, Font.BOLD));
            document.add(title);
            document.add(Chunk.NEWLINE);
            Phrase data = new Phrase("For student " + student.getName() + " " + student.getSurname() + ". He is learning programming on Learning site. He is very good student.");
            document.add(data);
            Paragraph logo = new Paragraph("Learning site 2016");
            logo.setAlignment(Element.ALIGN_BOTTOM);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);

            PdfContentByte canvas = writer.getDirectContentUnder();
            Image image = null;
            try {
                image = Image.getInstance(IMAGE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image != null) {
                image.scaleAbsolute(PageSize.A4.getWidth(), PageSize.A4.getHeight());
                image.setAbsolutePosition(0, 0);
                canvas.saveState();
                PdfGState pdfGState = new PdfGState();
                pdfGState.setFillOpacity(0.2f);
                canvas.setGState(pdfGState);
                canvas.addImage(image);
                canvas.restoreState();
            }
            document.close();
        }catch (DocumentException e){
            e.printStackTrace();
        }
    }

    @Override
    public void generateListOfLecturers(OutputStream outputStream, List<User> lecturerList) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            document.open();

            Paragraph title = new Paragraph("List of lecturers:");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(LECTURERLIST_COLUMNS_COUNT);

            PdfPCell indexTitleCell = new PdfPCell(Phrase.getInstance(10, "№", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell nameLecturerTitleCell = new PdfPCell(Phrase.getInstance(10, "Name", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell surnameLecturerTitleCell = new PdfPCell(Phrase.getInstance(10, "Surname", new Font(BASE_FONT, Font.DEFAULTSIZE, Font.BOLD)));
            PdfPCell phoneLecturerTitleCell = new PdfPCell(Phrase.getInstance(10, "Phone", new Font(BASE_FONT, Font.DEFAULTSIZE,Font.BOLD)));
            PdfPCell emailLecturerTitleCell = new PdfPCell(Phrase.getInstance(10, "Email", new Font(BASE_FONT,  Font.DEFAULTSIZE, Font.BOLD )));

            table.addCell(indexTitleCell);
            table.addCell(nameLecturerTitleCell);
            table.addCell(surnameLecturerTitleCell);
            table.addCell(phoneLecturerTitleCell);
            table.addCell(emailLecturerTitleCell);

            int index = 0;

            for(User lecturer : lecturerList) {
                PdfPCell indexCell = new PdfPCell(Phrase.getInstance(String.valueOf(++index)));
                PdfPCell lecturerNameCell = new PdfPCell(Phrase.getInstance(lecturer.getName()));
                PdfPCell lecturerSurnameCell = new PdfPCell(Phrase.getInstance(lecturer.getSurname()));
                PdfPCell lecturerPhoneCell = new PdfPCell(Phrase.getInstance(lecturer.getPhone()));
                PdfPCell lecturerEmailCell = new PdfPCell(Phrase.getInstance(lecturer.getEmail()));
                table.addCell(indexCell);
                table.addCell(lecturerNameCell);
                table.addCell(lecturerSurnameCell);
                table.addCell(lecturerPhoneCell);
                table.addCell(lecturerEmailCell);
            }
            document.add(table);

            PdfContentByte canvas = writer.getDirectContentUnder();
            Image image = null;
            try {
                image = Image.getInstance(IMAGE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image != null) {
                image.scaleAbsolute(PageSize.A4.getWidth(), PageSize.A4.getHeight());
                image.setAbsolutePosition(0, 0);
                canvas.saveState();
                PdfGState pdfGState = new PdfGState();
                pdfGState.setFillOpacity(0.2f);
                canvas.setGState(pdfGState);
                canvas.addImage(image);
                canvas.restoreState();
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
