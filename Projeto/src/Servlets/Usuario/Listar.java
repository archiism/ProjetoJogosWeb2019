package Servlets.Usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.UsuarioBus;
import Dto.UsuarioDto;

/**
 * Servlet implementation class Listar
 */
@WebServlet(name = "ListarUsuarios", urlPatterns = { "/ListarUsuarios" })
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UsuarioBus usuarioBus = new UsuarioBus();
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);
		
		try
		{
			List<UsuarioDto> usuario=usuarioBus.Listar();
			sessao.setAttribute("listaUsuario", usuario);
			
		}catch(Exception e)
		{
			
		}
		response.sendRedirect("./usuarios.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
