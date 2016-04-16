package service.certificate;

import bean.Certificate;
import dao.CertificateDao;
import dao.DaoFactory;

import java.util.List;

/**
 * Created by Антон on 15.04.2016.
 */
public class GetCertificatesByUserIdService{
    public static List<Certificate> execute(String userID){
        CertificateDao dao = DaoFactory.getCertificateDao();
        return dao.getCertificatesByUserID(userID);
    }
}
