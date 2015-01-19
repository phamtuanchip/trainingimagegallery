package training.JSF.imagegallery.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Image;

@ManagedBean
@SessionScoped
public class ImageBean {

	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	@Autowired
	ImageDAO imageDAO =  applicationContext.getBean("ImageDAO", ImageDAO.class) ;
	
	private UploadedFile file ;
	private List<Image> listImage;
	private Image image;
	
	public StreamedContent  getImageFromDB() throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("id");
            Image image = imageDAO.getImage(Integer.valueOf(id));
            if(image.getImage_file().length >0){
            return new DefaultStreamedContent(new ByteArrayInputStream(image.getImage_file()));
            }
            return null;
        }
	}
	
	public String saveImage(){
		System.out.println("finish");
		return "";
	}

	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public List<Image> getListImage() {
		this.listImage = imageDAO.listImage();
		System.out.println("list Image" + this.listImage.size());
		return this.listImage;
	}


	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}
	
	
	
}
