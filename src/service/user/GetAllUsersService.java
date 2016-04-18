package service.user;

import bean.User;
import dao.DaoFactory;
import dao.UserDao;

import java.util.List;

/**
 * Created by Антон on 15.04.2016.
 */
public class GetAllUsersService {
    public static List<User> execute(){
        UserDao dao = DaoFactory.getUserDao();
        return dao.getAll();
    }
}
