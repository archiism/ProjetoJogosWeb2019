package Bus;

import java.util.List;

import Dao.ComentarioDao;
import Dto.ComentarioDto;

public class ComentariosBus {
	ComentarioDao comentarioDao= new ComentarioDao();
	
	public Boolean Incluir(ComentarioDto comentarioDto)throws Exception
	{
		try
		{
			return comentarioDao.Incluir(comentarioDto);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	public List<ComentarioDto> Listar(int cod) throws Exception
	{
		List<ComentarioDto> comentarios=null;
		try
		{
			comentarios=comentarioDao.Lista(cod);
		}catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return comentarios;
	}

}
