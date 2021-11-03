package com.MariusPaulikas.ProductsAndCategories.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MariusPaulikas.ProductsAndCategories.Models.Category;
import com.MariusPaulikas.ProductsAndCategories.Models.Product;

public interface ProductRepository extends CrudRepository <Product, Long>{

	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category category);
	
	
}
