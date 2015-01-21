package training.JSF.imagegallery.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Image;

@ManagedBean(name ="showImageBean")
@RequestScoped
public class ShowImageBean {
	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	@Autowired
	ImageDAO imageDAO =  applicationContext.getBean("ImageDAO", ImageDAO.class) ;
	
	public StreamedContent  getImageFromDB() throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//        	System.out.println("testIF");
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("imageId");
            Image img = imageDAO.getImage(Integer.valueOf(id));
            
            return new DefaultStreamedContent(new ByteArrayInputStream(img.getImage_file()));
        }
	}
}
