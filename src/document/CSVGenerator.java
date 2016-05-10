package document;

import au.com.bytecode.opencsv.CSVWriter;
import bean.Certificate;
import bean.Course;
import bean.User;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVGenerator implements DocumentGenerator {
    private static final CSVGenerator instance = new CSVGenerator();

    private CSVGenerator() {

    }

    public static CSVGenerator getInstance(){return instance;}

    @Override
    public void generatePriceList(OutputStream outputStream, List<Course> courseList) {
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream));
        List<String[]> stringsToWrite = new ArrayList<>();

        String[] headString = {"","Course name","Technology","Price"};
        stringsToWrite.add(headString);

        for(int i=0; i<courseList.size(); i++) {
            Course course = courseList.get(i);
            String[] set = new String[4];

            set[0] = (new Integer(i+1)).toString();
            set[1] = course.getName();
            set[2] = course.getTechnology();
            set[3] = course.getPrice().toString();

            stringsToWrite.add(set);
        }

        try {
            writer.writeAll(stringsToWrite);
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateListOfStudents(OutputStream outputStream, List<User> studentList) {
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream));
        List<String[]> stringsToWrite = new ArrayList<>();

        String[] headString = {"","Name","Surname","Phone","Email"};
        stringsToWrite.add(headString);

        for(int i=0; i<studentList.size(); i++) {
            User student = studentList.get(i);
            String[] set = new String[5];

            set[0] = (new Integer(i+1)).toString();
            set[1] = student.getName();
            set[2] = student.getSurname();
            set[3] = student.getPhone();
            set[4] = student.getEmail();

            stringsToWrite.add(set);
        }

        try {
            writer.writeAll(stringsToWrite);
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateCertificate(OutputStream outputStream, Certificate certificate) {
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream));
        List<String[]> stringsToWrite = new ArrayList<>();

        String[] headString = {"Certificate"};
        stringsToWrite.add(headString);

        String[] data = {"For student " + certificate.getStudent().getName() + " " + certificate.getStudent().getSurname() + ". He successfully finished course " + certificate.getCourse().getName() + " on technology " + certificate.getCourse().getTechnology() + ". " + certificate.getData()};
        stringsToWrite.add(data);

        String[] date = {certificate.getDate().toString()};
        stringsToWrite.add(date);

        String[] logo = {"Learning site 2016"};
        stringsToWrite.add(logo);

        try {
            writer.writeAll(stringsToWrite);
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateRecommendation(OutputStream outputStream, User student) {
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream));
        List<String[]> stringsToWrite = new ArrayList<>();

        String[] headString = {"Recommendation"};
        stringsToWrite.add(headString);

        String[] data = {"For student " + student.getName() + " " + student.getSurname() + ". He is learning programming on Learning site. He is very good student."};
        stringsToWrite.add(data);

        String[] logo = {"Learning site 2016"};
        stringsToWrite.add(logo);

        try {
            writer.writeAll(stringsToWrite);
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateListOfLecturers(OutputStream outputStream, List<User> lecturerList) {
        CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream));
        List<String[]> stringsToWrite = new ArrayList<>();

        String[] headString = {"","Name","Surname","Phone","Email"};
        stringsToWrite.add(headString);

        for(int i=0; i<lecturerList.size(); i++) {
            User lecturer = lecturerList.get(i);
            String[] set = new String[5];

            set[0] = (new Integer(i+1)).toString();
            set[1] = lecturer.getName();
            set[2] = lecturer.getSurname();
            set[3] = lecturer.getPhone();
            set[4] = lecturer.getEmail();

            stringsToWrite.add(set);
        }

        try {
            writer.writeAll(stringsToWrite);
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
