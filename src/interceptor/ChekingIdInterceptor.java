package interceptor;

import bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Антон on 17.04.2016.
 */
public class ChekingIdInterceptor extends AbstractInterceptor implements StrutsStatics{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request;
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

        User user = (User) session.get("loginId");

        if (user == null)
        {
            return Action.LOGIN;
        }
        else
        {
            request = ServletActionContext.getRequest();
            String idParam = request.getParameter("userID");
            if(idParam.equals(user.getId().toString()))
                return actionInvocation.invoke();
            else return Action.LOGIN;
        }
    }
}