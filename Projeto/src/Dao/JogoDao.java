package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Dto.JogoDTO;
import connection.ConnectionFactory;

public class JogoDao {
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
	
	public Boolean Incluir(JogoDTO jogoDto) throws Exception
	{
		try
		{
			if(!VerifiqueConexao())
				return false;
			
			int idManual;
			int idGenero;
			
			sql="INSERT INTO JOGO (NOME, DIFICULDADE, CAMINHO, QUANTIDADEJOGADA, IDGENERO, IDMANUAL) VALUES(?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, jogoDto.getNome());
			pst.setInt(2, jogoDto.getDificuldade());
			pst.setString(3, jogoDto.getCaminhoHtml());
			pst.setInt(4, jogoDto.getQuantidadeJogada());
			pst.setInt(5, idGenero);
			pst.setInt(6, idManual);
			return pst.executeUpdate() > 0 ? true:false;
			
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
