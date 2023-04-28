package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Product;
import com.app.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductService productservice;

	@Autowired
	MessageSource messageSource;

	/*
	 * List all existing products.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listproducts(ModelMap model) {

		List<Product> products = productservice.getAllProducts();
		model.addAttribute("products", products);
		return "/allproducts";
	}

	/*
	 * Add a new Product.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product Product = new Product();
		model.addAttribute("Product", Product);
		model.addAttribute("edit", false);
		return "/registration";
	}

	/*
	 * Handling POST request for validating the user input and saving Product in
	 * database.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveProduct(@Valid Product Product, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "/registration";
		}

		productservice.add(Product);

		model.addAttribute("success", "Product " + Product.getName() + " registered successfully");
		return "/success";
	}

	/*
	 * Provide the existing Product for updating.
	 */
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editProduct(@PathVariable Integer id, ModelMap model) {
		Product Product = productservice.fetchById(id);
		model.addAttribute("Product", Product);
		model.addAttribute("edit", true);
		return "/registration";
	}

	/*
	 * Handling POST request for validating the user input and updating Product in
	 * database.
	 */
	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String updateProduct(@Valid Product Product, BindingResult result, ModelMap model,
			@PathVariable String id) {

		if (result.hasErrors()) {
			return "/registration";
		}

		productservice.update(Product);

		model.addAttribute("success", "Product " + Product.getName() + " updated successfully");
		return "/success";
	}

	/*
	 * Delete an Product by it's CODE value.
	 */
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String deleteProduct(@PathVariable Integer id) {
		productservice.delete(id);
		return "redirect:/list";
	}

}