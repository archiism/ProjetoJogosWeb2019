package Servlets.Comentario;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.ComentariosBus;
import Dto.ComentarioDto;
import Dto.JogoDto;
import Dto.UsuarioDto;

/**
 * Servlet implementation class Incluir
 */
@WebServlet(name = "IncluirComentario", urlPatterns = { "/IncluirComentario" })
public class Incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ComentarioDto comentarioDto=new ComentarioDto();
	ComentariosBus comentarioBus = new ComentariosBus();
	JogoDto jogoDto = new JogoDto();
	UsuarioDto usuarioDto = new UsuarioDto();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Incluir() {
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
		HttpSession session=request.getSession(false);
		if(session==null)
			response.sendRedirect("/index.jsp");
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String data=sdf.format(new Date(System.currentTimeMillis()));
			//String data="2008/02/14";
			UsuarioDto user=(UsuarioDto)session.getAttribute("usuarioLogado");
			String comentario=request.getParameter("txtComentarios");			
			int usuario=user.getIdUsuario();
			int jogo=Integer.parseInt(String.valueOf(session.getAttribute("idJogo")));			
			List<ComentarioDto> comentarios=null;
			
			comentarioDto.setComentario(comentario);
			comentarioDto.setData(data);
			comentarioDto.setIdUsuario(usuario);
			comentarioDto.setIdJogo(jogo);
			
			
			
			try
			{
				if(comentarioBus.Incluir(comentarioDto))
				{
					comentarios=comentarioBus.Listar(jogo);
					request.setAttribute("post", comentarios);
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/Jogos.jsp");
					rd.forward(request, response);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
