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
public class GetCertificateByUserIdAction extends ActionSupport {
    private String userId;
    private HttpServletRequest request;
    private List<Certificate> certificateList;

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String execute(){
        request = ServletActionContext.getRequest();
        userId = request.getParameter("userId");
        certificateList = GetCertificatesByUserIdService.execute(userId);
        return SUCCESS;
    }

   }
