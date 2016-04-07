package action;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 07.04.2016.
 */
public class UserAction extends ActionSupport {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getAllUsers(){
        setUserList(UserService.getAllUsers());
        return SUCCESS;
    }
}
