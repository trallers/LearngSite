package service.certificate;

import bean.Certificate;
import dao.CertificateDao;
import dao.DaoFactory;

/**
 * Created by Антон on 17.04.2016.
 */
public class CreateCertificateService {
    public static boolean execute(Certificate certificate){
        CertificateDao dao = DaoFactory.getCertificateDao();
        return dao.create(certificate);
    }
}
