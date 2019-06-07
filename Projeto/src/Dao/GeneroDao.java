package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dto.GeneroDto;
import connection.ConnectionFactory;

public class GeneroDao {
	
	private Connection con=null;
	private String sql="";
	private PreparedStatement pst;
	
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
			pst=con.prepareStatement(sql);
			pst.setString(1, generoDto.getNome);
			return (pst.executeUpdate() > 0? true:false);
		} catch (Exception e) 
		{
			throw new Exception("Não foi possível executar o comando "+e);
		}
	}
	
	public Boolean Alterar(GeneroDto generoDto) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			sql = "UPDATE GENERO SET NOME=?, WHERE CODIGO = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1, generoDto.getNome);
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + sql + ". ERRO: " + e);
		}
	}
	public Boolean Excluir(int cod) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			sql="DELETE FROM GENERO WHERE ID=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, cod);
			return pst.executeUpdate()>0?true:false;
		}catch(SQLException e)
		{
			throw new Exception("Não foi possível executar o comando " + sql + ". ERRO: " + e);
		}
	}

}
