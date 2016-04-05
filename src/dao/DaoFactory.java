package dao;

/**
 * Created by Антон on 05.04.2016.
 */
public  class DaoFactory {


    public static UserDao getUserDao(){
        return UserDao.getInstance();
    }

    public static LessonDao getLessonDao(){
        return LessonDao.getInstance();
    }

    public static CourseDao getCourseDao(){
        return CourseDao.getInstance();
    }

    public static CertificateDao getCertificateDao(){
        return CertificateDao.getInstance();
    }


}
