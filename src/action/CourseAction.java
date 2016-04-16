package action;

import bean.Course;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.course.GetAllCoursesService;
import service.course.GetCoursesByUserIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 03.04.2016.
 */
public class CourseAction extends ActionSupport {
    private HttpServletRequest  request;
    private List<Course> courseList;
    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }


    public String getCoursesByUserID() throws Exception {
        request  = ServletActionContext.getRequest();
        setUserID(request.getParameter("userID"));
        courseList = GetCoursesByUserIdService.execute(userID);
        return SUCCESS;
    }

    public String getAllCourses(){
        courseList = GetAllCoursesService.execute();
        return SUCCESS;
    }
}
