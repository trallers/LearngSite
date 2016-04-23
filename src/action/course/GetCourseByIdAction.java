package action.course;

import bean.Course;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.course.GetCourseByIdService;
import service.user.GetAllLecturersService;

import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetCourseByIdAction extends ActionSupport{
    private Course course;
    private String courseId;
    private List<User> lecturerList;
    private String lecturerName;

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<User> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<User> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String execute(){
        lecturerList = GetAllLecturersService.execute();
        course = GetCourseByIdService.execute(courseId);
        lecturerName = getLecturerSurnameById(course.getIdLecturer());
        return SUCCESS;
    }

    private String getLecturerSurnameById(Integer lecturerId){
        for(User lecturer : lecturerList){
            if (lecturer.getId().equals(lecturerId)){
                return lecturer.getSurname();
            }

        }
        return null;
    }
}
