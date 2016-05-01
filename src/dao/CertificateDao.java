package dao;

import bean.Certificate;
import bean.Course;
import bean.User;
import service.course.GetCourseByIdService;
import service.user.GetUserByIdService;
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
                Integer studentId =  rs.getInt(2);
                User student = GetUserByIdService.execute(studentId.toString());
                Integer courseId = rs.getInt(3);
                Course course = GetCourseByIdService.execute(courseId.toString());
                if(student != null && course != null)
                    certificateList.add(new Certificate(rs.getInt(1), student, course, rs.getString(4), rs.getDate(5)));
            }
        } catch (SQLException | NullPointerException e) {
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
                Integer studentId =  rs.getInt(2);
                User student = GetUserByIdService.execute(studentId.toString());
                Integer courseId = rs.getInt(3);
                Course course = GetCourseByIdService.execute(courseId.toString());
                if(student != null && course != null)
                certificateList.add(new Certificate(rs.getInt(1), student, course, rs.getString(4), rs.getDate(5)));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return certificateList;
    }

    public boolean delete(String id){
        try{
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(DELETE_CERTIFICATE_BY_ID_QUERY);
            ps.setString(1, id);
            ps.execute();
        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean create(Certificate certificate){
            try{
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(INSERT_CERTIFICATE_QUERY);
                ps.setInt(1, certificate.getStudent().getId());
                ps.setInt(2,certificate.getCourse().getId());
                ps.setString(3, certificate.getData());
                ps.setDate(4,parseDateToSql(certificate.getDate()));
                ps.executeUpdate();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        return true;
    }


    private java.sql.Date parseDateToSql(java.util.Date dateTime){
        java.sql.Date sqlDate = new java.sql.Date(dateTime.getTime());
        return sqlDate;
    }


    public boolean update(Certificate certificate){
        if (certificate.getId() != null) {
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(UPDATE_CERTIFICATE_QUERY);
                ps.setInt(1, certificate.getStudent().getId());
                ps.setInt(2, certificate.getCourse().getId());
                ps.setString(3, certificate.getData());
                ps.setDate(4, parseDateToSql(certificate.getDate()));
                ps.setInt(5, certificate.getId());
                ps.execute();
                return true;
            } catch (SQLException | NullPointerException e) {
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
            while (rs.next()){
                Integer studentId =  rs.getInt(2);
                User student = GetUserByIdService.execute(studentId.toString());
                Integer courseId = rs.getInt(3);
                Course course = GetCourseByIdService.execute(courseId.toString());
                if(student != null && course != null)
                certificate = new Certificate(rs.getInt(1), student, course, rs.getString(4), rs.getDate(5));
            }

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return certificate;

    }
}
