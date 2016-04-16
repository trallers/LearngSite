package service.certificate;

import bean.Certificate;
import dao.CertificateDao;
import dao.DaoFactory;

import java.util.List;

/**
 * Created by Антон on 05.04.2016.
 */
public class CertificateService {
    public static List<Certificate> getCertificatesByUserID(String userID){
        CertificateDao dao = DaoFactory.getCertificateDao();
        return dao.getCertificatesByUserID(userID);
    }

    public static List<Certificate> getAllCertificates(){
        CertificateDao dao = DaoFactory.getCertificateDao();
        return dao.getAllCertificates();
    }
}
