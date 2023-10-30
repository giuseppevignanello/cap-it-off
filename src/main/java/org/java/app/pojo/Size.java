package org.java.app.pojo;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, length = 5, nullable = false)
	@NotBlank(message = "You must insert a name for this size")
	@Length (
			min = 1,
			max = 5, 
			message = "The name of the size must be between 1 and 5 characters"
			)
	private String name;
	
	@ManyToMany(mappedBy = "sizes")
	@JsonBackReference
	private List<Cap> caps; 
	
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



	public List<Cap> getCaps() {
		return caps;
	}



	public void setCaps(List<Cap> caps) {
		this.caps = caps;
	}



	
}
