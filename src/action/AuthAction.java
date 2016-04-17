package action;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import constant.JSPName;
import org.apache.struts2.interceptor.SessionAware;
import service.user.LoginUserService;

import java.util.Map;

/**
 * Created by Антон on 02.04.2016.
 */
public class AuthAction extends ActionSupport implements SessionAware{

    private final static String REDIRECT = "redirect";

    private String login;
    private String password;
    private User user;
    private String url;
    private Integer userID;
    private Map<String, Object> session = null;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String login() throws Exception {

        user = LoginUserService.execute(login, password);

        if(user != null){
            setUserID(user.getId());

            switch (user.getRole()){
                case "admin" : setUrl(JSPName.HOME_ADMIN);
                    break;
                case "student" : setUrl(JSPName.HOME_STUDENT);
                    break;
                case "lecturer" : setUrl(JSPName.HOME_LECTURER);
            }
            session.put("loginId", user);
            return REDIRECT;

        }else{
            addActionError("Invalid login or password!");
            return LOGIN;
        }

    }

    public String logout() {
        session.remove("loginId");
        addActionMessage("You have been Successfully Logged Out");
        return SUCCESS;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
