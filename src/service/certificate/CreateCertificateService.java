package service.certificate;

import bean.Certificate;
import dao.CertificateDao;
import dao.DaoFactory;

/**
 * Created by Антон on 17.04.2016.
 */
public class CreateCertificateService {
    public static void execute(Certificate certificate){
        CertificateDao dao = DaoFactory.getCertificateDao();
        dao.create(certificate);
    }
}
