package action.certificate;

import bean.Certificate;
import com.opensymphony.xwork2.ActionSupport;
import service.certificate.GetAllCertificatesService;

import java.util.List;

/**
 * Created by Антон on 21.04.2016.
 */
public class GetAllCertificatesAction extends ActionSupport {
    private List<Certificate> certificateList;

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    @Override
    public String execute(){
        certificateList = GetAllCertificatesService.execute();
        return SUCCESS;
    }
}
