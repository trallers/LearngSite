package action.user;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.user.DeleteUserByIdService;
import service.user.GetUserByIdService;
import service.user.UpdateUserService;
import service.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 07.04.2016.
 */
public class UserAction extends ActionSupport {
    private List<User> userList = new ArrayList<>();
    private String userID;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

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

    public String getUserByID(){
        setUser(GetUserByIdService.execute(getUserID()));
        return SUCCESS;
    }

    public String updateUser(){
        Integer userID  = UpdateUserService.execute(getUser());
        setUserID(String.valueOf(userID));
        if(userID != null)
            return SUCCESS;
        return ERROR;
    }

    public String deleteUser(){
        boolean success = DeleteUserByIdService.execute(getUserID());
        if(success)
            return SUCCESS;
        else return ERROR;
    }


}
