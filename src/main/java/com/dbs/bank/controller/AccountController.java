package com.dbs.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dbs.bank.model.Account;
import com.dbs.bank.model.Customer;
import com.dbs.bank.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/account")
	public List<Account> getAllAccounts(){
		return accountService.listAll();
	}
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
		
	}
	
	@GetMapping("account/{id}")
	public Account getAccountById(@PathVariable("id") Long id) {
		return accountService.findById(id);
	}
	
	@GetMapping("account/customer/{id}")
	public List<Account> getAccountByCustomerId(@PathVariable("id") Customer id) {
		return accountService.findByCustomer(id);
	}
	

<<<<<<< HEAD
	@PutMapping("/account/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id,
			@Valid @RequestBody Account accountDetails) {
		return accountService.updateAccount(id, accountDetails);
=======
	@PutMapping("/account")
	public Account updateAccount(@RequestBody Account accountDetails) {
		return accountService.updateAccount(accountDetails);
>>>>>>> da3a703b171ca3348dbd9d622ca72c4c1f97f6ef
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id){
		return accountService.deleteAccount(id);
	}
}
