package com.dao;



public class FactoryPattern {
	public static BankDaoInterface getBankDao()
		{
			return new BankDao();
		}
}
