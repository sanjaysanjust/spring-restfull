package com.sanjay.springrestfull.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.springrestfull.model.Product;
import com.sanjay.springrestfull.service.ProductService;

@RestController
public class ProductServiceController {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProducts() {
		logger.info("getProducts controller called");
		if (productService.getProducts().isEmpty()) {
			return new ResponseEntity<>("No Products FOund", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}")
	public ResponseEntity<Object> getProducts(@PathVariable("id") String id) {
		logger.info("getProducts based on id");
		Product product = productService.getProductsById(id);
		if (product == null) {
			return new ResponseEntity<>("Product Not Found ", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		logger.info("createProduct Controller Called");
		String message = productService.createProduct(product);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable("id") String id) {
		logger.info("updateProduct controller called");
		String message = productService.updateProduct(id, product);
		if (message.equals("Product Updated")) {
			return new ResponseEntity<>(message, HttpStatus.OK);
		} else {
			logger.info("updateProduct did not find product based on id ");
			return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
		logger.info("deleteProduct controller");
		if (productService.deleteProduct(id).equals("Product Deleted")) {
			return new ResponseEntity<>("Product deleted ", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
		}
	}

}
