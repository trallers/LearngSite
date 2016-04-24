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
 * Created by Антон on 18.04.2016.
 */
public class LecturerRoleInterceptor extends AbstractInterceptor implements StrutsStatics {
    private HttpServletRequest request;

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
            if(user.getRole().equals("lecturer")) {
                request = ServletActionContext.getRequest();
                String idParam = request.getParameter("userId");
                if(idParam.equals(user.getId().toString()))
                    return actionInvocation.invoke();
                else return Action.LOGIN;
            }
            else return Action.LOGIN;
        }
    }
}
