package com.company.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.company.beans.Product;
import com.company.dao.ProductDAO;
import com.company.interfaces.IProductDAO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductController {
	@Autowired
	private IProductDAO productDAO;
	
	@RequestMapping(path = "/add-product", method = RequestMethod.GET)
	public String addProduct(Model model) {
		log.info("In /add-product, returning form");
		model.addAttribute("PRODUCT", new Product());
		
		return "product-form";
	}
	
	@RequestMapping(path = "/save-product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product) {
		productDAO.addProduct(product);
		return "get-all-products";
	}
}
