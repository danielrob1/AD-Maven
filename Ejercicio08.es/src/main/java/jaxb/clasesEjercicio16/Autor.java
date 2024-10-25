package jaxb.clasesEjercicio16;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"nombre", "apellido1", "apellido2", "puesto", "entidadTrabajo"})
public class Autor {
	private String id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String puesto;
	private String entidadTrabajo;

	public Autor() {
	}

	public Autor(String id, String nombre, String apellido1, String apellido2, String puesto, String entidadTrabajo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.puesto = puesto;
		this.entidadTrabajo = entidadTrabajo;
	}
	@XmlAttribute()
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEntidadTrabajo() {
		return entidadTrabajo;
	}

	public void setEntidadTrabajo(String entidadTrabajo) {
		this.entidadTrabajo = entidadTrabajo;
	}

}
