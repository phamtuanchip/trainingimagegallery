package training.imagegallery.DAOImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.mapper.CategoryMapper;
import training.imagegallery.model.Category;

@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	
	@SuppressWarnings("unused")
	private DataSource datasource;
	
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	@Override
	public void insertCategory(String name, String description) {
		// TODO Auto-generated method stub
		final int id = getSequence();
		String SQL ="INSERT INTO category_img VALUES(?,?,?, TO_CHAR(SYSDATE,'DD-MON-YYYY'))";
		jdbcTemplate.update(SQL, id , name, description);
	}

	@Override
	public void updateCategory(int id, String name,String description) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE category_img SET name=?. description=? WHERE id=? ";
		jdbcTemplate.update(SQL, name,description,id);
		
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM category_img WHERE id=?";
		jdbcTemplate.update(SQL, id);
		
	}

	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		String SQL = "SELECT*FROM category_img ORDER BY id";
		List<Category> listCategory = jdbcTemplate.query(SQL, new CategoryMapper());
		return listCategory;
	}

	@Override
	public Category listCategoryById(int id) {
		// TODO Auto-generated method stub
		String SQL = "SELECT*FROM category_img WHERE id =?";
		Category category = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new CategoryMapper());
		return category;
	}

	@Override
	public Category getCategory(String name) {
		// TODO Auto-generated method stub
		String SQL = "SELECT*FROM category_img WHERE cat_name = ?";
		Category category = jdbcTemplate.queryForObject(SQL, new Object[]{name}, new CategoryMapper());
		return category;
	}

	@Override
	public int getSequence() {
		// TODO Auto-generated method stub
		String SQL = "SELECT category_id_seq.NEXTVAL FROM DUAL";
		final int id = jdbcTemplate.queryForInt(SQL);
		return id;
	}

}
