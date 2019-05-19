package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Dto.UsuarioDTO;
import connection.ConnectionFactory;

public class UsuarioDAO {
	
	private Connection con=null;
	private String sql="";
	
	
	public Date converte(String data) {    
		SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
		Date dataRetorno = null;
		
		try {
			dataRetorno = new Date(forma.parse(data).getTime());
		} catch (java.text.ParseException e) {
			dataRetorno = null;
		}
		
		return dataRetorno;    
	}
	
	public Boolean VerifiqueConexao() throws Exception {
		try
		{
			con = ConnectionFactory.getConnection();
			if(con == null)
				return false;
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}

		return true;
	}
	
	public Boolean incluir(UsuarioDTO usuarioDTO) throws Exception
	{
		try 
		{
			if(!VerifiqueConexao())
				return false;
			
			sql="INSERT INTO USUARIO (nome,senha,login,telefone,email,cpf,dataNascimento,nivelAcesso) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, usuarioDTO.getNome());
			pst.setString(2, usuarioDTO.getSenha());
			pst.setString(3, usuarioDTO.getLogin());
			pst.setString(4, usuarioDTO.getTelefone());
			pst.setString(5, usuarioDTO.getEmail());
			pst.setString(6, usuarioDTO.getCpf());
			pst.setDate(7, this.converte(usuarioDTO.getDataNascimento()));
			pst.setInt(8, usuarioDTO.getNivelAcesso());
			return(pst.executeUpdate() > 0?true:false);
			
		} catch (SQLException e) {
			throw new Exception("Não foi possível executar o comando "+e);
		}
	}
}
