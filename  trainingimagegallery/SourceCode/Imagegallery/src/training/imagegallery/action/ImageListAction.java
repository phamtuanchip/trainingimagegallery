package training.imagegallery.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAOImpl.CategoryDAOImpl;
import training.imagegallery.DAOImpl.ImageDAOImpl;
import training.imagegallery.model.Category;
import training.imagegallery.model.Image;

import com.opensymphony.xwork2.ActionSupport;

public class ImageListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private ImageDAOImpl imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
	private CategoryDAOImpl categoryDAOImpl = (CategoryDAOImpl)context.getBean("CategoryDAO");
	private List<Image> listImage;
	private List<Category> listCategory;
	
	public String listImage() throws SQLException{
		listImage = imageDAOImpl.listImage();
		//System.out.println("name --" + listImage.get(0).getFile_img().length());
		listCategory = categoryDAOImpl.listCategory();
		return SUCCESS;
	}
	
	public List<Image> getListImage() {
		return listImage;
	}
	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
}
