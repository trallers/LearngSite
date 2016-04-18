package service.lesson;

import bean.Lesson;
import dao.DaoFactory;
import dao.LessonDao;

/**
 * Created by Антон on 18.04.2016.
 */
public class CreateOrUpdateLessonService {
    public static void execute(Lesson lesson){
        LessonDao dao = DaoFactory.getLessonDao();
        dao.update(lesson);
    }
}
