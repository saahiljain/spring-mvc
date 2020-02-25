package com.company.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.beans.Product;
import com.company.interfaces.IProductDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductDAO implements IProductDAO {
	private static List<Product> products = new ArrayList<Product>();
	
	static {
		products.add(new Product(101, "PenDrive", 655d, "Storage"));
		products.add(new Product(201, "Laptop", 124803d, "Electronics"));
		products.add(new Product(301, "Mobile", 25999d, "Electronics"));
		products.add(new Product(401, "TShirt", 999d, "Fashion"));
		products.add(new Product(501, "Rice", 1299d, "Grocery"));
	}


	public List<Product> getAllProducts() {
		return products;
	}

	
	public void addProduct(Product product) {
		products.add(product);
		log.info("added " + product);
		log.info("list -> " + products);
	}

	
	public Product getProduct(Integer productId) {
		return products.stream().filter(t -> t.getProductId()==productId).findAny().get();
	}

	
	public void updateProduct(Product product) {
	}

	
	public void deleteProduct(Integer productId) {
	}

	
	public List<Product> getProductsByPriceRange(Integer min, Integer max) {
		List<Product> pricedList = new ArrayList<Product>();
		
		for(Product p : products) {
			if(p.getProductPrice() < max && p.getProductPrice() > min) {
				pricedList.add(p);
			}
		}
		
		return pricedList;
	}
	
	
}
