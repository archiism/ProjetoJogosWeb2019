package Bus;

import java.util.List;

import Dao.NoticiaDao;
import Dto.NoticiaDto;

public class NoticiaBus {
	private NoticiaDao noticiaDao = new NoticiaDao();
	
	public Boolean Incluir(NoticiaDto noticiaDto) throws Exception
	{
		try
		{
			return noticiaDao.incluir(noticiaDto);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	public NoticiaDto Listar() throws Exception
	{
		NoticiaDto noticias = null;
		try
		{
			 noticias=noticiaDao.Listar();
			 
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return noticias;
	}
	
	public Boolean Alterar(NoticiaDto noticiaDto) throws Exception
	{
		
		try
		{
			return noticiaDao.Alterar(noticiaDto);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
