package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.dbs.bank.model.Account;
import com.dbs.bank.model.Customer;


public interface AccountService {
	List<Account> listAll();

	Account saveAccount(Account account);

	Account findById(long id);

<<<<<<< HEAD
	ResponseEntity<Account> updateAccount(long id, Account accountDetails);
=======
	Account updateAccount(Account accountDetails);
>>>>>>> da3a703b171ca3348dbd9d622ca72c4c1f97f6ef

	ResponseEntity<?> deleteAccount(long id);
	
	List<Account> findByCustomer(Customer id);
	
	Account findByAccountType(Account accountType);

}