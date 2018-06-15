package br.com.wellington.agenda.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.wellington.agenda.jdbc.ConnectionFactory;
import br.com.wellington.agenda.model.Contato;

//classe de CRUD

public class ContatoDAO {
	private Connection connection;
	
	public ContatoDAO(Connection connection) {
		this.connection = connection;
	}
	//Create
	public void adcionar(Contato contato) {
		String  sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
		PreparedStatement stmt = null;
			try {
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1,contato.getNome());
				stmt.setString(2,contato.getEmail());
				stmt.setString(3,contato.getEndereco());
				stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}
	
	//read
	public List<Contato> getLista(){
		List<Contato> listContatos = new ArrayList<Contato>();
		PreparedStatement stmt = null;
		String  sql = "select * from contatos";
		
		try{
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("idContato"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar  calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(calendar);
			
				listContatos.add(contato);
			}
		stmt.close();		
		return listContatos;	
		
		}catch(SQLException e) {
				throw new RuntimeException(e);
		}
	}
	
	//update
	public void alterar(Contato contato) {
		String sql = "update  contatos set nome=?, email=?, endereco=?, dataNascimento=? where idContato=?";
		PreparedStatement stmt = null;
		try {
		stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5,contato.getId());
		stmt.execute();
		stmt.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//delete
	public void remove(Contato contato) {
		String sql = "delete from contatos where idContato=?";
		PreparedStatement stmt = null;
			try {
				stmt = this.connection.prepareStatement(sql);
				stmt.setLong(1, contato.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}
	

}
