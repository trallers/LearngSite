package action.course;

import bean.Course;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.course.UpdateCourseService;
import service.user.GetAllLecturersService;

import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class CreateOrUpdateCourseAction extends ActionSupport{
    private Course course;
    private List<User> lecturerList;
    private String lecturerID;

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public List<User> getLecturerList() {
        return lecturerList;
    }

    public void setLecturerList(List<User> lecturerList) {
        this.lecturerList = lecturerList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String execute(){
        lecturerList = GetAllLecturersService.execute();
        course.setIdLecturer(Integer.parseInt(lecturerID));
        boolean success = UpdateCourseService.execute(course);
        if(success)
            return SUCCESS;
        else{
            addActionError("Can't create/update course. Check fields filling.");
            return ERROR;
        }
    }

    private Integer getLecturerIdBySurname(String lecturerSurname){
        for(User lecturer : lecturerList){
            if (lecturer.getName().equals(lecturerSurname)){
                return lecturer.getId();
            }

        }
        return null;
    }
}
