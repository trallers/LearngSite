package service.course;

import bean.Course;
import dao.CourseDao;
import dao.DaoFactory;

/**
 * Created by Антон on 18.04.2016.
 */
public class GetCourseByIdService {
    public static Course execute(String id){
        CourseDao dao = DaoFactory.getCourseDao();
        return dao.getById(id);
    }
}
