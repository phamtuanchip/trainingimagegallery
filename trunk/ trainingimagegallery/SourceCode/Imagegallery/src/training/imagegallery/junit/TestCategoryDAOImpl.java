package training.imagegallery.junit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:Beans.xml" })
public class TestCategoryDAOImpl {

//	@Autowired
//	private DataSource datasource;
//
//	@Before
//	public void setUp() throws Exception {
//		// DatabaseOperation.CLEAN_INSERT.execute(get, arg1)
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//
//	private IDatabaseConnection getConnection() throws Exception {
//		// get connection
//		Connection con = datasource.getConnection();
//		DatabaseMetaData databaseMetaData = con.getMetaData();
//		IDatabaseConnection connection = new DatabaseConnection(con,
//				databaseMetaData.getUserName().toUpperCase());
//		DatabaseConfig config = connection.getConfig();
//		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY	, new Oracle11DataTypeFactory());
//		return connection;
//	}

}
