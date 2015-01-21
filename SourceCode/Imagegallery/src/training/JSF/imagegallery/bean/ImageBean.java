package training.JSF.imagegallery.bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.model.Category;
import training.imagegallery.model.Image;

@ManagedBean(name = "imageBean")
@ViewScoped
public class ImageBean  {

	
	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
	@Autowired
	ImageDAO imageDAO =  applicationContext.getBean("ImageDAO", ImageDAO.class) ;
	
	@Autowired
	CategoryDAO categoryDAO =  applicationContext.getBean("CategoryDAO", CategoryDAO.class) ;
	private List<Image> listImage;
	private Image image ;
	private List<Category> listCategory;
	@PostConstruct
	public void init() {
        image = new Image();
        listImage = imageDAO.listImage();
        listCategory = categoryDAO.listCategory();
        
    }
	
	
	
	public void handleFileUpload(FileUploadEvent event) {
		byte[] imageByte = null ;
//		System.out.println("uploading...");
//		System.out.println(event.getFile().getSize());
//		System.out.println(event.getFile().getContentType());
		try {
			imageByte = IOUtils.toByteArray(event.getFile().getInputstream());
			image.setImg_size( String.valueOf(event.getFile().getSize()/1024));
			image.setImage_file(imageByte);
//			System.out.println("test" +  image.getImage_file() + "  " + image.getImg_size());
//			System.out.println("test" + imageByte.toString() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("helllo");
		 
			 
		}
	
	public String saveImage(){
		 
		//application code
//		image.setImg_size( String.valueOf(file.getSize()));
//		image.setImage_file(file.getContents());
//		System.out.println("imageSize: " + image.getImg_size() + "conetnt: " + image.getImage_file());
//		System.out.println(image.toString());
		try {
			imageDAO.insertImage(image);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("finish");
		return "listImage";
	}

	


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public List<Image> getListImage() {
		return this.listImage;
	}


	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}



	public List<Category> getListCategory() {

		return this.listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory ;
	}
	
	
	
}
