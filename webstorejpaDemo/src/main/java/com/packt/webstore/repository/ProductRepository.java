package com.packt.webstore.repository;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;

	@Repository
	public interface ProductRepository extends  CrudRepository<Product, Long> 
	{
	  Product getProductByProductId(String key);
	
 	    // findAll comes with repository
	    @Query("SELECT p FROM PRODUCT p")
		public List<Product> getAllProducts();
 	
	    @Query("SELECT p FROM PRODUCT p where PRODUCTID = :productId")
	    Product getProductById(@Param("productId") String key);
		
		List<Product> getProductsByCategory(String category);

		// This is a re-write of the InMemoryProduct repository filter
		@Query( "select p from PRODUCT p where p.manufacturer in :brand" )
		Set<Product> getProductsByFilter(@Param("brand") List<String> filterParams);
 
		// Removed addProduct ....		JPA standard is save COMES by default

		@Query("SELECT p FROM  PRODUCT p  order by p.productId desc")
		List<Product> getProductsByDescOrder();

 
	}

