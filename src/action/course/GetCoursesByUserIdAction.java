package action.course;

import bean.Course;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.course.GetCoursesByUserIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetCoursesByUserIdAction extends ActionSupport {
    private HttpServletRequest request;
    private String userId;
    private List<Course> courseList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String execute(){
        request  = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        courseList = GetCoursesByUserIdService.execute(userId);
        return SUCCESS;
    }
}
