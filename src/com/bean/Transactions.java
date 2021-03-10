package com.bean;

public class Transactions {

	private long customerid;
	private long accountid;
	private String accounttype;
	private double amount;
	private String transactiondate;
	private String sourceacctype;
	private String targetacctype;
	private String transaction_description;
	private String transaction_type;
	
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public long getAccountid() {
		return accountid;
	}
	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}
	public String getTransaction_description() {
		return transaction_description;
	}
	public void setTransaction_description(String transaction_description) {
		this.transaction_description = transaction_description;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}
	public String getSourceacctype() {
		return sourceacctype;
	}
	public void setSourceacctype(String sourceacctype) {
		this.sourceacctype = sourceacctype;
	}
	public String getTargetacctype() {
		return targetacctype;
	}
	public void setTargetacctype(String targetacctype) {
		this.targetacctype = targetacctype;
	}
	
	public Transactions(long customerid, long accountid, String accounttype, double amount, String transactiondate,
			String sourceacctype, String targetacctype, String transaction_description, String transaction_type) {
		super();
		this.customerid = customerid;
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.amount = amount;
		this.transactiondate = transactiondate;
		this.sourceacctype = sourceacctype;
		this.targetacctype = targetacctype;
		this.transaction_description = transaction_description;
		this.transaction_type = transaction_type;
	}
	public Transactions() {
		// TODO Auto-generated constructor stub
	}
	
	
}
