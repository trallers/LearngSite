package action;

import bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import constant.JSPName;
import org.apache.struts2.interceptor.SessionAware;
import service.user.LoginUserService;

import java.util.Map;

/**
 * Created by Антон on 21.04.2016.
 */
public class LoginAction extends ActionSupport implements SessionAware {
    private final static String REDIRECT = "redirect";

    private String login;
    private String password;
    private User user;
    private String url;
    private Integer userId;
    private Map<String, Object> session = null;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String execute() throws Exception {

        user = LoginUserService.execute(login, password);

        if(user != null){
            setUserId(user.getId());
            if(user.getBanStatus()){
                addActionError("U are banned on this site!!!");
                return Action.LOGIN;
            }

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
            return ERROR;
        }

    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
