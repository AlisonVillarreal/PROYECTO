package pe.edu.upeu.proyecto.entity;

public class TipoOrganizacion {
	private int idtipo_organizacion;
	private String nombre;
	public TipoOrganizacion() {
		
	}
	public TipoOrganizacion(int idtipo_organizacion, String nombre) {
		super();
		this.idtipo_organizacion = idtipo_organizacion;
		this.nombre = nombre;
	}
	public int getIdtipo_organizacion() {
		return idtipo_organizacion;
	}
	public void setIdtipo_organizacion(int idtipo_organizacion) {
		this.idtipo_organizacion = idtipo_organizacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}


