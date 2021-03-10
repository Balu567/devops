package com.bean;

import java.util.ArrayList;

public class Customer {

	private long customerid;
	private long ssn;
	private String name;
	private String address;
	private int age;
	
	private ArrayList<Account> acc;
	
	public ArrayList<Account> getAcc() {
		return acc;
	}
	
	public Customer(long customerid, long ssn, String name, String address, int age) {
		super();
		this.customerid = customerid;
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public void setAcc(ArrayList<Account> acc) {
		this.acc = acc;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
