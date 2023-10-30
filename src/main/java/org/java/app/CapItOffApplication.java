package org.java.app;

import java.util.ArrayList;
import java.util.List;

import org.java.app.pojo.Cap;
import org.java.app.pojo.Category;
import org.java.app.pojo.Size;
import org.java.app.serv.CapService;
import org.java.app.serv.CategoryService;
import org.java.app.serv.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapItOffApplication implements CommandLineRunner {

	@Autowired
	private CapService capService; 
	
	@Autowired
	private CategoryService categoryService; 
	
	@Autowired
	private SizeService sizeService; 
	
	public static void main(String[] args) {
		SpringApplication.run(CapItOffApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Creating Categories
		Category baseball = new Category();
		baseball.setName("Baseball Cap");
		baseball.setDescription("These hats are ideal for sports and come in a wide range of styles, including those representing sports teams.");

		Category winterHat = new Category();
		winterHat.setName("Winter Hat");
		winterHat.setDescription("These hats are designed to keep your head warm during the colder months of the year. They may include wool hats, beanies, and earflap hats.");

		Category summerHat = new Category();
		summerHat.setName("Summer Hat");
		summerHat.setDescription("This category includes lightweight and breathable hats perfect for summer, such as sun hats, straw hats, and wide-brimmed hats.");

		Category dressHat = new Category();
		dressHat.setName("Dress Hat");
		dressHat.setDescription("These hats are more elegant and suitable for special occasions. This category may include fedoras, Panama hats, and other stylish hats.");

		Category kidsHat = new Category();
		kidsHat.setName("Kids' Hat");
		kidsHat.setDescription("These hats are specially designed for children. They can come in a variety of styles and materials to meet kids' needs.");
		
		categoryService.save(baseball);
		categoryService.save(winterHat);
		categoryService.save(summerHat);
		categoryService.save(dressHat);
		categoryService.save(kidsHat);

		// Creating Sizes
		Size small = new Size();
		small.setName("Small");
		small.setDescription("This size typically corresponds to a head circumference of around 21-21.5 inches (54-55 centimeters). It is suitable for those with smaller heads.");

		Size medium = new Size();
		medium.setName("Medium");
		medium.setDescription("This is the average size, with a head circumference typically ranging from 22-22.5 inches (56-57 centimeters). It is the most common size.");

		Size large = new Size();
		large.setName("Large");
		large.setDescription("The large size is usually for heads with a circumference of around 23-23.5 inches (58-59 centimeters).");

		Size extraLarge = new Size();
		extraLarge.setName("Extra Large");
		extraLarge.setDescription("This size is for larger heads, with a circumference of about 24-24.5 inches (60-61 centimeters).");

		Size adjustable = new Size();
		adjustable.setName("Adjustable");
		adjustable.setDescription("Some hats have an adjustable closure that allows them to fit various head sizes. They are often marked as 'one size fits all' or 'adjustable.'");
		
		sizeService.save(small); 
		sizeService.save(medium); 
		sizeService.save(large); 
		sizeService.save(extraLarge); 
		sizeService.save(adjustable); 
		
		// Creating Products (Hats)
		Cap cappello1 = new Cap ();
		cappello1.setName("Classic Baseball Cap");
		cappello1.setDescription("A classic and stylish baseball cap suitable for sports and casual wear.");
		cappello1.setPrice(19.99);
		List <Category> classicBaseballCategories = new ArrayList<>();
		classicBaseballCategories.add(baseball);
		List <Size> classicBaseballSizes = new ArrayList<>(); 
		classicBaseballSizes.add(small); 
		classicBaseballSizes.add(medium);
		classicBaseballSizes.add(large);
		cappello1.setCategories(classicBaseballCategories); 
		cappello1.setSizes(classicBaseballSizes); 
		

		Cap cappello2 = new Cap();
		cappello2.setName("Wool Winter Hat");
		cappello2.setDescription("A warm woolen hat perfect for winter with a cozy and comfortable design.");
		cappello2.setPrice(29.99);	
		List <Category> woolCategories = new ArrayList<>();
		woolCategories.add(winterHat);
		cappello2.setCategories(woolCategories); 
		List <Size> woolSizes = new ArrayList<>(); 
		woolSizes.add(small); 
		woolSizes.add(medium);
		woolSizes.add(large);
		woolSizes.add(extraLarge);
		cappello2.setSizes(woolSizes); 
		

		Cap cappello3 = new Cap();
		cappello3.setName("Straw Sun Hat");
		cappello3.setDescription("A stylish and lightweight sun hat for your summer adventures.");
		cappello3.setPrice(14.99);
		List <Category> strawSunCategories = new ArrayList<>();
		strawSunCategories.add(summerHat);
		cappello3.setCategories(strawSunCategories);
		List <Size> strawSunSizes = new ArrayList<>(); 
		strawSunSizes.add(adjustable); 
		cappello3.setSizes(strawSunSizes);
		
		
		capService.save(cappello1);
		capService.save(cappello2);
		capService.save(cappello3);
		

		
		
	}

}
