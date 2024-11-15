package MVC_Ejercicio18.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import MVC_Ejercicio18.modelo.Departamento;
import MVC_Ejercicio18.modelo.Modelo;
import MVC_Ejercicio18.vista.Vista;

public class Controlador {
	private Modelo modelo;
	private Vista vista;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		vista.btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.anadirDpto(vista.textFieldNombre.getText(), vista.textFieldLocalidad.getText());
				limpiaControles();
				rellenaTabla();
			}
			
		});
		vista.btnNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiaControles();				
			}
		});
		
		vista.btnListar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rellenaTabla();
				
			}
			
		});
		
		vista.btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaS=vista.tableResultados.getSelectedRow();
				vista.modeloTbl.removeRow(filaS);
				modelo.borrarDpto(Integer.valueOf(vista.modeloTbl.getValueAt(filaS, 0).toString()));
				rellenaTabla();
				limpiaControles();
			}
			
		});
		
		vista.btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaS=vista.tableResultados.getSelectedRow();
				modelo.modificarDpto(Integer.valueOf(vista.modeloTbl.getValueAt(filaS, 0).toString()), vista.textFieldNombre.getText(), vista.textFieldLocalidad.getText());
				rellenaTabla();
				limpiaControles();
			}
			
		});
		
		
		vista.tableResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaS=vista.tableResultados.getSelectedRow();
				vista.textFieldNombre.setText(vista.modeloTbl.getValueAt(filaS, 1).toString());
				vista.textFieldLocalidad.setText(vista.modeloTbl.getValueAt(filaS, 2).toString());
			}
			
		});
	}

	protected void rellenaTabla() {
		vista.modeloTbl.setNumRows(0);
		ArrayList<Departamento> dptoListado=modelo.listarDptos();
		for(Departamento dpto: dptoListado) {
			Object[] fila = {dpto.getDepNum(), dpto.getDepNombre(), dpto.getDepLocalidad()};
			vista.modeloTbl.addRow(fila);
		}
		
	}

	protected void limpiaControles() {
		vista.textFieldNombre.setText(null);
		vista.textFieldLocalidad.setText(null);
		
	}
	

}
