package org.java.app.pojo;

public class CapDTO {
	private int id; 
	private String name;
	private String description;
	private double price; 
	private String photoUrl; 
	private boolean isAvailable; 
	
	public CapDTO() {
		
	}
	
	public CapDTO(String name, String description, double price, String photoUrl, boolean isAvailable) {
		setName(name); 
		setDescription(description); 
		setPrice(price);
		setPhotoUrl(photoUrl); 
		setAvailable(isAvailable);
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "CapDTO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", photoUrl=" + photoUrl + ", isAvailable=" + isAvailable + "]";
	}
	
	
	
	
}
