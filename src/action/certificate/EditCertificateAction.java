package action.certificate;

import bean.Certificate;
import bean.Course;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.certificate.GetCertificateByIdService;
import service.certificate.UpdateCertificateService;
import service.course.GetAllCoursesService;
import service.user.GetAllStudentsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 24.04.2016.
 */
public class EditCertificateAction extends ActionSupport {
    private Certificate certificate;
    private String certificateId;
    private List<User> studentList;
    private List<Course> courseList;
    private String studentSurname;
    private String courseName;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public EditCertificateAction(){
        this.courseList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public String createOrUpdate(){
        studentList = GetAllStudentsService.execute();
        courseList = GetAllCoursesService.execute();
        certificate.setStudent(getStudentBySurnameName(studentSurname));
        certificate.setCourse(getCourseByName(courseName));
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

    private User getStudentBySurnameName(String surname){
        for(User student : studentList){
            if(student.getSurname().equals(surname))
                return student;
        }
        return null;
    }

    private Course getCourseByName(String name){
        for (Course course : courseList){
            if(course.getName().equals(name))
                return course;
        }
        return null;
    }

}
