package action.lesson;

import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.lesson.CreateOrUpdateLessonService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Антон on 21.04.2016.
 */
public class CreateOrUpdateLessonAction extends ActionSupport {
    private Lesson lesson;
    private HttpServletRequest request;
    private String userId;

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

    @Override
    public String execute(){
        request = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        boolean success = CreateOrUpdateLessonService.execute(lesson);
        if(success)
            return SUCCESS;
        else
            return ERROR;
    }
}
