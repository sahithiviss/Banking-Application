package com.dbs.bank.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tid;
	private long ammount;
	
	private Date date; 
	
	private Time time;

    @ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="from_account", nullable = false)
    private Account fromAccount;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="to_account", nullable = false)
    private Account toAccount;
    
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public long getAmmount() {
		return ammount;
	}
	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}
 
	public Transaction() {
		super();
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	
	public Transaction(long tid, long ammount, Account fromAccount, Account toAccount) {
		super();
		this.tid = tid;
		this.ammount = ammount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
}
