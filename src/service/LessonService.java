package service;

import bean.Lesson;
import dao.DaoFactory;
import dao.LessonDao;

import java.util.List;

/**
 * Created by Антон on 05.04.2016.
 */
public class LessonService {

    public static List<Lesson> getLessonsByUserID(String userID){
        LessonDao dao = DaoFactory.getLessonDao();
        return dao.getLessonsByUserID(userID);
    }
}
