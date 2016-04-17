package service.certificate;

import bean.Certificate;
import dao.CertificateDao;
import dao.DaoFactory;

/**
 * Created by Антон on 17.04.2016.
 */
public class GetCertificateByIdService {
    public static Certificate execute(String id){
        CertificateDao dao = DaoFactory.getCertificateDao();
        return dao.getById(id);
    }
}
