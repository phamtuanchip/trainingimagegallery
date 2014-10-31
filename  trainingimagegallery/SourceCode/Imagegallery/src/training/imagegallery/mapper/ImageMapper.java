package training.imagegallery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.OracleLobHandler;

import training.imagegallery.model.Image;

public class ImageMapper implements RowMapper<Image> {

	@Override
	public Image mapRow(ResultSet rs, int rowcolumn) throws SQLException {
		// TODO Auto-generated method stub
		OracleLobHandler lobHamdler = new OracleLobHandler();
		Image image = new Image();
		image.setId(rs.getInt("img_no"));
		image.setImg_name(rs.getString("img_name"));
		image.setImg_description(rs.getString("img_description"));
		image.setDateCreate(rs.getDate("img_date_create"));
		image.setImg_size(rs.getString("img_size"));
		image.setImg_userUpLoad(rs.getString("img_user_upload"));
		image.setImage_file(lobHamdler.getBlobAsBytes(rs, "file_img"));
		image.setCategory_id(rs.getInt("category_id"));
		return image;
	}

}
