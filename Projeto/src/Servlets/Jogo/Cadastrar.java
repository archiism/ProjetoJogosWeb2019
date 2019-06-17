package Servlets.Jogo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bus.JogoBus;
import Dto.JogoDto;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet(name = "CadastrarJogo", urlPatterns = { "/CadastrarJogo" })
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    JogoDto jogoDto = new JogoDto();
    JogoBus jogoBus = new JogoBus();
    public Cadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txtNome");
		String dificuldade = request.getParameter("txtDificuldade");
		String genero = request.getParameter("txtGenero");
		String caminhoHtml = request.getParameter("txtCaminho");
		
		switch(dificuldade)
		{
		case "1":dificuldade="Facil"; break;
		case "2":dificuldade="Medio"; break;
		case "3":dificuldade="Dificil"; break;
		}
		
		switch(genero)
		{
		case "1":genero="Ação"; break;
		case "2":genero="Aventura"; break;
		case "3":genero="Corrida"; break;
		}
		
		jogoDto.setNome(nome);
		jogoDto.setDificuldade(dificuldade);
		jogoDto.setGenero(genero);
		jogoDto.setCaminhoHtml(caminhoHtml);
		
		try 
		{
			if(jogoBus.Incluir(jogoDto))
			{
				response.sendRedirect("/Projeto/menu.jsp");
			}
		}catch(Exception e)
		{
			e.getMessage();
		}
	}

}
