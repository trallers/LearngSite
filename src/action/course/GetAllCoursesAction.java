package action.course;

import bean.Course;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.course.GetAllCoursesService;
import service.user.GetAllLecturersService;

import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetAllCoursesAction extends ActionSupport {
    private List<Course> courseList;
    private List<User> lecturerList;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<User> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<User> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String execute(){
        courseList = GetAllCoursesService.execute();
        lecturerList = GetAllLecturersService.execute();
        return SUCCESS;
    }
}
