package Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dto.JogoDto;
import connection.ConnectionFactory;

public class JogoDao {
	private Connection con=null;
	private String sql="";
	private PreparedStatement pst;
	private ResultSet rs;
	
	private GeneroDao generoDao=new GeneroDao();
	
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
	
	public Boolean Incluir(JogoDto jogoDto) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			//int codGenero=generoDao.incluir(jogoDto);
			
			sql="INSERT INTO JOGO (NOME, DIFICULDADE, CAMINHO, GENERO,IMAGEM) VALUES(?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, jogoDto.getNome());
			pst.setString(2, jogoDto.getDificuldade());
			pst.setString(3, jogoDto.getCaminhoHtml());
			pst.setString(4, jogoDto.getGenero());
			pst.setString(5, jogoDto.getImagem());
			return pst.executeUpdate() > 0 ? true:false;
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public List<JogoDto> Listar() throws Exception
	{
		List<JogoDto> jogos = new ArrayList<JogoDto>();
		JogoDto jogoDto;
		try
		{
			if(!VerifiqueConexao())
				return jogos;
			
			sql="SELECT * FROM JOGO";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				jogoDto=new JogoDto();
				jogoDto.setCaminhoHtml(rs.getString("CAMINHO"));
				jogoDto.setDificuldade(rs.getString("DIFICULDADE"));
				jogoDto.setIdJogo(rs.getInt("IDJOGO"));
				jogoDto.setNome(rs.getString("NOME"));
				jogoDto.setGenero(rs.getString("GENERO"));
				jogoDto.setImagem(rs.getString("IMAGEM"));
				
				jogos.add(jogoDto);
			}
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return jogos;
	}
	
	public List<JogoDto> ListarCategoria(String categoria) throws Exception
	{
		List<JogoDto> jogos = new ArrayList<JogoDto>();
		JogoDto jogoDto;
		try
		{
			if(!VerifiqueConexao())
				return jogos;
			
			sql="SELECT * FROM JOGO where categoria=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, categoria);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				jogoDto=new JogoDto();
				jogoDto.setCaminhoHtml(rs.getString("CAMINHO"));
				jogoDto.setDificuldade(rs.getString("DIFICULDADE"));
				jogoDto.setIdJogo(rs.getInt("IDJOGO"));
				jogoDto.setNome(rs.getString("NOME"));
				jogoDto.setGenero(rs.getString("GENERO"));
				
				jogos.add(jogoDto);
			}
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return jogos;
	}

}
