package Dto;

import java.io.Serializable;

public class FavoritosDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idFavoritos;
	private Boolean favorito;
	private int idJogo;
	private int idUsuario;
	
	public FavoritosDto()
	{
		
	}

	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

	public int getIdFavoritos() {
		return idFavoritos;
	}

	public void setIdFavoritos(int idFavoritos) {
		this.idFavoritos = idFavoritos;
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
