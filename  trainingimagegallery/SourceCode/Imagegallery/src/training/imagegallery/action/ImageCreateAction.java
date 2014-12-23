package training.imagegallery.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Category;
import training.imagegallery.model.Image;
import training.imagegallery.util.TranferToByteArray;

import com.opensymphony.xwork2.ActionSupport;

public class ImageCreateAction extends ActionSupport {

	/**
	 * 
	 */
	@Autowired
	ImageDAO imageDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	private static final long serialVersionUID = 1L;
	private List<Category> listCategory;
	private Image image;
	private File file;
	private String error, error2, error3;
	
	
	// action redirect to form Add Image
	public String redirectImageCreateForm() {
		listCategory = categoryDAO.listCategory();
		return SUCCESS;
	}
	
	// action save image in to database
	@SuppressWarnings("null")
	public String saveImage() throws Exception {
		// get category id in select box
		boolean check = true;
			if(image.getImg_name() == null || image.getImg_name().trim().equals("")){
				addFieldError("ImageName","The name is required");
				setError(getText("Thse name is required"));
				check = false;
			}
			if(image.getImg_userUpLoad() == null || image.getImg_userUpLoad().trim().equals("")){
				addFieldError("UserUpload", "The userUpload is required");
				setError2(getText("The UserUpload is required"));
				check = false;
			}if(image.getCategory_id() == -1){
				addFieldError("Category", "The Category is required");
				setError3(getText("The Category is required"));
				check = false;
			}
			
			if(check == false){
				return INPUT;
			}
		try{
			image = new Image();
			image.setImg_name(image.getImg_name());
			image.setImg_description(image.getImg_description());
			image.setCategory_id(image.getCategory_id());
			image.setImg_size(String.valueOf(image.getFile().length()/1024));
			image.setImg_userUpLoad(image.getImg_userUpLoad());
			image.setImage_file(TranferToByteArray.ByteArray(image.getFile()));
			imageDAO.insertImage(image);
			//imageDAOImpl.insertImage(image);
		return SUCCESS;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
