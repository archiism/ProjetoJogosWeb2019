package Servlets.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bus.UsuarioBus;


@WebServlet(name = "AtualizarUsuario", urlPatterns = { "/AtualizarUsuario" })
public class Atualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioBus usuarioBus = new UsuarioBus();
       
   
    public Atualizar() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		int nivel=Integer.parseInt(request.getParameter("nivel"));
		try 
		{
			usuarioBus.TrocarNivel(id, nivel);
			response.sendRedirect("/Projeto/ListarUsuarios");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
