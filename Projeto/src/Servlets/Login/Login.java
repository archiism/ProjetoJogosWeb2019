package Servlets.Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.UsuarioBus;
import Dao.UsuarioDAO;
import Dto.UsuarioDto;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioBus usuarioBus=new UsuarioBus();
	private UsuarioDto usuarioDto = new UsuarioDto();
       
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
		
		usuarioDto.setLogin(usuario);
		usuarioDto.setSenha(senha);
		try 
		{
			HttpSession sessao = request.getSession(true);
			UsuarioDto user=usuarioBus.Login(usuarioDto);
			
			if(user!=null)
			{
				sessao.setMaxInactiveInterval(60);
				sessao.setAttribute("usuarioLogado", user);
				response.sendRedirect("");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
