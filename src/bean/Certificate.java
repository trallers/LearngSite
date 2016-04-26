package bean;

import java.util.Date;

/**
 * Created by Антон on 03.04.2016.
 */
public class Certificate {

    private Integer id;
    private User student;
    private Course course;
    private String data;
    private Date date;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Certificate(Integer id, User student, Course course, String data, Date date) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.data = data;
        this.date = date;
    }

    public Certificate() {
    }
}
