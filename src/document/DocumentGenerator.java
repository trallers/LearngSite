package document;

import bean.Certificate;
import bean.Course;
import bean.User;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by Антон on 06.05.2016.
 */
public interface DocumentGenerator {
    public abstract void generatePriceList(OutputStream outputStream, List<Course> courseList);
    public abstract void generateListOfStudents(OutputStream outputStream, List<User> studentList);
    public abstract void generateCertificate(OutputStream outputStream, Certificate certificate);
    public abstract void generateRecommendation(OutputStream outputStream, User student);
    public abstract void generateListOfLecturers(OutputStream outputStream, List<User> lecturerList);
}
