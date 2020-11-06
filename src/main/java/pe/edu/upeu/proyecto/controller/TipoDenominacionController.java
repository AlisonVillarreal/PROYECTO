package pe.edu.upeu.proyecto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.proyecto.entity.TipoDenominacion;
import pe.edu.upeu.proyecto.service.TipoDenominacionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipodenominacion")
public class TipoDenominacionController {

	@Autowired
	private TipoDenominacionService tipodenominacionService;
	
	@GetMapping("/all")
	/*public Map<String, Object> realAll() {
		return personaService.readAll();
	}*/
	public Map<String, Object> get(){
		return tipodenominacionService.readAll();
	}
	
	@GetMapping("/{id}")
	public Map<String, Object> read(@PathVariable int id) {
		return tipodenominacionService.read(id);
	}
	@PostMapping("/add")
	//este metodo permite registrar una competencia
	public int create(@RequestBody TipoDenominacion c) {
		return tipodenominacionService.create(c);		
	}
	@DeleteMapping("/delete/{id}")
	//este metodo permite eliminar una competencia
	public int delete(@PathVariable int id) {
		return tipodenominacionService.delete(id);
	}	
	
	@PutMapping("/edit/{id}")
	//este metodo permite modificar una competencia
    public int update(@RequestBody TipoDenominacion c,@PathVariable int id) {
		c.setIdtipo_denominacion(id);
		
	return tipodenominacionService.update(c);
	}	
	
}
