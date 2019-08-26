package com.dbs.bank.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Account;
import com.dbs.bank.model.Transaction;
import com.dbs.bank.repository.AccountRepository;
import com.dbs.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
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
	public String saveTransaction(Transaction transaction) {
			
			List<Transaction> transactions=transactionRepository.findByFromAccountAndDate(transaction.getFromAccount(),Date.valueOf(LocalDate.now()));
			long sum=0;
			for(int i=0;i<transactions.size();i++) {
				sum=sum+transactions.get(i).getAmmount();
			}
			System.out.println("\n"+transactions+"\n"+sum);
				double fromAccountBalance = transaction.getFromAccount().getBalance();
		        double toAccountBalance = transaction.getToAccount().getBalance();
		        if((fromAccountBalance - transaction.getAmmount()) < 5000) {
		            return "Transaction cannot be done... Your account balance will be short of $5,000 with this transaction";
		        }
		        else {
			        transaction.setDate(Date.valueOf(LocalDate.now())); 
		            fromAccountBalance = fromAccountBalance - transaction.getAmmount();
		            transaction.getFromAccount().setBalance(fromAccountBalance);
					this.accountRepository.save(transaction.getFromAccount());
		            if(sum+transaction.getAmmount()<=10000) {
		            	toAccountBalance = toAccountBalance + transaction.getAmmount();
		            	transaction.getToAccount().setBalance(toAccountBalance);
		            	System.out.println(transaction.getToAccount().getBalance());
						this.accountRepository.save(transaction.getToAccount());
		            	transactionRepository.save(transaction);
				        return "Transaction successfull";
		            }
		            else {
		            	transaction.setFlag(true);
				        transactionRepository.save(transaction);
				        return "Transaction limit exceeded/ Awaiting Bank Approval";
		            }
		        }

	}

	@Override
	@Transactional
	public Optional<List<Transaction>> findByFromAccount(Account id) {
		return this.transactionRepository.findByFromAccount(id);
	}

	@Override
	@Transactional
	public Transaction findById(long id) {
		return this.transactionRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Optional<List<Transaction>> findByToAccount(Account id) {
		return this.transactionRepository.findByToAccount(id);
		
	}

	@Override
	public Optional<List<Transaction>> findByFromAccountOrToAccount(Account id) {
		return this.transactionRepository.findByFromAccountOrToAccount(id,id);
	}
	

<<<<<<< HEAD
	

//	@Override
//    @Transactional
//    public ResponseEntity<Transaction> updateTransaction(Transaction transaction) {
//
//        if(transaction.isFlag()) {
//	        double toAccountBalance = transaction.getToAccount().getBalance();       
//	        toAccountBalance = toAccountBalance + transaction.getAmmount();
//	        transaction.getToAccount().setBalance(toAccountBalance);
//	        transaction.setFlag(false);
//			this.accountRepository.save(transaction.getToAccount());
//
//	        //return this.transactionRepository.save(transaction);
//			this.transactionRepository.save(transaction);
//	        return ResponseEntity.ok().build();
//        }
//        
//        return null;
//    }
	
=======
>>>>>>> d4015dc059265a78e0fa69fa7e51fcac232ed94f
	@Override
    @Transactional
    public Transaction updateTransaction(Transaction transaction) {
        if(transaction.isFlag()) {
	        double toAccountBalance = transaction.getToAccount().getBalance();       
	        toAccountBalance = toAccountBalance + transaction.getAmmount();
	        transaction.getToAccount().setBalance(toAccountBalance);
	        transaction.setFlag(false);
			this.accountRepository.save(transaction.getToAccount());
	        return this.transactionRepository.save(transaction);
<<<<<<< HEAD
//			this.transactionRepository.save(transaction);
//	        return ResponseEntity.ok().build();
=======
>>>>>>> d4015dc059265a78e0fa69fa7e51fcac232ed94f
        }
        
        return null;
    }

}