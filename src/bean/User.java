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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!role.equals(user.role)) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!phone.equals(user.phone)) return false;
        if (!email.equals(user.email)) return false;
        return banStatus.equals(user.banStatus);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + banStatus.hashCode();
        return result;
    }

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
