package service.course;

import dao.CourseDao;
import dao.DaoFactory;

/**
 * Created by Антон on 18.04.2016.
 */
public class DeleteCourseService {
    public static boolean  execute(String id){
        CourseDao dao = DaoFactory.getCourseDao();
        return dao.delete(id);
    }
}
