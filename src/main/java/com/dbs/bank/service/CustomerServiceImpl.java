package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Customer;
import com.dbs.bank.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @Override
    @Transactional
    public List<Customer> listAll(){
    	return customerRepository.findAll();
    }
    
    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
    	return customerRepository.save(customer);
    }
    
    @Override
    @Transactional
    public Customer findById(long id) {
    	return this.customerRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public Customer updateCustomer(Customer customerDetails) {
    	Customer customer = customerRepository.findById(customerDetails.getCust_id()).get();
    	
    	customer.setPassword(customerDetails.getPassword());
    	customer.setFirstname(customerDetails.getFirstname());
    	customer.setLastname(customerDetails.getLastname());
    	customer.setEmail(customerDetails.getEmail());
    	customer.setPhoneNumber(customerDetails.getPhoneNumber());
    	customer.setPanID(customerDetails.getPanID());
    	return customerRepository.save(customer);
    	
    }
     
    @Override
    @Transactional
    public ResponseEntity<?> deleteCustomer(long id){
    	Customer customer = customerRepository.findById(id).get();
    	customerRepository.delete(customer);
    	return ResponseEntity.ok().build();
    }
    
    @Override
    @Transactional
	public Optional<Customer> findByEmailAndPassword(String email, String password) {
		return this.customerRepository.findByEmailAndPassword(email, password);
	}
}
