package training.imagegallery.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.model.Category;
import training.imagegallery.util.MybatisSessionFactory;

public class CategoryService {
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
}
