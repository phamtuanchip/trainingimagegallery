package training.imagegallery.DAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.transaction.annotation.Transactional;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.form.ImageForm;
import training.imagegallery.mapper.ImageMapper;
import training.imagegallery.model.Image;

@Transactional
public class ImageDAOImpl implements ImageDAO {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Image> listImage() {
		// TODO Auto-generated method stub
		String SQL = "SELECT*FROM store_img";
		List<Image> listImage = jdbcTemplate.query(SQL, new ImageMapper());
		return listImage;
	}
	
	// insert image to table Store_img
	@Override
	public void insertImage(ImageForm image) throws FileNotFoundException{
		// TODO Auto-generated method stub
		 
		 final int id = getSquence();
		String SQL = "INSERT INTO store_img(img_no,img_name,img_description,img_date_create,img_user_upload,category_id) VALUES(?,?,?,TO_DATE (SYSDATE,'DD-MON-YYYY'),?,?)";
		jdbcTemplate.update(SQL,id , image.getImg_name(),
				image.getImg_description(), image.getImg_user_upload(), image.getCategory_id());
				updateFileImage(id, image.getFile());	
		
	}

	@Override
	public void updateImage(ImageForm image){
		// TODO Auto-generated method stub
		String SQL = "UPDATE store_img SET img_name =?, img_description=? , img_user_upload=? , category_id=? WHERE img_no=?";
		jdbcTemplate.update(SQL, image.getImg_name(),
				image.getImg_description(), image.getImg_user_upload(), image.getCategory_id(), image.getId());
//		}
	}

	@Override
	public void deleteImage(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM store_img WHERE img_no =?";
		jdbcTemplate.update(SQL, id);

	}
	@Override
	public Image getImageById(int id) {
		// TODO Auto-generated method stub
		String SQL = "SELECT*FROM store_img WHERE img_no=?";
		return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ImageMapper());
	}
	@Override
	public int getSquence() {
		// TODO Auto-generated method stub
		final	int id ;
			String SQL = "SELECT store_id_seq.NEXTVAL FROM DUAL";
		id = jdbcTemplate.queryForInt(SQL);	
		return id;
	}

	@Override
	public void updateFileImage(int id, File file) throws FileNotFoundException {
		// TODO Auto-generated method stub
		 final InputStream imageIs = new FileInputStream(file); 
		 final LobHandler lobHander = new DefaultLobHandler();
		 String SQL_updateImage = "UPDATE store_img SET img_size=?,  file_img =? WHERE img_no=?";
			jdbcTemplate.update(SQL_updateImage, new Object[] {file.length()/1024,new SqlLobValue(imageIs, (int)file.length(), lobHander), id}, new int[] {Types.VARCHAR,Types.BLOB, Types.NUMERIC});;
	}

	

}
