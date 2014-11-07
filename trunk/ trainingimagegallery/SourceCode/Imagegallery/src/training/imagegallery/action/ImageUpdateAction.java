package training.imagegallery.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.DAO.ImageDAO;
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
	private CategoryDAO categoryDAOImpl = (CategoryDAOImpl) context.getBean("CategoryDAO");
	private ImageDAO imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
	private Image image;
	private ImageForm imageForm;
	private Integer imageId;
	private List<Category> listCategory;
	private Category categoryImage;
	private String error, error2, error3;
	
	public String redirectToFormEdit(){
		listCategory =categoryDAOImpl.listCategory();
		image =imageDAOImpl.getImageById(imageId);
		int i = 0;
		for(Category cate : listCategory){
			if(cate.getId() == image.getCategory_id()){
				break;
			}
			i = i +1;
		}
		listCategory.remove(i);
		categoryImage = categoryDAOImpl.listCategoryById(image.getCategory_id());
		return SUCCESS;
	}
	
	public String UpdateImage(){
		try{
		imageDAOImpl.updateImage(imageForm);
		if(imageForm.getFile() != null){
			imageDAOImpl.updateFileImage(imageForm.getId(), imageForm.getFile());
			return SUCCESS;
		}else{
		return SUCCESS;
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
			return INPUT;
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
	
	
	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Category getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(Category categoryImage) {
		this.categoryImage = categoryImage;
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
