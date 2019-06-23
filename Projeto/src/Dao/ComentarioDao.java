package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Dto.ComentarioDto;
import Dto.JogoDto;
import Dto.UsuarioDto;
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
			pst.setInt(3, comentarioDto.getIdJogo());
			pst.setInt(4, comentarioDto.getIdUsuario());
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
		JogoDto jogoDto = new JogoDto();
		JogoDao jogoDao = new JogoDao();
		UsuarioDto usuarioDto = new UsuarioDto();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		int codJogo;
		int codUsuario;
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
				comentarioDto.setIdComentario(rs.getInt("IDCOMENTARIOS"));
				Date data=rs.getDate("DATA");
				comentarioDto.setData(sdf.format(data));
				comentarioDto.setIdJogo(rs.getInt("IDJOGO"));
				
				codJogo=rs.getInt("IDJOGO");
				codUsuario=rs.getInt("IDUSUARIO");
				
				jogoDto=jogoDao.RetornarRegistro(codJogo);
				usuarioDto=usuarioDao.RetornarRegistro(codUsuario);
				
				comentarioDto.setJogoDto(jogoDto);
				comentarioDto.setUsuarioDto(usuarioDto);
				
				comentarios.add(comentarioDto);
			}
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return comentarios;
	}

}
