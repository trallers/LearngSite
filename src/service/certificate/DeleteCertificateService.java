package service.certificate;

import dao.CertificateDao;
import dao.DaoFactory;

/**
 * Created by Антон on 17.04.2016.
 */
public class DeleteCertificateService {
    public static boolean execute(String id){
        CertificateDao dao = DaoFactory.getCertificateDao();
        return dao.delete(id);
    }
}
