package action;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;

/**
 * Created by Антон on 02.04.2016.
 */
public class RegisterAction extends ActionSupport {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute(){
        boolean result = UserDao.create(user);
        if(result){
            return SUCCESS;
        }
        addActionError("User with this login already exists");
        return ERROR;
    }
}
