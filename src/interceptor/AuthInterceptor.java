package interceptor;

import action.UserAware;
import bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Антон on 15.04.2016.
 */
public class AuthInterceptor extends AbstractInterceptor implements StrutsStatics{


    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        HttpServletRequest request;
        User user = (User) session.get("loginId");

        if (user == null)
        {
            return Action.LOGIN;
        }
        else
        {
            request = ServletActionContext.getRequest();
            String idParam = request.getParameter("userId");
            Byte banStatus = user.getBanStatus();
            if(banStatus != 0){
                return Action.ERROR;
            }
            if(idParam == null){
                if(actionInvocation instanceof UserAware) {
                    UserAware action = (UserAware) actionInvocation;
                    action.setUserID(user.getId().toString());
                    return actionInvocation.invoke();
                }
                return actionInvocation.invoke();
            }
            if(idParam.equals(user.getId().toString()))
                return actionInvocation.invoke();
            else return Action.LOGIN;
        }
    }
}
