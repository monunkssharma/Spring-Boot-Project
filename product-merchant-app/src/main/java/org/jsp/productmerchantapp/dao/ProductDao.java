package org.jsp.productmerchantapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.productmerchantapp.dto.Product;
import org.jsp.productmerchantapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	public Product updateProduct(Product product) {
		return repository.save(product);
	}
	public Optional<Product> findById(int id){
		return repository.findById(id);
	}
	public List<Product> findByMerchantId(int merchant_id){
		return repository.findByMerchantId(merchant_id);
	}
	public List<Product> findByName(String name){
		return repository.findByName(name);
	}
	public List<Product> findByBrand(String brand){
		return repository.findByBrand(brand);
	}
	public List<Product> findByCategory(String category){
		return repository.findByCategory(category);
	}
	public boolean deleteById(int id) {
		Optional<Product>recProduct=findById(id);
		if(recProduct.isPresent()) {
			repository.delete(recProduct.get());
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
