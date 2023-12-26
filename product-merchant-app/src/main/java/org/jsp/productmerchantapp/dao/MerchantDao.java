package org.jsp.productmerchantapp.dao;

import java.util.Optional;

import org.jsp.productmerchantapp.dto.Merchant;
import org.jsp.productmerchantapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository repository;
	public Merchant saveMerchant(Merchant merchant) {
		return repository.save(merchant);
	}
	public Merchant updateMerchant(Merchant merchant) {
		return repository.save(merchant);
	}
	public Optional<Merchant> findById(int id){
		return repository.findById(id);
	}
	public boolean deleteById(int id) {
		Optional<Merchant> recMerchant=findById(id);
		if(recMerchant.isPresent()) {
			repository.delete(recMerchant.get());
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	public Optional<Merchant> verifyByPhoneandPassword(long phone,String password){
		return repository.verifyByPhoneandPassword(phone, password);
	}
	public Optional<Merchant> verifyByNameandPassword(String name,String password){
		return repository.verifyByNameandPassword(name, password);
	}
	public Optional<Merchant> verifyByEmailandPassword(String email,String password){
		return repository.verifyByEmailandPassword(email, password);
	}
	public Optional<Merchant> verifyByIdandPassword(int id,String password){
		return repository.verifyByIdandPassword(id, password);
	}

}
