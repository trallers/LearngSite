package test;


import bean.Certificate;
import bean.Course;
import bean.User;
import dao.CertificateDao;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Test;
import org.dbunit.dataset.IDataSet;
import org.dbunit.DBTestCase;

import java.io.FileInputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

/**
 * Created by Wadim on 4/30/16.
 */
public class CertificateDaoTest extends DBTestCase {
    private IDataSet dataSet;

    @Override
    protected IDataSet getDataSet() throws Exception {
        dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dao/certificate_dataset.xml"));
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

    public CertificateDaoTest(String testName) throws Exception {
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
        List<Certificate> listOfCertificates = CertificateDao.getInstance().getAll();
        Certificate actualCertificate = listOfCertificates.get(0);

        Certificate expectedCertificate = new Certificate(1, new User(2,"login2", "2", "student", "name2", "surname2", "phone2", "email2", false), new Course(1, "name1", "technology1", 3, 1), "data1", new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2007-01-01").getTime()));

        Assert.assertEquals(actualCertificate, expectedCertificate);
    }

    @Test
    public void testReadUnexpected() throws Exception {
        List<Certificate> listOfCertificates = CertificateDao.getInstance().getAll();
        Certificate actualCertificate = listOfCertificates.get(0);

        Certificate expectedCertificate = new Certificate(1, new User(1,"znexie", "1234", "admin", "Anton", "Shulga", "+375222211220", "znexie@gmail.com", false), new Course(3, "Advanced JS: Natural Simulations", "JS", 3, 200), "10 iz 10 paranek!!", new java.util.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-20").getTime()));

        Assert.assertNotEquals(actualCertificate, expectedCertificate);
    }

    @Test
    public void testReadNull() {
        Certificate expectedCertificate = CertificateDao.getInstance().getById("10000");

        Assert.assertNull(expectedCertificate);
    }

    @Test
    public void testReadNegativeId() {
        Certificate expectedCertificate = CertificateDao.getInstance().getById("-2");

        Assert.assertNull(expectedCertificate);
    }

    @Test
    public void testReadOnNonCorrectId() {
        Certificate expectedCertificate = CertificateDao.getInstance().getById("nooooo");

        Assert.assertNull(expectedCertificate);
    }

    @Test
    public void testReadNullString() {
        String s = "100000";
        Certificate expectedCertificate = CertificateDao.getInstance().getById(s);

        Assert.assertNull(expectedCertificate);
    }

    @Test
    public void testReadOnNonCorrectIdString() {
        String s = "asdqee";
        Certificate expectedCertificate = CertificateDao.getInstance().getById(s);

        Assert.assertNull(expectedCertificate);
    }

    @Test
    public void testCreateNull() {
        Certificate certificate = new Certificate();

        Assert.assertFalse(CertificateDao.getInstance().create(certificate));
    }

    @Test
    public void testCreateWithSomeNullFields() {
        Certificate certificate = new Certificate();
        certificate.setId(1);
        certificate.setData("some data");

        Assert.assertFalse(CertificateDao.getInstance().create(certificate));
    }

    @Test
    public void testCreate() throws Exception {
        Certificate certificate = new Certificate(15, new User(1,"znexie", "1234", "admin", "Anton", "Shulga", "+375292237896", "znexie@gmail.com", false), new Course(3, "Advanced JS: Natural Simulations", "JS", 3, 200), "10 iz 10 paranek!!", new java.util.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2049-03-20").getTime()));

        Assert.assertTrue(CertificateDao.getInstance().create(certificate));
    }

    @Test
    public void testCreateWithExistingId() throws Exception {
        Certificate certificate = new Certificate(1, new User(1,"znexie", "1234", "admin", "Anton", "Shulga", "+375292237896", "znexie@gmail.com", false), new Course(3, "Advanced JS: Natural Simulations", "JS", 3, 200), "10 iz 10 paranek!!", new java.util.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2049-03-20").getTime()));

        Assert.assertTrue(CertificateDao.getInstance().create(certificate));
    }

    @Test
    public void testDelete() {
        Assert.assertTrue(CertificateDao.getInstance().delete("2"));
    }

    @Test(expected = SQLException.class)
    public void testDeleteNegativeId() {
        CertificateDao.getInstance().delete("-2");
    }

    @Test(expected = SQLException.class)
    public void testDeleteNonExistingElement() {
        CertificateDao.getInstance().delete("222");
    }

    @Test(expected = SQLException.class)
    public void testDeleteWithWrongParam() {
        CertificateDao.getInstance().delete("kek");
    }

    @Test(expected = SQLException.class)
    public void testDeleteNonExistingElementString() {
        String s = "222";
        CertificateDao.getInstance().delete(s);
    }

    @Test(expected = SQLException.class)
    public void testDeleteWithWrongString() {
        String s = "kek";
        CertificateDao.getInstance().delete(s);
    }

    @Test
    public void testGetByFirstId() {
        List<Certificate> listOfCertificates = CertificateDao.getInstance().getAll();
        Assert.assertEquals(listOfCertificates.get(0), CertificateDao.getInstance().getById("1"));
    }

    @Test
    public void testGetBySecondId() {
        List<Certificate> listOfCertificates = CertificateDao.getInstance().getAll();
        Assert.assertEquals(listOfCertificates.get(1), CertificateDao.getInstance().getById("2"));
    }

    @Test
    public void testGetByNonEqualsId() {
        List<Certificate> listOfCertificates = CertificateDao.getInstance().getAll();
        Assert.assertNotEquals(listOfCertificates.get(0), CertificateDao.getInstance().getById("2"));
    }

    @Test
    public void testGetByNonExistingId() {
        Assert.assertNull(CertificateDao.getInstance().getById("555"));
    }

    @Test
    public void testGetByNegativeId() {
        Assert.assertNull(CertificateDao.getInstance().getById("-555"));
    }

    @Test
    public void testGetByWrongId() {
        Assert.assertNull(CertificateDao.getInstance().getById("zzz"));
    }

    @Test
    public void testGetByNullId() {
        String s = new String();
        Assert.assertNull(CertificateDao.getInstance().getById(s));
    }

    @Test
    public void testGetByWrongString() {
        String s = "asdasd";
        Assert.assertNull(CertificateDao.getInstance().getById(s));
    }

    @Test
    public void testGetByString() {
        String s = "1";
        Assert.assertNotNull(CertificateDao.getInstance().getById(s));
    }

    @Test
    public void testGetAll() {
        Assert.assertNotNull(CertificateDao.getInstance().getAll());
    }
}
