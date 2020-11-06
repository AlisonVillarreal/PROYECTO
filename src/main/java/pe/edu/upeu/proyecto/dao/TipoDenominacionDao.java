package pe.edu.upeu.proyecto.dao;

import java.util.Map;

import pe.edu.upeu.proyecto.entity.TipoDenominacion;

public interface TipoDenominacionDao {
	int create(TipoDenominacion d);
	int update(TipoDenominacion d);
	int delete(int id);
	Map<String, Object> read(int id);
	Map<String, Object> readAll();
	}

