package document;

import bean.Certificate;
import bean.Course;
import bean.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Антон on 06.05.2016.
 */
public class XLSXGenerator implements DocumentGenerator {
    private static final XLSXGenerator instance = new XLSXGenerator();

    private XLSXGenerator() {

    }

    public static XLSXGenerator getInstance(){return instance;}

    @Override
    public void generatePriceList(OutputStream outputStream, List<Course> courseList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Pricelist");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);

        Row headRow = sheet.createRow(0);

        Cell courseIDHead = headRow.createCell(0);
        courseIDHead.setCellValue("");

        Cell courseNameHead = headRow.createCell(1);
        courseNameHead.setCellValue("Course name");

        Cell courseTechnologyHead = headRow.createCell(2);
        courseTechnologyHead.setCellValue("Technology");

        Cell coursePriceHead = headRow.createCell(3);
        coursePriceHead.setCellValue("Price");

        for(int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            Row row = sheet.createRow(i+1);
            row.setRowStyle(cellStyle);

            Cell courseID = row.createCell(0);
            courseID.setCellValue(i+1);
            courseID.setCellStyle(cellStyle);

            Cell courseName = row.createCell(1);
            courseName.setCellValue(course.getName());
            courseName.setCellStyle(cellStyle);

            Cell courseTechnology = row.createCell(2);
            courseTechnology.setCellValue(course.getTechnology());
            courseTechnology.setCellStyle(cellStyle);

            Cell coursePrice = row.createCell(3);
            coursePrice.setCellValue(course.getPrice());
            coursePrice.setCellStyle(cellStyle);
        }

        sheet.setColumnWidth(0, 1000);
        sheet.setColumnWidth(1, 14000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 2000);

        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateListOfStudents(OutputStream outputStream, List<User> studentList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("List of students");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);

        Row headRow = sheet.createRow(0);

        Cell studentIDHead = headRow.createCell(0);
        studentIDHead.setCellValue("");

        Cell studentNameHead = headRow.createCell(1);
        studentNameHead.setCellValue("Name");

        Cell studentSurnameHead = headRow.createCell(2);
        studentSurnameHead.setCellValue("Surname");

        Cell studentPhoneHead = headRow.createCell(3);
        studentPhoneHead.setCellValue("Phone");

        Cell studentEmailHead = headRow.createCell(4);
        studentEmailHead.setCellValue("Email");

        for(int i=0; i<studentList.size(); i++) {
            User student = studentList.get(i);
            Row row = sheet.createRow(i+1);
            row.setRowStyle(cellStyle);

            Cell studentID = row.createCell(0);
            studentID.setCellValue(i+1);
            studentID.setCellStyle(cellStyle);

            Cell studentName = row.createCell(1);
            studentName.setCellValue(student.getName());
            studentName.setCellStyle(cellStyle);

            Cell studentSurname = row.createCell(2);
            studentSurname.setCellValue(student.getSurname());
            studentSurname.setCellStyle(cellStyle);

            Cell studentPhone = row.createCell(3);
            studentPhone.setCellValue(student.getPhone());
            studentPhone.setCellStyle(cellStyle);

            Cell studentEmail = row.createCell(4);
            studentEmail.setCellValue(student.getEmail());
            studentEmail.setCellStyle(cellStyle);
        }

        sheet.setColumnWidth(0, 1000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 5000);

        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateCertificate(OutputStream outputStream, Certificate certificate) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Certificate");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        Row certificateRow = sheet.createRow(0);
        Cell certificateCell = certificateRow.createCell(0);
        certificateCell.setCellValue("Certificate");
        certificateCell.setCellStyle(cellStyle);

        Row dataRow = sheet.createRow(1);
        Cell dataCell = dataRow.createCell(0);
        String data = "For student " + certificate.getStudent().getName() + " " + certificate.getStudent().getSurname() + ". He successfully finished course " + certificate.getCourse().getName() + " on technology " + certificate.getCourse().getTechnology() + ". " + certificate.getData();
        dataCell.setCellValue(data);
        dataCell.setCellStyle(cellStyle);

        Row dateRow = sheet.createRow(2);
        Cell dateCell = dateRow.createCell(0);
        dateCell.setCellValue(certificate.getDate());
        dateCell.setCellStyle(cellStyle);

        Row signatureRow = sheet.createRow(3);
        Cell signatureCell = signatureRow.createCell(0);
        signatureCell.setCellValue("Learning site 2016");
        signatureCell.setCellStyle(cellStyle);

        sheet.setColumnWidth(0, 21000);

        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateRecommendation(OutputStream outputStream, User student) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Recommendation");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);

        Row certificateRow = sheet.createRow(0);
        Cell certificateCell = certificateRow.createCell(0);
        certificateCell.setCellValue("Recommendation");
        certificateCell.setCellStyle(cellStyle);

        Row dataRow = sheet.createRow(1);
        Cell dataCell = dataRow.createCell(0);
        String data = "For student " + student.getName() + " " + student.getSurname() + ". He is learning programming on Learning site. He is very good student.";
        dataCell.setCellValue(data);
        dataCell.setCellStyle(cellStyle);

        Row signatureRow = sheet.createRow(2);
        Cell signatureCell = signatureRow.createCell(0);
        signatureCell.setCellValue("Learning site 2016");
        signatureCell.setCellStyle(cellStyle);

        sheet.setColumnWidth(0, 21000);

        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateListOfLecturers(OutputStream outputStream, List<User> lecturerList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("List of students");

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);

        Row headRow = sheet.createRow(0);

        Cell lecturerIDHead = headRow.createCell(0);
        lecturerIDHead.setCellValue("");

        Cell lecturerNameHead = headRow.createCell(1);
        lecturerNameHead.setCellValue("Name");

        Cell lecturerSurnameHead = headRow.createCell(2);
        lecturerSurnameHead.setCellValue("Surname");

        Cell lecturerPhoneHead = headRow.createCell(3);
        lecturerPhoneHead.setCellValue("Phone");

        Cell lecturerEmailHead = headRow.createCell(4);
        lecturerEmailHead.setCellValue("Email");

        for(int i=0; i<lecturerList.size(); i++) {
            User lecturer = lecturerList.get(i);
            Row row = sheet.createRow(i+1);
            row.setRowStyle(cellStyle);

            Cell lecturerID = row.createCell(0);
            lecturerID.setCellValue(i+1);
            lecturerID.setCellStyle(cellStyle);

            Cell lecturerName = row.createCell(1);
            lecturerName.setCellValue(lecturer.getName());
            lecturerName.setCellStyle(cellStyle);

            Cell lecturerSurname = row.createCell(2);
            lecturerSurname.setCellValue(lecturer.getSurname());
            lecturerSurname.setCellStyle(cellStyle);

            Cell lecturerPhone = row.createCell(3);
            lecturerPhone.setCellValue(lecturer.getPhone());
            lecturerPhone.setCellStyle(cellStyle);

            Cell lecturerEmail = row.createCell(4);
            lecturerEmail.setCellValue(lecturer.getEmail());
            lecturerEmail.setCellStyle(cellStyle);
        }

        sheet.setColumnWidth(0, 1000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 5000);

        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
