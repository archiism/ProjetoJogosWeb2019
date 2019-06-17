package Servlets.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.NoticiaBus;
import Bus.UsuarioBus;
import Dao.UsuarioDAO;
import Dto.NoticiaDto;
import Dto.UsuarioDto;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioBus usuarioBus=new UsuarioBus();
	private UsuarioDto usuarioDto = new UsuarioDto();
	private NoticiaBus noticiaBus=new NoticiaBus();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String usuario=request.getParameter("txtLogin");
		String senha=request.getParameter("txtSenha");
		request.setAttribute("dados", "hidden");
		usuarioDto.setLogin(usuario);
		usuarioDto.setSenha(senha);
		try 
		{
			
			UsuarioDto user=usuarioBus.Login(usuarioDto);
			
			if(user!=null)
			{
				HttpSession sessao = request.getSession(true);
				sessao.setMaxInactiveInterval(60);
				sessao.setAttribute("usuarioLogado", user);
				
				NoticiaDto  noticias=noticiaBus.Listar();
				sessao.setAttribute("noti", noticias);
				sessao.setAttribute("logado", "verdade");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/menu.jsp");
				rd.forward(request, response);
				//response.sendRedirect("menu.jsp");
			}
			else
			{
				response.sendRedirect("/Projeto/index.jsp");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
