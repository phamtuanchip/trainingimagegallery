package training.imagegallery.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Category;
import training.imagegallery.model.Image;

import com.opensymphony.xwork2.ActionSupport;

public class ImageListAction extends ActionSupport {

	/**
	 * 
	 */
	
	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	@Autowired
	ImageDAO imageDAO =  applicationContext.getBean("ImageDAO", ImageDAO.class) ;
	
	private static final long serialVersionUID = 1L;
	private List<Image> listImage;
	private List<Image> listImage1;
	private List<Category> listCategory;
	
	public String listImage() throws SQLException{
		try{
		listImage = imageDAO.listImage();
//		System.out.println("name --" + listImage.get(0).getFile_img().length());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return SUCCESS;
	}
	public String redirectToSlideShow(){
		listImage1 = imageDAO.listImage();
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
