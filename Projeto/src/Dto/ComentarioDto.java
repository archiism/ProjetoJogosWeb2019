package Dto;

public class ComentarioDto {
	private int idComentario;
	private String comentario;
	private int idJogo;
	private int idUsuario;
	private String data;
	private JogoDto jogoDto;
	private UsuarioDto usuarioDto;
	
	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}
	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}
	public JogoDto getJogoDto() {
		return jogoDto;
	}
	public void setJogoDto(JogoDto jogoDto) {
		this.jogoDto = jogoDto;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getIdJogo() {
		return idJogo;
	}
	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
	
	
	
}
