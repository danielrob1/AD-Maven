package dbRelacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilidades.Utilidades;

public class Ejercicio17 {
	private static String DB= "dbEmpresaSQLITE.dat";
	private static Connection con;
	public Ejercicio17() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		establecerConexionSQLite();
		//borrarTablaDepartamentos();
		//establecerConexionMySQL();
		//listarDptos();
		anadirDpto();
		//borrarDpto("Tortured Poets");
		listarDptos();
		cerrarConexion();

	}

	private static void anadirDpto() {
		String sentenciaSql = "INSERT INTO departamentos (dnombre, loc) VALUES (?,?)";
		PreparedStatement sentencia = null;
		try {
			sentencia = con.prepareStatement(sentenciaSql);
			sentencia.setString(1, "Tortured Poets");
			sentencia.setString(2, "Florida!!!");
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void borrarDpto(String dnombre) {
		String sentenciaSql = "DELETE FROM departamentos where dnombre = (?)";
		PreparedStatement sentencia = null;
		try {
			sentencia = con.prepareStatement(sentenciaSql);
			sentencia.setString(1, dnombre);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private static void listarDptos() {
		try {
			PreparedStatement sentencia = con.prepareStatement("Select * from departamentos;");
			ResultSet rs= sentencia.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void establecerConexionMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void establecerConexionSQLite() {
		try {
			Class.forName("org.sqlite.JDBC");
			con= DriverManager.getConnection("jdbc:sqlite:" + Utilidades.RUTA+DB );
			PreparedStatement sentencia = con.prepareStatement("CREATE TABLE IF NOT EXISTS departamentos (dept_no INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, dnombre VARCHAR(15), loc VARCHAR(15));");
			sentencia.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void borrarTablaDepartamentos() {
	    String sentenciaSql = "DROP TABLE IF EXISTS departamentos";
	    try (PreparedStatement sentencia = con.prepareStatement(sentenciaSql)) {
	        sentencia.executeUpdate();
	        System.out.println("Tabla departamentos eliminada si existía.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
