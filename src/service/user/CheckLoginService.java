package service.user;

import dao.DaoFactory;
import dao.UserDao;

/**
 * Created by Антон on 27.04.2016.
 */
public class CheckLoginService {
    public static boolean execute(String login){
        UserDao dao = DaoFactory.getUserDao();
        return dao.isLoginExist(login);
    }
}
