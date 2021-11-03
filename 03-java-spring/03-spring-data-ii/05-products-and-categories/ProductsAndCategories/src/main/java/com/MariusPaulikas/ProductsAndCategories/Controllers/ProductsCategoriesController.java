package com.MariusPaulikas.ProductsAndCategories.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MariusPaulikas.ProductsAndCategories.Models.Category;
import com.MariusPaulikas.ProductsAndCategories.Models.Product;
import com.MariusPaulikas.ProductsAndCategories.Services.CategoryService;
import com.MariusPaulikas.ProductsAndCategories.Services.ProductService;

@Controller
public class ProductsCategoriesController {

	@Autowired
	private CategoryService categoryservice;
	
	@Autowired
	private ProductService productservice;
	
	
	
	@RequestMapping("/products/new")
	public String home(@ModelAttribute("product") Product product, Model model) {
		List<Product>allproducts = productservice.allProducts();
		model.addAttribute("products",allproducts);
		return "productsnew.jsp";
	}
	
	@RequestMapping(value = "/products/new/create", method=RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") Product product, Model model) {
		productservice.createProduct(product);
		return "redirect:/products/new";
	}

	
	@RequestMapping("/products/{id}")
	public String NewProduct (@PathVariable("id")long id, @ModelAttribute("categories") Product product, Model model) {
		Product location = productservice.findProduct(id);
		model.addAttribute("product", location);
		List <Category> somecategories = categoryservice.someCategories(location);
		model.addAttribute("somecategories", somecategories);
		return "productsid.jsp";
	
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.POST) 
	public String AddProduct(@PathVariable("id")Long id, @RequestParam("product") Long productid) {
		Product p = productservice.findProduct(productid);
		Category c = categoryservice.AddProducts(p,categoryservice.findCategory(id));
		Long identification = c.getId();
		return "redirect:/categories/" + identification;
	}
	
	@RequestMapping("/products/{id}/delete")
    public String destroyproduct(@PathVariable("id") Long id) {
		productservice.deleteProduct(id);
        return "redirect:/products/new";
    }
	
	
	
	
	@RequestMapping("/categories/new")
	public String home(@ModelAttribute("category") Category category, Model model) {
		List <Category> allcategories = categoryservice.allCategories();
		model.addAttribute("categories",allcategories);
		return "categorynew.jsp";
	}
	
	@RequestMapping(value = "/categories/new/create", method=RequestMethod.POST)
	public String createProduct(@ModelAttribute("category") Category category, Model model) {
		categoryservice.createCategory(category);
		return "redirect:/categories/new";
	}
	
	
	@RequestMapping("/categories/{id}")
	public String NewCategory (@PathVariable("id")long id, Category category, Model model) {
		Category cat = categoryservice.findCategory(id);
		model.addAttribute("category", cat);
		List<Product>someproducts = productservice.someProduct(cat);
		model.addAttribute("someproducts",someproducts);
		return "categoryid.jsp";
	
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.POST) 
	public String AddCategory(@PathVariable("id")Long id, @RequestParam("category") Long catid) {
		Category c = categoryservice.findCategory(catid);
		Product p = productservice.AddCategories(productservice.findProduct(id),c);
		Long identification = p.getId();
		return "redirect:/products/" + identification;
	}
	
	
	@RequestMapping("/categories/{id}/delete")
    public String destroycategory(@PathVariable("id") Long id) {
		categoryservice.deleteCategory(id);
        return "redirect:/categories/new";
    }
	
}
