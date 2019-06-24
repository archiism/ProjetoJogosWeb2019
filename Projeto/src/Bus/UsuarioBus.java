package Bus;

import java.util.List;

import Dao.UsuarioDAO;
import Dto.UsuarioDto;

public class UsuarioBus {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	
	public UsuarioDto Login(UsuarioDto usuarioDto) throws Exception
	{
		try
		{
			return usuarioDAO.Login(usuarioDto);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		 
	}
	
	public Boolean Incluir(UsuarioDto usuarioDto) throws Exception
	{
		try
		{
			return usuarioDAO.incluir(usuarioDto);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public List<UsuarioDto> Listar() throws Exception
	{
		List<UsuarioDto> usuarios=null;
		try
		{
			 usuarios = usuarioDAO.Listar();
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return usuarios;
	}
	
	public UsuarioDto RetornarRegistro(int cod) throws Exception
	{
		try
		{
			return usuarioDAO.RetornarRegistro(cod);
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public Boolean TrocarNivel(int id, int nivel) throws Exception
	{
		
		try 
		{
			
			return usuarioDAO.AlterarNivel(nivel==1? 0:1, id);
			
		} catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}

}
