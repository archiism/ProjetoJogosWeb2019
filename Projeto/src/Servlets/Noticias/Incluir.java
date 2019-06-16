package Servlets.Noticias;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.NoticiaBus;
import Dto.NoticiaDto;

/**
 * Servlet implementation class Incluir
 */
@WebServlet(name = "CadNoticia", urlPatterns = { "/CadNoticia" })
public class Incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoticiaDto noticiaDto = new NoticiaDto();
    private NoticiaBus noticiaBus = new NoticiaBus();
    
    public Incluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String titulo=request.getParameter("txtTitulo");
		String assunto=request.getParameter("txtAssunto");
		String data= sdf.format( new Date( System.currentTimeMillis()));
		
		noticiaDto.setAssunto(titulo);
		noticiaDto.setTexto(assunto);
		noticiaDto.setData(data);
		
		HttpSession session = request.getSession(true);
		
		try
		{
			if(noticiaBus.Alterar(noticiaDto))
			{
				NoticiaDto  noticias=noticiaBus.Listar();
				session.setAttribute("noti", noticias);
				//response.sendRedirect("./menu.jsp");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/menu.jsp");
				rd.forward(request, response);
				
				
			}
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
