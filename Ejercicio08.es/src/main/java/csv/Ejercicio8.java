package csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import utilidades.*;

import com.opencsv.CSVReader;

public class Ejercicio8 {
	public static final String DOCTRABAJO_IN = "Ejercicio08.csv";

	public static void main(String[] args) {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(Utilidades.RUTA + DOCTRABAJO_IN), ',', '"');
			String[] linea;
			while((linea=reader.readNext())!=null) {
				for (int i = 0; i < linea.length; i++) {
					System.out.print(linea[i] + "\t");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
