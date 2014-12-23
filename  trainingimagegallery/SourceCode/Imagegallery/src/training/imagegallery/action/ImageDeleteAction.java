package training.imagegallery.action;

import org.springframework.beans.factory.annotation.Autowired;

import training.imagegallery.DAO.ImageDAO;

import com.opensymphony.xwork2.ActionSupport;

public class ImageDeleteAction extends ActionSupport {

	/**
	 * 
	 */
	@Autowired
	ImageDAO imageDAO;
	
	private static final long serialVersionUID = 1L;
	private int imageId;
	
	public String DeleteRecordImage(){
		imageDAO.deleteImage(imageId);
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
