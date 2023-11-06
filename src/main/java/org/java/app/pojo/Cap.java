package org.java.app.pojo;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Cap {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, length = 30, nullable= false)
	@NotBlank(message = "You must insert a name for this cap")
	@Length(
			min = 3,
			max = 30, 
			message = "The name of the cap must be between 3 and 30 characters"
			)
	private String name; 
	
	@Lob
	@Column(columnDefinition="text")
	@NotBlank(message = "You must insert a description for this cap")
	@Length(
			min = 3, 
			max = 500,
			message = "The description of the cap must be between 3 and 500 characters"
			)
	private String description; 
	
	@Column(nullable = false)
	@Positive(message = "The price of the cap must be positive")
	private double price; 
	
	@Lob 
	@Column(columnDefinition="text")
	private String photoUrl; 
	
	@Column()
	private boolean isAvailable; 
	
	@ManyToMany
	@JsonManagedReference 
	private List<Category> categories; 
	
	@ManyToMany 
	@JsonManagedReference 
	private List<Size> sizes; 
	
	public Cap() {
		
	}
	
	public Cap(CapDTO capDTO) {
		setName(capDTO.getName()); 
		setDescription(capDTO.getDescription()); 
		setPrice(capDTO.getPrice());
		setPhotoUrl(capDTO.getPhotoUrl()); 
		setAvailable(capDTO.isAvailable());
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	public void fillFromCapDTO(CapDTO capDTO) {
		setName(capDTO.getName()); 
		setDescription(capDTO.getDescription());
		setPrice(capDTO.getPrice());
		setPhotoUrl(capDTO.getPhotoUrl());
		setAvailable(capDTO.isAvailable());
		
	}

	
}
