package action.lesson;

import bean.Course;
import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.lesson.GetLessonsByLecturerIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 24.04.2016.
 */
public class GetLessonByLecturerIdAction extends ActionSupport {

    private HttpServletRequest request;
    private String userId;
    private List<Lesson> lessonList;
    private List<Course> courseList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @Override
    public String execute(){
        request = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        lessonList = GetLessonsByLecturerIdService.execute(userId);
        return SUCCESS;
    }
}
