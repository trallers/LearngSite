package action.user;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.user.GetAllUsersService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetAllUsersAction extends ActionSupport {

    private List<User> userList = new ArrayList<>();
    private String userId;
    private HttpServletRequest request;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String execute() throws Exception {


        userList = GetAllUsersService.execute();
        if(userList.size() == 0)
            addActionMessage("There's no one registered user in database!");
        return SUCCESS;
    }

    public boolean currentUser(String id){
        if(userId.equals(id))
            return true;
        return false;
    }
}
