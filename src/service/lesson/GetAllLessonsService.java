package service.lesson;

import bean.Lesson;
import dao.DaoFactory;
import dao.LessonDao;

import java.util.List;

/**
 * Created by Антон on 15.04.2016.
 */
public class GetAllLessonsService {
    public static List<Lesson> execute(){
        LessonDao dao = DaoFactory.getLessonDao();
        return dao.getAllLessons();
    }
}
