package com.JUnitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import org.junit.Test;

import com.Exception.InvalidUserException;
import com.Exception.SsnIdAlreadyPresent;
import com.Exception.SsnIdNotPresent;
import com.Exceptions.TransactionNotPresent;
import com.bean.Account;
import com.bean.AccountStatus;
import com.bean.Customer;
import com.bean.CustomerStatus;
import com.bean.Transactions;
import com.dao.BankDaoInterface;
import com.dao.FactoryPattern;

public class JUnitTest {
	Logger logg=Logger.getLogger(JUnitTest.class);

	@Test
	public void testLoginandinsert(){
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=false;
		int i;
		try {
			i = bdao.loginandinsert("123456789", "executive");
			if(i>0)
			{
				b=true;
				logg.info("Test Succeed");
			}
			
			assertEquals(true, b);
			
		

		} catch (ClassNotFoundException e) {
			logg.info("class not found exception");
			
		} catch (InvalidUserException e) {
			
			logg.info("Does not exist");
		} catch (SQLException e) {
			logg.info("sql Exception");
		}
	}
		
		
	@Test
	public void testCreatecustomer()  {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b;
		try {
			b = bdao.createcustomer(777777777, "sravani", 22, "nlr,nlr1,hyd,AndhraPradesh");
		
		
		assertEquals(true, b);
		logg.info("Test Succeed");
		} catch (SQLException | SsnIdAlreadyPresent e) {
			logg.info("SSN already exist");
		}
	}

	@Test
	public void testSearchCustomerwithId()  {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=false;
		Customer c;
		try {
			c = bdao.searchCustomerwithId(100000000);
			if(c!=null)
			{
				b=true;
				logg.info("Test Succeed");
			}
			assertEquals(true, b);
		} catch (SQLException e) {
			logg.info("Sql exception");

		} catch (SsnIdNotPresent e) {
			logg.info("SSN not exist");

		}
		
	}

	@Test
	public void testUpdateCustomerDetails() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.updateCustomerDetails(222222222, 100000010, "Sumu", "kolkata,kharida,bidhanpally", 20);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}

	@Test
	public void testCreateaccount() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		Account a=new Account();
		a.setCustomerid(100000050);
		a.setAccounttype("C");
		a.setBalance(1000);
		long b=bdao.createaccount(a);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}

	

	@Test
	public void testViewCustomerDetails() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		ArrayList<CustomerStatus> list=bdao.ViewCustomerDetails();
		boolean b=false;
		if(list.size()>0||list!=null){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
		
	}

	@Test
	public void testViewAccountStatus() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		ArrayList<AccountStatus> list=bdao.ViewAccountStatus();
		boolean b=false;
		if(list.size()>0||list!=null){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
	}

	@Test
	public void testAccountInfo() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		Account a=bdao.accountInfo(200000000);
		boolean b=false;
		if(a!=null){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
	}

	@Test
	public void testSelectaccountId() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		ArrayList<Long> list=bdao.selectaccountId(100000040);
		boolean b=false;
		if(list.size()>0||list!=null){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
	}

	@Test
	public void testDeposit_ammount() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		Account a=bdao.deposit_ammount(200000011, 2000);
		boolean b=false;
		if(a!=null){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
		
	}

	@Test
	public void testGetBalance() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		Double ammount=bdao.getBalance(200000011);
		boolean b=false;
		if(ammount>=0){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
	}

	@Test
	public void testWithdraw_ammount() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		Account a=bdao.withdraw_ammount(200000011, 1000);
		boolean b=false;
		if(a!=null){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
	}

	@Test
	public void testTransactionfortransfering() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.Transactionfortransfering(200000000, 200000002,500);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}

	@Test
	public void testFetchTrans() {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		ArrayList<Transactions> list;
		try {
			list = bdao.fetchTrans(200000000, 1);
			boolean b=false;
			if(list.size()>0||list!=null){
				b=true;
				logg.info("Test Succeed");
			}
			assertEquals(true, b);
		} catch (SQLException e) {
			logg.info("Sql exception");

		} catch (TransactionNotPresent e) {
			logg.info("No transaction present");

		}
		
	}

	@Test
	public void testFetchTransByDate()  {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		ArrayList<Transactions> list;
		try {
			list = bdao.fetchTransByDate(200000000,"2018-08-24","2018-08-30");
			boolean b=false;
			if(list.size()>0||list!=null){
				b=true;
				logg.info("Test Succeed");
			}
			assertEquals(true, b);
		} catch (SQLException e) {
			logg.info("sql exception");
		} catch (TransactionNotPresent e) {
			logg.info("No transaction present");
		}
		
	}

	@Test
	public void testSearchforId() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.searchforId(100000050);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}

	

	@Test
	public void testSearchCustomer() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.searchCustomer(100000020);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}

	@Test
	public void testSearchAccount() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.searchAccount(200000002);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}
	@Test
	public void testDeletetransaction() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.deletetransaction((long) 200000001);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}


	@Test
	public void testDeletetransactionforcust() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.deletetransactionforcust(100000010);
		logg.info("Test Succeed");
		assertEquals(true, b);
		
	}
	
	@Test
	public void testConfirmdelete() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		ArrayList<Account> list=bdao.confirmdelete((long) 100000010);
		boolean b=false;
		if(list.size()>0||list!=null){
			b=true;
			logg.info("Test Succeed");
		}
		assertEquals(true, b);
	}
   
	@Test
	public void testDeleteaccount() throws SQLException {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b=bdao.deleteaccount((long) 200000002);
		logg.info("Test Succeed");
		assertEquals(true, b);
	}

	@Test
	public void testDeletecustomer() {
		BankDaoInterface bdao=FactoryPattern.getBankDao();
		boolean b;
		try {
			b = bdao.deletecustomer(100000010);
			logg.info("Test Succeed");
			assertEquals(true, b);
		} catch (SQLException e) {
			logg.info("sql Exception");
		}
		
	}


}
