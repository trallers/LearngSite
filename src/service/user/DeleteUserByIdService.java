package service.user;

import dao.DaoFactory;
import dao.UserDao;

/**
 * Created by Антон on 17.04.2016.
 */
public class DeleteUserByIdService {
    public static boolean execute(String id){
        UserDao dao = DaoFactory.getUserDao();
        return dao.delete(id);
    }
}
