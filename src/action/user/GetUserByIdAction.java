package action.user;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import service.user.GetUserByIdService;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetUserByIdAction extends ActionSupport {
    private User user;
    private String userId;
    private String id;

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
        user = GetUserByIdService.execute(userId);
        return SUCCESS;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
