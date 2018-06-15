package br.com.wellington.mvc.agenda.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wellington.agenda.dao.ContatoDAO;
import br.com.wellington.agenda.model.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		Connection connection = (Connection) request.getAttribute("connection");
		ContatoDAO contatoDAO = new ContatoDAO(connection);
		List<Contato> contatos = contatoDAO.getLista();
		request.setAttribute("contatos", contatos);
		
		
		return "/WEB-INF/jsp/lista-contato-taglib.jsp";
	}

}
