package training.imagegallery.model;

import java.io.Serializable;
import java.util.Date;



public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;
	private String name;
	private String description;
	private Date dateCreate;
	
	//constructor
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Category(int id, String name, String description, Date dateCreate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateCreate = dateCreate;
	}


	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description="
				+ description + ", dateCreate=" + dateCreate + "]";
	}
	
	
}
