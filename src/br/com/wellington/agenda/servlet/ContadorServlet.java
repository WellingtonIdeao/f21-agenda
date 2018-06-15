package br.com.wellington.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ContadorServlet extends HttpServlet {
	private int contador;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.contador++;
		PrintWriter out = response.getWriter(); 
		out.print("<html>"
				+ "<body>Contador: "+this.contador+"</body>"
				+ "</html>");
	}
	
	
	

}
