package com.service;

public class FactoryService {

	public static BankserviceInterface getBankService(){
		return new BankService();
	}
}
