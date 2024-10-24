package xstream;

import java.util.ArrayList;

import ficheros.ejercicio6.Persona;

public class ListaPersonas {
	private ArrayList<Persona> lista = new ArrayList<Persona>();

	public ListaPersonas(ArrayList<Persona> lista) {
		super();
		this.lista = lista;
	}
	
	public ListaPersonas() {
		
	}

	public ArrayList<Persona> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Persona> lista) {
		this.lista = lista;
	}
	
	public void anadir(Persona person) {
		this.lista.add(person);
	}

}
