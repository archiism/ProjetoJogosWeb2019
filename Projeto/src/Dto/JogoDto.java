package Dto;

import java.io.Serializable;

public class JogoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idJogo;
	private String nome;
	private String dificuldade;
	private String caminhoHtml;
	private String Genero;
	private String imagem;
	
	public JogoDto()
	{
		
	}
	public JogoDto(int cod)
	{
		this.idJogo=cod;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public String getCaminhoHtml() {
		return caminhoHtml;
	}

	public void setCaminhoHtml(String caminhoHtml) {
		this.caminhoHtml = caminhoHtml;
	}


	public String getGenero() {
		return Genero;
	}

	public void setGenero(String Genero) {
		this.Genero = Genero;
	}

	
	
}
