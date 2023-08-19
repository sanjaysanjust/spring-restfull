package com.sanjay.springrestfull.resttemplate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sanjay.springrestfull.model.Product;

@RestController
public class RestTemplateExample {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/template/getproductlist", method = RequestMethod.GET)
	public String getProductList() {
		System.out.println("Inside rest template get");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8081/products", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/template/postproductlist", method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		System.out.println("Inside rest template post");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
		return restTemplate.exchange("http://localhost:8081/products", HttpMethod.POST, entity, String.class).getBody();
	}
}
