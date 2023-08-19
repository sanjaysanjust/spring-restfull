package com.sanjay.springrestfull.service;

import java.util.Collection;

import com.sanjay.springrestfull.model.Product;

public interface ProductService {

	public abstract String createProduct(Product product);

	public abstract String updateProduct(String id, Product product);

	public abstract String deleteProduct(String id);

	public abstract Collection<Product> getProducts();

	public abstract Product getProductsById(String id);

}
