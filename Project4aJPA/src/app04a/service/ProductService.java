package app04a.service;

import java.util.List;

import app04a.domain.Product;

 public interface ProductService   {
	
		public List<Product> getAll();
		
		public List<Product> getAllProducts();
		
	public void save(Product product);
	
	public Product find(Long id);

		   
}
 
