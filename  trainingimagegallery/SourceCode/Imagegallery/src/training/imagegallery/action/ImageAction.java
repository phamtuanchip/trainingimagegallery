package training.imagegallery.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Image;

import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	@Autowired
	ImageDAO imageDAO =  applicationContext.getBean("ImageDAO", ImageDAO.class) ;
	
	private static final long serialVersionUID = 1L;
	private Image image;
	private int imageId;
	private byte[] dataImage;
	@SuppressWarnings("unused")
	private HttpServletRequest servletRequest;
	public String execute(){
		return SUCCESS;
	}
	public byte[] getMyImageInBytes(){
		image = imageDAO.getImage(imageId);
		dataImage = image.getImage_file();
//			image = imageDAOImpl.getImageById(imageId);
//				dataImage = image.getImage_file();
		return dataImage;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.servletRequest = request;
		
	}
	
	public String getCustomContentType() {
		return "image/jpeg";
	}
 
	public String getCustomContentDisposition() {
		return "anyname.jpg";
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
