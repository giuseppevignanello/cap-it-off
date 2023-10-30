package org.java.app.pojo;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, length = 20, nullable= false)
	@NotBlank(message = "You must insert a name for this category")
	@Length(
			min = 3,
			max = 20, 
			message = "The name of the category must be between 3 and 20 characters"
			)
	private String name; 
	
	@Lob
	@Column(columnDefinition="text")
	@NotBlank(message = "You must insert a description for this category")
	@Length(
			min = 3, 
			max = 300,
			message = "The description of the category must be between 3 and 300 characters"
			)
	private String description; 
	
	@ManyToMany(mappedBy = "categories")
	@JsonBackReference
	private List<Cap> caps; 
	
	
	//Constructor
	public Category() {
		
	}
	
	//Getters and Setters
	
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



	public List<Cap> getCaps() {
		return caps;
	}



	public void setCaps(List<Cap> caps) {
		this.caps = caps;
	}



	
}




