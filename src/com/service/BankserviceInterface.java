package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Exception.InvalidUserException;
import com.Exception.SsnIdAlreadyPresent;
import com.Exception.SsnIdNotPresent;
import com.Exceptions.TransactionNotPresent;
import com.bean.Account;
import com.bean.AccountStatus;
import com.bean.Customer;
import com.bean.CustomerStatus;
import com.bean.Transactions;

public interface BankserviceInterface {
	
public int loginandinsert(String employee_id, String password) throws InvalidUserException,SQLException, ClassNotFoundException;
	
	public boolean createcustomer(long ssn, String custname,int age1,String address) throws SQLException, SsnIdAlreadyPresent;
	
	public Customer searchCustomerwithId(long uid) throws SQLException, SsnIdNotPresent;

	public boolean updateCustomerDetails(long ssnid, long customerId, String custname, String address, int age) throws SQLException;
	
	public long createaccount(Account a) throws SQLException ;
	
	public ArrayList<Account> confirmdelete(Long id) throws SQLException ;
	
	public boolean deleteaccount(Long aid) throws SQLException;

	public boolean deletecustomer(long id) throws SQLException;

	public ArrayList<CustomerStatus> ViewCustomerDetails() throws SQLException;

	public ArrayList<AccountStatus> ViewAccountStatus() throws SQLException;

	public Account accountInfo(long id) throws SQLException;

	public ArrayList<Long> selectaccountId(long cid) throws SQLException;

	public Account deposit_ammount(long accid, double ammnt) throws SQLException;

	public boolean Transactionfortransfering(long sourceAccountId, long targetAccountId, double transferAmount) throws SQLException;

	public Account withdraw_ammount(long accid, double ammnt) throws SQLException;

	public double getBalance(long accid) throws SQLException;

	public ArrayList<Transactions> fetchTransByDate(long accid, String stDate, String endDate) throws  SQLException, TransactionNotPresent ;

	public ArrayList<Transactions> fetchTrans(long accid, int num) throws SQLException, TransactionNotPresent;

	public boolean deletetransaction(Long aid) throws SQLException;

	public boolean deletetransactionforcust(long id) throws SQLException;

	public boolean searchCustomer(long id) throws SQLException;

	public boolean searchforId(long cid) throws SQLException;

	public boolean searchAccount(long accid) throws SQLException;



}
