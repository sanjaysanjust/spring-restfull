package com.sanjay.springrestfull.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sanjay.springrestfull.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@Override
	public String createProduct(Product product) {
		logger.info("CreateProduct Service called");
		productRepo.put(product.getId(), product);
		logger.info("createProduct Done ");
		return "Product Created";
	}

	@Override
	public String updateProduct(String id, Product product) {
		logger.info("UpdateProduct Service called");
		for (Product pdct : productRepo.values()) {
			if (pdct.getId().equals(id)) {
				productRepo.remove(id);
				product.setId(id);
				productRepo.put(id, product);
				logger.info("updateProduct updated based on id ");
				return "Product Updated";
			}
		}
		return "Product Not found.";

	}

	@Override
	public String deleteProduct(String id) {
		logger.info("deleteProduct Service called");
		for (Product pdct : productRepo.values()) {
			if (pdct.getId().equals(id)) {
				productRepo.remove(id);
				logger.info("deleteProduct deleted product based on id");
				return "Product Deleted";
			}
		}
		logger.info("deleteProduct did not find product based on id");
		return "Product Not found";
		

	}

	@Override
	public Collection<Product> getProducts() {
		logger.info("getProduct Service called");
		System.out.println(productRepo.values());
		return productRepo.values();
	}

	@Override
	public Product getProductsById(String id) {
		for (Product pdct : productRepo.values()) {
			if (pdct.getId().equals(id)) {
				logger.info("getProducts Found based on id");
				return pdct;
			}
		}
		logger.info("getProducts did not find based on id");
		return null;
	}

}
