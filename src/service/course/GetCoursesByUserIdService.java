package service.course;

import bean.Course;
import dao.CourseDao;
import dao.DaoFactory;

import java.util.List;

/**
 * Created by Антон on 15.04.2016.
 */
public class GetCoursesByUserIdService {
    public static List<Course> execute(String userID){
        CourseDao dao = DaoFactory.getCourseDao();
        return dao.getByUserId(userID);
    }
}
