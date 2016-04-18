package service.user;

import dao.DaoFactory;
import dao.UserDao;

/**
 * Created by Антон on 17.04.2016.
 */
public class DeleteUserByIdService {
    public static void execute(String id){
        UserDao dao = DaoFactory.getUserDao();
        dao.delete(id);
    }
}
