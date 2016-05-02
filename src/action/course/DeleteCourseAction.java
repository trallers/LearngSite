package action.course;

import com.opensymphony.xwork2.ActionSupport;
import service.course.DeleteCourseService;

/**
 * Created by Антон on 21.04.2016.
 */
public class DeleteCourseAction extends ActionSupport{
    private String courseId;
    private String userId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String execute(){
        boolean success = DeleteCourseService.execute(courseId);
        if(success)
            return SUCCESS;
        else {
            addActionError("Can't delete course.");
            return ERROR;
        }
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
