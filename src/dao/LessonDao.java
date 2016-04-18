package dao;

import bean.Lesson;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 04.04.2016.
 */
public class LessonDao {
    public static final String GET_LESSONS_BY_USER_ID_QUERY = "SELECT passed_lesson.id_lesson, course.name, data_for_lesson.data FROM passed_lesson INNER JOIN lesson ON passed_lesson.id_lesson = lesson.id INNER JOIN course ON lesson.id_course = course.id INNER JOIN data_for_lesson ON lesson.id_data = data_for_lesson.id WHERE passed_lesson.id_student = ?";

    public static final String GET_ALL_LESSONS = "SELECT  lesson.id, course.name, data_for_lesson.data FROM lesson INNER JOIN course ON lesson.id_course = course.id INNER JOIN data_for_lesson ON lesson.id_data = data_for_lesson.id";
    private static final String GET_LESSONS_BY_LECTURER_ID_QUERY = "SELECT lesson.id, course.name, data_for_lesson.data FROM lesson INNER JOIN course on lesson.id_course = course.id INNER JOIN data_for_lesson ON lesson.id_data = data_for_lesson.id WHERE course.id_lecturer = ?";
    private static final String GET_LESSON_BY_ID = "SELECT lesson.id, course.name, data_for_lesson.data FROM lesson INNER JOIN course on lesson.id_course = course.id INNER JOIN data_for_lesson ON lesson.id_data = data_for_lesson.id WHERE lesson.id = ?";
    private static final String UPDATE_LESSON_QUERY = "";
    private static final String INSERT_DATA_QUERY = "INSERT INTO data_for_lesson (data) VALUES (?)";
    private static final String DELETE_LESSON_QUERY = "";

    private final static LessonDao instance = new LessonDao();
    private static final String GET_COURSE_ID = "SELECT course.id FROM course WHERE course.name = ?";
    private static final String INSERT_LESSON_QUERY = "INSERT INTO lesson (id_course, id_data) VALUES (?,?)";


    private LessonDao(){}

    public final static LessonDao getInstance() {
        return instance;
    }

    public  List<Lesson> getByUserID(String userID){
        List<Lesson> lessonList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_LESSONS_BY_USER_ID_QUERY);
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                lessonList.add(new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return lessonList;
    }

    public List<Lesson> getAll(){
        List<Lesson> lessonList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_ALL_LESSONS);
            ResultSet rs  = ps.executeQuery();
            while (rs.next())
                lessonList.add(new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessonList;
    }

    public List<Lesson> getByLecturerId(String id) {
        List<Lesson> lessonList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_LESSONS_BY_LECTURER_ID_QUERY);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lessonList.add(new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return lessonList;
    }

    public Lesson getById(String id){
        Lesson lesson = null;
        if(id == null)
            return new Lesson();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_LESSON_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                lesson = new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesson;
    }

    public boolean create(Lesson lesson){
        int idCourse=0;
        int idData=0;
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(INSERT_DATA_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, lesson.getData());
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            while (result.next()){
                idData = result.getInt(1);
            }
            PreparedStatement prSt =DBUtil.getConnection().prepareStatement(GET_COURSE_ID);
            prSt.setString(1, lesson.getCourseName());
            ResultSet rs = prSt.executeQuery();
            while (rs.next()){
                idCourse = rs.getInt(1);
            }
            PreparedStatement pst = DBUtil.getConnection().prepareStatement(INSERT_LESSON_QUERY);
            pst.setInt(1, idCourse);
            pst.setInt(2, idData);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id){
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(DELETE_LESSON_QUERY);
            ps.setString(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(Lesson lesson){
        if(lesson.getId() != null){
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(UPDATE_LESSON_QUERY);
                ps.setString(1, lesson.getCourseName());
                ps.setString(2, lesson.getData());
                ps.setInt(3, lesson.getId());
                ps.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else create(lesson);
        return true;
    }
}
