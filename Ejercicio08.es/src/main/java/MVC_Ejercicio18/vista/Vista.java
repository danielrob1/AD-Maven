package MVC_Ejercicio18.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textFieldUsuario;
	public JTextField textFieldContrasenia;
	public JTextField textFieldNombre;
	public JTextField textFieldLocalidad;
	public JTable tableResultados;
	public DefaultTableModel modeloTbl = new DefaultTableModel();
	public JButton btnIniciarSesion;
	public JButton btnModificar;
	public JButton btnBorrar;
	public JButton btnNuevo;
	public JButton btnListar;
	public JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConectar = new JMenu("Conectar");
		menuBar.add(mnConectar);
		
		JMenu mnConectarDB = new JMenu("Conectar ddbb");
		mnConectar.add(mnConectarDB);
		
		JMenuItem mntmOracle = new JMenuItem("Oracle");
		mnConectarDB.add(mntmOracle);
		
		JMenuItem mntmMySQL = new JMenuItem("MySQL");
		mnConectarDB.add(mntmMySQL);
		
		JMenuItem mntmSQLite = new JMenuItem("SQLite");
		mnConectarDB.add(mntmSQLite);
		
		JMenuItem mntmIniciarSesion = new JMenuItem("Iniciar Sesion");
		mnConectar.add(mntmIniciarSesion);
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		JMenuItem mtnmDesconectar = new JMenuItem("Desconectar");
		mnSalir.add(mtnmDesconectar);
		
		JMenuItem mtnmSalir = new JMenuItem("Salir");
		mnSalir.add(mtnmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 172, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 36, 46, 14);
		panel.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(76, 33, 96, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(10, 86, 56, 14);
		panel.add(lblNewLabel_1);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(76, 83, 96, 20);
		panel.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBounds(32, 134, 113, 23);
		panel.add(btnIniciarSesion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(192, 25, 309, 311);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 30, 46, 14);
		panel_1.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(76, 27, 96, 20);
		panel_1.add(textFieldNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Localidad");
		lblNewLabel_1_1.setBounds(10, 80, 56, 14);
		panel_1.add(lblNewLabel_1_1);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setColumns(10);
		textFieldLocalidad.setBounds(76, 77, 96, 20);
		panel_1.add(textFieldLocalidad);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(10, 115, 89, 23);
		panel_1.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(100, 115, 89, 23);
		panel_1.add(btnBorrar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(199, 26, 89, 23);
		panel_1.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(199, 115, 89, 23);
		panel_1.add(btnGuardar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(199, 76, 89, 23);
		panel_1.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 149, 278, 151);
		Object[] identificadores = {"Id", "Nombre", "Localidad"};
		modeloTbl.setColumnIdentifiers(identificadores);
		tableResultados = new JTable();
		tableResultados.setModel(modeloTbl);
		scrollPane.setViewportView(tableResultados);
		tableResultados.setFillsViewportHeight(true);
		tableResultados.setBounds(10, 149, 278, 151);
		panel_1.add(scrollPane);
		setVisible(true);
	}
}
