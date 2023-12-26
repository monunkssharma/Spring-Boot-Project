package org.jsp.productmerchantapp.controller;

import java.util.List;

import org.jsp.productmerchantapp.dto.Merchant;
import org.jsp.productmerchantapp.dto.Product;
import org.jsp.productmerchantapp.dto.ResponseStructure;
import org.jsp.productmerchantapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("products/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>>saveProduct(@RequestBody Product product,@PathVariable int merchant_id){
		return service.saveProduct(product, merchant_id);
	}
	@PutMapping("products/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@PathVariable int merchant_id){
		return service.updateProduct(product, merchant_id);
	}
	@GetMapping("products/by-id/{id}")
	public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable int id){
		return service.findById(id);
	}
	@GetMapping("/products/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(@PathVariable int merchant_id){
		return service.findByMerchantId(merchant_id);
	}
	@GetMapping("/products/verify-by-name/{name}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	@GetMapping("/products/verify-by-brand/{brand}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(@PathVariable String brand){
		return service.findByBrand(brand);
	}
	@GetMapping("/products/verify-by-category/{category}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(@PathVariable String category){
		return service.findByCategory(category);
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}

}
