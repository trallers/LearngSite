package bean;

import java.util.Date;

/**
 * Created by Антон on 03.04.2016.
 */
public class Certificate {

    private Integer id;
    private Integer idStudent;
    private Integer idCourse;
    private String data;
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
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


    public Certificate(Integer id, Integer idStudent, Integer idCourse, String data, Date date) {
        this.id = id;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.data = data;
        this.date = date;
    }

    public Certificate() {
    }
}
