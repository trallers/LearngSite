package service.course;

import bean.Course;
import dao.CourseDao;
import dao.DaoFactory;

import java.util.List;

/**
 * Created by Антон on 24.04.2016.
 */
public class GetCoursesByLecturerIdService {
    public static List<Course> execute(String lecturerId){
        CourseDao dao = DaoFactory.getCourseDao();
        return dao.getByLecturerId(lecturerId);
    }
}
