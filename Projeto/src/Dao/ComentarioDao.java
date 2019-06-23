package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Dto.ComentarioDto;
import connection.ConnectionFactory;

public class ComentarioDao {
	private Connection con=null;
	private String sql="";
	private PreparedStatement pst;
	private ResultSet rs;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
			
			
			sql="INSERT INTO COMENTARIOS(DATA, COMENTARIO, IDUSUARIO, IDJOGO) VALUES(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, comentarioDto.getData());
			pst.setString(2, comentarioDto.getComentario());
			pst.setInt(3, comentarioDto.getIdUsuario());
			pst.setInt(4, comentarioDto.getIdJogo());
			return pst.executeUpdate() > 0?true:false;
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	public List<ComentarioDto> Lista(int cod) throws Exception
	{
		List<ComentarioDto> comentarios = new ArrayList<ComentarioDto>();
		ComentarioDto comentarioDto=null;
		try
		{
			if(!VerifiqueConexao())
				return comentarios;
			sql="SELECT comentarios.COMENTARIO, comentarios.DATA, usuario.NOME FROM COMENTARIOS "
					+ "INNER JOIN USUARIO ON COMENTARIOS.IDUSUARIO=USUARIO.IDUSUARIO "
					+ "INNER JOIN JOGO ON COMENTARIOS.IDJOGO=JOGO.IDJOGO WHERE COMENTARIOS.IDJOGO=?";
			
			pst=con.prepareStatement(sql);
			pst.setInt(1, cod);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				comentarioDto = new ComentarioDto();
				comentarioDto.setComentario(rs.getString("COMENTARIO"));
				comentarioDto.setIdUsuario(rs.getInt("IDUSUARIO"));
				comentarioDto.setIdJogo(rs.getInt("IDJOGO"));
				comentarioDto.setIdComentario(rs.getInt("IDCOMENTARIOS"));
				Date data=rs.getDate("DATA");
				comentarioDto.setData(sdf.format(data));
				
				comentarios.add(comentarioDto);
			}
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return comentarios;
	}

}
