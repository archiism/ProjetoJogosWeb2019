package Dto;

import java.io.Serializable;

public class FavoritosDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Boolean favorito;
	
	public FavoritosDto()
	{
		
	}

	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}
	
	

}
