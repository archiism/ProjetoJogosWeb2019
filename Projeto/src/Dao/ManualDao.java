package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Dto.ManualDto;
import connection.ConnectionFactory;

public class ManualDao {
	
	private Connection con=null;
	private String sql="";
	PreparedStatement pst;

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
			
			sql="INSERT INTO MANUAL (controle, objetivo) VALUES (?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, manualDto.getControle());
			pst.setString(2,manualDto.getObjetivo());
			
			return (pst.executeUpdate() > 0? true:false);
		} catch (Exception e) 
		{
			throw new Exception("Não foi possível executar o comando "+e);
		}
	}
}
