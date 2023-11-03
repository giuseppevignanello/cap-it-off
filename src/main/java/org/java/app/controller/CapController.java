package org.java.app.controller;

import java.util.List;

import org.java.app.pojo.Cap;
import org.java.app.repo.CapRepo;
import org.java.app.serv.CapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0")
public class CapController {
	
	//Service and Repo
	@Autowired 
	private CapService capService;
	@Autowired
	private CapRepo capRepo; 
	
	//index
	@GetMapping
	public ResponseEntity<List<Cap>> getAll() {
		
		List<Cap> caps = capService.findAll();
		return new ResponseEntity<>(caps, HttpStatus.OK);
		
	}
}
