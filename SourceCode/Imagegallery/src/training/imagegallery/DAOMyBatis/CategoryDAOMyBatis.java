package training.imagegallery.DAOMyBatis;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.model.Category;
import training.imagegallery.util.MybatisSessionFactory;

public class CategoryDAOMyBatis implements CategoryDAO {

	@Override
	public int insertCategory(Category category ){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			CategoryDAO categoryDAO = session.getMapper(CategoryDAO.class);
			int count = categoryDAO.insertCategory(category);
			session.commit();
			return count;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Category> listCategory() {
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			CategoryDAO category = (CategoryDAO) session.getMapper(CategoryDAO.class);
			return category.listCategory();
		}finally{
			session.close();
		}
	}

	@Override
	public Category listCategoryById(int id) {
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			CategoryDAO category = (CategoryDAO) session.getMapper(CategoryDAO.class);
			return category.listCategoryById(id);
		}finally{
			session.close();
		}
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCategory(String name, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(int id, String name, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSequence() {
		// TODO Auto-generated method stub
		return 0;
	}
}
