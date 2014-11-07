package training.imagegallery.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.imagegallery.DAO.CategoryDAO;
import training.imagegallery.model.Category;

@Path("/category")
public class CategoryWebService {
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	CategoryDAO categoryDAOImpl = (CategoryDAO) context.getBean("CategoryDAO");
	
@GET
@Path("/getall")
@Produces(MediaType.APPLICATION_JSON)
public List<Category> listAllCategory(){
	List<Category> listCategory = categoryDAOImpl.listCategory();
	return listCategory;
}
}
