package bean;

/**
 * Created by Антон on 03.04.2016.
 */
public class Course {
    private Integer id;
    private String name;
    private String technology;
    private Integer price;
    private User lecturer;

    public Course(Integer id, String name, String technology,  User lecturer, Integer price) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.lecturer = lecturer;
        this.price = price;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!id.equals(course.id)) return false;
        if (!name.equals(course.name)) return false;
        if (!technology.equals(course.technology)) return false;
        if (!price.equals(course.price)) return false;
        return lecturer.equals(course.lecturer);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + technology.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + lecturer.hashCode();
        return result;
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getLecturer() {
        return lecturer;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }
}
