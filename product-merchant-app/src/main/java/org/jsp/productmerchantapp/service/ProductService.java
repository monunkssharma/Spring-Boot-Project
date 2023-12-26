package org.jsp.productmerchantapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.productmerchantapp.dao.MerchantDao;
import org.jsp.productmerchantapp.dao.ProductDao;
import org.jsp.productmerchantapp.dto.Merchant;
import org.jsp.productmerchantapp.dto.Product;
import org.jsp.productmerchantapp.dto.ResponseStructure;
import org.jsp.productmerchantapp.exception.IdNotFoundException;
import org.jsp.productmerchantapp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	private MerchantDao merchantDao;
	public ResponseEntity<ResponseStructure<Product>>saveProduct(Product product,int merchant_id){
		ResponseStructure<Product>structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(merchant_id);
		if(recMerchant.isPresent()) {
			Merchant m=recMerchant.get();
			product.setMerchant(m);
			m.getProducts().add(product);
			merchantDao.updateMerchant(m);
			dao.saveProduct(product);
			structure.setMessage("Product Added");
			structure.setData(product);
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Product>>updateProduct(Product product,int merchant_id){
		ResponseStructure<Product> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(merchant_id);
		if(recMerchant.isPresent()) {
			Merchant m=recMerchant.get();
			product.setMerchant(m);
			dao.saveProduct(product);
			structure.setMessage("Product Updated");
			structure.setData(product);
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Product>>findById(int id){
		ResponseStructure<Product>structure=new ResponseStructure<>();
		Optional<Product> recProduct=dao.findById(id);
		if(recProduct.isPresent()) {
			structure.setMessage("Product Found");
			structure.setData(recProduct.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<List<Product>>>findByMerchantId(int merchant_id){
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(merchant_id);
		if(recMerchant.isPresent()) {
			structure.setData(dao.findByMerchantId(merchant_id));
			structure.setMessage("Products Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findByName(String name) {
	    ResponseStructure<List<Product>> structure = new ResponseStructure<>();
	    List<Product> recProduct = dao.findByName(name);
	    
	    if (!recProduct.isEmpty()) {
	        structure.setData(recProduct);
	        structure.setMessage("Product Found");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	    }
	    
	    throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(String brand) {
	    ResponseStructure<List<Product>> structure = new ResponseStructure<>();
	    List<Product> recProduct = dao.findByBrand(brand);
	    
	    if (!recProduct.isEmpty()) {
	        structure.setData(recProduct);
	        structure.setMessage("Product Found");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	    }
	    
	    throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(String category) {
	    ResponseStructure<List<Product>> structure = new ResponseStructure<>();
	    List<Product> recProduct = dao.findByCategory(category);
	    
	    if (!recProduct.isEmpty()) {
	        structure.setData(recProduct);
	        structure.setMessage("Product Found");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	    }
	    
	    throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<String>>deleteById(@PathVariable int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		boolean deleted=dao.deleteById(id);
		if(deleted) {
			structure.setData("Product Deleted");
			structure.setMessage("Product Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}


}
