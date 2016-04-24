package action.lesson;

import bean.Course;
import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.course.GetCoursesByLecturerIdService;
import service.lesson.GetLessonByIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetLessonByIdAction extends ActionSupport {
    private Lesson lesson;
    private String lessonId;
    private String userId;
    private HttpServletRequest request;
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String execute(){
        request = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        courseList = GetCoursesByLecturerIdService.execute(userId);
        lesson = GetLessonByIdService.execute(lessonId);
        return SUCCESS;
    }
}
