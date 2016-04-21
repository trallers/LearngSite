package action.user;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.user.UpdateUserService;

/**
 * Created by Антон on 21.04.2016.
 */
public class CreateOrUpdateUserAction extends ActionSupport {
    private String userId;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String execute(){
        Integer userID  = UpdateUserService.execute(getUser());
        setUserId(String.valueOf(userID));
        if(userID != null)
            return SUCCESS;
        return ERROR;
    }
}
