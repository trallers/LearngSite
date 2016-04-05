package action;

import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import dao.LessonDao;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 04.04.2016.
 */
public class LessonAction extends ActionSupport {

    private HttpServletRequest request;
    private String userID;
    private List<Lesson> lessonList = new ArrayList<>();

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public  String getAllLessons(){
        request = ServletActionContext.getRequest();
        setUserID(request.getParameter("userID"));
        lessonList = LessonDao.getLessonsByUserID(getUserID());
        return SUCCESS;
    }
}
