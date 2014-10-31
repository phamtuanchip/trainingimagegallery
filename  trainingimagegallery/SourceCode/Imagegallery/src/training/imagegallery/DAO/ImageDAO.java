package training.imagegallery.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.sql.DataSource;

import training.imagegallery.form.ImageForm;
import training.imagegallery.model.Image;

public interface ImageDAO {
		public void setDataSource(DataSource dataSource);
		public List<Image> listImage();
		public void insertImage( ImageForm image ) throws FileNotFoundException ;
		public void updateImage(ImageForm image) throws FileNotFoundException ;
		public void deleteImage(int id);
		public void updateFileImage(int id, File file) throws FileNotFoundException;
		public Image getImageById(int id );
		public int getSquence();
}
