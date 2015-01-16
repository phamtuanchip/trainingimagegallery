package training.imagegallery.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.form.CategoryForm;
import training.imagegallery.model.Category;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	
	@Autowired
	CategoryDAO categoryDAO = (CategoryDAO) applicationContext.getBean("CategoryDAO");
	private CategoryForm categoryForm;
	private List<Category> categoryList;
	private Integer categoryId;
	private Category category;
	
	public String rerdirectToCategoryAdd(){
		return SUCCESS;
	}

	public String categoryAdd() throws Exception {
		try{
		category = new Category();
		category.setName(categoryForm.getName());
		category.setDescription(categoryForm.getDescription());
		categoryDAO.insertCategory(category);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		//categoryDaoImpl.insertCategory(category);
		return SUCCESS;
	}
	
	public String categoryUpdate(){
		
		return SUCCESS;
	}
	public String categoryList(){
		categoryList = categoryDAO.listCategory();
		return SUCCESS;
	}
	
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public CategoryForm getCategoryForm() {
		return categoryForm;
	}
	public void setCategoryForm(CategoryForm categoryForm) {
		this.categoryForm = categoryForm;
	}

	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
