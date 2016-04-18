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
    private static final String GET_CERTIFICATES_BY_USER_ID_QUERY = "SELECT * FROM certificate WHERE certificate.id_student = ?";
    private static final String GET_ALL_CERTIFICATES_QUERY = "SELECT * FROM certificate";
    private static final String DELETE_CERTIFICATE_BY_ID_QUERY = "DELETE FROM certificate WHERE id = ?";
    private static final String INSERT_CERTIFICATE_QUERY = "INSERT INTO certificate (id_student, id_course, data , date) VALUES (?,?,?,?)";
    private static final String GET_CERTIFICATE_BY_ID_QUERY = "SELECT * FROM certificate WHERE id = ?";
    private static final String UPDATE_CERTIFICATE_QUERY = "UPDATE certificate SET id_student = ?, id_course = ?, data = ?, date = ? WHERE id = ?";


    private final static CertificateDao instance = new CertificateDao();

    private CertificateDao(){}

    public final static CertificateDao getInstance() {
        return instance;
    }

    public List<Certificate> getByUserId(String userID){

        List<Certificate> certificateList = new ArrayList<>();

        try {
           PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_CERTIFICATES_BY_USER_ID_QUERY);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                certificateList.add(new Certificate(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificateList;
    }

    public List<Certificate> getAll(){
        List<Certificate> certificateList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_ALL_CERTIFICATES_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                certificateList.add(new Certificate(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificateList;
    }

    public boolean delete(String id){
        try{
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(DELETE_CERTIFICATE_BY_ID_QUERY);
            ps.setString(1, id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean create(Certificate certificate){
            try{
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(INSERT_CERTIFICATE_QUERY);
                ps.setString(1, String.valueOf(certificate.getIdStudent()));
                ps.setString(2, String.valueOf(certificate.getIdCourse()));
                ps.setString(3, certificate.getData());
                ps.setString(4, String.valueOf(certificate.getDate()));
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        return true;
    }

    public boolean update(Certificate certificate){
        if (certificate.getId() != null) {
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(UPDATE_CERTIFICATE_QUERY);
                ps.setInt(1, certificate.getIdStudent());
                ps.setInt(2, certificate.getIdCourse());
                ps.setString(3, certificate.getData());
                ps.setDate(4, certificate.getDate());
                ps.setInt(5, certificate.getId());
                ps.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else create(certificate);
        return true;
    }

    public Certificate getById(String id){
        Certificate certificate = null;
        if(id == null)
            return new Certificate();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_CERTIFICATE_BY_ID_QUERY);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                certificate = new Certificate(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificate;

    }
}
