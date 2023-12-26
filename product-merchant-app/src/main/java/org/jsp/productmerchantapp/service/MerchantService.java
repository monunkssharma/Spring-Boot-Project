package org.jsp.productmerchantapp.service;

import java.util.Optional;

import org.jsp.productmerchantapp.dao.MerchantDao;
import org.jsp.productmerchantapp.dto.Merchant;
import org.jsp.productmerchantapp.dto.ResponseStructure;
import org.jsp.productmerchantapp.exception.IdNotFoundException;
import org.jsp.productmerchantapp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MerchantService {
@Autowired
private MerchantDao dao;

public ResponseEntity<ResponseStructure<Merchant>>saveMerchant(@RequestBody Merchant merchant){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	merchant=dao.saveMerchant(merchant);
	structure.setData(merchant);
	structure.setMessage("Merchant Registered Successfully");
	structure.setStatusCode(HttpStatus.CREATED.value());
	return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.CREATED);
}
public ResponseEntity<ResponseStructure<Merchant>>updateMerchant(@RequestBody Merchant merchant){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	merchant=dao.updateMerchant(merchant);
	structure.setData(merchant);
	structure.setMessage("Merchant Updated Successfully");
	structure.setStatusCode(HttpStatus.ACCEPTED.value());
	return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.ACCEPTED);
}
public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable int id){
	Optional<Merchant>recMerchant=dao.findById(id);
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	if(recMerchant.isPresent()) {
		structure.setData(recMerchant.get());
		structure.setMessage("Merchant Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new IdNotFoundException();
	
}
public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id){
	ResponseStructure<String >structure=new ResponseStructure<>();
	boolean deleted=dao.deleteById(id);
	if(deleted) {
		structure.setData("Merchant Deleted");
		structure.setMessage("Merchant Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
	}
	throw new IdNotFoundException();
}
public ResponseEntity<ResponseStructure<Merchant>>verifyByPhoneandPassword(@RequestParam long phone,@RequestParam String password){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recMerchant=dao.verifyByPhoneandPassword(phone, password);
	if(recMerchant.isPresent()) {
		structure.setData(recMerchant.get());
		structure.setMessage("Merchant Verified");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new InvalidCredentialsException();
}
public ResponseEntity<ResponseStructure<Merchant>>VerifyByEmailandPassword(@RequestParam String email,@RequestParam String password){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recMerchant=dao.verifyByEmailandPassword(email, password);
	if(recMerchant.isPresent()) {
		structure.setData(recMerchant.get());
		structure.setMessage("Merchant Verified");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new InvalidCredentialsException();
}
public ResponseEntity<ResponseStructure<Merchant>>VerifyByIdandPassword(@RequestParam int id,@RequestParam String password){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recMerchant=dao.verifyByIdandPassword(id, password);
	if(recMerchant.isPresent()) {
		structure.setData(recMerchant.get());
		structure.setMessage("Merchant Verified");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new InvalidCredentialsException();
}
public ResponseEntity<ResponseStructure<Merchant>>VerifyByNameandPassword(@RequestParam String name,@RequestParam String password){
	ResponseStructure<Merchant> structure=new ResponseStructure<>();
	Optional<Merchant> recMerchant=dao.verifyByNameandPassword(name, password);
	if(recMerchant.isPresent()) {
		structure.setData(recMerchant.get());
		structure.setMessage("Merchant Verified");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
	}
	throw new InvalidCredentialsException();
}

}
