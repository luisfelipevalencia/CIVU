package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAbonosReservas extends JPanel {
	
	public JTextField textFieldBuscarReserva;
	public JTable table;
	public DefaultTableModel model;
	public DefaultTableModel model_1;
	public JButton btnBuscarReserva;
	public JButton btnRegistrarAbono;
	public JButton btnCancelarReserva;
	public JButton btnBuscarAbono;
	public JTable table_1;
	private JSeparator separator_1;
	public JTextField textFieldIdReserva;
	private JLabel lblNewLabel_2;
	public JTextField textFieldIdReservaAbonos;
	public JTextField textFieldCantidadAbono;
	public JTextField textFieldBuscarAbono;

	/**
	 * Create the panel.
	 */
	public VentanaAbonosReservas() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservas");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 221, 828, 2);
		add(separator_6);
		
		textFieldBuscarReserva = new JTextField();
		textFieldBuscarReserva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
	
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(e.getKeyChar()>32 && e.getKeyChar()<48) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				
				if(textFieldBuscarReserva.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
			}
		});
		textFieldBuscarReserva.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarReserva.setColumns(10);
		textFieldBuscarReserva.setBorder(null);
		textFieldBuscarReserva.setBackground(Color.WHITE);
		textFieldBuscarReserva.setBounds(299, 61, 422, 20);
		add(textFieldBuscarReserva);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 153, 255));
		separator_7.setBounds(299, 85, 422, 2);
		add(separator_7);
		
		btnBuscarReserva = new JButton("BUSCAR RESERVA");
		btnBuscarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarReserva.setForeground(Color.WHITE);
		btnBuscarReserva.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarReserva.setBorder(null);
		btnBuscarReserva.setBackground(new Color(0, 51, 153));
		btnBuscarReserva.setBounds(731, 61, 127, 25);
		add(btnBuscarReserva);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 314, 559, 102);
		add(scrollPane);
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		
		Object[] column = {"ID Abono","ID Reserva","Cantidad","Fecha"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		
		btnRegistrarAbono = new JButton("REGISTRAR");
		btnRegistrarAbono.setForeground(Color.WHITE);
		btnRegistrarAbono.setFont(new Font("Roboto", Font.BOLD, 12));
		btnRegistrarAbono.setBorder(null);
		btnRegistrarAbono.setBackground(new Color(0, 51, 153));
		btnRegistrarAbono.setBounds(30, 391, 144, 25);
		add(btnRegistrarAbono);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(299, 98, 559, 102);
		add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Roboto", Font.PLAIN, 13));
		table_1.setBackground(Color.WHITE);
		
		model_1 = new DefaultTableModel();
		
		Object[] column_1 = {"ID Reserva","Cedula Cliente","Fecha","Saldo Pendiente", "Total Reserva", "Estado"};
		Object[] row_1 = new Object[0];
		model_1.setColumnIdentifiers(column_1);
		table_1.setModel(model_1);
		
		scrollPane_2.setViewportView(table_1);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 255));
		separator_1.setBounds(117, 85, 145, 2);
		add(separator_1);
		
		textFieldIdReserva = new JTextField();
		textFieldIdReserva.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdReserva.setColumns(10);
		textFieldIdReserva.setBorder(null);
		textFieldIdReserva.setBackground(Color.WHITE);
		textFieldIdReserva.setBounds(117, 61, 145, 20);
		add(textFieldIdReserva);
		
		lblNewLabel_2 = new JLabel("ID Reserva:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_2.setBounds(30, 67, 77, 20);
		add(lblNewLabel_2);
		
		btnCancelarReserva = new JButton("CANCELAR RESERVA");
		btnCancelarReserva.setForeground(Color.WHITE);
		btnCancelarReserva.setFont(new Font("Roboto", Font.BOLD, 12));
		btnCancelarReserva.setBorder(null);
		btnCancelarReserva.setBackground(new Color(0, 51, 153));
		btnCancelarReserva.setBounds(30, 174, 144, 26);
		add(btnCancelarReserva);
		
		JLabel lblReservas = new JLabel("Abonos");
		lblReservas.setFont(new Font("Roboto", Font.BOLD, 20));
		lblReservas.setBounds(30, 245, 260, 26);
		add(lblReservas);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID Reserva:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(30, 282, 77, 20);
		add(lblNewLabel_2_1);
		
		textFieldIdReservaAbonos = new JTextField();
		textFieldIdReservaAbonos.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdReservaAbonos.setColumns(10);
		textFieldIdReservaAbonos.setBorder(null);
		textFieldIdReservaAbonos.setBackground(Color.WHITE);
		textFieldIdReservaAbonos.setBounds(117, 276, 145, 20);
		add(textFieldIdReservaAbonos);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(0, 153, 255));
		separator_1_1.setBounds(117, 300, 145, 2);
		add(separator_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(30, 322, 71, 20);
		add(lblNewLabel_1_1);
		
		textFieldCantidadAbono = new JTextField();
		textFieldCantidadAbono.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldCantidadAbono.setColumns(10);
		textFieldCantidadAbono.setBorder(null);
		textFieldCantidadAbono.setBackground(Color.WHITE);
		textFieldCantidadAbono.setBounds(117, 316, 145, 20);
		add(textFieldCantidadAbono);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 153, 255));
		separator_2.setBounds(117, 340, 145, 2);
		add(separator_2);
		
		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setForeground(new Color(0, 153, 255));
		separator_7_1.setBounds(299, 300, 422, 2);
		add(separator_7_1);
		
		textFieldBuscarAbono = new JTextField();
		textFieldBuscarAbono.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarAbono.setColumns(10);
		textFieldBuscarAbono.setBorder(null);
		textFieldBuscarAbono.setBackground(Color.WHITE);
		textFieldBuscarAbono.setBounds(299, 276, 422, 20);
		add(textFieldBuscarAbono);
		
		btnBuscarAbono = new JButton("BUSCAR ABONO");
		btnBuscarAbono.setForeground(Color.WHITE);
		btnBuscarAbono.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarAbono.setBorder(null);
		btnBuscarAbono.setBackground(new Color(0, 51, 153));
		btnBuscarAbono.setBounds(731, 276, 127, 25);
		add(btnBuscarAbono);

	}
	
	
	
	public void limpiarCasillas() {

	}
	

	
	public void borrarElementosTabla(DefaultTableModel model) {
		 
        int numeroFilasBorrar = model.getRowCount();
        //remove rows from the bottom one by one
        for (int i = numeroFilasBorrar - 1; i >= 0; i--) {
            model.removeRow(i);
        }
	}
}
