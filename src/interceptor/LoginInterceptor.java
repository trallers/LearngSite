package interceptor;

import action.UserAware;
import bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;

import java.util.Map;

/**
 * Created by Антон on 15.04.2016.
 */
public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics{


    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();

        User user = (User) sessionAttributes.get("USER");

        if (user == null) {
            return Action.LOGIN;
        } else {
            Action action = (Action) actionInvocation.getAction();
            if (action instanceof UserAware) {
                ((UserAware) action).setUser(user);
            }
            return actionInvocation.invoke();
        }
    }
}
