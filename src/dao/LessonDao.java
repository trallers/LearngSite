package dao;

import bean.Course;
import bean.Data;
import bean.Lesson;
import service.course.GetCourseByIdService;
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
    public static final String GET_LESSONS_BY_USER_ID_QUERY = "SELECT passed_lesson.id_lesson, lesson.id_course, lesson.id_data FROM passed_lesson INNER JOIN lesson ON passed_lesson.id_lesson = lesson.id  WHERE passed_lesson.id_student = ?";

    public static final String GET_ALL_LESSONS = "SELECT  * FROM lesson";
    private static final String GET_LESSONS_BY_LECTURER_ID_QUERY = "SELECT lesson.id, lesson.id_course, lesson.id_data FROM lesson INNER JOIN course on lesson.id_course = course.id WHERE course.id_lecturer = ?";
    private static final String GET_LESSON_BY_ID = "SELECT * FROM lesson WHERE id = ?";
    private static final String UPDATE_LESSON_QUERY = "UPDATE lesson SET id_course = ?, id_data = ? WHERE id = ?";
    private static final String INSERT_DATA_QUERY = "INSERT INTO data_for_lesson (data) VALUES (?)";
    private static final String UPDATE_DATA_QUERY = "UPDATE data_for_lesson SET data = ? WHERE id = ?";
    private static final String DELETE_LESSON_QUERY = "DELETE FROM lesson WHERE id = ?  ";

    private final static LessonDao instance = new LessonDao();
    private static final String GET_COURSE_ID = "SELECT course.id FROM course WHERE course.name = ?";
    private static final String INSERT_LESSON_QUERY = "INSERT INTO lesson (id_course, id_data) VALUES (?,?)";
    private static final String GET_DATA_BY_ID_QUERY = "SELECT * FROM data_for_lesson WHERE id = ?";


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
                Integer dataId = rs.getInt(3);
                Data data = getDataById(dataId);
                Course course = GetCourseByIdService.execute(rs.getString(2));
                lessonList.add(new Lesson(rs.getInt(1), course, data));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return lessonList;
    }

    public Data getDataById(Integer dataId){
        PreparedStatement ps = null;
        try {
            ps = DBUtil.getConnection().prepareStatement(GET_DATA_BY_ID_QUERY);
            ps.setInt(1, dataId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
              return  new Data(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Lesson> getAll(){
        List<Lesson> lessonList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_ALL_LESSONS);
            ResultSet rs  = ps.executeQuery();
            while (rs.next()) {
                Integer dataId = rs.getInt(3);
                Data data = getDataById(dataId);
                Course course = GetCourseByIdService.execute(rs.getString(2));
                lessonList.add(new Lesson(rs.getInt(1), course, data));
            }

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
                Integer dataId = rs.getInt(3);
                Data data = getDataById(dataId);
                Course course = GetCourseByIdService.execute(rs.getString(2));
                lessonList.add(new Lesson(rs.getInt(1), course, data));
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
            while (rs.next()) {
                Integer dataId = rs.getInt(3);
                Data data = getDataById(dataId);
                Course course = GetCourseByIdService.execute(rs.getString(2));
                lesson = new Lesson(rs.getInt(1), course, data);
            }

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
            ps.setString(1, lesson.getData().getData());
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            while (result.next()){
                idData = result.getInt(1);
            }
            ps = DBUtil.getConnection().prepareStatement(INSERT_LESSON_QUERY);
            ps.setInt(1, lesson.getCourse().getId());
            ps.setInt(2, idData);
            ps.execute();
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
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(UPDATE_DATA_QUERY);
                ps.setString(1, lesson.getData().getData());
                ps.setInt(2, lesson.getData().getId());
                ps.execute();
                ps = DBUtil.getConnection().prepareStatement(UPDATE_LESSON_QUERY);
                ps.setInt(1, lesson.getCourse().getId());
                ps.setInt(2, lesson.getData().getId());
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
