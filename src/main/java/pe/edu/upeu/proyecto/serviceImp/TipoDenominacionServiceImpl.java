package pe.edu.upeu.proyecto.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.proyecto.dao.TipoDenominacionDao;
import pe.edu.upeu.proyecto.entity.TipoDenominacion;
import pe.edu.upeu.proyecto.service.TipoDenominacionService;
@Service
public class TipoDenominacionServiceImpl implements TipoDenominacionService {
@Autowired
	private TipoDenominacionDao tipodenominacioDao;

	@Override
	public int create(TipoDenominacion d) {
		// TODO Auto-generated method stub
		return tipodenominacioDao.create(d);
	}

	@Override
	public int update(TipoDenominacion d) {
		// TODO Auto-generated method stub
		return tipodenominacioDao.update(d);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return tipodenominacioDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return tipodenominacioDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return tipodenominacioDao.readAll();
	}

}
