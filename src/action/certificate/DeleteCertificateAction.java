package action.certificate;

import com.opensymphony.xwork2.ActionSupport;
import service.certificate.DeleteCertificateService;

/**
 * Created by Антон on 21.04.2016.
 */
public class DeleteCertificateAction extends ActionSupport {
    private String certificateId;

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    @Override
    public String execute(){
        boolean success = DeleteCertificateService.execute(certificateId);
        if(success)
            return SUCCESS;
        else {
            addActionError("Can't delete current certificate.");
            return ERROR;
        }
    }
}
