package test;

import bean.Course;
import bean.Data;
import bean.Lesson;
import dao.LessonDao;
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
public class LessonDaoTest extends DBTestCase {
    private IDataSet dataSet;

    @Override
    protected IDataSet getDataSet() throws Exception {
        dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dao/lesson_dataset.xml"));
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

    public LessonDaoTest(String testName) throws Exception {
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
        List<Lesson> listOfLessons = LessonDao.getInstance().getAll();
        Lesson actualLesson = listOfLessons.get(0);

        Lesson expectedLesson = new Lesson(1, new Course(), new Data(1, "data1"));

        Assert.assertEquals(actualLesson, expectedLesson);
    }

    @Test
    public void testReadUnexpected() throws Exception {
        List<Lesson> listOfLessons = LessonDao.getInstance().getAll();
        Lesson actualLesson = listOfLessons.get(0);

        Lesson expectedLesson = new Lesson(2, new Course(), new Data(1, "data1"));

        Assert.assertNotEquals(actualLesson, expectedLesson);
    }

    @Test
    public void testReadNull() {
        Lesson lesson = LessonDao.getInstance().getById("333");

        Assert.assertNull(lesson);
    }

    @Test
    public void testReadNullTilda() {
        Lesson lesson = LessonDao.getInstance().getById("~");

        Assert.assertNull(lesson);
    }
    @Test
    public void testReadNullSymbol() {
        Lesson lesson = LessonDao.getInstance().getById(".");

        Assert.assertNull(lesson);
    }
    @Test
    public void testReadSum() {
        Lesson lesson = LessonDao.getInstance().getById("1+2");

        Assert.assertNotNull(lesson);
    }
    @Test
    public void testReadMinus() {
        Lesson lesson = LessonDao.getInstance().getById("2-1");

        Assert.assertNull(lesson);
    }

    @Test
    public void testReadOnNonCorrectId() {
        Lesson lesson = LessonDao.getInstance().getById("asdqqwe");

        Assert.assertNull(lesson);
    }

    @Test
    public void testCreateNull() {
        Lesson lesson = new Lesson();

        Assert.assertFalse(LessonDao.getInstance().create(lesson));
    }

    @Test
    public void testCreateWithSomeNullFields() {
        Lesson lesson = new Lesson();
        lesson.setId(1);

        Assert.assertFalse(LessonDao.getInstance().create(lesson));
    }

    @Test
    public void testCreate() {
        Lesson lesson = new Lesson(1, new Course(), new Data(1, "data1"));

        Assert.assertTrue(LessonDao.getInstance().create(lesson));
    }

    @Test
    public void testCreateWithExistingId() {
        Lesson lesson = new Lesson(1, new Course(), new Data(1, "data1"));

        Assert.assertTrue(LessonDao.getInstance().create(lesson));
    }

    @Test
    public void testDelete() {
        Assert.assertTrue(LessonDao.getInstance().delete("1"));
    }

    @Test(expected = SQLException.class)
    public void testDeleteNonExistingElement() {
        LessonDao.getInstance().delete("222");
    }

    @Test(expected = SQLException.class)
    public void testDeleteWithWrongParam() {
        LessonDao.getInstance().delete("kek");
    }

    @Test
    public void testGetById() {
        List<Lesson> listOfLesson = LessonDao.getInstance().getAll();
        Assert.assertEquals(listOfLesson.get(0), LessonDao.getInstance().getById("1"));
    }

    @Test
    public void testGetByNonExistingId() {
        Assert.assertNull(LessonDao.getInstance().getById("322"));
    }

    @Test
    public void testGetByNegativeId() {
        Assert.assertNull(LessonDao.getInstance().getById("-322"));
    }

    @Test
    public void testGetByWrongId() {
        Assert.assertNull(LessonDao.getInstance().getById("rly"));
    }

    @Test
    public void testGetAll() {
        Assert.assertNotNull(LessonDao.getInstance().getAll());
    }
}