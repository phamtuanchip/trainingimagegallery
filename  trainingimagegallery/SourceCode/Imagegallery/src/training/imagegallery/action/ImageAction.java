package training.imagegallery.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAOImpl.ImageDAOImpl;
import training.imagegallery.model.Image;

import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private ImageDAOImpl imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
	private Image image;
	private int imageId;
	private byte[] dataImage;
	private HttpServletRequest servletRequest;
	private File file;
	public String execute(){
		return SUCCESS;
	}
	public byte[] getMyImageInBytes(){
			image = imageDAOImpl.getImageById(imageId);
				dataImage = image.getImage_file();

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
