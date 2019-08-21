package com.dbs.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.bank.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByPanId(String panId);
	public Customer findByEmail(String email);
	public Customer findByPhoneNum(String phoneNum);
	Optional<Customer> findByEmailAndPassword(String email, String password);
}
