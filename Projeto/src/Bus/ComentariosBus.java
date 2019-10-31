package Bus;

import java.util.List;
//teste
import Dao.ComentarioDao;
import Dto.ComentarioDto;
import Dto.JogoDto;

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
