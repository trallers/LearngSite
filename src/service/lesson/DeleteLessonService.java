package service.lesson;

import dao.DaoFactory;
import dao.LessonDao;

/**
 * Created by Антон on 18.04.2016.
 */
public class DeleteLessonService {
    public static boolean execute(String id) {
        LessonDao dao = DaoFactory.getLessonDao();
        return dao.delete(id);
    }
}
