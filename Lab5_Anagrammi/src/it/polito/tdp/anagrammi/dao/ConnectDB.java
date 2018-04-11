package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	static private final String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=root"; 
	static private Connection connection = null;
	
	public static Connection getConnection() {
		
		try {
			if(connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(jdbcURL);
			}
		}catch(SQLException e){
			throw new RuntimeException("Cannot get a connection " + jdbcURL, e);
		}
		return connection;
	}
}
