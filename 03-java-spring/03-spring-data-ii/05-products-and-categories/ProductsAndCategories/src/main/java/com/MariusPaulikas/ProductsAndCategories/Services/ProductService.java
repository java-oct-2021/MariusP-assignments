package com.MariusPaulikas.ProductsAndCategories.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.ProductsAndCategories.Models.Category;
import com.MariusPaulikas.ProductsAndCategories.Models.Product;
import com.MariusPaulikas.ProductsAndCategories.Repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productrepository;
	
	public ProductService (ProductRepository productrepository) {
		this.productrepository = productrepository;
	}

	public List<Product> allProducts() {
		return productrepository.findAll();
	}
	
	
	public Product createProduct (Product p) {
		return productrepository.save(p);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productrepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
		
	}
	
	
	public Product AddCategories (Product p, Category c) {
		List<Category> mycategories = p.getCategories();
		mycategories.add(c);
		return productrepository.save(p);
		
	}

	public List<Product> someProduct(Category category) {
		System.out.println(productrepository.findByCategoriesNotContains(category));	
		return productrepository.findByCategoriesNotContains(category);
	}
	
	
	public void deleteProduct(Long id) {
		productrepository.deleteById(id);
	}
	
	
}
	
	

