package training.imagegallery.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.DAOImpl.ImageDAOImpl;
import training.imagegallery.service.ImageService;

import com.opensymphony.xwork2.ActionSupport;

public class ImageDeleteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//	private ImageDAO imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
	private int imageId;
	private ImageService imageService;
	
	public String DeleteRecordImage(){
		imageService = new ImageService();
		imageService.deleteImage(imageId);
	//	imageDAOImpl.deleteImage(imageId);
		return SUCCESS;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

}
