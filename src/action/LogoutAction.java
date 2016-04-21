package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Антон on 21.04.2016.
 */
public class LogoutAction extends ActionSupport implements SessionAware {
    private Map<String,Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String execute() {
        session.remove("loginId");
        addActionMessage("You have been Successfully Logged Out");
        return SUCCESS;
    }
}
