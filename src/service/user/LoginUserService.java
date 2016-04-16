package service.user;

import bean.User;
import dao.DaoFactory;
import dao.UserDao;

/**
 * Created by Антон on 16.04.2016.
 */
public class LoginUserService {
    public static User execute(String login, String password){
        UserDao dao = DaoFactory.getUserDao();
        return dao.login(login, password);
    }
}
