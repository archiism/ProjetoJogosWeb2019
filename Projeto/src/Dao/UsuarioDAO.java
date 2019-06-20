package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Dto.UsuarioDto;
import connection.ConnectionFactory;

public class UsuarioDAO {
	
	private Connection con=null;
	private String sql="";
	PreparedStatement pst;
	ResultSet rs;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date d=null;
	
	public Date converte(String datas) {    
		SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
		Date dataRetorno = null;
		String data=datas.replaceAll("-", "/");
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
	
	public UsuarioDto Login(UsuarioDto usuarioDTO) throws Exception
	{
		UsuarioDto dto=null;
		
		try
		{
			if(!VerifiqueConexao())
				return dto;
			
			sql="SELECT * FROM USUARIO WHERE LOGIN=? AND SENHA=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, usuarioDTO.getLogin());
			pst.setString(2, usuarioDTO.getSenha());
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				if(rs.getString("Login").equals(usuarioDTO.getLogin()) && rs.getString("Senha").equals(usuarioDTO.getSenha()))
				{
					dto=new UsuarioDto();
					dto.setLogin(rs.getString("Login"));
					dto.setNome(rs.getString("Nome"));
					dto.setLogin(rs.getString("Login"));
					dto.setCpf(rs.getString("Cpf"));
					dto.setEmail(rs.getString("Email"));
					dto.setIdUsuario(rs.getInt("idUsuario"));
					dto.setNivelAcesso(rs.getInt("nivelAcesso"));
					dto.setDataNascimento(sdf.format(rs.getDate("DATANASCIMENTO")));
					
					return dto;
				}
			}
			
		}catch(Exception e)
		{
			throw new Exception("Erro "+e.getMessage());
		}
		return dto;
		
	}
	
	public Boolean incluir(UsuarioDto usuarioDTO) throws Exception
	{
		try 
		{
			if(!VerifiqueConexao())
				return false;
			
			sql="INSERT INTO USUARIO (nome,senha,login,email,cpf,dataNascimento,nivelAcesso) VALUES (?,?,?,?,?,?,?);";
			pst=con.prepareStatement(sql);
			pst.setString(1, usuarioDTO.getNome());
			pst.setString(2, usuarioDTO.getSenha());
			pst.setString(3, usuarioDTO.getLogin());
			pst.setString(4, usuarioDTO.getEmail());
			pst.setString(5, usuarioDTO.getCpf());
			//d=converte(usuarioDTO.getDataNascimento());
			pst.setString(6, usuarioDTO.getDataNascimento());
			pst.setInt(7, usuarioDTO.getNivelAcesso());
			
			return(pst.executeUpdate() > 0?true:false);
			
		} catch (SQLException e) {
			throw new Exception("Não foi possível executar o comando "+e);
		}
		
	}
	
	public Boolean selecionarUsuario(long indice,UsuarioDto usuarioDTO) throws Exception {

		try {
			if (!VerifiqueConexao())
				return false;

			sql = "SELECT * FROM USUARIO WHERE codigo = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, (int) indice);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				usuarioDTO = new UsuarioDto();
				usuarioDTO.setIdUsuario(rs.getInt("IDUSUARIO"));
				usuarioDTO.setNome(rs.getString("NOME"));
				usuarioDTO.setEmail(rs.getString("EMAIL"));
				usuarioDTO.setCpf(rs.getString("CPF"));
				Date data = rs.getDate("DATANASCIMENTO");
				usuarioDTO.setDataNascimento(sdf.format(data));
				usuarioDTO.setNivelAcesso(rs.getInt("NIVELACESSO"));

			}
			return (pst.executeUpdate() > 0 ? true : false);

		} catch (SQLException e) {
			throw new Exception("Não foi possível executar o comando " + e);
		}

	}
	
	public Boolean atualizar(UsuarioDto usuarioDTO) throws Exception{
		
		try {
			if(!VerifiqueConexao())
			return false;
		
		sql="UPDATE USUARIO SET nome = ?,senha = ?,login = ?,email = ?,cpf = ?,dataNascimento = ?,nivelAcesso = ? WHERE codigo = ?";
		pst=con.prepareStatement(sql);
		pst.setString(1, usuarioDTO.getNome());
		pst.setString(2, usuarioDTO.getSenha());
		pst.setString(3, usuarioDTO.getLogin());
		pst.setString(4, usuarioDTO.getEmail());
		pst.setString(5, usuarioDTO.getCpf());
		//d=converte(usuarioDTO.getDataNascimento());
		pst.setString(6, usuarioDTO.getDataNascimento());
		pst.setInt(7, usuarioDTO.getNivelAcesso());
		pst.setInt(8, usuarioDTO.getIdUsuario());
		
		return(pst.executeUpdate() > 0?true:false);
		
		} catch (SQLException e) {
			throw new Exception("Não foi possível executar o comando "+e);
		}
		
	}
	
	public List<UsuarioDto> Listar() throws Exception
	{
		List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
		UsuarioDto usuarioDto;
		
		try
		{
			if(!VerifiqueConexao())
				return usuarios;
			
			sql="SELECT * FROM USUARIO";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				usuarioDto = new UsuarioDto();
				usuarioDto.setIdUsuario(rs.getInt("IDUSUARIO"));
				usuarioDto.setNome(rs.getString("NOME"));
				usuarioDto.setLogin(rs.getString("LOGIN"));
				usuarioDto.setEmail(rs.getString("EMAIL"));
				usuarioDto.setCpf(rs.getString("CPF"));
				Date data=rs.getDate("DATANASCIMENTO");
				usuarioDto.setDataNascimento(sdf.format(data));
				usuarioDto.setNivelAcesso(rs.getInt("NIVELACESSO"));
				
				usuarios.add(usuarioDto);
			}
			
		}catch (SQLException e) {
			throw new Exception("Não foi possível executar o comando "+e);
		}
		return usuarios;
	}
}
