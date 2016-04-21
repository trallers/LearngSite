package action.course;

import bean.Course;
import com.opensymphony.xwork2.ActionSupport;
import service.course.GetAllCoursesService;

import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetAllCoursesAction extends ActionSupport {
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String execute(){
        courseList = GetAllCoursesService.execute();
        return SUCCESS;
    }
}
