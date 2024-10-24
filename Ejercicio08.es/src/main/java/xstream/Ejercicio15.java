package xstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import ficheros.ejercicio6.Persona;

import java.io.EOFException;
import java.io.File;

public class Ejercicio15 {
	private static ObjectInputStream oIS=null;
	private static XStream xS=null;
	private static ListaPersonas lp=null;

	public static void main(String[] args) {
		try {
			oIS = new ObjectInputStream(new FileInputStream(new File("FicheroPersonasSerializado.dat")));
			xS = new XStream(new DomDriver("UTF-8"));
			 lp= new ListaPersonas();
			while(true) {
				Persona person = (Persona) oIS.readObject();
				lp.anadir(person);
			}
		}catch (EOFException e) {
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				xS.alias("familia", ListaPersonas.class);
				xS.alias("miembro", Persona.class);
				xS.addImplicitCollection(ListaPersonas.class,"lista");
				xS.aliasField("primerApellido", Persona.class, "apellido1");
				xS.aliasField("segundoApellido", Persona.class, "apellido2");
				xS.useAttributeFor(Persona.class, "nombre");
				xS.toXML(lp, new FileOutputStream(new File("Ejercicio15.xml")));
				oIS.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
