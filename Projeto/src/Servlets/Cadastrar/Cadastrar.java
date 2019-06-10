package Servlets.Cadastrar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bus.UsuarioBus;
import Dto.UsuarioDto;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/Cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDto usuarioDto = new UsuarioDto();
    private UsuarioBus usuarioBus = new UsuarioBus();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome= request.getParameter("txtNome");
		String cpf=request.getParameter("txtCpf");
		String login=request.getParameter("txtLogin");
		String senha=request.getParameter("txtSenha");
		String email=request.getParameter("txtEmail");
		String data=request.getParameter("txtData");
		int nvl=0;
		
		usuarioDto.setNome(nome);
		usuarioDto.setCpf(cpf);
		usuarioDto.setDataNascimento(data);
		usuarioDto.setEmail(email);
		usuarioDto.setLogin(login);
		usuarioDto.setNivelAcesso(nvl);
		usuarioDto.setSenha(senha);
		
		try
		{
			if(usuarioBus.Incluir(usuarioDto))
			{
				response.sendRedirect("/Projeto/index.jsp");
			}
		}catch(Exception e)
		{
		 e.getMessage();
		}
		
		
		
	}

}
