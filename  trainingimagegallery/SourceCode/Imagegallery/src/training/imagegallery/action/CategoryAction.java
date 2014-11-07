package training.imagegallery.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.DAOImpl.CategoryDAOImpl;
import training.imagegallery.form.CategoryForm;
import training.imagegallery.model.Category;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"Beans.xml");
	private CategoryDAO categoryDaoImpl = (CategoryDAOImpl) applicationContext
			.getBean("CategoryDAO");
	private CategoryForm categoryForm;
	private List<Category> categoryList;
	private Integer categoryId;
	private Category category;
	public String rerdirectToCategoryAdd(){
		return SUCCESS;
	}

	public String categoryAdd() throws Exception {
		categoryDaoImpl.insertCategory(categoryForm.getName(), categoryForm.getDescription());
		return SUCCESS;
	}
	public String redirectCategoryUpdate(){
		category = categoryDaoImpl.listCategoryById(categoryId);
		return SUCCESS;
	}
	
	public String categoryUpdate(){
		
		return SUCCESS;
	}
	public String categoryList(){
		categoryList = categoryDaoImpl.listCategory();
		System.out.println(categoryList.get(1).getName());
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
