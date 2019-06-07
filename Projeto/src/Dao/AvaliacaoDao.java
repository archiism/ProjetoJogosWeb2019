package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionFactory;

public class AvaliacaoDao {
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
	
	public Boolean Incluir(AvaliacaoDto avaliacaoDto) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			int idUsuario;
			int idJogo;
			
			sql="INSERT INTO AVALIACAO(NOTA, idUsuario, idJogo) VALUES(?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, avaliacaoDto.getNota());
			pst.setInt(2, idUsuario);
			pst.setInt(3, idJogo);
			return pst.executeUpdate() > 0 ? true:false;
		}catch(Exception e)
		{
			throw new Exception("Não foi possível executar o comando "+e);
		}
	}

}
