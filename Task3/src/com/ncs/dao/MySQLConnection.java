package com.ncs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	public static String host = "localhost:3306";
	public static String database = "task2";
	public static String url = "jdbc:mysql://"+ host+"/"+database;

    public static Connection mySql;
   
   
    static {
    		try {
				
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			mySql = DriverManager.getConnection(url,"root","root");
    	        System.out.println("MySQL Connection :- "+mySql);
    	        
			} 
    		catch (SQLException e) {
    			System.out.println("SQL Issues :- "+e.getMessage());
			}
    		catch (ClassNotFoundException e) {
    			System.out.println("Driver Class Missing , Load the Jar File :- "+e.getMessage());
			}
    		
    }
}
