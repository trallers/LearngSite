package interceptor;

import bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
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
        HttpServletRequest request = null;
        User user = (User) session.get("loginId");

        if (user == null)
        {
            return Action.LOGIN;
        }
        else
        {
            return actionInvocation.invoke();
        }
    }
}
