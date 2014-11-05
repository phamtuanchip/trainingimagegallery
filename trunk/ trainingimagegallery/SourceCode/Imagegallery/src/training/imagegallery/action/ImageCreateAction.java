package training.imagegallery.action;

import java.io.File;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.DAOImpl.CategoryDAOImpl;
import training.imagegallery.DAOImpl.ImageDAOImpl;
import training.imagegallery.form.ImageForm;
import training.imagegallery.model.Category;

import com.opensymphony.xwork2.ActionSupport;

public class ImageCreateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"Beans.xml");
	private ImageDAO imageDAOImpl = (ImageDAOImpl) context
			.getBean("ImageDAO");
	private CategoryDAO categoryDAOImpl = (CategoryDAOImpl) context
			.getBean("CategoryDAO");
	private List<Category> listCategory;
	private String category_name;
	private ImageForm imageForm;
	private File file;
	private String error, error2, error3;
	
	
	// action redirect to form Add Image
	public String redirectImageCreateForm() {
		setListCategory(categoryDAOImpl.listCategory());
		return SUCCESS;
	}
	
	// action save image in to database
	public String saveImage() throws Exception {
		// get category id in select box
		boolean check = true;
			if(imageForm.getImg_name() == null || imageForm.getImg_name().trim().equals("")){
				addFieldError("ImageName","The name is required");
				setError(getText("The name is required"));
				check = false;
			}
			if(imageForm.getImg_user_upload() == null || imageForm.getImg_user_upload().trim().equals("")){
				addFieldError("UserUpload", "The userUpload is required");
				setError2(getText("The UserUpload is required"));
				check = false;
			}
			if(check == false){
				return INPUT;
			}
		
		try{
		
		imageForm.setCategory_id(categoryDAOImpl.getCategory(category_name)
				.getId());
		imageDAOImpl.insertImage(imageForm);
		return SUCCESS;
		}catch (Exception e) {
			// TODO: handle exception
			return INPUT;
		}
	}
	

	// getter and setter
	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public ImageForm getImageForm() {
		return imageForm;
	}

	public void setImageForm(ImageForm imageForm) {
		this.imageForm = imageForm;
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError2() {
		return error2;
	}

	public void setError2(String error2) {
		this.error2 = error2;
	}

	public String getError3() {
		return error3;
	}

	public void setError3(String error3) {
		this.error3 = error3;
	}
}
