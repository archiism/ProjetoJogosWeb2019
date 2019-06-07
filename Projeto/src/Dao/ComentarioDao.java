package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionFactory;

public class ComentarioDao {
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
	
	public Boolean Incluir(ComentarioDto comentarioDto) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			int idUsuario;
			int idJogo;
			
			sql="INSERT INTO COMENTARIO(DATA, COMENTARIO, IDUSUARIO, IDJOGO) VALUES(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setDate(1, comentarioDto.getData());
			pst.setString(2, comentarioDto.getComentario());
			pst.setInt(3, idUsuario);
			pst.setInt(4, idJogo);
			return pst.executeUpdate() > 0?true:false;
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
