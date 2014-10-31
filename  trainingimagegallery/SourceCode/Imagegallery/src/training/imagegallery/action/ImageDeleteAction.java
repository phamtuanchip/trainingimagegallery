package training.imagegallery.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAOImpl.ImageDAOImpl;

import com.opensymphony.xwork2.ActionSupport;

public class ImageDeleteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private ImageDAOImpl imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
	private int imageId;
	public String DeleteRecordImage(){
		imageDAOImpl.deleteImage(imageId);
		return SUCCESS;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

}
