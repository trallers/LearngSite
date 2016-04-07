package service;

import bean.User;
import dao.DaoFactory;
import dao.UserDao;

import java.util.List;

/**
 * Created by Антон on 05.04.2016.
 */
public class UserService {

    public static User login(String login, String password){
        UserDao dao = DaoFactory.getUserDao();
        return dao.login(login, password);
    }

    public static Integer register(User user){
        UserDao dao = DaoFactory.getUserDao();
        return dao.create(user);
    }

    public static List<User> getAllUsers(){
        UserDao dao = DaoFactory.getUserDao();
        return dao.getAllUsers();
    }



}
