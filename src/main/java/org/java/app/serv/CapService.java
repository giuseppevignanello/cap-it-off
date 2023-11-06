package org.java.app.serv;

import java.util.List;
import java.util.Optional;

import org.java.app.pojo.Cap;
import org.java.app.repo.CapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapService {
@Autowired

private CapRepo capRepo; 

public Cap save(Cap cap) {
	return capRepo.save(cap);
}

public List<Cap> findAll() {
	return capRepo.findAll();
}

public Optional<Cap> findById(int id) {
	
	return capRepo.findById(id);
}

public void deleteCap(Cap cap) {
	
capRepo.delete(cap);
	
}
}
