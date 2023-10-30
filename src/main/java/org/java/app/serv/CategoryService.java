package org.java.app.serv;

import org.java.app.pojo.Category;
import org.java.app.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
@Autowired

private CategoryRepo categoryRepo; 

public Category save(Category category) {
	return categoryRepo.save(category);
}
}
