package MVC_DEMO.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textOp1;
	public JTextField textOp2;
	public JTextField textResult;
	public JButton btnSumar;
	public JButton btnRestar;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("MVC_Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textOp1 = new JTextField();
		textOp1.setBounds(115, 24, 86, 20);
		panel.add(textOp1);
		textOp1.setColumns(10);
		
		textOp2 = new JTextField();
		textOp2.setBounds(115, 55, 86, 20);
		panel.add(textOp2);
		textOp2.setColumns(10);
		
		textResult = new JTextField();
		textResult.setBounds(115, 86, 86, 20);
		panel.add(textResult);
		textResult.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Operador 1");
		lblNewLabel.setBounds(18, 27, 87, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operador 2");
		lblNewLabel_1.setBounds(18, 58, 87, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado");
		lblNewLabel_2.setBounds(18, 89, 87, 14);
		panel.add(lblNewLabel_2);
		
		btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSumar.setBounds(31, 155, 89, 23);
		panel.add(btnSumar);
		
		btnRestar = new JButton("Restar");
		btnRestar.setBounds(134, 155, 89, 23);
		panel.add(btnRestar);
		setVisible(true);
	}
}
