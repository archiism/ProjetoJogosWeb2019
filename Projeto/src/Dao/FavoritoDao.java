package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionFactory;

public class FavoritoDao {
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
	
	public Boolean Incluir(Boolean fav) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			int idJogo;
			int idUsuario;
			
			sql="INSERT INTO FAVORITOS(IDJOGO, IDUSUARIO, FAVORITO) VALUES(?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, idJogo);
			pst.setInt(2, idUsuario);
			pst.setBoolean(3, fav);
			return pst.executeUpdate()> 0 ? true:false;
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
