package org.java.app.controller;

import java.util.List;
import java.util.Optional;

import org.java.app.pojo.Cap;
import org.java.app.pojo.CapDTO;
import org.java.app.repo.CapRepo;
import org.java.app.serv.CapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	//show
	@GetMapping("{id}")
	public ResponseEntity<Cap> getCap(@PathVariable int id){
		Optional<Cap> optCap = capService.findById(id);
		if(optCap.isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(optCap.get(), HttpStatus.OK);
		
	}
	
	//create 
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody CapDTO capDTO) {
		Cap cap = new Cap(capDTO); 
		cap = capService.save(cap); 
		
		return new ResponseEntity<>(cap.getId(), HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cap> updateCap(@PathVariable int id, @RequestBody CapDTO capDTO) {
		Optional<Cap> optCap = capService.findById(id);
		if(optCap.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Cap cap = optCap.get();
		cap.fillFromCapDTO(capDTO);
		
		try {
			cap = capService.save(cap); 
			
			return new ResponseEntity<>(cap, HttpStatus.OK);	
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteCap(@PathVariable int id) {
		Optional<Cap> optCap = capService.findById(id);
		
		if(optCap.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Cap cap = optCap.get();
		capService.deleteCap(cap);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
		
	}
}
