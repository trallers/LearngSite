package action.course;

import bean.Course;
import com.opensymphony.xwork2.ActionSupport;
import service.course.GetCourseByIdService;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetCourseByIdAction extends ActionSupport{
    private Course course;
    private String courseId;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String execute(){
        course = GetCourseByIdService.execute(courseId);
        return SUCCESS;
    }
}
