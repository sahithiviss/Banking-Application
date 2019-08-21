package com.dbs.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dbs.bank.model.Customer;
import com.dbs.bank.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return customerService.listAll();
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
		
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id) {
		return customerService.findById(id);
	}
	
	@GetMapping("/customer/{email}/{password}")
	public Optional<Customer> getCustomerByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password) {
		return customerService.findByEmailAndPassword(email, password);
	}
	
<<<<<<< HEAD
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,
			@Valid @RequestBody Customer customerDetails) {
		return customerService.updateCustomer(id, customerDetails);
=======
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customerDetails) {
		return customerService.updateCustomer(customerDetails);
>>>>>>> da3a703b171ca3348dbd9d622ca72c4c1f97f6ef
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
		return customerService.deleteCustomer(id);
	}
}
