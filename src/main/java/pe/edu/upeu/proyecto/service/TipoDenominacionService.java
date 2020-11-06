package pe.edu.upeu.proyecto.service;

import java.util.Map;


import pe.edu.upeu.proyecto.entity.TipoDenominacion;

public interface TipoDenominacionService {
	int create (TipoDenominacion d);
	int update (TipoDenominacion d);
	int delete (int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
}


