package Servlets.Noticias;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.NoticiaBus;
import Dto.NoticiaDto;

/**
 * Servlet implementation class Listar
 */
@WebServlet(name = "ListarNoticias", urlPatterns = { "/ListarNoticias" })
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticiaBus noticiaBus=new NoticiaBus();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);
		try
		{
			List<NoticiaDto> noticias=noticiaBus.Listar();
			sessao.setAttribute("listarNoticias", noticias);
		}catch(Exception e)
		{
			e.getMessage();
		}
	}

	

}
