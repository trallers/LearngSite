package action.user;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import service.user.GetAllUsersService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetAllUsersAction extends ActionSupport implements SessionAware {

    private List<User> userList = new ArrayList<>();
    private String userId;
    private HttpServletRequest request;
    private Map<String, Object> session;


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
        User currentUser = (User) session.get("loginId");
        String currentUserId = currentUser.getId().toString();
        if(currentUserId.equals(id))
            return true;
        return false;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
