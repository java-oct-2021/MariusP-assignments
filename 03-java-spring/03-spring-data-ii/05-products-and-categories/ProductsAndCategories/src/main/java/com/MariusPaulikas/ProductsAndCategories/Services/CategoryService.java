package com.MariusPaulikas.ProductsAndCategories.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.ProductsAndCategories.Models.Category;
import com.MariusPaulikas.ProductsAndCategories.Models.Product;
import com.MariusPaulikas.ProductsAndCategories.Repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryrepository;
	
	public CategoryService (CategoryRepository categoryrepository) {
		this.categoryrepository = categoryrepository;
	}

	public List<Category> allCategories() {
		return categoryrepository.findAll();
	}
	
	
	public List<Category> someCategories(Product product) {
		System.out.println(categoryrepository.findByProductsNotContains(product));	
		return categoryrepository.findByProductsNotContains(product);
	}
	
	
	public Category createCategory (Category c) {
		return categoryrepository.save(c);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryrepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
		
	}
	
	public Category AddProducts (Product p, Category c) {
		List<Product> myproducts = c.getProducts();
		myproducts.add(p);
		return categoryrepository.save(c);
		
	}
	
	
	public void deleteCategory(Long id) {
		categoryrepository.deleteById(id);
	}
	
}
