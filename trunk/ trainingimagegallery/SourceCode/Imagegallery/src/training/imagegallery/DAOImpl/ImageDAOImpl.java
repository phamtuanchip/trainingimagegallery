package training.imagegallery.DAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.transaction.annotation.Transactional;

import training.imagegallery.DAO.ImageDAO;
import training.imagegallery.form.ImageForm;
import training.imagegallery.mapper.ImageMapper;
import training.imagegallery.mapper.ImageMapperNotImage;
import training.imagegallery.model.Image;
import training.imagegallery.model.ImageMybatis;

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
		String SQL = "SELECT a.IMG_NO, a.IMG_NAME, a.IMG_DESCRIPTION, a.IMG_DATE_CREATE, a.IMG_SIZE, a.IMG_USER_UPLOAD, b.CAT_NAME " + 
		              "FROM STORE_IMG a INNER  JOIN CATEGORY_IMG b ON a.CATEGORY_ID = b.ID  ";
		List<Image> listImage = jdbcTemplate.query(SQL, new ImageMapper());
		return listImage;
	}

	// insert image to table Store_img
	@Override
	public void insertImage(Image image) throws FileNotFoundException {
		// TODO Auto-generated method stub

		final int id = getSquence();
		String SQL = "INSERT INTO store_img(img_no,img_name,img_description,img_date_create,img_user_upload,category_id) VALUES(?,?,?, TO_CHAR(SYSDATE,'DD-MON-YYYY'),?,?)";
		jdbcTemplate.update(SQL, id, image.getImg_name(),
				image.getImg_description(), image.getImg_userUpLoad(),
				image.getCategory_id());
		if(image.getFile() != null){
		updateFileImage(id, image.getFile());
		}

	}

	@Override
	public void updateImage(Image image) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE store_img SET img_name =?, img_description=? , img_user_upload=? , category_id=? WHERE img_no=?";
		jdbcTemplate.update(SQL, image.getImg_name(),
				image.getImg_description(), image.getImg_userUpLoad(),
				image.getCategory_id(), image.getId());
		// }
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
		return jdbcTemplate.queryForObject(SQL, new Object[] { id },
				new ImageMapper());
	}

	@Override
	public int getSquence() {
		// TODO Auto-generated method stub
		final int id;
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
		jdbcTemplate
				.update(SQL_updateImage,
						new Object[] {
								file.length() / 1024,
								new SqlLobValue(imageIs, (int) file.length(),
										lobHander), id }, new int[] {
								Types.VARCHAR, Types.BLOB, Types.NUMERIC });
		;
	}

	@Override
	public List<Image> SearchImage(String name, String description,
			String date, String user_Update, String category_Name) {
		// TODO Auto-generated method stub
		List<Image> listImageSearch = new ArrayList<Image>();
		String SQL1 = "SELECT*FROM store_img WHERE ";
		String SQL_name = " img_name LIKE '%?%'";
		String SQL_description = " img_description LIKE '%?%'";
		String SQL_date = " img_date_create = '?'";
		String SQL_UserUpload = " img_user_upload LIKE '%?%'";
		if (name != null && description != null && date != null
				&& user_Update != null) {
			String SQL = SQL1 + SQL_name + " AND " + SQL_description + " AND "
					+ SQL_date + "AND" + SQL_UserUpload;
			listImageSearch = jdbcTemplate.query(SQL, new ImageMapper());
		}
		return listImageSearch;
	}

	@Override
	public List<Image> SearchImageFullText(String key) {
		// TODO Auto-generated method stub
		MapSqlParameterSource param = new MapSqlParameterSource();
		String finalKey = "%" + key.trim() + "%"; 
		param.addValue("key", finalKey);
		List<Image> listImageSearch = new ArrayList<Image>();
		NamedParameterJdbcTemplate nameparameterJDBCTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		String SQL = "SELECT img_name, img_description,img_date_create, img_no, img_size, img_user_upload, cat_name FROM STORE_IMG INNER JOIN CATEGORY_IMG ON category_id = id WHERE img_name LIKE :key OR img_description LIKE :key OR img_date_create LIKE :key OR img_user_upload LIKE :key OR cat_name LIKE :key ORDER BY img_no ";
		listImageSearch = nameparameterJDBCTemplate.query(SQL, param, new ImageMapperNotImage());
		return listImageSearch;
	}

	@Override
	public Image getImage(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
