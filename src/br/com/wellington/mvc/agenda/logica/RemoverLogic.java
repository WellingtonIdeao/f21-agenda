package br.com.wellington.mvc.agenda.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wellington.agenda.dao.ContatoDAO;
import br.com.wellington.agenda.model.Contato;

public class RemoverLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		Contato contato = new Contato();
		Connection connection = (Connection) request.getAttribute("connection");
		ContatoDAO dao = new ContatoDAO(connection);
		contato.setId(id);
		dao.remove(contato);
		return "/sistema?logica=ListaContatosLogic";
	}

}
