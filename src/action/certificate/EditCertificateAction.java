package action.certificate;

import bean.Certificate;
import bean.Course;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.certificate.GetCertificateByIdService;
import service.certificate.UpdateCertificateService;
import service.course.GetAllCoursesService;
import service.user.GetAllStudentsService;

import java.util.List;

/**
 * Created by Антон on 24.04.2016.
 */
public class EditCertificateAction extends ActionSupport {
    private Certificate certificate;
    private String certificateId;
    private List<User> studentList;
    private List<Course> courseList;
    private Integer idCourse;
    private Integer idStudent;

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public List<User> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<User> studentList) {
        this.studentList = studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }


    public String createOrUpdate(){
        certificate.setIdCourse(idCourse);
        certificate.setIdStudent(idStudent);
        boolean success = UpdateCertificateService.execute(certificate);
        if(success)
            return SUCCESS;
        else {
            addActionError("Invalid values. Please, fill all fields.");
            return ERROR;
        }
    }

    public String getById() {
        studentList = GetAllStudentsService.execute();
        courseList = GetAllCoursesService.execute();
        certificate = GetCertificateByIdService.execute(certificateId);
        if(certificate != null){
            return SUCCESS;
        }
        return ERROR;
    }

}
