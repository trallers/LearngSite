package bean;

/**
 * Created by Антон on 25.04.2016.
 */
public class Data {
    private Integer id;
    private String data;

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

    public Data(Integer id, String data) {
        this.id = id;
        this.data = data;
    }

    public Data() {
    }
}
