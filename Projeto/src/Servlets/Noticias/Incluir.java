package Servlets.Noticias;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String titulo=request.getParameter("txtTitulo");
		String assunto=request.getParameter("txtAssunto");
		
		noticiaDto.setAssunto(titulo);
		noticiaDto.setTexto(assunto);
		try
		{
			//if(noticiaBus.Incluir(noticiaDto))
			//{
				response.sendRedirect("./menu.jsp");
			//}
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		
		
	}

}
