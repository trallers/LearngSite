package service.user;

import bean.User;
import dao.DaoFactory;
import dao.UserDao;

/**
 * Created by Антон on 16.04.2016.
 */
public class RegisterUserService {
    public static Integer execute(User user){
        UserDao dao = DaoFactory.getUserDao();
        return dao.create(user);
    }
}
