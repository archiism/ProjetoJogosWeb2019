package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import Dto.ComentarioDto;
import connection.ConnectionFactory;

public class ComentarioDao {
	private Connection con=null;
	private String sql="";
	PreparedStatement pst;
	
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
	
	public Boolean Incluir(ComentarioDto comentarioDto) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			
			sql="INSERT INTO COMENTARIO(DATA, COMENTARIO, IDUSUARIO, IDJOGO) VALUES(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setDate(1, this.converte(comentarioDto.getData()));
			pst.setString(2, comentarioDto.getComentario());
			pst.setInt(3, comentarioDto.getIdUsuario());
			pst.setInt(4, comentarioDto.getIdJogo());
			return pst.executeUpdate() > 0?true:false;
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
