package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionFactory;

public class ManualDto {
	
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
	
	public Boolean incluir(ManualDto manualDto) throws Exception
	{
		try 
		{
			if(!VerifiqueConexao())
				return false;
			
			sql="INSERT INTO MANUAL (NOME) VALUES (?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, generoDto.getNome);
			return (pst.executeUpdate() > 0? true:false);
		} catch (Exception e) 
		{
			throw new Exception("N�o foi poss�vel executar o comando "+e);
		}
	}
}
