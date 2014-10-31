package training.imagegallery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import training.imagegallery.model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowcolumn) throws SQLException {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("cat_name"));
		category.setDescription(rs.getString("description"));
		category.setDateCreate(rs.getDate("date_create"));
		return category;
	}

}
