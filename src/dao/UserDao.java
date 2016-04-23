package dao;

import bean.User;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 02.04.2016.
 */
public class UserDao {

    public static final String REGISTER_USER_QUERY = "INSERT INTO USER (login, password, role, name, surname,phone, email, ban_status ) VALUES (?,?,?,?,?,?,?,?)";
    private static final String LOGIN_USER_QUERY = "SELECT * FROM USER WHERE login = ? AND password = ?";
    private static final String CHECK_LOGIN_QUERY = "SELECT * FROM USER WHERE login = ?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM USER";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE id = ?";
    public static final String UPDATE_USER_QUERY = "UPDATE USER set password = ?, name = ?, surname = ?, phone = ?, email = ?, ban_status = ?  WHERE id = ?";
    public static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM USER where id = ?";

    private final static UserDao instance = new UserDao();
    private static final String GET_ALL_LECTURERS_QUERY = "SELECT * FROM user WHERE role = \"lecturer\"";

    private UserDao(){}

    public final static UserDao getInstance(){
        return instance;
    }

    public Integer create(User user) {
        Integer resultUserID = null;
        if(user != null) {
            if (!isLoginExist(user.getLogin())) {
                try {
                    PreparedStatement ps = DBUtil.getConnection().prepareStatement(REGISTER_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getLogin());
                    ps.setString(2, user.getPassword());
                    ps.setString(3, user.getRole());
                    ps.setString(4, user.getName());
                    ps.setString(5, user.getSurname());
                    ps.setString(6, user.getPhone());
                    ps.setString(7, user.getEmail());
                    ps.setByte(8, user.getBanStatus());
                    ps.executeUpdate();

                    ResultSet rs = ps.getGeneratedKeys();

                    while (rs.next()) {
                        resultUserID = rs.getInt(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultUserID;


    }

    public User login(String login, String password) {
        User currentUser = null;
        if(login != null && password != null) {
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(LOGIN_USER_QUERY);
                ps.setString(1, login);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    currentUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getByte(9));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return currentUser;
    }

    private  boolean isLoginExist(String login){
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
    
    public List<User> getAll(){
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_ALL_USERS_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getByte(9)));
            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User geByID(String id) {
        User user = new User();
        if(id != null) {
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_USER_BY_ID_QUERY);
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    user.setId(rs.getInt(1));
                    user.setLogin(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setRole(rs.getString(4));
                    user.setName(rs.getString(5));
                    user.setSurname(rs.getString(6));
                    user.setPhone(rs.getString(7));
                    user.setEmail(rs.getString(8));
                    user.setBanStatus(rs.getByte(9));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public Integer update(User user){
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(UPDATE_USER_QUERY);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setByte(6, user.getBanStatus());
            ps.setInt(7, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return user.getId();
        }
        return user.getId();
    }

    public boolean delete(String id){
        try{
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(DELETE_USER_BY_ID_QUERY);
            ps.setString(1, id);
            ps.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public List<User> getLecturerss(){
        List<User> lecturerList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_ALL_LECTURERS_QUERY);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lecturerList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getByte(9)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturerList;
    }
}
