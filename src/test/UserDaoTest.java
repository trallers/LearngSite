package test;

import bean.User;
import dao.UserDao;
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
public class UserDaoTest extends DBTestCase{
    private IDataSet dataSet;

    @Override
    protected IDataSet getDataSet() throws Exception {
        dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dao/user_dataset.xml"));
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

    public UserDaoTest(String testName) throws Exception {
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
        List<User> listOfUsers = UserDao.getInstance().getAll();
        User actualUser = listOfUsers.get(0);

        User expectedUser = new User(1, "login1", "1", "admin", "name1", "surname1", "phone1", "email1", false);

        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void testReadUnexpected() throws Exception {
        List<User> listOfUsers = UserDao.getInstance().getAll();
        User actualUser = listOfUsers.get(0);

        User expectedUser = new User(1, "login1", "1", "admin", "name1", "surname1", "phone1", "email1", true);

        Assert.assertNotEquals(actualUser, expectedUser);
    }

    @Test(expected = SQLException.class)
    public void testReadNull() {
        UserDao.getInstance().getByID("111");
    }

    @Test(expected = SQLException.class)
    public void testReadOnNonCorrectId() {
        UserDao.getInstance().getByID("ahaha");
    }

    @Test
    public void testCreateNull() {
        User user = new User();

        Assert.assertNull(UserDao.getInstance().create(user));
    }

    @Test
    public void testCreateWithSomeNullFields() {
        User user = new User();
        user.setId(1);
        user.setEmail("asdads@adads.com");

        Assert.assertNull(UserDao.getInstance().create(user));
    }

    @Test(expected = SQLException.class)
    public void testCreate() {
        User user = new User(5, "login1", "1", "admin", "name1", "surname1", "phone1", "email1", false);

        UserDao.getInstance().create(user);
    }

    @Test(expected = SQLException.class)
    public void testCreateWithExistingId() {
        User user = new User(1, "login1", "1", "admin", "name1", "surname1", "phone1", "email1", false);

        UserDao.getInstance().create(user);
    }

    @Test
    public void testDelete() {
        Assert.assertTrue(UserDao.getInstance().delete("1"));
    }

    @Test(expected = SQLException.class)
    public void testDeleteNonExistingElement() {
        UserDao.getInstance().delete("222");
    }

    @Test(expected = SQLException.class)
    public void testDeleteWithWrongParam() {
        UserDao.getInstance().delete("222");
    }

    @Test
    public void testGetById() {
        List<User> listOfUsers = UserDao.getInstance().getAll();
        Assert.assertEquals(listOfUsers.get(0), UserDao.getInstance().getByID("1"));
    }

    @Test(expected = SQLException.class)
    public void testGetByNonExistingId() {
        UserDao.getInstance().getByID("322");
    }

    @Test(expected = SQLException.class)
    public void testGetByWrongId() {
        UserDao.getInstance().getByID("rly");
    }

    @Test
    public void testGetAll() {
        Assert.assertNotNull(UserDao.getInstance().getAll());
    }

    @Test
    public void testLogin() {
        Assert.assertNotNull(UserDao.getInstance().login("login1", "1"));
    }

    @Test
    public void testWrongLogin() {
        Assert.assertNull(UserDao.getInstance().login("lasdla","asdas"));
    }

    @Test
    public void testLoginExist() {
        Assert.assertTrue(UserDao.getInstance().isLoginExist("login1"));
    }

    @Test
    public void testLoginNotExist() {
        Assert.assertFalse(UserDao.getInstance().isLoginExist("asdasda"));
    }
}