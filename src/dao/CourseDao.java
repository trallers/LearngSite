package dao;

import bean.Course;
import bean.User;
import service.user.GetUserByIdService;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 03.04.2016.
 */
public class CourseDao {
    private final static String GET_COURSES_BY_USER_ID_QUERY = "SELECT c.id, c.name, c.technology, c.id_lecturer, c.price FROM course c INNER JOIN student_course sc ON c.id = sc.id_of_course where sc.id_of_student = ?";
    private static final String INSERT_COURSE_QUERY = "INSERT INTO course (name, technology, id_lecturer, price) VALUES (?,?,?,?)";
    private static final String UPDATE_COURSE_QUERY = "UPDATE course SET name = ?, technology = ?, id_lecturer = ?, price = ? WHERE id = ?";
    private static final String GET_COURSE_BY_ID = "SELECT * FROM course WHERE id = ?";
    private static final String GET_ALL_COURSES = "SELECT * FROM course";
    private static final String DELETE_COURSE_QUERY = "DELETE FROM course WHERE id = ?";

    private final static CourseDao instance = new CourseDao();
    private static final String GET_BY_LECTURER_ID = "SELECT * FROM course WHERE id_lecturer = ?";

    private CourseDao(){}

    public final static CourseDao getInstance() {
        return instance;
    }

    public  List<Course> getByUserId(String userID){
        List<Course> coursesList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_COURSES_BY_USER_ID_QUERY);
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer idLecturer = rs.getInt(4);
                User lecturer = GetUserByIdService.execute(idLecturer.toString());
                if(lecturer != null)
                    coursesList.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), lecturer, rs.getInt(5)));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return coursesList;
    }

    public List<Course> getAll(){
        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_ALL_COURSES);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer idLecturer = rs.getInt(4);
                User lecturer = GetUserByIdService.execute(idLecturer.toString());
                if(lecturer != null)
                    courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), lecturer, rs.getInt(5)));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public boolean create(Course course){
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(INSERT_COURSE_QUERY);
            ps.setString(1, course.getName());
            ps.setString(2, course.getTechnology());
            ps.setInt(3, course.getLecturer().getId());
            ps.setInt(4, course.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id){
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(DELETE_COURSE_QUERY);
            ps.setString(1, id);
            ps.execute();
            return true;
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Course course){
        if(course.getId() != null){
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(UPDATE_COURSE_QUERY);
                ps.setString(1, course.getName());
                ps.setString(2, course.getTechnology());
                ps.setInt(3, course.getLecturer().getId());
                ps.setInt(4, course.getPrice());
                ps.setInt(5, course.getId());
                ps.execute();
                return true;
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
                return false;
            }
        }else create(course);
        return true;
    }

    public Course getById(String id){
        Course course = null;
        if(id == null)
            return new Course();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_COURSE_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idLecturer = rs.getInt(4);
                User lecturer = GetUserByIdService.execute(idLecturer.toString());
                if(lecturer != null)
                    course = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), lecturer, rs.getInt(5));
            }

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return course;
    }

    public List<Course> getByLecturerId(String lecturerId){
        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_BY_LECTURER_ID);
            ps.setString(1,lecturerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer idLecturer = rs.getInt(4);
                User lecturer = GetUserByIdService.execute(idLecturer.toString());
                if(lecturer != null)
                    courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), lecturer, rs.getInt(5)));
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return courseList;
    }
}
