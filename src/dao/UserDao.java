package dao;

import bean.User;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Антон on 02.04.2016.
 */
public class UserDao {
    public static final String REGISTER_USER_QUERY = "INSERT INTO USER (login, password, role, name, surname,phone, email, ban_status ) VALUES (?,?,?,?,?,?,?,?)";
    public static final String LOGIN_USER_QUERY = "SELECT * FROM USER WHERE login = ? AND password = ?";
    private static final String CHECK_LOGIN_QUERY = "SELECT * FROM USER WHERE login = ?";

    public static boolean create(User user) {
        if (!isLoginExist(user.getLogin())) {
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(REGISTER_USER_QUERY);
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.setString(4, user.getName());
                ps.setString(5, user.getSurname());
                ps.setString(6, user.getPhone());
                ps.setString(7, user.getEmail());
                ps.setByte(8, user.getBanStatus());
                ps.execute();
                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        else return false;

    }


    public static User login(String login, String password) {
        User currentUser = null;
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(LOGIN_USER_QUERY);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            currentUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getByte(9));
            }
            return currentUser;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isLoginExist(String login){
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(CHECK_LOGIN_QUERY);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }

    }


}
