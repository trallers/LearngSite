package action;

import bean.Certificate;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.certificate.*;
import service.user.DeleteUserByIdService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 03.04.2016.
 */
public class CertificateAction extends ActionSupport {
    private HttpServletRequest request;
    private List<Certificate> certificateList;
    private String userID;
    private Certificate certificate;
    private String certificateId;

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

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

    public String getCertificateById(){
        certificate = GetCertificateByIdService.execute(certificateId);
        if(certificate != null){
            return SUCCESS;
        }
        return ERROR;
    }
    public String updateCertificate(){
        UpdateCertificateService.execute(certificate);
        return SUCCESS;
    }

    public String deleteCertificate(){
        DeleteUserByIdService.execute(certificateId);
        return SUCCESS;
    }

    public String createCertificate(){
        CreateCertificateService.execute(certificate);
        return SUCCESS;
    }

}
