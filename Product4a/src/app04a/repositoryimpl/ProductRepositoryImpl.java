package app04a.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

 import app04a.domain.Category;

import org.springframework.stereotype.Repository;

import app04a.domain.Product;
import app04a.repository.ProductRepository;

@Repository
 public class ProductRepositoryImpl implements ProductRepository {
	
		private List<Product> listOfProducts = new ArrayList<Product>();

  	
		@Override
		public List<Product> getAll() {
		return listOfProducts;
	}
	
	@Override
	public void save(Product product) {
		listOfProducts.add(product);
		return ;
	}
	
 
		   
}
 
