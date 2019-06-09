package Dto;

import java.io.Serializable;

public class JogoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idJogo;
	private String nome;
	private String categoria;
	private String descricao;
	private String classificacao;
	private String dificuldade;
	private String caminhoHtml;
	private int quantidadeJogada;
	private String Genero;
	private String Manual;
	
	public JogoDto()
	{
		
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
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

	public int getQuantidadeJogada() {
		return quantidadeJogada;
	}

	public void setQuantidadeJogada(int quantidadeJogada) {
		this.quantidadeJogada = quantidadeJogada;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String Genero) {
		this.Genero = Genero;
	}

	public String getManual() {
		return Manual;
	}

	public void setManual(String Manual) {
		this.Manual = Manual;
	}
	
	
}
