package bean;

/**
 * Created by Антон on 03.04.2016.
 */
public class Course {
    private Integer id;
    private String name;
    private String technology;
    private Integer price;
    private Integer idLecturer;

    public Course(Integer id, String name, String technology, Integer idLecturer, Integer price) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.idLecturer = idLecturer;
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
        return idLecturer.equals(course.idLecturer);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + technology.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + idLecturer.hashCode();
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

    public Integer getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(Integer idLecturer) {
        this.idLecturer = idLecturer;
    }
}
