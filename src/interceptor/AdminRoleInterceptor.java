package interceptor;

import bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;

import java.util.Map;

/**
 * Created by Антон on 18.04.2016.
 */
public class AdminRoleInterceptor extends AbstractInterceptor implements StrutsStatics {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        User user = (User) session.get("loginId");

        if (user == null)
        {
            return Action.LOGIN;
        }
        else
        {
           if(user.getRole().equals("admin"))
                return actionInvocation.invoke();
           else return Action.LOGIN;
        }
    }
}
