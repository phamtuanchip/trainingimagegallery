package training.imagegallery.action;

import java.sql.SQLException;
import java.util.List;

import training.imagegallery.model.Category;
import training.imagegallery.model.Image;
import training.imagegallery.service.ImageService;

import com.opensymphony.xwork2.ActionSupport;

public class ImageListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//	private ImageDAO imageDAOImpl = (ImageDAO) context.getBean("ImageDAO");
//	private CategoryDAO categoryDAO = (CategoryDAO)context.getBean("CategoryDAO");
	private List<Image> listImage;
	private List<Image> listImage1;
	private ImageService imageService;
	private List<Category> listCategory;
	
	public String listImage() throws SQLException{
		imageService = new ImageService();
		listImage = imageService.listImage();
		//System.out.println("name --" + listImage.get(0).getFile_img().length());
				
		return SUCCESS;
	}
	public String redirectToSlideShow(){
		imageService = new ImageService();
		listImage1 =imageService.listImage();
		return SUCCESS;
	}
	
	
	

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public List<Image> getListImage1() {
		return listImage1;
	}
	public void setListImage1(List<Image> listImage1) {
		this.listImage1 = listImage1;
	}
	public List<Image> getListImage() {
		return listImage;
	}
	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}
	
}
