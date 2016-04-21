package action.certificate;

import bean.Certificate;
import com.opensymphony.xwork2.ActionSupport;
import service.certificate.GetCertificateByIdService;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetCertificateByIdAction extends ActionSupport {

    private Certificate certificate;
    private String certificateId;

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    @Override
    public String execute() {
        certificate = GetCertificateByIdService.execute(certificateId);
        if(certificate != null){
            return SUCCESS;
        }
        return ERROR;
    }


}
