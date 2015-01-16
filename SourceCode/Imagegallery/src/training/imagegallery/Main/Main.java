package training.imagegallery.Main;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAOImpl.CategoryDAOImpl;
import training.imagegallery.DAOImpl.ImageDAOImpl;

public class Main {
	public static void main (String[] args){
		ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		CategoryDAOImpl categoryDAOImpl = (CategoryDAOImpl) aplicationContext.getBean("CategoryDAO");
		ImageDAOImpl ImageDAOImpl = (ImageDAOImpl) aplicationContext.getBean("ImageDAO");
		//categoryDAOImpl.insertCategory("Nude", "khoa than");
		//System.out.println("pass");
		//List<Category> listCat = new ArrayList<Category>();
		//listCat = categoryDAOImpl.listCategory();
		File file = new File("D:/z1.jpg");
		//ImageDAOImpl.updateFileImage(53, file);
//		for(Category cat : listCat){
//			System.out.println(cat.toString());
//		}
	}
}
