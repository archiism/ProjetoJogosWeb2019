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
			
			
			
			sql="INSERT INTO JOGO (NOME, DIFICULDADE, CAMINHO, QUANTIDADEJOGADA, IDGENERO, IDMANUAL) VALUES(?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, jogoDto.getNome());
			pst.setString(2, jogoDto.getDificuldade());
			pst.setString(3, jogoDto.getCaminhoHtml());
			pst.setInt(4, jogoDto.getQuantidadeJogada());
			pst.setInt(5, jogoDto.getIdGenero());
			pst.setInt(6, jogoDto.getIdManual());
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
				jogoDto.setCaminhoHtml(rs.getString("CAMINHOHTML"));
				jogoDto.setCategoria(rs.getString("CATEGORIA"));
				jogoDto.setClassificacao(rs.getString("CLASSIFICACAO"));
				jogoDto.setDescricao(rs.getString("DESCRICAO"));
				jogoDto.setDificuldade(rs.getString("DIFICULDADE"));
				jogoDto.setIdJogo(rs.getInt("IDJOGO"));
				jogoDto.setNome(rs.getString("NOME"));
				jogoDto.setQuantidadeJogada(rs.getInt("QUANTIDADEJOGADA"));
				
				jogos.add(jogoDto);
			}
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return jogos;
	}

}
