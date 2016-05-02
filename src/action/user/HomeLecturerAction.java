package action.user;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Антон on 02.05.2016.
 */
public class HomeLecturerAction extends ActionSupport {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
