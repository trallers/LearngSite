package service.user;

import bean.User;
import dao.DaoFactory;
import dao.UserDao;

/**
 * Created by Антон on 16.04.2016.
 */
public class GetUserByIdService {
    public static User execute(String id){
        UserDao dao = DaoFactory.getUserDao();
        return dao.getByID(id);
    }
}
