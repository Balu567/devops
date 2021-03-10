package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.Exception.InvalidUserException;
import com.Exception.SsnIdAlreadyPresent;
import com.Exception.SsnIdNotPresent;
import com.Exceptions.TransactionNotPresent;
import com.bean.Account;
import com.bean.AccountStatus;
import com.bean.Customer;
import com.bean.CustomerStatus;
import com.bean.Transactions;
import com.dao.BankDao;
import com.dao.BankDaoInterface;
import com.dao.FactoryPattern;
import com.util.Constants;

public class BankService implements BankserviceInterface,Constants {
	
	BankDaoInterface bdao=FactoryPattern.getBankDao();
	Logger logg=Logger.getLogger(BankDao.class);
	public int loginandinsert(String employee_id, String password) throws ClassNotFoundException, SQLException, InvalidUserException {
		// TODO Auto-generated method stub
	
		
		boolean result = true;
			int i=bdao.loginandinsert(employee_id,password);
			if(i!=1 &&i!=-1)
			{
				result=false;
			}
			if(result == false)
			{
				logg.info(Console_3);
				throw new InvalidUserException();
			}
		
			return i;
	}
	public boolean createcustomer(long ssn, String custname,int age1,String address) throws SQLException,SsnIdAlreadyPresent
	{
		boolean b=bdao.createcustomer(ssn,custname,age1,address);
		if(b==false)
		{
			logg.info(Console_4);
			throw new SsnIdAlreadyPresent();
		}
		return b;
	}

	public Customer searchCustomerwithId(long uid) throws SQLException, SsnIdNotPresent {
		Customer c=bdao.searchCustomerwithId(uid);
		if(c==null)
		{
			logg.info(Console_6);
			throw new SsnIdNotPresent();
		}
		return c;
		
	}
	public boolean updateCustomerDetails(long ssnid, long customerId, String custname, String address, int age) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.updateCustomerDetails(ssnid,customerId,custname,address,age);
	}

	public long createaccount(Account a) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.createaccount(a);
	}
	public ArrayList<Account> confirmdelete(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.confirmdelete(id);
	}
	
	public boolean deleteaccount(Long aid) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.deleteaccount(aid);
	}
	public boolean deletecustomer(long id) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.deletecustomer(id);
	}
	
	public ArrayList<CustomerStatus> ViewCustomerDetails() throws SQLException {
		// TODO Auto-generated method stub
		return bdao.ViewCustomerDetails();
	}
	public ArrayList<AccountStatus> ViewAccountStatus() throws SQLException {
		// TODO Auto-generated method stub
		return bdao.ViewAccountStatus();
	}
	public Account accountInfo(long id) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.accountInfo(id);
	}
	public ArrayList<Long> selectaccountId(long cid) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.selectaccountId(cid);
	}

	public Account deposit_ammount(long accid, double ammnt) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.deposit_ammount(accid, ammnt);
	}
	public boolean Transactionfortransfering(long sourceAccountId, long targetAccountId, double transferAmount) throws SQLException {
		
		return bdao.Transactionfortransfering(sourceAccountId,targetAccountId,transferAmount);
	}
	public Account withdraw_ammount(long accid, double ammnt) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.withdraw_ammount(accid,ammnt);
	}
	public double getBalance(long accid) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.getBalance(accid);
		
	}
	public ArrayList<Transactions> fetchTrans(long accid, int num) throws SQLException, TransactionNotPresent {
		
		ArrayList<Transactions> tr=bdao.fetchTrans(accid, num);
		if(tr==null||tr.size()==0){
			logg.info(NoTrans);
			throw new TransactionNotPresent();
		}
		return tr;
	}
	public ArrayList<Transactions> fetchTransByDate(long accid, String stDate, String endDate) throws SQLException, TransactionNotPresent {
		// TODO Auto-generated method stub
		ArrayList<Transactions> tr=bdao.fetchTransByDate(accid,stDate, endDate);
		if(tr==null||tr.size()==0){
			logg.info(NoTrans);
			throw new TransactionNotPresent();
		}
		return tr;
	}
	public boolean deletetransaction(Long aid) throws SQLException {
		
		return bdao.deletetransaction( aid);
	}
	public boolean deletetransactionforcust(long id) throws SQLException {
		
		return bdao.deletetransactionforcust(id);
	}
	public boolean searchCustomer(long id) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.searchCustomer(id);
	}
	public boolean searchforId(long cid) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.searchforId(cid);
		
	}
	public boolean searchAccount(long accid) throws SQLException {
		// TODO Auto-generated method stub
		return bdao.searchAccount(accid);
	}
	


	
}
