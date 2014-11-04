package training.imagegallery.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import training.imagegallery.form.ImageForm;
import training.imagegallery.model.Image;

public interface ImageDAO {
		public void setDataSource(DataSource dataSource);
		public List<Image> listImage();
		public void insertImage( ImageForm image ) throws FileNotFoundException ;
		public void updateImage(ImageForm image);
		public void deleteImage(int id);
		public void updateFileImage(int id, File file) throws FileNotFoundException;
		public Image getImageById(int id );
		public List<Image> SearchImageFullText(String key);
		public List<Image> SearchImage(String name, String description, String date, String user_Update, String category_Name ); 
		public int getSquence();
}
