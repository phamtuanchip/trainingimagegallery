package training.imagegallery.action;

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

public class ImageUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	@Autowired
	ImageDAO imageDAO = (ImageDAO) applicationContext.getBean("ImageDAO") ;
	
	@Autowired
	CategoryDAO categoryDAO = (CategoryDAO) applicationContext.getBean("CategoryDAO") ;
	
	private static final long serialVersionUID = 1L;
	private Integer imageId;
	private List<Category> listCategory;
	private Category categoryImage;
	private Image image;
	private String error, error2, error3;
	
	public String redirectToFormEdit(){
		image = imageDAO.getImage(imageId);
		listCategory = categoryDAO.listCategory();
		//image =imageDAOImpl.getImageById(imageId);
		int i = 0;
		for(Category cate : listCategory){
			if(cate.getId() == image.getCategory_id()){
				break;
			}
			i = i +1;
		}
		listCategory.remove(i);
		categoryImage = categoryDAO.listCategoryById(image.getCategory_id());
		return SUCCESS;
	}
	
	public String UpdateImage(){
		try{
		image = new Image();
		image.setId(image.getId());
		image.setImg_name(image.getImg_name());
		image.setImg_description(image.getImg_description());
		image.setCategory_id(image.getCategory_id());
		
		image.setImg_userUpLoad(image.getImg_userUpLoad());
		if(image.getFile() != null){
			image.setImg_size(String.valueOf(image.getFile().length()/1024));
			image.setImage_file(TranferToByteArray.ByteArray(image.getFile()));
		}
		imageDAO.updateImage(image);	
		
//		imageDAOImpl.updateImage(image);
//		if(image.getFile() != null){
//			imageDAOImpl.updateFileImage(image.getId(), image.getFile());
//			return SUCCESS;
//		}else{
		return SUCCESS;
//		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
			return INPUT;
		}
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	
	
}
