package training.imagegallery.DAOMyBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.model.Category;
import training.imagegallery.util.MybatisSessionFactory;

public class CategoryDAOMyBatis implements CategoryDAO {
	public List<Category> listAllCategory(){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			CategoryDAO category = (CategoryDAO) session.getMapper(CategoryDAO.class);
			return category.listCategory();
		}finally{
			session.close();
		}
	}
	
	public Category getCategoryById(int id){
		SqlSession session = MybatisSessionFactory.openSession();
		try{
			CategoryDAO category = (CategoryDAO) session.getMapper(CategoryDAO.class);
			return category.listCategoryById(id);
		}finally{
			session.close();
		}
	}
	
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
		// TODO Auto-generated method stub
		return null;
	}
}
