package action.course;

import bean.Course;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.course.GetCourseByIdService;
import service.course.UpdateCourseService;
import service.user.GetAllLecturersService;

import java.util.List;

/**
 * Created by Антон on 24.04.2016.
 */
public class EditCourseAction extends ActionSupport{
    private Course course;
    private List<User> lecturerList;
    private String lecturerID;
    private String courseId;
    private String userId;
    private String lecturerSurname;

    public String getLecturerSurname() {
        return lecturerSurname;
    }

    public void setLecturerSurname(String lecturerSurname) {
        this.lecturerSurname = lecturerSurname;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public List<User> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<User> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



    public String createOrUpdate(){
        lecturerList = GetAllLecturersService.execute();
        course.setLecturer(getLecturerBySurname(lecturerSurname));
        boolean success = UpdateCourseService.execute(course);
        if(success)
            return SUCCESS;
        else{
            addActionError("Can't create/update course. Check fields filling.");
            return ERROR;
        }
    }

    public String getById(){
        lecturerList = GetAllLecturersService.execute();
        course = GetCourseByIdService.execute(courseId);
        return SUCCESS;
    }

    private User getLecturerBySurname(String surname){
        for(User lecturer : lecturerList){
            if(lecturer.getSurname().equals(surname))
                return lecturer;
        }
        return null;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
