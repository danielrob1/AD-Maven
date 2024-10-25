package jaxb;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jaxb.clasesEjercicio16.Examen;

public class Ejercicio16{
	private static JAXBContext jC;
	private static Examen examen;
	
	public static void main(String[] args) {
		
	}
	
	public static void unmarshalling() {
		try {
			jC = JAXBContext.newInstance(Examen.class);
			Unmarshaller uM= jC.createUnmarshaller();
			examen = (Examen) uM.unmarshal(new File("Ejercicio16.xml"));
			//Hacer marshall para hacerlo persistente
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}