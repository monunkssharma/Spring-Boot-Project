package org.jsp.productmerchantapp.controller;

import org.jsp.productmerchantapp.dto.Merchant;
import org.jsp.productmerchantapp.dto.ResponseStructure;
import org.jsp.productmerchantapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
	@Autowired
	private MerchantService service;
	
	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>>saveMerchant(@RequestBody Merchant merchant){
		return service.saveMerchant(merchant);
	}
	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>>updateMerchant(@RequestBody Merchant merchant){
		return service.updateMerchant(merchant);
	}
	@GetMapping("/merchants/{id}")
	public ResponseEntity<ResponseStructure<Merchant>>findById(@PathVariable int id){
		return service.findById(id);
	}
	@DeleteMapping("/merchants/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	@PostMapping("merchants/verify-by-phone")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByPhoneandPassword(@RequestParam long phone,@RequestParam String password){
		return service.verifyByPhoneandPassword(phone, password);
	}
	@PostMapping("merchants/verify-by-email")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByEmailandPassword(@RequestParam String email,@RequestParam String password){
		return service.VerifyByEmailandPassword(email, password);
	}
	@PostMapping("merchants/verify-by-id")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByIdandPassword(@RequestParam int id,@RequestParam String password){
		return service.VerifyByIdandPassword(id, password);
	}
	@PostMapping("merchants/verify-by-name")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByNameandPassword(@RequestParam String name,@RequestParam String password){
		return service.VerifyByNameandPassword(name, password);
	}
	

}
