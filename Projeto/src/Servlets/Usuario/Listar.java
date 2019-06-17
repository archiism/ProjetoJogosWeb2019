package Servlets.Usuario;

import java.io.IOException;
import java.util.ArrayList;
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
       List<UsuarioDto> usuario = new ArrayList<>();
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
			 usuario=usuarioBus.Listar();
			sessao.setAttribute("listaUsuario", usuario);
			for(UsuarioDto u:usuario)
			{
				System.out.println(u.getNome());
				System.out.println(u.getEmail());
			}
			
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
