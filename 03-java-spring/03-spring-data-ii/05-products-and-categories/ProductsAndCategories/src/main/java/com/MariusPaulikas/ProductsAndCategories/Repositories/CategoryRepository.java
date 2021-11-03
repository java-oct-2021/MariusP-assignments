package com.MariusPaulikas.ProductsAndCategories.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.MariusPaulikas.ProductsAndCategories.Models.Category;
import com.MariusPaulikas.ProductsAndCategories.Models.Product;

public interface CategoryRepository extends CrudRepository <Category, Long>{
	
	List<Category> findAll();
	
	// Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
    
    @Query("SELECT c FROM Category c WHERE product_id = ?1")
    List<Category> getCategoryWhereId(Long id);
    



}
