package com.company.interfaces;

import java.util.List;

import com.company.beans.Product;

public interface IProductDAO {
	public List<Product> getAllProducts();
	
	public void addProduct(Product product1);
	
	public Product getProduct(Integer productId);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Integer productId);
	
	public List<Product> getProductsByPriceRange(Integer min, Integer max);
}
