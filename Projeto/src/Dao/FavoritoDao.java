package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import Dto.FavoritosDto;
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
	
	public List<FavoritosDto> Listar() throws Exception
	{
		List<FavoritosDto> favoritos = new ArrayList<FavoritosDto>();
		FavoritosDto favoritosDto=null;
		try
		{
			if(!VerifiqueConexao())
				return favoritos;
			
			sql="SELECT JOGO.NOME, JOGO.DIFICULDADE, JOGO.MANUAL, JOGO.CAMINHOHTML FROM JOGO, FAVORITOS, USUARIO WHERE JOGO.IDJOGO=FAVORITOS.IDJOGO AND FAVORITOS.IDUSUARIO=USUARIO.IDUSUARIO";
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
