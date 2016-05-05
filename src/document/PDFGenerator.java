package document;

import bean.Course;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import service.course.GetAllCoursesService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Антон on 04.05.2016.
 */
public class PDFGenerator implements DocumentGenerator {
    private static final int COLUMNS_COUNT = 4;
    private static String PRICELIST_FILE_NAME = "G:\\Univer\\LearngSite\\pricelist.pdf";
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

    public  void generatePriceList(){
        List<Course> courseList = GetAllCoursesService.execute();
        Document document = new Document();
        try {

            File file = new File(PRICELIST_FILE_NAME);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Paragraph title = new Paragraph("Pricelist of courses of Learning Site:");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(COLUMNS_COUNT);

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
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateListOfStudents() {

    }

    @Override
    public void generateCertificate() {

    }

    @Override
    public void generateRecommendation() {

    }

    @Override
    public void generateListOfLecturers() {

    }


}
