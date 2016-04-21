package action.lesson;

import bean.Lesson;
import com.opensymphony.xwork2.ActionSupport;
import service.lesson.GetAllLessonsService;

import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetAllLessonsAction extends ActionSupport {
    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @Override
    public String execute(){
        lessonList = GetAllLessonsService.execute();
        return SUCCESS;
    }
}
