package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.dbs.bank.model.Customer;

public interface CustomerService {

	List<Customer> listAll();

	Customer saveCustomer(Customer customer);

	Customer findById(long id);

<<<<<<< HEAD
	ResponseEntity<Customer> updateCustomer(long id, Customer customerDetails);
=======
	Customer updateCustomer(Customer customerDetails);
>>>>>>> da3a703b171ca3348dbd9d622ca72c4c1f97f6ef

	ResponseEntity<?> deleteCustomer(long id);
	
	Optional<Customer> findByEmailAndPassword(String email,String password);
	
	

}
