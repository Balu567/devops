package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Exception.InvalidUserException;
import com.Exception.SsnIdAlreadyPresent;
import com.Exception.SsnIdNotPresent;
import com.Exceptions.TransactionNotPresent;
import com.JUnitTest.JUnitTest;
import com.bean.Account;
import com.bean.AccountStatus;
import com.bean.Customer;
import com.bean.CustomerStatus;
import com.bean.Transactions;
import com.dao.FactoryPattern;
import com.service.BankService;
import com.service.BankserviceInterface;
import com.service.FactoryService;
import com.util.Constants;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class BankServlet extends HttpServlet implements Constants{
	Logger logg=Logger.getLogger(BankServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

             doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String action = request.getParameter(Action_1);
		BankserviceInterface bs =FactoryService.getBankService();
		if(action.equalsIgnoreCase(Logout_1)){
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect(Jsp_1);
		}
		if(action.equalsIgnoreCase(Login_1)){
			String Employee_id=request.getParameter(ID_1);
			String password=request.getParameter(Password_1);
			int el;
			try {
				
				el = bs.loginandinsert(Employee_id, password);
				
				if(el>0){
					RequestDispatcher rd=request.getRequestDispatcher(Jsp_11);
					request.setAttribute(El_1, el);
					HttpSession session = request.getSession();
					session.setAttribute(Login_11,Valid_12);
					rd.forward(request, response);
				}else if(el<0) {
					RequestDispatcher rd=request.getRequestDispatcher(Jsp_12);
					request.setAttribute(Valid_1, el);
					HttpSession session = request.getSession();
					session.setAttribute(Login_11,Valid_12);
					rd.forward(request, response);
				}
				if(el==0)
				{
					RequestDispatcher rd=request.getRequestDispatcher(Jsp_1);
					request.setAttribute(Msg_1, Invalid_1);				
					rd.forward(request, response);
				}
			} catch (ClassNotFoundException e) {
					logg.info(ClassnF);			
			} catch (InvalidUserException e) {
					RequestDispatcher rd=request.getRequestDispatcher(Jsp_1);
					request.setAttribute(Msg_1,Invalid_1);				
					rd.forward(request, response);
						
				}
			catch (SQLException e) {
				logg.info(Sql_ex);	
			}
			
		}
		
		if(action.equalsIgnoreCase(CreateCustomer_2))
		{
			String ssnid = request.getParameter(Ssnid_2);
			String custname = request.getParameter(Custname_2);
			String age = request.getParameter(Age_2);
			String addressline1 = request.getParameter(Address_2);
			String addressline2 = request.getParameter(Address1_2);
			String city = request.getParameter(City_2);
			String state = request.getParameter(State_2);
			
			long ssn = Long.parseLong(ssnid);
			int age1 = Integer.parseInt(age);
			
			String address = addressline1 + Comma_2 + addressline2 + Comma_2 +city+Comma_2 + state;
			
			boolean result=false;
			try {
			
				 result = bs.createcustomer(ssn,custname,age1,address);

					if(result)
					{
						
						RequestDispatcher rd=request.getRequestDispatcher(Jsp1_2);
						request.setAttribute(Custname_2,custname );
						request.setAttribute(Msg,Msg_2);
						rd.forward(request, response);
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher(Jsp2_2);
						request.setAttribute(Msg, Msg2_2);
						rd.forward(request, response);
					}
				
			} catch (SQLException e) {
				logg.info(Sql_ex);	
			} catch (SsnIdAlreadyPresent e) {
				RequestDispatcher rd=request.getRequestDispatcher(Jsp2_2);
				request.setAttribute(Msg, Msg3_2);
				rd.forward(request, response);
			}
			
		}
		if(action.equalsIgnoreCase(SearchCustomer_2)){
			int uid=Integer.parseInt(request.getParameter(Uid_2));
			Customer customer=new Customer();
			try {
				customer=bs.searchCustomerwithId(uid);
				if(customer!=null){
					RequestDispatcher rd=request.getRequestDispatcher(Jsp_3);
					request.setAttribute(Customer_2, customer);
					rd.forward(request, response);
					
				}
				else{
					RequestDispatcher rd=request.getRequestDispatcher(Jsp2_3);
					request.setAttribute(Message_2, Message2_1);
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				logg.info(Sql_ex);	
			} catch (SsnIdNotPresent e) {
				RequestDispatcher rd=request.getRequestDispatcher(Jsp2_4);
				request.setAttribute(Message_2, Message2_1);
				rd.forward(request, response);
			}
			
			
		}
		if(action.equalsIgnoreCase(UpdateCustomer_1)){
			int ssnid = Integer.parseInt(request.getParameter(Ssn_2));
			int customerId = Integer.parseInt(request.getParameter(CustId_2));
			String custname = request.getParameter(Name_2);
			String address = request.getParameter(Address_1);
			int age = Integer.parseInt(request.getParameter(Age1_2));
			String message=null;
			Customer customer=new Customer();
			customer.setSsn(ssnid);
			customer.setCustomerid(customerId);
			customer.setName(custname);
			customer.setAddress(address);
			customer.setAge(age);
			try {
				boolean flag=bs.updateCustomerDetails(ssnid,customerId,custname,address,age);
				RequestDispatcher rd=request.getRequestDispatcher(Jsp_3);
				request.setAttribute(Customer_2, customer);
				if(flag){
					
					request.setAttribute(Message_2, Message2_2);	
				}
				else{
					request.setAttribute(Message_2, Message2_3);	
				}
				rd.forward(request, response);
			} catch (SQLException e) {
				logg.info(Sql_ex);	
			}
			
		}
		
		
		
if(action.equalsIgnoreCase(CreateAcc_1)){
			
			long cid=Long.parseLong(request.getParameter(Cid_1));
			String accounttype = request.getParameter(AccType_1);
			double damount=Double.parseDouble(request.getParameter(DAmount));
			try {
				boolean b=bs.searchforId(cid);
			if(b)
			{
				
            Account a = new Account();
            a.setCustomerid(cid);
            a.setAccounttype(accounttype);
            a.setBalance(damount);
            long d=0;
			
				d = bs.createaccount(a);
				
				if(d>0){
					request.setAttribute("d",d);
					request.setAttribute(Cid_1, cid);
	            	request.getRequestDispatcher(Jsp2_5).forward(request, response);
	            }
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher(jsp2_6);
				request.setAttribute(Message_2, Message2_5);
				rd.forward(request, response);
			}
			} catch (SQLException e) {
				logg.info(Sql_ex);	
			}
         	}
		if(action.equalsIgnoreCase(Confirmdel_1)){
			Long id=Long.parseLong(request.getParameter(Id_1));
			try {
				boolean b=bs.searchforId(id);
			if(b){
			ArrayList<Account> al = new ArrayList<Account>();
              
				al = bs.confirmdelete(id);
				if(al!=null){
					request.setAttribute(A1_1, al);
	            	request.getRequestDispatcher(Jsp3_1).forward(request, response);
				}
			}
				
				else{
					RequestDispatcher rd=request.getRequestDispatcher(Jsp3_2);
					request.setAttribute(Message_2,Message2_6 );
					rd.forward(request, response);
				}
				
			
			} catch (SQLException e) {
				logg.info(Sql_ex);	
			}
			
		}
             if(action.equalsIgnoreCase(Del_1)){
          
            	 
         	long aid = Long.parseLong(request.getParameter(DelId_1));
         	request.setAttribute(DelId_1,aid);
         	try {

				boolean b=bs.deletetransaction(aid);
			
				if(b){
					
			
			boolean de=false;
			
				de = bs.deleteaccount(aid);
				
				if(de){
					
					request.getRequestDispatcher(Jsp4_1).forward(request, response);

				}
         	}
				else{
					boolean de=false;
					
					de = bs.deleteaccount(aid);
				
					if(de){
		            	request.getRequestDispatcher(Jsp4_1).forward(request, response);

					}
					
				}
         	
			} catch (SQLException e) {
				logg.info(Sql_ex);	
			}
		}
		

	
	
	
	
	else if(action.equalsIgnoreCase(delCust_1)) {
		
		long id = Long.parseLong(request.getParameter(UId_2));
		request.setAttribute("id",id);
		boolean bool = false;
		try {
			boolean x=bs.searchCustomer(id);
			if(x){
			bool=bs.deletetransactionforcust(id);
			if(bool){
				
			
			boolean bool1 = bs.deletecustomer(id);
			
		
		if (bool1) {
			RequestDispatcher rd = request.getRequestDispatcher(Jsp5_1);
			request.setAttribute(Message5_5,Message5 );
			rd.forward(request, response);
		}
			else {
				RequestDispatcher rd = request.getRequestDispatcher(Jsp5_1);
				request.setAttribute(Message5_1,Message5_2 );
				rd.forward(request, response);
			}
		
		} 
			else
			{
				boolean bool1 = bs.deletecustomer(id);
		
				if (bool1) {
					RequestDispatcher rd = request.getRequestDispatcher(Jsp5_1);
					request.setAttribute(Message5_5, Message5);
					rd.forward(request, response);
				}
					else {
						RequestDispatcher rd = request.getRequestDispatcher(Jsp5_1);
						request.setAttribute(Message5_1, Message5_2);
						rd.forward(request, response);
					}
			}
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher(Jsp5_1);
				request.setAttribute(Message5_1, Message5_2);
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			logg.info(Sql_ex);	
		}
		
	}

             if(action.equalsIgnoreCase(ViewCust_1)){
     			try {
     				ArrayList<CustomerStatus> cs=bs.ViewCustomerDetails();
     				RequestDispatcher rd=request.getRequestDispatcher(Jsp7_1);
     				request.setAttribute(Cs_1, cs);
     				rd.forward(request, response);
     			} catch (SQLException e) {
     				
     				logg.info(Sql_ex);	
     			}
     			
     			
     		}
     		
     		if(action.equalsIgnoreCase(Refresh_1)){
     			ArrayList<CustomerStatus> cs=new ArrayList<CustomerStatus>();
     			try {
     		    cs = bs.ViewCustomerDetails();
     			RequestDispatcher rd=request.getRequestDispatcher(Jsp8_1);
     			request.setAttribute(Cs_1, cs);
     			rd.forward(request, response);
     			}
     			
     			catch (SQLException e) {
     				
     				logg.info(Sql_ex);	
     			}
     			
     			
     		}
     		if(action.equalsIgnoreCase(ViewAcc_1))
     		{
     			ArrayList<AccountStatus> as=new ArrayList<AccountStatus>();
     			try {
     				as=bs.ViewAccountStatus();
     				RequestDispatcher rd=request.getRequestDispatcher(Jsp9_1);
     				request.setAttribute(As_1, as);
     				rd.forward(request, response);
     			} 
     			catch (SQLException e) {
     				logg.info(Sql_ex);	
     			}
     		}
     		if(action.equalsIgnoreCase(Refacc_1))
     		{
     		ArrayList<AccountStatus> as=new ArrayList<AccountStatus>();
     			try {
     				as = bs.ViewAccountStatus();
     				RequestDispatcher rd=request.getRequestDispatcher(Jsp9_1);
     				request.setAttribute(As_1, as);
     				rd.forward(request, response);
     			}
     			
     			catch (SQLException e) {
     				logg.info(Sql_ex);	
     			}
     		}
     		if(action.equalsIgnoreCase(Subacc_1))
    		{
    			long cid=Long.parseLong(request.getParameter(Ui_1));
    			long accid=Long.parseLong(request.getParameter(AcId_1));
    			if(accid>0){
    				try {
    					Account acc=bs.accountInfo(accid);
    					if(acc!=null){
    						RequestDispatcher rd=request.getRequestDispatcher(Jsp10_1);
    						request.setAttribute(AcDe_1, acc);
    						rd.forward(request, response);
    						}
    						else{
    							RequestDispatcher rd=request.getRequestDispatcher(Jsp11_1);
    							request.setAttribute(Message5_1,InAcCr_1 );
    							rd.forward(request, response);
    						}
    				} catch (SQLException e) {
    					
    					logg.info(Sql_ex);	
    				}
    			}
    			else if(cid>0){
    				try {
    					
    					ArrayList<Long> ob= bs.selectaccountId(cid);
    					if(ob!=null){
    						if(ob.size()>0)	{
    						RequestDispatcher rd=request.getRequestDispatcher(Jsp12_1);
    						request.setAttribute(Alist_1,ob);
    						rd.forward(request, response);
    						}
    						else{
    							RequestDispatcher rd=request.getRequestDispatcher(Jsp11_1);
    							request.setAttribute(Message5_1, Mss_1 );
    							rd.forward(request, response);
    							
    						}
    					}
    					else{
    						RequestDispatcher rd=request.getRequestDispatcher(Jsp11_1);
    						request.setAttribute(Message5_1, Mse_1);
    						rd.forward(request, response);
    					}
    					
    				} catch (SQLException e) {
    					
    					logg.info(Sql_ex);	
    				}
    			}
    			
    			
    		}
    		if(action.equalsIgnoreCase(Acchoice_1)){
    			long accountId=Long.parseLong(request.getParameter(Aid_1));
    			try {
    				Account acc=bs.accountInfo(accountId);
    				if(acc!=null){
    					RequestDispatcher rd=request.getRequestDispatcher(Jsp13_1);
    					request.setAttribute(Adee_1,acc);
    					rd.forward(request, response);
    					}
    					else{
    						RequestDispatcher rd=request.getRequestDispatcher(Jsp12_1);
    						request.setAttribute(Message5_1,AdAc_1);
    						rd.forward(request, response);
    					}
    			} catch (SQLException e) {
    				
    				logg.info(Sql_ex);	
    			}
    		
    		
    			
    			
    		}
    		
    		

			if(action.equals(Dm_1))
			{    		
				long cid=Long.parseLong(request.getParameter(Cid_1));
				long accid=Long.parseLong(request.getParameter(Acid_1));
				RequestDispatcher rd=request.getRequestDispatcher(Jsp14_1);
				request.setAttribute(Cid_1, cid);
				request.setAttribute(Acid_1, accid);
				rd.forward(request, response);
			}
			if(action.equals(Da_1))
			{
				long cid=Long.parseLong(request.getParameter(Id1_1));
				long accid=Long.parseLong(request.getParameter(Acid_1));
				double ammnt=Double.parseDouble(request.getParameter(MAm_1));
				try {
					Account a=bs.deposit_ammount(accid, ammnt);
					if(a!=null)
					{
						RequestDispatcher rd=request.getRequestDispatcher(Jsp15_1);
	    				request.setAttribute(Acc_1, a);
	    				request.setAttribute(Amm_1, ammnt);
	    				rd.forward(request, response);
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher(Jsp16_1);
	    				rd.forward(request, response);
					}
				} catch (SQLException e) {
					
					logg.info(Sql_ex);	
				}
				
						
				
			}
    		
			if(action.equals(WitD_1))
			{    
				long cid=Long.parseLong(request.getParameter(Cid_1));
				long accid=Long.parseLong(request.getParameter(AcId_1));
				try {
					double d=bs.getBalance(accid);
					
					RequestDispatcher rd=request.getRequestDispatcher(Jsp17_1);
				request.setAttribute(Cid_1, cid);
				request.setAttribute(AcId_1, accid);
				request.setAttribute(ACbal_1, d);
				rd.forward(request, response);
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		
			
		
			else if(action.equals(W_1))
			{
				long cid=Long.parseLong(request.getParameter(I_1));
				long accid=Long.parseLong(request.getParameter(AcId_1));
				double ammnt=Double.parseDouble(request.getParameter(MAm_1));
				try {
					double d=bs.getBalance(accid);
					
					if(d<ammnt)
					{
						RequestDispatcher rd=request.getRequestDispatcher(Jsp16_1);
	    				rd.forward(request, response);
					}
					else
					{
						
					
						Account a=bs.withdraw_ammount(accid, ammnt);
						if(a!=null)
						{
							RequestDispatcher rd=request.getRequestDispatcher(Jsp18_1);
							request.setAttribute(Aa_1, a);
							request.setAttribute(Amm_1, ammnt);
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher(Jsp16_1);
							rd.forward(request, response);
						}
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					logg.info(Sql_ex);	
				}
			}
			 if(action.equalsIgnoreCase(TAm_1))
			 {
			   	long sourceAccountId=Long.parseLong(request.getParameter(Acid_1));
			 	RequestDispatcher rd=request.getRequestDispatcher(Jsp19_1);
			 	request.setAttribute(SouAId_1,sourceAccountId);
			 	rd.forward(request, response);
			 }
			
    		if(action.equalsIgnoreCase(TfA_1)){
        		long sourceAccountId=Long.parseLong(request.getParameter(SouAId_1));	
        		long targetAccountId=Long.parseLong(request.getParameter(TaAId_1));	
        		double transferAmount=Long.parseLong(request.getParameter(TFa_1));
        		if(sourceAccountId!=targetAccountId){
        			Account targetAcccount;
					try {
						targetAcccount = bs.accountInfo(targetAccountId);
						if(targetAcccount!=null){
	            			Account sourceAcccount=bs.accountInfo(sourceAccountId);
	            			if(sourceAcccount.getBalance()>=transferAmount){
		            			boolean flag=bs.Transactionfortransfering(sourceAccountId,targetAccountId,transferAmount);
		            			if(flag){
		            			targetAcccount=bs.accountInfo(targetAccountId);
		            			sourceAcccount=bs.accountInfo(sourceAccountId);
		            			RequestDispatcher rd=request.getRequestDispatcher(Jsp20_1);
		    					request.setAttribute(SInfo_1,sourceAcccount);
		    					request.setAttribute(Tinfo_1,targetAcccount);
		    					request.setAttribute(MAm_1, transferAmount);
		    					rd.forward(request, response);
		            			}
		            			else{
		            				RequestDispatcher rd=request.getRequestDispatcher(Jsp21_1);
		        					request.setAttribute(Message5_1,TtF_1);

			    					rd.forward(request, response);
		            			}
	            			}
						
            			else{
            				RequestDispatcher rd=request.getRequestDispatcher(Jsp22_1);
            				request.setAttribute(SouAId_1,sourceAccountId);
        					request.setAttribute(Message5_1,sourceAcccount.getBalance()+No_1);
        					rd.forward(request, response);
            			}
					}
        			else{
        				RequestDispatcher rd=request.getRequestDispatcher(Jsp22_1);
        				request.setAttribute(SouAId_1,sourceAccountId);
    					request.setAttribute(Message5_1,No1_1);
    					rd.forward(request, response);
        			}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						logg.info(Sql_ex);	
					}
 
        		}
        		else{
        			RequestDispatcher rd=request.getRequestDispatcher(Jsp22_1);
        			request.setAttribute(SouAId_1,sourceAccountId);
					request.setAttribute(Message5_1,No2_1);
					rd.forward(request, response);
        		}

    		}
    		
    		
    		
    		
			
    		if(action.equalsIgnoreCase(Vss_1))
    		{
    			long accid=Long.parseLong(request.getParameter(AcId_1));
    			int num=Integer.parseInt(request.getParameter(C_1));
    			try {
    				boolean b=bs.searchAccount(accid);
    				if(b){
					ArrayList<Transactions> ob=bs.fetchTrans(accid,num);
					if(ob!=null)
					{
						RequestDispatcher rd=request.getRequestDispatcher(Jsp23_1);
						request.setAttribute(Arr_1, ob);
						
						rd.forward(request, response);
					}
    				}
    				else
    				{
    					RequestDispatcher rd=request.getRequestDispatcher(Jsp24_1);
						request.setAttribute(Message5_1,Nosuch_1);
						
						rd.forward(request, response);
    					
    				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					logg.info(Sql_ex);	
				} catch (TransactionNotPresent e) {
					RequestDispatcher rd=request.getRequestDispatcher(Jsp24_1);
					request.setAttribute(Message5_1,Notra_1);
					rd.forward(request, response);
				}
    			
    		}
			
    		
    		if(action.equals(SSt_1))
    		{
    			long accid=Long.parseLong(request.getParameter(AcId_1));
    			String stDate=request.getParameter(StD_1);
    			String endDate=request.getParameter(EnD_1);
    			try {
    				boolean b=bs.searchAccount(accid);
    				
    				if(b){
					ArrayList <Transactions>arr=bs.fetchTransByDate(accid,stDate,endDate);
				
					if(arr!=null)
					{
						RequestDispatcher rd=request.getRequestDispatcher(Jsp23_1);
						request.setAttribute(Arr_1, arr);
						
						rd.forward(request, response);
					}
    				}
    				else
    				{
    					RequestDispatcher rd=request.getRequestDispatcher(Jsp25_1);
						request.setAttribute(Message5_1,NSAId_1);
						
						rd.forward(request, response);
    					
    				}
    			} catch (SQLException e) {
					// TODO Auto-generated catch block
    				logg.info(Sql_ex);	
				} catch (TransactionNotPresent e) {
					RequestDispatcher rd=request.getRequestDispatcher(Jsp25_1);
					request.setAttribute(Message5_1,Notra_1);
					rd.forward(request, response);
				}

    			
    		}
    	
			
	}
}

