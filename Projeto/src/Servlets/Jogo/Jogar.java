package Servlets.Jogo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.ComentariosBus;
import Dto.ComentarioDto;

/**
 * Servlet implementation class Jogar
 */
@WebServlet("/Jogar")
public class Jogar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ComentariosBus comentarioBus = new ComentariosBus();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jogar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String game=request.getParameter("jogoJs");
		String nome=request.getParameter("nome");
		int idJogo= Integer.parseInt((String)request.getParameter("codigo"));
		List<ComentarioDto> comentarios=null;
		
		//request.setAttribute("game",game);
		//request.setAttribute("nomeJogo", nome);
		session.setAttribute("game", game);
		session.setAttribute("nomeJogo", nome);
		session.setAttribute("idJogo", idJogo);
		
		try
		{
			comentarios=comentarioBus.Listar(idJogo);
			request.setAttribute("post", comentarios);
		}catch(Exception e)
		{
			
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Jogos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
