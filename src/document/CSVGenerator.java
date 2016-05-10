package document;

import bean.Certificate;
import bean.Course;
import bean.User;

import java.io.OutputStream;
import java.util.List;

public class CSVGenerator implements DocumentGenerator {
    private static final CSVGenerator instance = new CSVGenerator();

    private CSVGenerator() {

    }

    public static CSVGenerator getInstance(){return instance;}

    @Override
    public void generatePriceList(OutputStream outputStream, List<Course> courseList) {

    }

    @Override
    public void generateListOfStudents(OutputStream outputStream, List<User> studentList) {

    }

    @Override
    public void generateCertificate(OutputStream outputStream, Certificate certificate) {

    }

    @Override
    public void generateRecommendation(OutputStream outputStream, User student) {

    }

    @Override
    public void generateListOfLecturers(OutputStream outputStream, List<User> lecturerList) {

    }
}
