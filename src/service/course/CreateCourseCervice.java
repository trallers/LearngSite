package service.course;

import bean.Course;
import dao.CourseDao;
import dao.DaoFactory;

/**
 * Created by Антон on 18.04.2016.
 */
public class CreateCourseCervice {
    public static boolean execute(Course course){
        CourseDao dao = DaoFactory.getCourseDao();
        return dao.create(course);
    }
}
