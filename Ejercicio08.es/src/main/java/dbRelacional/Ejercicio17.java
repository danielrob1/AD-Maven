package dbRelacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio17 {
	private static Connection con;
	public Ejercicio17() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		establecerConexion();
		listarDptos();
		anadirDpto();
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

	private static void listarDptos() {
		try {
			PreparedStatement sentencia = con.prepareStatement("Select * from empresa.departamentos;");
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

	private static void establecerConexion() {
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

}
