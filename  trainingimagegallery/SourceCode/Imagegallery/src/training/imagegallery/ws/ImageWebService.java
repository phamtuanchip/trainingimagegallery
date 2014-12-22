package training.imagegallery.ws;

import java.util.List;

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

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.DAOImpl.ImageDAOImpl;
import training.imagegallery.model.Image;
import training.imagegallery.service.ImageService;

@Path("/image")
public class ImageWebService {
//	private ApplicationContext context = new ClassPathXmlApplicationContext(
//			"Beans.xml");
//	private ImageDAO imageDAOImpl = (ImageDAOImpl) context.getBean("ImageDAO");
	private ImageService imageService;
	@GET	
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getImageObj(@PathParam("id") int id) {
		imageService = new ImageService();
		Image i = imageService.getImageEdit(id);
		return Response.ok(i.getImage_file(), MediaType.APPLICATION_OCTET_STREAM).build();
	}
	
	@GET
	@Path("/search/{key}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> searchUserInJSON(@PathParam("key") String key) {
		imageService = new ImageService();
		List<Image> listImage=  imageService.searchImageFullText(key);
		return listImage;
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Image i) {

		String result = "Image saved : " + i;
		return Response.status(200).entity(result).build();
		
	}
	
}