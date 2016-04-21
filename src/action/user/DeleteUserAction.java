package action.user;

import com.opensymphony.xwork2.ActionSupport;
import service.user.DeleteUserByIdService;

/**
 * Created by Антон on 21.04.2016.
 */
public class DeleteUserAction  extends ActionSupport{
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String execute(){
        boolean success = DeleteUserByIdService.execute(userId);
        if(success)
            return SUCCESS;
        else return ERROR;
    }

}
