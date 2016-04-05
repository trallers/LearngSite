package dao;

import bean.Certificate;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 03.04.2016.
 */
public class CertificateDao {
    private final static String GET_CERTIFICATES_BY_USER_ID_QUERY = "SELECT * FROM certificate WHERE certificate.id_student = ?";

    private final static CertificateDao instance = new CertificateDao();

    private CertificateDao(){}

    public final static CertificateDao getInstance() {
        return instance;
    }

    public List<Certificate> getCertificatesByUserID(String userID){

        List<Certificate> certificateList = new ArrayList<>();

        try {
           PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_CERTIFICATES_BY_USER_ID_QUERY);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                certificateList.add(new Certificate(rs.getInt(1), rs.getInt(2   ), rs.getInt(3), rs.getString(4), rs.getDate(5)));
            }
            return certificateList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
