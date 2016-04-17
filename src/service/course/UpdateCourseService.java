package service.course;

import bean.Course;
import dao.CourseDao;
import dao.DaoFactory;

/**
 * Created by Антон on 18.04.2016.
 */
public class UpdateCourseService {
    public static void execute(Course course){
        CourseDao dao = DaoFactory.getCourseDao();
        dao.update(course);
    }
}
