package org.java.app.serv;

import org.java.app.pojo.Size;
import org.java.app.repo.SizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService {
@Autowired

private SizeRepo sizeRepo; 

public Size save(Size size) {
	return sizeRepo.save(size);
}
}
