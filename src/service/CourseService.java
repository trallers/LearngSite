package service;

import bean.Course;
import dao.CourseDao;
import dao.DaoFactory;

import java.util.List;

/**
 * Created by Антон on 05.04.2016.
 */
public class CourseService {

    public static List<Course> getCoursesByUserID(String userID){
        CourseDao dao = DaoFactory.getCourseDao();
        return dao.getCoursesByUserID(userID);
    }
}
