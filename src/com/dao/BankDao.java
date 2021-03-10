package com.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.controller.BankServlet;
import com.util.Constants;
import com.util.DBUtil;

public class BankDao implements BankDaoInterface,Constants {

	Logger logg=Logger.getLogger(BankDao.class);
	public int loginandinsert(String employee_id, String password) throws InvalidUserException,SQLException, ClassNotFoundException {
		ResultSet rs=null;
		boolean result = false;
		Connection con=DBUtil.getConnection();

		PreparedStatement pst=con.prepareStatement(DBUtil.QUERY_0);
		pst.setString(1, employee_id);
		pst.setString(2, password);
		rs=pst.executeQuery();
		if(rs.next()){
			result = true;
			PreparedStatement pst1=con.prepareStatement(DBUtil.QUERY_1);
			pst1.setTimestamp(1, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			pst1.setString(2,employee_id);
			pst1.executeUpdate();
			if(employee_id.charAt(0)=='1'){
				logg.info(Console_1);
				return 1;
			}else if(employee_id.charAt(0)=='2'){

				logg.info(Console_2);

				return -1;
			}
		}
	
		
	return 0;

}

public boolean createcustomer(long ssn, String custname,int age1,String address) throws SQLException,SsnIdAlreadyPresent
{
	boolean res=false;
	int i=0;
	Connection con = DBUtil.getConnection();
	PreparedStatement ps2 = con.prepareStatement(DBUtil.QUERY_41);
	ResultSet rs=ps2.executeQuery();
	while(rs.next()){
		if(rs.getLong(1)==ssn){
			
			i=1;
		}
	}
		
		if(i==1)
		{
			
			return res;
		}
		else{
	
	PreparedStatement ps = con.prepareStatement(DBUtil.QUERY_2);
	ps.setLong(1, ssn);
	ps.setString(2, custname);
	ps.setString(3, address);
	ps.setInt(4, age1);
	int t = ps.executeUpdate();
	if(t>0)
	{
		res = true;
		PreparedStatement ps1 = con.prepareStatement(DBUtil.QUERY_3);
		ps1.setLong(1, ssn);
		ps1.setString(2, Cre_1);
		ps1.setString(3, CreS_1);
		ps1.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		ps1.executeUpdate();
		logg.info(Console_5);
		con.commit();
		return res;
	}
		
		
}
	
		
		return false;

}

public Customer searchCustomerwithId(long uid) throws SQLException,SsnIdNotPresent {
	Connection con = DBUtil.getConnection();
	boolean result =false;
	ResultSet rs=null;
	Customer customer=null;
	PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_4);
	ps.setLong(1, uid);
	ps.setLong(2, uid);
	rs=ps.executeQuery();
	if(rs.next()){
		result=true;
		customer=new Customer();
		customer.setSsn(rs.getLong(1));
		customer.setCustomerid(rs.getLong(2));
		customer.setName(rs.getString(3));
		customer.setAddress(rs.getString(4));
		customer.setAge(rs.getInt(5));
	}
	if(result==false)
	{
		
		customer=null;
		
	}
	return customer;
}

	public boolean updateCustomerDetails(long ssnid, long customerId, String custname, String address, int age) throws SQLException {

		boolean flag=false;
		Connection con = DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_5);
		ps.setString(1, custname);
		ps.setString(2, address);
		ps.setInt(3, age);
		ps.setLong(4, ssnid);
		flag=ps.executeUpdate()>0;
		if(flag){
			ps=con.prepareStatement(DBUtil.QUERY_6);
			ps.setString(1, Up_1);
			ps.setString(2, UpS_1);
			ps.setTimestamp(3,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps.setLong(4, ssnid);
			ps.executeUpdate();
			logg.info(Console_7);
		}
		
		return flag;
	}
	
	public long createaccount(Account a) throws SQLException {
		 Connection con = null;
		  PreparedStatement ps = null;
		  PreparedStatement ps2 = null;
          ResultSet rs=null;
		  boolean bool=false;
		  long accountid=0;
		  try{
			  con=DBUtil.getConnection();
			  ps=con.prepareStatement(DBUtil.QUERY_30);
			  ps.setLong(1,a.getCustomerid());
			  ps.setString(2,a.getAccounttype());
			  ps.setDouble(3,a.getBalance());
			  ps.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now()));
			  ps.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));
			  double du=10;
			  ps.setDouble(6,du);
			 int t=ps.executeUpdate();
			  if(t>0){
				  ps2=con.prepareStatement(DBUtil.QUERY_9);
				  ps2.setLong(1, a.getCustomerid());
				  rs=ps2.executeQuery();
				  while(rs.next()){
					  if(accountid<rs.getLong(2)){
						  accountid=rs.getLong(2);
					  }
				  }
				  bool=true;
				 
				  PreparedStatement ps1= con.prepareStatement(DBUtil.QUERY_31);
				  ps1.setLong(1,a.getCustomerid());
				  ps1.setString(2,a.getAccounttype());
				  ps1.setString(3, Cre_1);
				  ps1.setString(4,CreS_1);
				  ps1.setTimestamp(5,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				  ps1.executeUpdate();
				  logg.info(Console_8);
				  con.commit();
				 
				  return accountid;
			  }
			 
		  }
		  
		  finally{
			  if(con!=null)
				  con.close();
			  if(ps!=null)
				  ps.close();
		  }
		  logg.info(Console_9);
		return accountid;
	}

	public ArrayList<Account> confirmdelete(Long id) throws SQLException {

		Connection con = null;
		  PreparedStatement ps = null;
		  ResultSet rs=null;
		  ArrayList<Account> al = new ArrayList<Account>();
		  try{
			  con=DBUtil.getConnection();
			  ps=con.prepareStatement(DBUtil.QUERY_32);
			  ps.setLong(1,id);
			  rs=ps.executeQuery();
			  while(rs.next()){
				  Account a = new Account();
				  a.setCustomerid(id);
				  a.setAccountid(rs.getLong(2));
				  a.setAccounttype(rs.getString(3));
				  a.setBalance(rs.getDouble(4));
				  a.setCrdate(rs.getString(5));
				  a.setCrlastdate(rs.getString(6));
				  a.setDuration(rs.getDouble(7));
				  al.add(a);
			  }
			  return al;
		
	}finally{
		  if(con!=null)
			  con.close();
		  if(ps!=null)
			  ps.close();
	}
}

	public boolean deleteaccount(Long aid) throws SQLException {
		boolean bool=false;
		 Connection con = null;
		  PreparedStatement ps = null;
		  
		  try{
			  con=DBUtil.getConnection();
			  ps= con.prepareStatement(DBUtil.QUERY_33);
			  ps.setLong(1, aid);
			 int r=ps.executeUpdate();
			  if(r>0){
				  
				  PreparedStatement ps1 = con.prepareStatement(DBUtil.QUERY_34);
				  ps1.setString(1,Dele_1);
				  ps1.setString(2,DelS_1);
				  ps1.setTimestamp(3,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				  ps1.setLong(4, aid);
				  ps1.executeUpdate();
				  bool=true;
				  logg.info(Console_10);
				  con.commit();
				  return true;
			  }
	}finally{
		  if(con!=null)
			  con.close();
		  if(ps!=null)
			  ps.close();}
		  logg.info(Console_11);
		  return false;

}
	
	
	
	
	public boolean deletecustomer(long id) throws SQLException {
		boolean bool = false;
		Connection con = DBUtil.getConnection();
		long custid = 0,ssnid=0;
		PreparedStatement ps3 = con.prepareStatement(DBUtil.QUERY_7);
		ps3.setLong(1, id);
		ps3.setLong(2, id);
		ResultSet rs6 = ps3.executeQuery();
		while (rs6.next()) {
			custid = rs6.getLong(Cc_1);
			ssnid = rs6.getLong(SSnn_1);
		}
		PreparedStatement ps1 = con.prepareStatement(DBUtil.QUERY_8);
		ps1.setString(1, Dele_1);
		ps1.setString(2, DelS_1);
		ps1.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		ps1.setLong(4, custid);
		ps1.executeUpdate();
		
		PreparedStatement ps = con.prepareStatement(DBUtil.QUERY_9);
		ps.setLong(1, custid);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			PreparedStatement ps4 = con.prepareStatement(DBUtil.QUERY_10);
			ps4.setLong(1, custid);
			ps4.executeUpdate();
			PreparedStatement ps5 = con.prepareStatement(DBUtil.QUERY_11);
			ps5.setString(1, Dele_1);
			ps5.setString(2, DelS_1);
			ps5.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps5.setLong(4, custid);
			ps5.executeUpdate();
		}
		PreparedStatement ps6 = con.prepareStatement(DBUtil.QUERY_12);
		ps6.setLong(1, custid);
		int val = ps6.executeUpdate();
		if(val>0)
			bool=true;
		con.commit();
		DBUtil.closeStatement(ps);
		DBUtil.closeConnection(con);
		return bool;
	}
	
	public ArrayList<CustomerStatus> ViewCustomerDetails() throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		ArrayList<CustomerStatus> cs=new ArrayList<CustomerStatus>();
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_39);
		rs=ps.executeQuery();
		while(rs.next()){
			CustomerStatus s=new CustomerStatus();
			s.setSsn_id(rs.getLong(1));
			s.setCustomer_id(rs.getLong(2));
			s.setStatus(rs.getString(3));
			s.setMessage(rs.getString(4));
			s.setLast_updated(rs.getString(5));
			cs.add(s);
		}
		return cs;
	
	}

	public ArrayList<AccountStatus> ViewAccountStatus() throws SQLException {
		ArrayList<AccountStatus> as=new ArrayList<AccountStatus>();
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_40);
		rs=ps.executeQuery();
		while(rs.next()){
			AccountStatus a=new AccountStatus();
			a.setCustomer_id(rs.getLong(1));
			a.setAccount_id(rs.getLong(2));
			a.setAccount_type(rs.getString(3));
			a.setStatus(rs.getString(4));
			a.setMessage(rs.getString(5));
			a.setLast_updated(rs.getString(6));
			as.add(a);
		}
		return as;
	}
	public Account accountInfo(long id) throws SQLException {
		Connection con = DBUtil.getConnection();
		Account ob1=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_17);
		ps.setLong(1, id);
		ResultSet rs=null;
		rs=ps.executeQuery();
		
			if(rs.next())
			{
				ob1=new Account();
				ob1.setCustomerid(rs.getLong(1));
				ob1.setAccountid(rs.getLong(2));
				ob1.setAccounttype(rs.getString(3));
				ob1.setBalance(rs.getDouble(4));
				ob1.setCrdate(rs.getString(5));
				ob1.setCrlastdate(rs.getString(6));
				
			}
			
			return ob1;
	
	}

	public ArrayList<Long> selectaccountId(long cid) throws SQLException {
		ArrayList<Long> AccIdList=new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_15);
		long custId=0;
		ps.setLong(1, cid);
		ps.setLong(2, cid);
		ResultSet rs=null;
		rs=ps.executeQuery();
		if(rs.next())
		{
			custId=rs.getInt(1);
			ps=con.prepareStatement(DBUtil.QUERY_16);
			ps.setLong(1, custId);
			
			ResultSet rs1=null;
			rs1=ps.executeQuery();
			while(rs1.next())
			{
				AccIdList.add(rs1.getLong(1));
			}
			
			return AccIdList;
		}
		
		return null;
	}
	
	public Account deposit_ammount(long accid, double ammnt) throws SQLException {
		Account a=new Account();
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_23);
		ps.setDouble(1, ammnt);
		ps.setLong(2, accid);
		int t=ps.executeUpdate();
		if(t>0)
		{
			PreparedStatement ps1=con.prepareStatement(DBUtil.QUERY_24);
			ps1.setString(1,DeP_1 );
			ps1.setString(2, DePs_1);
			ps1.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps1.setLong(4, accid);
			int t1=ps1.executeUpdate();
			
			
			
			PreparedStatement ps3=con.prepareStatement(DBUtil.QUERY_25);
			PreparedStatement ps2=con.prepareStatement(DBUtil.QUERY_26);
			ps2.setLong(1,accid);
			ResultSet rs10=ps2.executeQuery();
			while(rs10.next())
			{

			ps3.setLong(1,rs10.getLong(1));
			ps3.setLong(2,rs10.getLong(2));

			ps3.setString(3, rs10.getString(3));
			ps3.setDouble(4, ammnt);
			ps3.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps3.setString(6, rs10.getString(3));
			ps3.setString(7, rs10.getString(3));
			ps3.setString(8, DeP_1);
			ps3.setString(9,Cred_1 );
			ps3.executeUpdate();
			a.setAccountid(accid);
			a.setCustomerid(rs10.getLong(1));
			a.setBalance(rs10.getLong(4));
			}
			
		}
		con.commit();
		return a;
	}
	
	public double getBalance(long accid) throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_36);
		ps.setLong(1, accid);
		rs=ps.executeQuery();
		rs.next();
		return rs.getDouble(1);
	}
	
	
	
	public Account withdraw_ammount(long accid, double ammnt) throws SQLException {
		Account a=new Account();
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_27);
		ps.setDouble(1, ammnt);
		ps.setLong(2, accid);
		int t=ps.executeUpdate();
		if(t>0)
		{
			PreparedStatement ps1=con.prepareStatement(DBUtil.QUERY_28);
			ps1.setString(1, Wit_1);
			ps1.setString(2, WitDS_1);
			ps1.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps1.setLong(4, accid);
			int t1=ps1.executeUpdate();
			
			
			
				PreparedStatement ps3=con.prepareStatement(DBUtil.QUERY_29);
				PreparedStatement ps2=con.prepareStatement(DBUtil.QUERY_35);
				ps2.setLong(1,accid);
				ResultSet rs10=ps2.executeQuery();
				while(rs10.next())
				{

				ps3.setLong(1,rs10.getLong(1));
				ps3.setLong(2,rs10.getLong(2));

				ps3.setString(3, rs10.getString(3));
				ps3.setDouble(4, ammnt);
				ps3.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				ps3.setString(6, rs10.getString(3));
				ps3.setString(7, rs10.getString(3));
				ps3.setString(8, Wit_1);
				ps3.setString(9,DeB_1 );
				ps3.executeUpdate();

				a.setAccountid(accid);
				a.setCustomerid(rs10.getLong(1));
				a.setBalance(rs10.getLong(4));
				
				}
				

			}
			
		
		con.commit();
		return a;
	}

	public boolean Transactionfortransfering(long sourceAccountId, long targetAccountId, double transferAmount) throws SQLException {
	
		Connection con = DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_18);
		ps.setDouble(1, transferAmount);
		ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		ps.setLong(3, sourceAccountId);
		boolean flag=ps.executeUpdate()>0;
		if(flag){
			PreparedStatement ps1=con.prepareStatement(DBUtil.QUERY_20);
			ps1.setString(1, Transa_1);
			ps1.setString(2,Amtc_1);
			ps1.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps1.setLong(4,targetAccountId );
			int t=ps1.executeUpdate();
			
			if(t>0){
				
			ps=con.prepareStatement(DBUtil.QUERY_19);
			ps.setDouble(1, transferAmount);
			ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps.setLong(3, targetAccountId);
			boolean flag1=ps.executeUpdate()>0;
			if(flag1){
				PreparedStatement ps3=con.prepareStatement(DBUtil.QUERY_20);
				ps3.setString(1, CR_1);
				ps3.setString(2, CrS_1);
				ps3.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				ps3.setLong(4,targetAccountId );
				ps3.executeUpdate();
				
				
				ps3=con.prepareStatement(DBUtil.QUERY_21);
				ps3.setLong(1,sourceAccountId );
				ResultSet	rs=ps3.executeQuery();
				ps=con.prepareStatement(DBUtil.QUERY_21);
				ps.setLong(1,targetAccountId );
				ResultSet	rs1=ps.executeQuery();
				Transactions trans=new Transactions();
				if(rs.next()&&rs1.next()){
					trans.setCustomerid(rs.getLong(1));
					trans.setAccountid(rs.getLong(2));
					trans.setAccounttype(rs.getString(3));
					trans.setSourceacctype(rs.getString(3));
					trans.setTargetacctype(rs1.getString(3));
				}
				
				//source account transaction Update
				PreparedStatement ps5=con.prepareStatement(DBUtil.QUERY_22);
				ps5.setLong(1,trans.getCustomerid());
				ps5.setLong(2, trans.getAccountid());
				ps5.setString(3,trans.getAccounttype());
				ps5.setDouble(4, transferAmount);
				ps5.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				ps5.setString(6, trans.getSourceacctype());
				ps5.setString(7,trans.getTargetacctype());
				ps5.setString(8,tRANsU_1);
				ps5.setString(9,DeB_1);
				ps5.executeUpdate();
				
				
				
				//target account transaction Update
				
				ps3=con.prepareStatement(DBUtil.QUERY_21);
				ps3.setLong(1,sourceAccountId );
				rs=ps3.executeQuery();
				ps=con.prepareStatement(DBUtil.QUERY_21);
				ps.setLong(1,targetAccountId );
				rs1=ps.executeQuery();
				trans=new Transactions();
				if(rs.next()&&rs1.next()){
					trans.setCustomerid(rs1.getLong(1));
					trans.setAccountid(rs1.getLong(2));
					trans.setAccounttype(rs1.getString(3));
					trans.setSourceacctype(rs1.getString(3));
					trans.setTargetacctype(rs.getString(3));
				}
				ps5=con.prepareStatement(DBUtil.QUERY_22);
				ps5.setLong(1,trans.getCustomerid());
				ps5.setLong(2, trans.getAccountid());
				ps5.setString(3,trans.getAccounttype());
				ps5.setDouble(4, transferAmount);
				ps5.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
				ps5.setString(6, trans.getSourceacctype());
				ps5.setString(7,trans.getTargetacctype());
				ps5.setString(8,CreSuc_1);
				ps5.setString(9,Cred_1);
				ps5.executeUpdate();
			}
			}
			
			return true;
		}
		else{
			PreparedStatement ps4=con.prepareStatement(DBUtil.QUERY_20);
			ps4.setString(1, Transa_1);
			ps4.setString(2, AmTrF_1);
			ps4.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps4.setLong(4,targetAccountId );
			ps4.executeUpdate();
			
		}
		return false;
	}

	

	public ArrayList<Transactions> fetchTrans(long accid, int num) throws SQLException {
		
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		int count=num;
		ArrayList<Transactions> arr=new ArrayList<Transactions>();
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_37);
		ps.setLong(1, accid);
		rs=ps.executeQuery();
		while(rs.next()){
			if(count>0){
				Transactions t=new Transactions();
				t.setAccountid(accid);
				t.setTransactiondate(rs.getString(1));
				t.setTransaction_description(rs.getString(2));
				t.setTransaction_type(rs.getString(3));
				t.setAmount(rs.getDouble(4));
				arr.add(t);
				count--;	
			}
		}
		return arr;
	}

	public ArrayList<Transactions> fetchTransByDate(long accid, String stDate, String endDate) throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		ArrayList<Transactions> arr=new ArrayList<Transactions>();
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_38);
		ps.setLong(1, accid);
		ps.setString(2,stDate);
		ps.setString(3,endDate);
		rs=ps.executeQuery();
		while(rs.next()){
			
				Transactions t=new Transactions();
				t.setAccountid(accid);
				t.setTransactiondate(rs.getString(1));
				t.setTransaction_description(rs.getString(2));
				t.setTransaction_type(rs.getString(3));
				t.setAmount(rs.getDouble(4));
				arr.add(t);
					
			}
		
		return arr;
		
	}
	
	

	public boolean searchforId(long cid) throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_44);
		rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.getLong(1)==cid)
			{
				return true;
			}
		}
		return false;
	}

	public boolean deletetransaction(Long aid) throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_42);
		ps.setLong(1, aid);
		int t=ps.executeUpdate();
		if(t>0)
		{
			return true;
		}
		return false;
	}

	public boolean deletetransactionforcust(long id) throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		long id1=0;
		PreparedStatement ps1=con.prepareStatement(DBUtil. QUERY_60);
		ps1.setLong(1, id);
		ps1.setLong(2, id);
		ResultSet rs6 = ps1.executeQuery();
		while(rs6.next())
		{
			id1=rs6.getLong(2);
		}
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_43);
		ps.setLong(1, id1);
		
		int t=ps.executeUpdate();
		if(t>0)
		{
			System.out.println("1");
			return true;
		}
		return false;
	}

	public boolean searchCustomer(long id) throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_13);
		rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.getLong(1)==id)
			{
				return true;
			}
			else if(rs.getLong(2)==id)
			{
                                                                       				
				return true;
			}
		}
		return false;
	
	}

	public boolean searchAccount(long accid) throws SQLException {
		Connection con = DBUtil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps=con.prepareStatement(DBUtil.QUERY_14);
		rs=ps.executeQuery();
		while(rs.next())
		{
			if(rs.getLong(1)==accid)
			{
				return true;
			}
		}
		return false;
	}
	
	
}