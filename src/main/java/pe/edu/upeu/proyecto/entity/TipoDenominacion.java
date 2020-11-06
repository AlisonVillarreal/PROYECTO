package pe.edu.upeu.proyecto.entity;

public class TipoDenominacion {
	private int idtipo_denominacion;
	private String nombre;
	public TipoDenominacion() {
		
	}
	public int getIdtipo_denominacion() {
		return idtipo_denominacion;
	}
	public void setIdtipo_denominacion(int idtipo_denominacion) {
		this.idtipo_denominacion = idtipo_denominacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoDenominacion(int idtipo_denominacion, String nombre) {
		super();
		this.idtipo_denominacion = idtipo_denominacion;
		this.nombre = nombre;
	}
	

}