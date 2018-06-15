package br.com.wellington.agenda.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.wellington.agenda.jdbc.ConnectionFactory;
@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Connection connection = ConnectionFactory.getConection();	
		request.setAttribute("connection", connection);
		chain.doFilter(request, response);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
