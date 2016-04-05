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

    public Course(Integer id, String name, String technology, Integer price, Integer idLecturer) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.price = price;
        this.idLecturer = idLecturer;
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
