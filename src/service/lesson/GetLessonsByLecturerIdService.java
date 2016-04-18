package service.lesson;

import bean.Lesson;
import dao.DaoFactory;
import dao.LessonDao;

import java.util.List;

/**
 * Created by Антон on 18.04.2016.
 */
public class GetLessonsByLecturerIdService {
    public static List<Lesson> execute(String id){
        LessonDao dao = DaoFactory.getLessonDao();
        return dao.getByLecturerId(id);
    }

}
