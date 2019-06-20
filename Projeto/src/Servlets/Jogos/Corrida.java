package Servlets.Jogos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.JogoBus;
import Dto.JogoDto;

/**
 * Servlet implementation class Corrida
 */
@WebServlet("/Corrida")
public class Corrida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JogoBus jogoBus = new JogoBus();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Corrida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null)
			response.sendRedirect("/Projeto/index.jsp");
		else
		{
			try
			{
				List<JogoDto> jogos=jogoBus.ListaJogosCategoria("Corrida");
				request.setAttribute("jogos", jogos);
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu.jsp");
				rd.forward(request, response);
				response.sendRedirect("/Projeto/Jogos.jsp");
				
			}catch(Exception e)
			{
				
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
