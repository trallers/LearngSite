package action.lesson;

import bean.Course;
import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.course.GetCoursesByLecturerIdService;
import service.lesson.CreateOrUpdateLessonService;
import service.lesson.GetLessonByIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 24.04.2016.
 */
public class EditLessonAction extends ActionSupport {
    private Lesson lesson;
    private HttpServletRequest request;
    private String userId;
    private String courseName;
    private List<Course> courseList;
    private String lessonId;

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String createOrUpdate(){
        request = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        courseList = GetCoursesByLecturerIdService.execute(userId);
        Course course = getCourseByName(courseName);
        lesson.setCourse(course);
        boolean success = CreateOrUpdateLessonService.execute(lesson);
        if(success)
            return SUCCESS;
        else
            return ERROR;
    }

    private Course getCourseByName(String courseName){
        for(Course course : courseList){
            if(course.getName().equals(courseName))
                return course;
        }
        return null;
    }
    public String getById(){
        request = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        courseList = GetCoursesByLecturerIdService.execute(userId);
        lesson = GetLessonByIdService.execute(lessonId);
        return SUCCESS;
    }
}
