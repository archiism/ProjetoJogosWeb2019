package Servlets.Login;

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
import Bus.NoticiaBus;
import Bus.UsuarioBus;
import Dao.UsuarioDAO;
import Dto.JogoDto;
import Dto.NoticiaDto;
import Dto.UsuarioDto;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioBus usuarioBus=new UsuarioBus();
	private UsuarioDto usuarioDto = new UsuarioDto();
	private NoticiaBus noticiaBus=new NoticiaBus();
    private JogoDto jogoDto = new JogoDto();
    private JogoBus jogoBus = new JogoBus();
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
				//sessao.setMaxInactiveInterval(60);
				sessao.setAttribute("usuarioLogado", user);
				sessao.setAttribute("usuario", user.getNome());
				
				List<JogoDto> jogos=jogoBus.ListaJogos();
				
				NoticiaDto  noticias=noticiaBus.Listar();
				sessao.setAttribute("jogos", jogos);
				sessao.setAttribute("noti", noticias);
				sessao.setAttribute("logado", "verdade");
				sessao.setAttribute("jogos", jogos);
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
