package jaxb.clasesEjercicio16;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "enunciado", "listaRespuesta" })
public class Pregunta {
	private String autoria;
	private String dificultad;
	private String enunciado;
	private ArrayList<Respuesta> listaRespuesta;

	public Pregunta() {

	}

	public Pregunta(String autoria, String dificultad, String enunciado, ArrayList<Respuesta> listaRespuesta) {
		super();
		this.autoria = autoria;
		this.dificultad = dificultad;
		this.enunciado = enunciado;
		this.listaRespuesta = listaRespuesta;
	}

	@XmlAttribute()
	public String getAutoria() {
		return autoria;
	}

	public void setAutoria(String autoria) {
		this.autoria = autoria;
	}

	@XmlAttribute()
	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	@XmlElement(name="respuesta")
	public ArrayList<Respuesta> getListaRespuesta() {
		return listaRespuesta;
	}

	public void setListaRespuesta(ArrayList<Respuesta> listaRespuesta) {
		this.listaRespuesta = listaRespuesta;
	}

}
