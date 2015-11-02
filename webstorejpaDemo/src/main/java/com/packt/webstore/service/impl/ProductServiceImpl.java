package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.domain.Product;
import com.packt.webstore.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		List<String> params =  filterParams.get("brand");
		return productRepository.getProductsByFilter(params);
	}

	public void addProduct(Product product) {
		   productRepository.save(product);
	}
	
	public Product get(long productID) {
		return productRepository.findOne(productID);
	}
	
	public List<Product> getProductsByDescOrder() {
		return productRepository.getProductsByDescOrder();
	}

	// Cache in play because fetches are in same session
	public Product getAddProduct(String desc) {
		Product p =  getProductById("P1235");		 
		 p =  get(p.getId());

		 // Update
		 p.setDescription(desc);
		 addProduct(p);
		 return p;

	}


}
