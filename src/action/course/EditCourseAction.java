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
        course.setIdLecturer(Integer.parseInt(lecturerID));
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
}