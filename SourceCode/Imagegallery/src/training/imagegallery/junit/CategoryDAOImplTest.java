package training.imagegallery.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import training.imagegallery.DAOImpl.CategoryDAOImpl;

import com.opensymphony.xwork2.interceptor.annotations.After;

public class CategoryDAOImplTest extends TestCase {
	private Connection dbConnection = null;
	private Statement statement = null;
	@Before
	public void setUp() throws Exception {
				dbConnection = getConnection();
				statement = dbConnection.createStatement();
	}

	@After
	public void tearDown() throws Exception {
		dbConnection.close();
	}

	@Test
	public void Create() {
		// categoryDAOImpl.insertCategory("hello");
		// ApplicationContext application = new
		// ClassPathXmlApplicationContext("Beans.xml");
		// CategoryDAOImpl categoryDAOImpl = (CategoryDAOImpl)
		// application.getBean("CategoryDAO");
//		IDataSet databaseDataSet = getConnection().createDataSet();
//		int initialCount = jdbcTemplate
//				.queryForInt("SELECT COUNT(1) FROM category_img");
//		categoryDAOImpl.insertCategory("Phong Canh", "Hinh anh tu nhien");
//		org.junit.Assert.assertEquals(initialCount + 1,
//				jdbcTemplate.queryForInt("SELECT COUNT(1) FROM category_img"));
		
	}

	public static Connection getConnection(){
		 Connection dbConnection = null;
		 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ifi12g", "IMAGEGALLERY",
						"admin");
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 return dbConnection;
	}
}
