package br.com.wellington.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/caellumjavaweb?serverTimezone=UTC&useSSL=false","root","Ccy123");
		} catch (SQLException e ) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e2) {
			throw new RuntimeException(e2);
		}
	} 
}
