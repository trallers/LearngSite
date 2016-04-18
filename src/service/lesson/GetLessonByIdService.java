package service.lesson;

import bean.Lesson;
import dao.DaoFactory;
import dao.LessonDao;

/**
 * Created by Антон on 18.04.2016.
 */
public class GetLessonByIdService {
    public static Lesson execute(String id){
        LessonDao dao = DaoFactory.getLessonDao();
        return dao.getById(id);
    }
}
