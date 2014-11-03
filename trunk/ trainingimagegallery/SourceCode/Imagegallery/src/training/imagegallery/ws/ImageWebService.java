package training.imagegallery.ws;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import training.imagegallery.DAOImpl.ImageDAOImpl;
import training.imagegallery.model.Image;

@Path("/image")
public class ImageWebService {
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"Beans.xml");
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Image getUserInJSON(@PathParam("id") String id) {
		
		ImageDAOImpl imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
		System.out.println("test " + imageDAOImpl);
		Image i = new Image();
		 
		return i;

	}
	
	@GET
	@Path("/search/{key}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Image> searchUserInJSON(@PathParam("key") String key) {
		System.out.println("search " + key);
		ArrayList<Image> arr = new ArrayList<Image>();
		
		Image i = new Image();
		arr.add(i); 
		
		return arr;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Image i) {

		String result = "Image saved : " + i;
		return Response.status(201).entity(result).build();
		
	}
	
}