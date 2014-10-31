package training.imagegallery.action;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAOImpl.CategoryDAOImpl;
import training.imagegallery.DAOImpl.ImageDAOImpl;
import training.imagegallery.form.ImageForm;
import training.imagegallery.model.Category;
import training.imagegallery.model.Image;


import com.opensymphony.xwork2.ActionSupport;

public class ImageUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private CategoryDAOImpl categoryDAOImpl = (CategoryDAOImpl) context.getBean("CategoryDAO");
	private ImageDAOImpl imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
	private Image image;
	private ImageForm imageForm;
	private int imageId;
	private String category_name;
	private List<Category> listCategory;
	private Category categoryImage;
	
	public String redirectToFormEdit(){
		setListCategory(categoryDAOImpl.listCategory());
		image =imageDAOImpl.getImageById(imageId);
		categoryImage = categoryDAOImpl.listCategoryById(image.getCategory_id());
		return SUCCESS;
	}
	
	public String UpdateImage() throws FileNotFoundException{
		try{
		System.out.println("hello" + category_name);
		imageForm.setCategory_id(categoryDAOImpl.getCategory(category_name).getId());
		System.out.println("hello1" + imageForm.getCategory_id());
		imageDAOImpl.updateImage(imageForm);
		return SUCCESS;
		}catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
	}
	public ImageForm getImageForm() {
		return imageForm;
	}

	public void setImageForm(ImageForm imageForm) {
		this.imageForm = imageForm;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Category getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(Category categoryImage) {
		this.categoryImage = categoryImage;
	}

}
