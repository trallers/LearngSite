package action.course;

import bean.Course;
import com.opensymphony.xwork2.ActionSupport;
import service.course.UpdateCourseService;

/**
 * Created by Антон on 21.04.2016.
 */
public class CreateOrUpdateCourseAction extends ActionSupport{
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String execute(){
        boolean success = UpdateCourseService.execute(course);
        if(success)
            return SUCCESS;
        else{
            addActionError("Can't create/update course. Check fields filling.");
            return ERROR;
        }
    }
}
