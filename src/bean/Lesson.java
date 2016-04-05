package bean;

/**
 * Created by Антон on 04.04.2016.
 */
public class Lesson {

    private Integer id;
    private String courseName;
    private String data;

    public Lesson(Integer id, String courseName, String data) {
        this.id = id;
        this.courseName = courseName;
        this.data = data;
    }

    public Lesson() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
