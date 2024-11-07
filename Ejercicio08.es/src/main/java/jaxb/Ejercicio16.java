package jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jaxb.clasesEjercicio16.Autor;
import jaxb.clasesEjercicio16.Examen;

public class Ejercicio16 {
	private static JAXBContext jC;
	private static Examen examen;
	private static ArrayList<Autor> autores;

	public static void main(String[] args) {
		unmarshalling();
		menu();
		marshalling();

	}

	public static void menu() {
		Scanner in = new Scanner(System.in);
		boolean salir = false;
		int opcion = 0;
		while (!salir) {
			System.out.println("1. Leer autores\n2. Añadir autor\n3. Modificar autor\n4. Eliminar autor\n5. Salir");
			opcion = in.nextInt();
			in.nextLine();
			switch (opcion) {
			case 1:
				System.out.println("Leyendo autores");
				leerAutores();
				break;
			case 2:
				System.out.println("Añadiendo autores");
				añadirAutor(pedirDatosAutor());
				break;
			case 3:
				System.out.println("Modificando autores");
				System.out.println("Id del autor a modificar: ");
				String idAutor = in.nextLine();
				System.out.println("Nueva entidad de trabajo: ");
				String newEt = in.nextLine();
				System.out.println("Nuevo puesto: ");
				String newP = in.nextLine();
				System.out.println(modificarAutor(idAutor, newEt, newP) ? "Autor añadido" : "Autor no añadido");
				break;
			case 4:
				System.out.println("Eliminando autores");
				System.out.println("Id del autour a eliminar: ");
				idAutor= in.nextLine();
				System.out.println(eliminarAutor(idAutor) ? "Autor eliminado" : "Autor no eliminado");
				break;
			case 5:
				System.out.println("Saliendo del programa");
				salir = true;
				break;
			default:
				System.out.println("Solo numeros entre 1 y 5");
			}
		}

	}

	private static boolean eliminarAutor(String idAutor) {
		if(autores.remove(localizarAutor(idAutor))) {
			return true;
		} else {	
			return false;
		}	
		
	}

	private static boolean modificarAutor(String idAutor, String newEt, String newP) {
		Autor autor = localizarAutor(idAutor);
		if (autor != null) {
			autor.setEntidadTrabajo(newEt);
			autor.setPuesto(newP);
			return true;
		} else {
			return false;
		}

	}

	private static Autor localizarAutor(String idAutor) {
		Iterator<Autor> it = autores.iterator();
		Autor encontrado = new Autor();
		while (it.hasNext()) {
			encontrado = it.next();
			if (encontrado.getId().equals(idAutor)) {
				return encontrado;
			}
		}
		return encontrado;
	}

	private static boolean añadirAutor(Autor pedirDatosAutor) {
		if (autores.add(pedirDatosAutor)) {
			return true;
		} else
			return false;

	}

	private static Autor pedirDatosAutor() {
		Scanner in = new Scanner(System.in);
		Autor autor = new Autor();
		System.out.println("Introduce el nombre: ");
		autor.setNombre(in.nextLine());
		System.out.println("Introduce el apellido 1: ");
		autor.setApellido1(in.nextLine());
		System.out.println("Introduce el apellido 2: ");
		autor.setApellido2(in.nextLine());
		System.out.println("Introduce el ID: ");
		autor.setId(in.nextLine());
		System.out.println("Introduce el puesto: ");
		autor.setPuesto(in.nextLine());
		System.out.println("Introduce la entidad: ");
		autor.setEntidadTrabajo(in.nextLine());
		return autor;
	}

	private static void leerAutores() {
		Iterator<Autor> it = autores.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}

	public static void unmarshalling() {
		try {
			jC = JAXBContext.newInstance(Examen.class);
			Unmarshaller uM = jC.createUnmarshaller();
			examen = (Examen) uM.unmarshal(new File("Ejercicio16.xml"));
			autores = examen.getListaAutor();
			// Hacer marshall para hacerlo persistente
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void marshalling() {
		try {
			Marshaller m = jC.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(examen, new File("Ejercicio16.xml"));
			// Hacer marshall para hacerlo persistente
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}