package action.document;

import bean.Certificate;
import bean.Course;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import document.PDFGenerator;
import org.apache.struts2.ServletActionContext;
import service.certificate.GetCertificateByIdService;
import service.course.GetAllCoursesService;
import service.user.GetAllLecturersService;
import service.user.GetAllStudentsService;
import service.user.GetUserByIdService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Антон on 04.05.2016.
 */
public class GeneratePdfAction extends ActionSupport{

    private String userId;
    private String certificateId;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String generatePriceList() throws IOException {
        List<Course> courseList = GetAllCoursesService.execute();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String fileName = URLEncoder.encode("PriceList.pdf", "UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        PDFGenerator generator = PDFGenerator.getInstance();
        generator.generatePriceList(response.getOutputStream(), courseList);
        return SUCCESS;
    }


    public String generateListOfStudents() throws IOException {
        List<User> studentList = GetAllStudentsService.execute();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String fileName = URLEncoder.encode("Students.pdf", "UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        PDFGenerator generator = PDFGenerator.getInstance();
        generator.generateListOfStudents(response.getOutputStream(), studentList);
        return SUCCESS;
    }


    public String generateCertificate() throws IOException {
        Certificate certificate = GetCertificateByIdService.execute(certificateId);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String fileName = URLEncoder.encode("certificate.pdf", "UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        PDFGenerator generator = PDFGenerator.getInstance();
        generator.generateCertificate(response.getOutputStream(), certificate);
        return SUCCESS;
    }

    public String generateRecommendation() throws IOException {
        User student = GetUserByIdService.execute(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String fileName = URLEncoder.encode("Recommendation.pdf", "UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        PDFGenerator generator = PDFGenerator.getInstance();
        generator.generateRecommendation(response.getOutputStream(), student);
        return SUCCESS;
    }

    public String generateListOfLecturers() throws IOException {
        List<User> lecturerList = GetAllLecturersService.execute();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String fileName = URLEncoder.encode("Lecturers.pdf", "UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        PDFGenerator generator = PDFGenerator.getInstance();
        generator.generateListOfLecturers(response.getOutputStream(), lecturerList);
        return SUCCESS;
    }

}
