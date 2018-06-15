package br.com.wellington.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wellington.agenda.dao.ContatoDAO;
import br.com.wellington.agenda.model.Contato;

@WebServlet("/adicionarContato")
public class AdicionarContato extends HttpServlet{
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando servlet "+getClass().getSimpleName());
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo servlet "+getClass().getSimpleName());
	}


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");;
		String email = request.getParameter("email");;
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		//PrintWriter out = response.getWriter();
		
		try {
			Date data =  new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			//out.println("Erro de conversão de data");
			return;
		}
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		Connection connection = (Connection)request.getAttribute("connection");
		
		ContatoDAO contatoDAO = new ContatoDAO(connection);
		
		contatoDAO.adcionar(contato);
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);		
		
	}

}
