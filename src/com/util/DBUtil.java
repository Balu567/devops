package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil implements Constants{
	
	public static Connection getConnection(){
		
		Connection conn = null;
		
		try {
				Class.forName(DRIVERNAME);
				
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver cannot be loaded");
				
		}catch (SQLException e ) {
			// TODO Auto-generated catch block
			System.out.println("Connection cannot be established");
		}
		
		return conn;
	}
	
	
	public static void closeConnection(Connection conn){
		
		if(conn != null){
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void closeStatement(PreparedStatement ps){
		
		if(ps != null){
			try{
				ps.close();
			}
			catch (SQLException e) {
			
				e.printStackTrace();
			}
		}

	}
	public static void closeStatement(Statement s){
		
		if(s != null){
			try{
				s.close();
			}
			catch (SQLException e) {
			
				e.printStackTrace();
			}
		}

	}
	}


