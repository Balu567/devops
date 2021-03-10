package com.bean;

import java.util.ArrayList;

public class Account {

	private long customerid;
	private long accountid;
	private String accounttype;
	private double balance;
	private String crdate;
	private String crlastdate;
	private double duration;
	
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	ArrayList<Transactions> tran;
	
	public ArrayList<Transactions> getTran() {
		return tran;
	}
	public void setTran(ArrayList<Transactions> tran) {
		this.tran = tran;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getAccountid() {
		return accountid;
	}
	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCrdate() {
		return crdate;
	}
	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}
	public String getCrlastdate() {
		return crlastdate;
	}
	public void setCrlastdate(String crlastdate) {
		this.crlastdate = crlastdate;
	}
	
	
}
