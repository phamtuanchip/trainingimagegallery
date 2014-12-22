package training.imagegallery.DAO;

import java.util.List;

import javax.sql.DataSource;

import training.imagegallery.model.Category;

public interface CategoryDAO {
	
	public List<Category> listCategory();
	public int insertCategory(Category category);
	public Category listCategoryById(int id);
	
	/*
	 * using spring JDBC
	public void insertCategory( String name, String description);
	public void updateCategory( int id, String name,String description);
	public Category listCategoryById(int id);
	public Category getCategory(String name);
	public void deleteCategory(int id);
	public List<Category> listCategory();
	public int getSequence();
	public void setDataSource(DataSource dataSource);
	*/
}
