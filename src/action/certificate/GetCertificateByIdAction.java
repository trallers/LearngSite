package action.certificate;

import bean.Certificate;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.certificate.GetCertificatesByUserIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetCertificateByIdAction extends ActionSupport {
    private HttpServletRequest request;
    private String userId;

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    private List<Certificate> certificateList;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String execute() {
        request = ServletActionContext.getRequest();
        setUserId(request.getParameter("userId"));
        certificateList = GetCertificatesByUserIdService.execute(userId);
        return SUCCESS;
    }


}
