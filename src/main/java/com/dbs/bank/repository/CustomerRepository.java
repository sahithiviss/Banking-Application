package com.dbs.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.bank.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findByEmailAndPassword(String email, String password);
	public Customer findByPanID(String panID);
	public Customer findByEmail(String email);
	public Customer findByPhoneNumber(String phoneNumber);
}
