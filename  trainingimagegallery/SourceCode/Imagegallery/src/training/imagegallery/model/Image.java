package training.imagegallery.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.Arrays;

import oracle.sql.BLOB;


public class Image implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -303340490732991443L;
	private int id;
	private String img_name;
	private String img_description;
	private Date dateCreate;
	private String img_size;
	private String img_userUpLoad;
	private byte [] image_file;
	private BLOB file;
	private int category_id;
	private String category_name;
	private Category category;
	private String key;
	
	// constructor
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//getter and setter
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
	public String getImg_size() {
		return img_size;
	}
	public void setImg_size(String img_size) {
		this.img_size = img_size;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public Date getDateCreate() {
		return dateCreate;
	}


	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	
	public String getImg_userUpLoad() {
		return img_userUpLoad;
	}


	public void setImg_userUpLoad(String img_userUpLoad) {
		this.img_userUpLoad = img_userUpLoad;
	}


	public byte [] getImage_file() {
		return image_file;
	}


	public void setImage_file(byte [] image_file) {
		this.image_file = image_file;
	}

	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public BLOB getFile() {
		return file;
	}


	public void setFile(BLOB file) {
		this.file = file;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return "Image [img_name=" + img_name + ", img_description="
				+ img_description + ", img_size=" + img_size
				+ ", img_userUpLoad=" + img_userUpLoad + ", file=" + file
				+ ", category_id=" + category_id + ", category_name="
				+ category_name + "]";
	}


}
