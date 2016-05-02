package action.lesson;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.lesson.DeleteLessonService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Антон on 21.04.2016.
 */
public class DeleteLessonAction extends ActionSupport {
    private String lessonId;
    private HttpServletRequest request;
    private String userId;

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

    @Override
    public String execute(){
        request = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        boolean success = DeleteLessonService.execute(lessonId);
        if(success)
            return SUCCESS;
        else
            return ERROR;
    }
}
