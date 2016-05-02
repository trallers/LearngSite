package bean;

/**
 * Created by Антон on 04.04.2016.
 */
public class Lesson {

    private Integer id;
    private Course course;
    private Data data;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        if (!id.equals(lesson.id)) return false;
        if (!course.equals(lesson.course)) return false;
        return data.equals(lesson.data);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + course.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

    public Lesson(Integer id, Course course, Data data) {
        this.id = id;
        this.course = course;
        this.data = data;
    }

    public Lesson() {
    }
}
