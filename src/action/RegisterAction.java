package action;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.user.RegisterUserService;

/**
 * Created by Антон on 02.04.2016.
 */
public class RegisterAction extends ActionSupport {
    private User user;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute(){

        Integer result = RegisterUserService.execute(user);
        if(result != null) {
            addActionMessage("Registration completed successfully. You can log in to your account.");
            return SUCCESS;
        }else {
            addActionError("User with this login already exists");
            return ERROR;
        }
    }
}
