package service.user;

import bean.User;
import dao.DaoFactory;
import dao.UserDao;

import java.util.List;

/**
 * Created by Антон on 24.04.2016.
 */
public class GetAllStudentsService {
    public static List<User> execute(){
        UserDao dao = DaoFactory.getUserDao();
        return dao.getStudents();
    }
}
