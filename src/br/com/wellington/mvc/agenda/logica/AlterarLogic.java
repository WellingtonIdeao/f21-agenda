package br.com.wellington.mvc.agenda.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wellington.agenda.dao.ContatoDAO;
import br.com.wellington.agenda.model.Contato;

public class AlterarLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Connection connection = (Connection) request.getAttribute("connection");
		Long id = Long.parseLong(request.getParameter("id"));
		
		
		Contato contato = new Contato();
		ContatoDAO contatoDAO = new ContatoDAO(connection);
		contatoDAO.alterar(contato);
		return "/WEB-INF/jsp/lista-contato-taglib.jsp";
	}

}
