package action;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.user.CheckLoginService;
import service.user.RegisterUserService;

import java.io.IOException;

/**
 * Created by Антон on 02.04.2016.
 */
public class RegisterAction extends ActionSupport {
    private User user;
    private String repeatPassword;
    private String login;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() {
        if (!user.getPassword().equals(repeatPassword)) {
            addActionError("Different passwords");
            return ERROR;
        }
        user.setLogin(login);
        Integer result = RegisterUserService.execute(user);
        if (result != null) {
            addActionMessage("Registration completed successfully. You can log in to your account.");
            return SUCCESS;
        } else {
            addActionError("User with this login already exists");
            return ERROR;
        }
    }

    public String isLoginExist() {
        try {
            String loginValue = ServletActionContext.getRequest().getParameter("userName");
            boolean isExist = CheckLoginService.execute(loginValue);
            if (isExist)
                ServletActionContext.getResponse().getWriter().write("exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}