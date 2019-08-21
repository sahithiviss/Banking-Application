package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Account;
import com.dbs.bank.model.Transaction;
import com.dbs.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository=transactionRepository;
	}
	
	@Override
	@Transactional
	public List<Transaction> listAll() {
		return this.transactionRepository.findAll();
	}

	@Override
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}



	@Override
	@Transactional
	public List<Transaction> findByFromAccount(Account id) {
		return this.transactionRepository.findByFromAccount(id);
	}

	@Override
	@Transactional
	public Transaction findById(long id) {
		return this.transactionRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Transaction> findByToAccount(Account id) {
		return this.transactionRepository.findByToAccount(id);
		
	}

}