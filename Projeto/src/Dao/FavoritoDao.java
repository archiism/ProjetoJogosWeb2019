package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dto.FavoritosDto;
import Dto.JogoDto;
import connection.ConnectionFactory;

public class FavoritoDao {
	private Connection con=null;
	private String sql="";
	private PreparedStatement pst;
	private ResultSet rs;
	
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
	
	public Boolean Incluir(FavoritosDto favoritosDto) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			int idJogo;
			int idUsuario;
			
			sql="INSERT INTO FAVORITOS(IDJOGO, IDUSUARIO, FAVORITO) VALUES(?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, favoritosDto.getIdJogo());
			pst.setInt(2, favoritosDto.getIdUsuario());
			pst.setBoolean(3, favoritosDto.getFavorito());
			return pst.executeUpdate()> 0 ? true:false;
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public Boolean Alterar(Boolean cod) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			
			sql="UPDATE FAVORITOS SET FAVORITO=?";
			pst=con.prepareStatement(sql);
			pst.setBoolean(1, cod);
			return pst.executeUpdate() > 0 ? true:false;
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public List<JogoDto> Listar(int cod) throws Exception
	{
		List<JogoDto> favoritos = new ArrayList<JogoDto>();
		JogoDto jogoDto=null;
		try
		{
			if(!VerifiqueConexao())
				return favoritos;
			
			sql="SELECT JOGO.NOME, JOGO.DIFICULDADE, JOGO.MANUAL, JOGO.CAMINHOHTML"+
			" FROM JOGO, FAVORITOS, USUARIO WHERE JOGO.IDJOGO=FAVORITOS.IDJOGO"+
			" AND FAVORITOS.IDUSUARIO=USUARIO.IDUSUARIO AND IDUSUARIO=? AND FAVORITOS=TRUE";
			
			pst=con.prepareStatement(sql);
			pst.setInt(1, cod);
			rs = pst.executeQuery();
			
			
			
			while(rs.next())
			{
				jogoDto = new JogoDto();
				jogoDto.setCaminhoHtml(rs.getString("CAMINHOHTML"));
				jogoDto.setIdJogo(rs.getInt("IDJOGO"));
				jogoDto.setManual(rs.getString("MANUAL"));
				jogoDto.setNome(rs.getString("NOME"));
				jogoDto.setDificuldade(rs.getString("DIFICULDADE"));
				favoritos.add(jogoDto);
			}
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return favoritos;
	}

}
