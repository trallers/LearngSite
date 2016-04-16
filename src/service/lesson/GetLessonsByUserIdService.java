package service.lesson;

import bean.Lesson;
import dao.DaoFactory;
import dao.LessonDao;

import java.util.List;

/**
 * Created by Антон on 15.04.2016.
 */
public class GetLessonsByUserIdService {
    public static List<Lesson> execute(String userID){
        LessonDao dao = DaoFactory.getLessonDao();
        return dao.getLessonsByUserID(userID);
    }
}
