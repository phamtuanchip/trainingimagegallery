package training.imagegallery.form;

import java.io.File;

public class ImageForm {
	private int id ;
	private String img_name;
	private String img_description;
	private String img_user_upload;
	private float img_size;
	private int category_id;
	private String categoryName;
	private File file;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getImg_description() {
		return img_description;
	}
	public void setImg_description(String img_description) {
		this.img_description = img_description;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getImg_user_upload() {
		return img_user_upload;
	}
	public void setImg_user_upload(String img_user_upload) {
		this.img_user_upload = img_user_upload;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public float getImg_size() {
		return img_size;
	}
	public void setImg_size(float img_size) {
		this.img_size = img_size;
	}
}
