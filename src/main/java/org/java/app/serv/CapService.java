package org.java.app.serv;

import org.java.app.pojo.Cap;
import org.java.app.repo.CapRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CapService {
@Autowired

private CapRepo capRepo; 

public Cap save(Cap cap) {
	return capRepo.save(cap);
}
}