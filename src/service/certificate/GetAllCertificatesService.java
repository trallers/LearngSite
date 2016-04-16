package service.certificate;

import bean.Certificate;
import dao.CertificateDao;
import dao.DaoFactory;

import java.util.List;

/**
 * Created by Антон on 15.04.2016.
 */
public class GetAllCertificatesService {
    public static List<Certificate> execute(){
        CertificateDao dao = DaoFactory.getCertificateDao();
        return dao.getAllCertificates();
    }
}
