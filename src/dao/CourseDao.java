package dao;

import bean.Course;
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
                coursesList.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
            return coursesList;
        } catch (SQLException e) {
            e.printStackTrace();
            return coursesList;
        }

    }
    
    public List<Course> getAll(){
        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_ALL_COURSES);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                courseList.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public void create(Course course){
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(INSERT_COURSE_QUERY);
            ps.setString(1, course.getName());
            ps.setString(2, course.getTechnology());
            ps.setInt(3, course.getIdLecturer());
            ps.setInt(4, course.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id){
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(DELETE_COURSE_QUERY);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Course course){
        if(course.getId() != null){
            try {
                PreparedStatement ps = DBUtil.getConnection().prepareStatement(UPDATE_COURSE_QUERY);
                ps.setString(1, course.getName());
                ps.setString(2, course.getTechnology());
                ps.setInt(3, course.getIdLecturer());
                ps.setInt(4, course.getPrice());
                ps.setInt(5, course.getId());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else create(course);
    }

    public Course getById(String id){
        Course course = null;
        if(id == null)
            return new Course();
        try {
            PreparedStatement ps = DBUtil.getConnection().prepareStatement(GET_COURSE_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                course = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}
