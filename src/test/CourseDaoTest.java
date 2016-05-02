package test;

import bean.Course;
import dao.CourseDao;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


/**
 * Created by Wadim on 5/2/16.
 */
public class CourseDaoTest extends DBTestCase{
    private IDataSet dataSet;

    @Override
    protected IDataSet getDataSet() throws Exception {
        dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dao/course_dataset.xml"));
        return dataSet;
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.NONE;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.CLEAN_INSERT;
    }

    public CourseDaoTest(String testName) throws Exception {
        super(testName);

        Properties property = new Properties();
        property.load(new FileInputStream("src/resources/db.properties"));

        String driver = property.getProperty("driver");
        String url = property.getProperty("url");
        String login = property.getProperty("login");
        String password = property.getProperty("password");

        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, driver);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, url);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, login);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, password);
    }

    @Test
    public void testConnection() throws Exception {
        IDatabaseConnection dbConnection = getConnection();
        Assert.assertNotNull(dbConnection);
    }

    @Test
    public void testRead() throws Exception {
        List<Course> listOfCourses = CourseDao.getInstance().getAll();
        Course actualCourse = listOfCourses.get(0);

        Course expectedCourse = new Course(1,"name1", "technology1", 3, 1);

        Assert.assertEquals(actualCourse, expectedCourse);
    }

    @Test
    public void testReadUnexpected() throws Exception {
        List<Course> listOfCourses = CourseDao.getInstance().getAll();
        Course actualCourse = listOfCourses.get(0);

        Course expectedCourse = new Course(1,"name2", "technology2", 3, 1);

        Assert.assertNotEquals(actualCourse, expectedCourse);
    }

    @Test
    public void testReadNull() {
        Course course = CourseDao.getInstance().getById("333");

        Assert.assertNull(course);
    }

    @Test
    public void testReadOnNonCorrectId() {
        Course course = CourseDao.getInstance().getById("ahaha");

        Assert.assertNull(course);
    }

    @Test
    public void testCreateNull() {
        Course course = new Course();

        Assert.assertFalse(CourseDao.getInstance().create(course));
    }

    @Test
    public void testCreateWithSomeNullFields() {
        Course course = new Course();
        course.setId(1);
        course.setIdLecturer(3);

        Assert.assertFalse(CourseDao.getInstance().create(course));
    }

    @Test
    public void testCreate() {
        Course course = new Course(5, "name5", "technology5", 3, 5);

        Assert.assertTrue(CourseDao.getInstance().create(course));
    }

    @Test
    public void testCreateWithExistingId() {
        Course course = new Course(1, "name1", "technology1", 3, 1);

        Assert.assertTrue(CourseDao.getInstance().create(course));
    }

    @Test
    public void testDelete() {
        Assert.assertTrue(CourseDao.getInstance().delete("1"));
    }

    @Test(expected = SQLException.class)
    public void testDeleteNonExistingElement() {
        CourseDao.getInstance().delete("222");
    }

    @Test(expected = SQLException.class)
    public void testDeleteWithWrongParam() {
        CourseDao.getInstance().delete("kek");
    }

    @Test
    public void testGetById() {
        List<Course> listOfCourses = CourseDao.getInstance().getAll();
        Assert.assertEquals(listOfCourses.get(0), CourseDao.getInstance().getById("1"));
    }

    @Test
    public void testGetByNonExistingId() {
        Assert.assertNull(CourseDao.getInstance().getById("322"));
    }

    @Test
    public void testGetByWrongId() {
        Assert.assertNull(CourseDao.getInstance().getById("rly"));
    }

    @Test
    public void testGetAll() {
        Assert.assertNotNull(CourseDao.getInstance().getAll());
    }
}