package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import Dto.NoticiaDto;
import connection.ConnectionFactory;

public class NoticiaDao {
	
	private Connection con=null;
	private String sql="";
	

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
	
	public Boolean incluir(NoticiaDto noticiaDto) throws Exception
	{
		try 
		{
			if(!VerifiqueConexao())
				return false;
			
			sql="INSERT INTO NOTICIA (ASSUNTO, TEXTO, DATAPUBLICACAO) VALUES (?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, noticiaDto.getAssunto());
			pst.setString(2, noticiaDto.getTexto());
			pst.setDate(3,this.converte(noticiaDto.getData()));
			
			return (pst.executeUpdate() > 0? true:false);
		} catch (Exception e) 
		{
			throw new Exception("N�o foi poss�vel executar o comando "+e);
		}
	}
	
	public Boolean excluir(int codigo) throws Exception
	{
		try 
		{
			if(!VerifiqueConexao())
				return false;
			
			sql="DELETE FROM NOTICIA WHERE idNoticia=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, codigo);
			
			return pst.executeUpdate() > 0?true:false;
		} catch (Exception e) 
		{
			throw new Exception("N�o foi poss�vel executar o comando " + sql + ". ERRO: " + e);
		}
	}
	
	public Boolean Alterar(NoticiaDto noticiaDto) throws Exception {
		try
		{
			if(!VerifiqueConexao())
				return false;

			sql = "UPDATE NOTICIA SET ASSUNTO=?,TEXTO=?, DATAPUBLICACAO=? WHERE CODIGO = ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, noticiaDto.getAssunto());
			pst.setString(2, noticiaDto.getTexto());
			pst.setDate(3,this.converte(noticiaDto.getData()));
			pst.setInt(4, noticiaDto.getIdNoticia());
			
			return (pst.executeUpdate() > 0 ? true : false);

		}
		catch (SQLException e)
		{
			throw new Exception("N�o foi poss�vel executar o comando " + sql + ". ERRO: " + e);
		}
	}
}
