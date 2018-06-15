package br.com.wellington.mvc.agenda.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wellington.agenda.dao.ContatoDAO;
import br.com.wellington.agenda.model.Contato;

public class AdicionarContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome");;
		String email = request.getParameter("email");;
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		try {
			Date data =  new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			throw new RuntimeException("erro de conversão de data", e);
		}
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		Connection connection = (Connection)request.getAttribute("connection");
		
		ContatoDAO contatoDAO = new ContatoDAO(connection);
		
		contatoDAO.adcionar(contato);
		return "/WEB-INF/contato-adicionado.jsp";
	}

}
