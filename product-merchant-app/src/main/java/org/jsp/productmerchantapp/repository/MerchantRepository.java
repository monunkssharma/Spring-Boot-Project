package org.jsp.productmerchantapp.repository;

import java.util.Optional;

import org.jsp.productmerchantapp.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	public Optional<Merchant> verifyByPhoneandPassword(long phone,String password);
	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	public Optional<Merchant> verifyByEmailandPassword(String email,String password);
	@Query("select m from Merchant m where m.id=?1 and m.password=?2")
	public Optional<Merchant> verifyByIdandPassword(int id,String password);
	@Query("select m from Merchant m where m.name=?1 and m.password=?2")
	public Optional<Merchant> verifyByNameandPassword(String name,String password);

}
