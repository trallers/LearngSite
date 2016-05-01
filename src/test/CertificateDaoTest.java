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
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

/**
 * Created by Wadim on 4/30/16.
 */
public class CertificateDaoTest extends DBTestCase {
    private IDataSet dataSet;
    private List<Certificate> listOfCertificates = CertificateDao.getInstance().getAll();

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
        return DatabaseOperation.NONE;
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
        Certificate actualCertificate = listOfCertificates.get(0);

        Certificate expectedCertificate = new Certificate(1, new User(1,"znexie", "1234", "admin", "Anton", "Shulga", "+375257576982", "znexie@gmail.com", false), new Course(3, "Advanced JS: Natural Simulations", "JS", 3, 200), "10 iz 10 paranek!!", new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-20").getTime()));

        Assert.assertEquals(actualCertificate, expectedCertificate);
    }

    @Test
    public void testReadNull() {
        Certificate expectedCertificate = CertificateDao.getInstance().getById("10000");

        Assert.assertNull(expectedCertificate);
    }

    @Test
    public void testCreateNull() {
        Certificate certificate = new Certificate();

        Assert.assertFalse(CertificateDao.getInstance().create(certificate));
    }
}
