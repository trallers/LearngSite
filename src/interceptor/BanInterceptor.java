package interceptor;

import bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by Антон on 17.04.2016.
 */
public class BanInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        actionInvocation.invoke();
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

        User user = (User) session.get("loginId");
        if(user != null) {
            Byte banStatus = user.getBanStatus();
            if (banStatus != 0) {
                return Action.ERROR;
            }
        }
        return "redirect";
    }
}
