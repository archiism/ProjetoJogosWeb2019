package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dto.GeneroDto;
import connection.ConnectionFactory;

public class GeneroDao {
	
	private Connection con=null;
	private String sql="";
	
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
	
	public Boolean incluir(GeneroDto generoDto) throws Exception
	{
		try 
		{
			if(!VerifiqueConexao())
				return false;
			
			sql="INSERT INTO GENERO (NOME) VALUES (?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, generoDto.getNome);
			return (pst.executeUpdate() > 0? true:false);
		} catch (Exception e) 
		{
			throw new Exception("N�o foi poss�vel executar o comando "+e);
		}
	}
	
	public Boolean Alterar(GeneroDto generoDto) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			sql = "UPDATE GENERO SET NOME=?, WHERE CODIGO = ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, generoDto.getNome);
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("N�o foi poss�vel executar o comando " + sql + ". ERRO: " + e);
		}
	}

}
