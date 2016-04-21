package action.lesson;

import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.lesson.GetLessonsByUserIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetLessonsByUserIdAction extends ActionSupport{
    private HttpServletRequest request;
    private String userId;
    private List<Lesson> lessonList;

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
        lessonList = GetLessonsByUserIdService.execute(userId);
        return SUCCESS;
    }
}
