package bean;

/**
 * Created by Антон on 02.04.2016.
 */
public class User {
    private Integer id;
    private String login;
    private String password;
    private String role;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Boolean banStatus;



    public User(Integer id, String login, String password, String role, String name, String surname, String phone, String email, Boolean banStatus) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.banStatus = banStatus;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getBanStatus() {
        return banStatus;
    }

    public void setBanStatus(Boolean banStatus) {
        this.banStatus = banStatus;
    }
}
