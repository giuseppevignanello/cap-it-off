package org.java.app.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cap {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
}