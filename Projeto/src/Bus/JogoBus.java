package Bus;

import java.util.List;

import Dao.JogoDao;
import Dto.JogoDto;

public class JogoBus {
	private JogoDao jogoDao = new JogoDao();
	public Boolean Incluir(JogoDto jogoDto) throws Exception
	{
		try
		{
			return jogoDao.Incluir(jogoDto);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public List<JogoDto> ListaJogos() throws Exception
	{
		List<JogoDto> jogos=null;
		try
		{
			jogos=jogoDao.Listar();
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return jogos;
	}
	
	public List<JogoDto> ListaJogosCategoria(String categoria) throws Exception
	{
		List<JogoDto> jogos=null;
		try
		{
			jogos=jogoDao.ListarCategoria(categoria);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return jogos;
	}
	
	public JogoDto RetornarRegistro(int cod) throws Exception
	{
		try
		{
			return jogoDao.RetornarRegistro(cod);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
