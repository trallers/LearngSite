package action;

import bean.Certificate;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.certificate.GetAllCertificatesService;
import service.certificate.GetCertificatesByUserIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 03.04.2016.
 */
public class CertificateAction extends ActionSupport {
    private HttpServletRequest request;
    private List<Certificate> certificateList;
    private String userID;

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCertificatesByUserID(){
        request = ServletActionContext.getRequest();
        setUserID(request.getParameter("userID"));
        certificateList = GetCertificatesByUserIdService.execute(userID);
        return SUCCESS;
    }

    public String getAllCertificates(){
        certificateList = GetAllCertificatesService.execute();
        return SUCCESS;
    }


}
