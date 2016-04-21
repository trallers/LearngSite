package action.certificate;

import bean.Certificate;
import com.opensymphony.xwork2.ActionSupport;
import service.certificate.UpdateCertificateService;

/**
 * Created by Антон on 21.04.2016.
 */
public class CreateOrUpdateCertificateAction extends ActionSupport {
    private Certificate certificate;

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public String execute(){
        boolean success = UpdateCertificateService.execute(certificate);
        if(success)
            return SUCCESS;
        else {
            addActionError("Invalid values. Please, fill all fields.");
            return ERROR;
        }
    }
}
