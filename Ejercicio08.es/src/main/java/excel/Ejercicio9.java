package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilidades.*;


/**
 * Modificar el ejercicio creando al menos dos metodos:
 * 	buscarCiudad, le pasaremos el nombre de una ciudad y nos mostrará los ptos de recarga (ubicacion)
 * 	buscarMarca, nos mostrará los puntos de recarga de una marca, pasamos como parametro la marca
 * Añadir una nueva hoja al documento excel y cada vez que se busque una nueva ciudad, añadir las estaciones
 * La pagina se llamara como la ciudad
 */
public class Ejercicio9 {
	public static final String DOCTRABAJO_IN = "vehiculosElectricos.xlsx";
	public static  Workbook wb=null;
	public static Sheet hoja=null;
	public static int numFila;
	public static Row fila;
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			//Ahro el documento excel con extension xls. Si quisiera abrir un doc xlsx, se usa XSSFWb
			 wb = new XSSFWorkbook(new FileInputStream(Utilidades.RUTA + DOCTRABAJO_IN));
			//Tomo la primera hoja
			 hoja=wb.getSheetAt(0);
			 numFila=1;
			//Tomamos la fila 1, ya que la 0 es la cabecera
			 fila = hoja.getRow(numFila);
			//Muestro las localizaciones de los puntos de carga de la marca que se introduzca
			mostrarMarca();
			//Devolvemos la fila a la posicion original
			numFila=1;
			fila = hoja.getRow(numFila);
			//Muestro las localizaciones de los puntos de carga de la ciudad que se introduzca
			mostrarCiudad();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mostrarMarca() {
		System.out.println("¿Que marca quieres buscar?: ");
		String marca= in.nextLine();
		while(fila!=null) {
			Cell celdaBusqueda = fila.getCell(2);
			if(celdaBusqueda!=null) {
				if(celdaBusqueda.getStringCellValue().contains(marca)) {
					System.out.println("Nombre: " + fila.getCell(0).getStringCellValue());
				}
			}
			numFila++;
			fila = hoja.getRow(numFila);
		}
		
	}
	public static void mostrarCiudad() {
		System.out.println("¿Qué ciudad quieres buscar?: ");
		String ciudad = in.nextLine();
		Sheet nuevaHoja = wb.createSheet(ciudad);
		int numFilaNueva= 1;
		Row nuevaFila= nuevaHoja.createRow(numFilaNueva);
		nuevaFila.createCell(0);
		nuevaFila.createCell(1);
		while(fila!=null) {
			Cell celdaBusqueda = fila.getCell(1);
			if(celdaBusqueda!=null) {
				if(celdaBusqueda.getStringCellValue().contains(ciudad)) {
					System.out.println("Nombre: " + fila.getCell(0).getStringCellValue());
					nuevaFila= nuevaHoja.createRow(numFilaNueva);
					Cell nuevoNombre = nuevaFila.createCell(0);
					Cell nuevaLoc = nuevaFila.createCell(1);
					nuevoNombre.setCellValue(fila.getCell(0).getStringCellValue());
					nuevaLoc.setCellValue(fila.getCell(1).getStringCellValue());
					numFilaNueva++;
				}
			}
			numFila++;
			fila = hoja.getRow(numFila);
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(Utilidades.RUTA + DOCTRABAJO_IN);
	        wb.write(outputStream);
	        wb.close();
	        outputStream.close();
		} catch(Exception e) {
			
		}
		
		
		
	}

}
