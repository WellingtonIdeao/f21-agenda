package br.com.wellington.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.wellington.agenda.jdbc.ConnectionFactory;

public class main {
	
	public static void main (String[] args) throws SQLException {
	
	Connection c = ConnectionFactory.getConection();
	System.out.println(c);
	c.close();
	
	}
	
}
