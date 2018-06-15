package br.com.wellington.mvc.agenda.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.wellington.mvc.agenda.logica.Logica;


@WebServlet("/sistema")
//controller
public class ControllerLogicaServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroLogica = request.getParameter("logica");
		String nomeClasse = "br.com.wellington.mvc.agenda.logica."+parametroLogica; 
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			Logica  lg = (Logica) classe.newInstance();
			String paginaRedirecionada = lg.executa(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(paginaRedirecionada);
			rd.forward(request, response);
		} catch (Exception e) {
			throw new  ServletException("Logica de negocio causou uma exceção",e);
		}
		
	}

}
