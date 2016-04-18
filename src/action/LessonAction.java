package action;

import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.lesson.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 04.04.2016.
 */
public class LessonAction extends ActionSupport  implements UserAware{

    private HttpServletRequest request;
    private String userID;
    private List<Lesson> lessonList = new ArrayList<>();
    private Lesson lesson;
    private String lecturerId;
    private String lessonId;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

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

    public  String getAllLessonsByUserID(){
        request = ServletActionContext.getRequest();
        setUserID(request.getParameter("userID"));
        lessonList = GetLessonsByUserIdService.execute(getUserID());
        return SUCCESS;
    }

    public String getAllLessons(){
        lessonList = GetAllLessonsService.execute();
        return SUCCESS;
    }

    public String getLessonsByLecturerId(){
        lessonList = GetLessonsByLecturerIdService.execute(userID);
        return SUCCESS;
    }

    public String getLessonById(){
        lesson = GetLessonByIdService.execute(lessonId);
        return SUCCESS;
    }

    public String createOrUpdateLesson(){
        CreateOrUpdateLessonService.execute(lesson);
        return SUCCESS;
    }

    public String deleteLesson(){
        DeleteLessonService.execute(lessonId);
        return SUCCESS;
    }
}
