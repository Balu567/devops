package com.util;

public interface Constants {
	public static final String USERNAME="system";
	public static final String PASSWORD="balaraju";
	public static final String DRIVERNAME="oracle.jdbc.driver.OracleDriver";
	public static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String QUERY_0="select*from USERSTORE_TJA31_GROUP_D where USERNAME=? and PASSWORD=?";
	public static final String QUERY_1="update USERSTORE_TJA31_GROUP_D set TIME_STAMP=? where USERNAME=?";
	public static final String QUERY_2="insert into CUSTOMER_TJA31_GROUP_D values (?, CUSTOMER_SEQ_TJA31_GROUP_D.nextval,?,?,?)";
	public static final String QUERY_3="insert into CUSTOMER_STATUS_TJA31_GROUP_D values (?,CUSTOMER_SEQ_TJA31_GROUP_D.currval,?,?,?)";
	public static final String QUERY_4="select * from CUSTOMER_TJA31_GROUP_D where SSN=? or CUSTOMER_ID=?";
	public static final String QUERY_5="update CUSTOMER_TJA31_GROUP_D set NAME=?,ADDRESS=?,AGE=? where SSN=?";
	public static final String QUERY_6="update CUSTOMER_STATUS_TJA31_GROUP_D set STATUS=?, MESSAGE=?,LAST_UPDATED=? where SSN_ID=?";
	
	
	public static final String QUERY_7="select * from CUSTOMER_TJA31_GROUP_D where CUSTOMER_ID=? or SSN=?";
	public static final String QUERY_8="update CUSTOMER_STATUS_TJA31_GROUP_D set STATUS=?,MESSAGE=?,LAST_UPDATED=? where CUSTOMER_ID=?";
	public static final String QUERY_9="select * from ACCOUNT_TJA31_GROUP_D where CUSTOMER_ID=?";
	public static final String QUERY_10="delete from ACCOUNT_TJA31_GROUP_D where CUSTOMER_ID=?";
	public static final String QUERY_11="update ACCOUNT_STATUS_TJA31_GROUP_D set STATUS=?,MESSAGE=?,LAST_UPDATED=? where CUSTOMER_ID=?";
	public static final String QUERY_12="delete from CUSTOMER_TJA31_GROUP_D where CUSTOMER_ID=?";
	public static final String QUERY_15="select CUSTOMER_ID from CUSTOMER_TJA31_GROUP_D where SSN=? or CUSTOMER_ID=?";
	public static final String QUERY_16="select ACCOUNT_ID from ACCOUNT_TJA31_GROUP_D where  CUSTOMER_ID=?";

	public static final String QUERY_17="select * from ACCOUNT_TJA31_GROUP_D where  ACCOUNT_ID=?";
	public static final String QUERY_18="update ACCOUNT_TJA31_GROUP_D set ACCOUNT_BALANCE=ACCOUNT_BALANCE-?, ACCOUNT_CR_LAST_DATE=? where  ACCOUNT_ID=?";
	public static final String QUERY_19="update ACCOUNT_TJA31_GROUP_D set ACCOUNT_BALANCE=ACCOUNT_BALANCE+?, ACCOUNT_CR_LAST_DATE=? where  ACCOUNT_ID=?";
	public static final String QUERY_20="update ACCOUNT_STATUS_TJA31_GROUP_D set STATUS=?, MESSAGE=?, LAST_UPDATED=? where ACCOUNT_ID=?";
	public static final String QUERY_21="select * from ACCOUNT_STATUS_TJA31_GROUP_D where ACCOUNT_ID=?";
	public static final String QUERY_22="INSERT INTO TRANSACTIONS_TJA31_GROUP_D VALUES(?,?,?,?,?,?,?,?,?)";
	
	public static final String QUERY_23="update ACCOUNT_TJA31_GROUP_D set ACCOUNT_BALANCE=ACCOUNT_BALANCE+? where ACCOUNT_ID=?";
	public static final String QUERY_24="update ACCOUNT_STATUS_TJA31_GROUP_D set STATUS=?, MESSAGE=?, LAST_UPDATED=? where ACCOUNT_ID=?";
	public static final String QUERY_25="insert into TRANSACTIONS_TJA31_GROUP_D values(?,?,?,?,?,?,?,?,?)";
	public static final String QUERY_26="select * from ACCOUNT_TJA31_GROUP_D where ACCOUNT_ID=?";

	public static final String QUERY_27="update ACCOUNT_TJA31_GROUP_D set ACCOUNT_BALANCE=ACCOUNT_BALANCE-? where ACCOUNT_ID=?";
	public static final String QUERY_28="update ACCOUNT_STATUS_TJA31_GROUP_D set STATUS=?, MESSAGE=?, LAST_UPDATED=? where ACCOUNT_ID=?";
	public static final String QUERY_29="insert into TRANSACTIONS_TJA31_GROUP_D values(?,?,?,?,?,?,?,?,?)";
	public static final String QUERY_35="select * from ACCOUNT_TJA31_GROUP_D where ACCOUNT_ID=?";
	public static final String QUERY_36="select ACCOUNT_BALANCE from ACCOUNT_TJA31_GROUP_D where ACCOUNT_ID=?";
	
	public static final String QUERY_37="select TRANSACTION_DATE,TRANSACTION_DESCRIPTION,TRANSACTION_TYPE,AMOUNT from TRANSACTIONS_TJA31_GROUP_D where ACCOUNT_ID=? order by TRANSACTION_DATE desc";
	public static final String QUERY_38="select TRANSACTION_DATE,TRANSACTION_DESCRIPTION,TRANSACTION_TYPE,AMOUNT from TRANSACTIONS_TJA31_GROUP_D where ACCOUNT_ID=? AND TRANSACTION_DATE>=TO_DATE(?,'YYYY-MM-DD') AND TRANSACTION_DATE<=TO_DATE(?,'YYYY-MM-DD')";
	public static final String QUERY_41="select SSN from CUSTOMER_TJA31_GROUP_D";
	public static final String QUERY_42="delete from TRANSACTIONS_TJA31_GROUP_D where ACCOUNT_ID=?";
	public static final String QUERY_43="delete from TRANSACTIONS_TJA31_GROUP_D where CUSTOMER_ID=?";
	public static final String QUERY_44="select  CUSTOMER_ID from CUSTOMER_TJA31_GROUP_D";
	public static final String QUERY_13="select CUSTOMER_ID,SSN from CUSTOMER_TJA31_GROUP_D";
	public static final String QUERY_14="select ACCOUNT_ID from ACCOUNT_TJA31_GROUP_D";
	
	
	
	public static final String QUERY_30="insert into ACCOUNT_TJA31_GROUP_D values( ?,ACCOUNT_SEQ_TJA31_GROUP_D.NEXTVAL,?,?,?,?,?)";
	public static final String QUERY_31="insert into ACCOUNT_STATUS_TJA31_GROUP_D values(?,ACCOUNT_SEQ_TJA31_GROUP_D.currval,?,?,?,?)";
	public static final String QUERY_32="select * from ACCOUNT_TJA31_GROUP_D where CUSTOMER_ID=?";
	public static final String QUERY_33="delete from ACCOUNT_TJA31_GROUP_D where ACCOUNT_ID=?";
	public static final String QUERY_34="update ACCOUNT_STATUS_TJA31_GROUP_D set STATUS=?,MESSAGE=?,LAST_UPDATED=? where ACCOUNT_ID=?";
	public static final String QUERY_39="select * from CUSTOMER_STATUS_TJA31_GROUP_D";
	public static final String QUERY_40="select * from ACCOUNT_STATUS_TJA31_GROUP_D";

	public static final String QUERY_60="select * from CUSTOMER_TJA31_GROUP_D where CUSTOMER_ID=? or SSN=?";
	//constants for servlet
	
	//for login servlet
	public static final String Action_1="action";
	public static final String Logout_1="logout";
	public static final String Jsp_1="login.jsp";
	public static final String Login_1="Login";
	public static final String ID_1="id";
	public static final String Valid_12="valid";
	public static final String Password_1="password";
	public static final String Jsp_11="jsp/1.jsp";
	public static final String El_1="el";
	public static final String Login_11="login";
	public static final String Valid_1="el";
	public static final String Jsp_12 ="jsp/5.jsp";
	public static final String Msg_1="msg";
	public static final String Invalid_1="invalid credentials";
	public static final String NoTrans="no transaction present";
	public static final String ACbal_1="accbalance";

	//for create customer servlet
	public static final String CreateCustomer_2="createcustomer";
	public static final String Ssnid_2="ssnid";
	public static final String Custname_2="custname";
	public static final String Age_2="age";
	public static final String Address_2="addressline1";
	public static final String Address1_2="addressline2";
	public static final String City_2="city";
	public static final String State_2="state";
	public static final String Comma_2=", ";
	public static final String Jsp1_2="jsp/success.jsp";
	public static final String Msg_2="Customer added successfully!!!";
	public static final String Jsp2_2="createcustomer.jsp";
	public static final String Msg2_2="Enter valid credentials!!!";
	public static final String Msg="message";
	public static final String Msg3_2="SSN ALREADY EXIST!!!";

	//for search customer servlet
	public static final String SearchCustomer_2="searchcustomer";
	public static final String Uid_2="uid";
	public static final String Jsp_3="jsp/updateCustomerDetails.jsp";
	public static final String Customer_2="customerDetails";
	public static final String Message_2="message";
	public static final String Message2_1="Invalid Customer credentials";
	public static final String Jsp2_3="jsp/updateCustomer.jsp";
	public static final String Jsp2_4="jsp/updateCustomer.jsp";
	
	//for update customer servlet
	
	public static final String UpdateCustomer_1="updateCustomer";
	public static final String Ssn_2="ssnId";
	public static final String CustId_2="customerId";
	public static final String Name_2="name";
	public static final String Address_1="address";
	public static final String Age1_2="age";
	public static final String Message2_2="Customer Update initiated successfully";
	public static final String Message2_3="Customer Updatation failed";

	//for create  account servlet
	public static final String CreateAcc_1="create";
	public static final String Cid_1="cid";
	public static final String AccType_1="atype";
	public static final String DAmount="damount";
	public static final String Jsp2_5="jsp/createsuccess.jsp";
	public static final String jsp2_6="createaccount.jsp";
	public static final String Message2_5="customer not exist";
	
	
	//for confirmdelete servlet
	public static final String Confirmdel_1="ConfirmDelete";
	public static final String Id_1="id";
	public static final String A1_1="al";
	public static final String Jsp3_1="jsp/confirmdelete.jsp";
	public static final String Jsp3_2="deleteaccount.jsp";
	public static final String Message2_6="customer not exist";

	
//for delete servlet
	public static final String Del_1="delete";
	public static final String DelId_1="delid";
	public static final String Jsp4_1="deletesuccess.jsp";
	
	
	//for delete customer servlet
	public static final String delCust_1="deletecust";
	public static final String UId_2="uid";
	public static final String Message5_1="message";
	public static final String Jsp5_1="deletecustomer.jsp";
	public static final String Message5_2=" Deletion failed!!!";
	public static final String Message5=" Deleted successfully";
	public static final String Message5_5="msg";
	//for view Customer servlet
	
	public static final String ViewCust_1="ViewCustomer";
	public static final String Jsp7_1="jsp/ViewCustomerStatus.jsp";
	public static final String Cs_1="cs";
	public static final String AccId_1="accid";
	//Refresh details servlet
	public static final String Refresh_1="Refresh";
	public static final String Jsp8_1="jsp/ViewCustomerStatus.jsp";
	
	
	//ViewAccount servlet
	
	public static final String ViewAcc_1="ViewAccount";
	public static final String Jsp9_1="jsp/ViewAccountStatus.jsp";
	public static final String As_1="as";
	//Refresh servlet
	
	public static final String Refacc_1="RefreshAccount";
	public static final String Subacc_1="Submit_Account";
	public static final String Ui_1="uid";
	public static final String AcId_1="accid";
	public static final String Jsp10_1="jsp/AccountDetails.jsp";
	public static final String AcDe_1="AccountDetails";
	public static final String Jsp11_1="AccountInput.jsp";
	public static final String InAcCr_1="Invalid Account credentials";
	
	//dropdown servlet
	public static final String Jsp12_1="jsp/Dropdownaccount.jsp";
	public static final String Alist_1="acclist";
	public static final String Mss_1="No accounts present for customer";
	public static final String Mse_1="Invalid Customer";


	public static final String Acchoice_1="AccountChoice";
	public static final String Aid_1="accountId";
	public static final String Jsp13_1="jsp/AccountDetails.jsp";
	public static final String Adee_1="AccountDetails";
	public static final String AdAc_1= "Add Account";
	public static final String Dm_1="DepositMoney";
	public static final String Acid_1="accid";
	public static final String Jsp14_1="jsp/deposit.jsp";
	public static final String Da_1="depositAmmount";
	public static final String Id1_1="id";
	public static final String MAm_1="amount";
	public static final String Jsp15_1="credited.jsp";
	
	
	public static final String Acc_1="acc";
	public static final String Amm_1="ammount";
	public static final String Jsp16_1="failure.jsp";
	public static final String WitD_1="WithdrawtMoney";
	public static final String Jsp17_1= "jsp/withdraw.jsp";
	public static final String WdMo_1="WithdrawtMoney";
	public static final String W_1="withdrawAmmount";
	public static final String I_1="id";
	public static final String Jsp18_1="debited.jsp";
	public static final String Aa_1="acc";
	public static final String TAm_1="TransferMoney";
	public static final String Jsp19_1="jsp/TransferAmount.jsp";
	
	public static final String SouAId_1="sourceAccountId";
	public static final String TfA_1="TransferAmount";
	public static final String TaAId_1="targetAccountId";
	public static final String TFa_1="transferAmount";
	public static final String Jsp20_1="jsp/Transactionsuccess.jsp";
	public static final String SInfo_1="sourceAccountInfo";
	public static final String Tinfo_1="targetAccountInfo";
	public static final String Jsp21_1="jsp/Transactionfailure.jsp";
	public static final String TtF_1="transaction failed";
	public static final String Jsp22_1="jsp/TransferAmount.jsp";
	public static final String No_1=" amount in balance! Reenter the amount to be transferred!";
	public static final String No1_1="TargetAccountId is invalid";
	public static final String No2_1="SourceId and TargetId cannot be same";
	public static final String Vss_1="viewStatement";
	
	public static final String C_1="count";
	public static final String Jsp23_1="jsp/getMini.jsp";
	public static final String Arr_1="arr";
	public static final String Jsp24_1="jsp/viewmini.jsp";
	public static final String Nosuch_1="no such account id present";
	public static final String Notra_1="NO TRANSACTIONS PRESENT";
	public static final String SSt_1="searchState";
	public static final String StD_1="stdate";
	public static final String EnD_1="enddate";
	public static final String Jsp25_1="jsp/viewByDate.jsp";
	public static final String NSAId_1="no such account id present";
	
	public static final String Cre_1="created";
	public static final String CreS_1="created successfully";
	public static final String Up_1="Updated";
	public static final String UpS_1="Updated Successfully";
	public static final String Dele_1="Deleted";
	public static final String DelS_1="Deleted successfully";
	public static final String Cc_1="CUSTOMER_ID";
	public static final String SSnn_1="SSN";
	public static final String DeP_1="deposited";
	public static final String DePs_1="depositedSuccessfully";
	public static final String Cred_1="CREDIT";
	
	public static final String Wit_1="withdrawn";
	public static final String WitDS_1="withdrawnSuccessfully";
	public static final String DeB_1="DEBIT";
	public static final String Transa_1="Transaction";
	public static final String Amtc_1= "Amount transfer completed successfully";
	public static final String CR_1="credited";
	public static final String CrS_1="creditedSuccessfully";
	public static final String tRANsU_1="transaction succedded";
	public static final String CreSuc_1="Credited successfully";
	public static final String AmTrF_1="Amount transfer failed";
	
	
	public static final String ClassnF="Class Not Found Exception";
	public static final String  Sql_ex="sql exception";
	
	
	
	public static final String Console_1="Login successful for executive";
	public static final String Console_2="Login successful for cashier";

	public static final String Console_4="Customer with the entered SSN Already Present!";

	public static final String Console_5="Customer successfully created";

	public static final String Console_3="Login unsuccessful!";

	public static final String Console_6="Entered SSN Not Present";

	public static final String Console_7="Customer details successfully updated";
	public static final String Console_8="Account Created successfully!";
	public static final String Console_9="Account Creation Unsuccessfull!";
	public static final String Console_10="Account Deleted successfully!";
	public static final String Console_11="Account Deletion Unsuccessfull!";
}
