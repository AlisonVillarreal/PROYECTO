package pe.edu.upeu.proyecto.dao;

import java.util.Map;

import pe.edu.upeu.proyecto.entity.TipoOrganizacion;

public interface TipoOrganizacionDao {
	int create(TipoOrganizacion o);
	int update(TipoOrganizacion o);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}


