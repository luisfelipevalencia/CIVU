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

public class VentanaVentas extends JPanel {
	
	public JTextField textFieldIdItem;
	public JTextField textFieldBuscarItemPorId;
	public JTable table;
	public DefaultTableModel model;
	public DefaultTableModel model_1;
	public JButton btnEliminarRegistroTabla;
	public JButton btnBuscarItem;
	public JButton btnLimpiarRegistrosTabla;
	public JButton btnVenta;
	public JButton btnAgregarItem;
	public JButton btnComprobarCliente;
	public JComboBox comboCantidad;
	public JTable table_1;
	private JSeparator separator_1;
	public JTextField textFieldIdCliente;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_3;
	public JTextField textFieldTotal;
	public JButton btnReserva;
	private JLabel lblNewLabel_1_4;
	public JTextField textFieldDescuento;
	private JLabel lblNewLabel_1_5;
	public JTextField textFieldSubtotal;
	public JComboBox comboBoxArgumentoBusqueda;
	public JButton btnActualizarTablaItemsVentas;

	/**
	 * Create the panel.
	 */
	public VentanaVentas() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Item:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 121, 56, 27);
		add(lblNewLabel_1);
		
		textFieldIdItem = new JTextField();
		textFieldIdItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//adicionar validacion de casilla
				
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
				
				
				if(textFieldIdItem.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
				
			}
		});
		textFieldIdItem.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdItem.setBackground(new Color(255, 255, 255));
		textFieldIdItem.setBorder(null);
		textFieldIdItem.setBounds(96, 121, 166, 20);
		add(textFieldIdItem);
		textFieldIdItem.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 255));
		separator.setBounds(96, 145, 166, 2);
		add(separator);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cantidad:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, 162, 69, 26);
		add(lblNewLabel_1_2);
		
		btnEliminarRegistroTabla = new JButton("ELIMINAR");
		btnEliminarRegistroTabla.setForeground(Color.WHITE);
		btnEliminarRegistroTabla.setFont(new Font("Roboto", Font.BOLD, 12));
		btnEliminarRegistroTabla.setBorder(null);
		btnEliminarRegistroTabla.setBackground(new Color(0, 51, 153));
		btnEliminarRegistroTabla.setBounds(745, 236, 113, 25);
		add(btnEliminarRegistroTabla);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 223, 828, 2);
		add(separator_6);
		
		textFieldBuscarItemPorId = new JTextField();
		textFieldBuscarItemPorId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				

			}
		});
		textFieldBuscarItemPorId.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarItemPorId.setColumns(10);
		textFieldBuscarItemPorId.setBorder(null);
		textFieldBuscarItemPorId.setBackground(Color.WHITE);
		textFieldBuscarItemPorId.setBounds(487, 61, 166, 20);
		add(textFieldBuscarItemPorId);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 153, 255));
		separator_7.setBounds(487, 85, 166, 2);
		add(separator_7);
		
		btnBuscarItem = new JButton("BUSCAR");
		btnBuscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarItem.setForeground(Color.WHITE);
		btnBuscarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarItem.setBorder(null);
		btnBuscarItem.setBackground(new Color(0, 51, 153));
		btnBuscarItem.setBounds(663, 61, 84, 25);
		add(btnBuscarItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 236, 691, 102);
		add(scrollPane);
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		
		Object[] column = {"ID","Referencia","Cantidad","Precio","Subtotal"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		
		btnVenta = new JButton("VENTA");
		btnVenta.setForeground(Color.WHITE);
		btnVenta.setFont(new Font("Roboto", Font.BOLD, 12));
		btnVenta.setBorder(null);
		btnVenta.setBackground(new Color(0, 51, 153));
		btnVenta.setBounds(570, 449, 151, 25);
		add(btnVenta);
		
		btnLimpiarRegistrosTabla = new JButton("LIMPIAR");
		btnLimpiarRegistrosTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiarRegistrosTabla.setForeground(Color.WHITE);
		btnLimpiarRegistrosTabla.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiarRegistrosTabla.setBorder(null);
		btnLimpiarRegistrosTabla.setBackground(new Color(0, 51, 153));
		btnLimpiarRegistrosTabla.setBounds(745, 278, 113, 25);
		add(btnLimpiarRegistrosTabla);
		
		comboCantidad = new JComboBox();
		comboCantidad.setBackground(Color.WHITE);
		comboCantidad.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboCantidad.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		comboCantidad.setBorder(null);
		comboCantidad.setBounds(104, 162, 158, 20);
		add(comboCantidad);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(341, 98, 517, 114);
		add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Roboto", Font.PLAIN, 13));
		table_1.setBackground(Color.WHITE);
		
		model_1 = new DefaultTableModel();
		
		Object[] column_1 = {"ID","Referencia","Cantidad","Precio", "Talla", "Color", "Genero"};
		Object[] row_1 = new Object[0];
		model_1.setColumnIdentifiers(column_1);
		table_1.setModel(model_1);
		
		scrollPane_2.setViewportView(table_1);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 255));
		separator_1.setBounds(146, 85, 116, 2);
		add(separator_1);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.addKeyListener(new KeyAdapter() {
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
			}
		});
		textFieldIdCliente.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBorder(null);
		textFieldIdCliente.setBackground(Color.WHITE);
		textFieldIdCliente.setBounds(146, 61, 116, 20);
		add(textFieldIdCliente);
		
		lblNewLabel_2 = new JLabel("Cedula Cliente:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_2.setBounds(30, 67, 104, 20);
		add(lblNewLabel_2);
		
		btnComprobarCliente = new JButton("VERIFICAR");
		btnComprobarCliente.setForeground(Color.WHITE);
		btnComprobarCliente.setFont(new Font("Roboto", Font.BOLD, 12));
		btnComprobarCliente.setBorder(null);
		btnComprobarCliente.setBackground(new Color(0, 51, 153));
		btnComprobarCliente.setBounds(30, 90, 232, 20);
		add(btnComprobarCliente);
		
		lblNewLabel_1_3 = new JLabel("Total");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(471, 411, 84, 20);
		add(lblNewLabel_1_3);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBackground(Color.WHITE);
		textFieldTotal.setEditable(false);
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(570, 411, 151, 20);
		add(textFieldTotal);
		
		btnAgregarItem = new JButton("AGREGAR");
		btnAgregarItem.setForeground(Color.WHITE);
		btnAgregarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnAgregarItem.setBorder(null);
		btnAgregarItem.setBackground(new Color(0, 51, 153));
		btnAgregarItem.setBounds(30, 191, 232, 21);
		add(btnAgregarItem);
		
		btnReserva = new JButton("RESERVA");
		btnReserva.setForeground(Color.WHITE);
		btnReserva.setFont(new Font("Roboto", Font.BOLD, 12));
		btnReserva.setBorder(null);
		btnReserva.setBackground(new Color(0, 51, 153));
		btnReserva.setBounds(745, 449, 113, 25);
		add(btnReserva);
		
		lblNewLabel_1_4 = new JLabel("Descuento");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(471, 380, 84, 20);
		add(lblNewLabel_1_4);
		
		textFieldDescuento = new JTextField();
		textFieldDescuento.setColumns(10);
		textFieldDescuento.setBackground(Color.WHITE);
		textFieldDescuento.setBounds(570, 380, 152, 20);
		add(textFieldDescuento);
		
		lblNewLabel_1_5 = new JLabel("Subtotal");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(471, 349, 85, 20);
		add(lblNewLabel_1_5);
		
		textFieldSubtotal = new JTextField();
		textFieldSubtotal.setEditable(false);
		textFieldSubtotal.setColumns(10);
		textFieldSubtotal.setBackground(Color.WHITE);
		textFieldSubtotal.setBounds(570, 349, 151, 20);
		add(textFieldSubtotal);
		
		comboBoxArgumentoBusqueda = new JComboBox();
		comboBoxArgumentoBusqueda.setModel(new DefaultComboBoxModel(new String[] {"", "ID", "Referencia", "Cantidad", "Precio Unidad", "Color", "Genero"}));
		comboBoxArgumentoBusqueda.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxArgumentoBusqueda.setBackground(Color.WHITE);
		comboBoxArgumentoBusqueda.setBounds(341, 62, 136, 25);
		add(comboBoxArgumentoBusqueda);
		
		btnActualizarTablaItemsVentas = new JButton("ACTUALIZAR");
		btnActualizarTablaItemsVentas.setForeground(Color.WHITE);
		btnActualizarTablaItemsVentas.setFont(new Font("Roboto", Font.BOLD, 12));
		btnActualizarTablaItemsVentas.setBorder(null);
		btnActualizarTablaItemsVentas.setBackground(new Color(0, 51, 153));
		btnActualizarTablaItemsVentas.setBounds(757, 60, 101, 25);
		add(btnActualizarTablaItemsVentas);

	}
	
	
	public boolean validarComboBox(JComboBox comboBox) {
		
		boolean vacio = true;
		
		String valor = comboBox.getSelectedItem().toString();
		
		if(valor != "") {
			
			vacio= false;
		}
			
		return vacio;
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
	
	public String parametroBusquedaItem(JComboBox box) {
		
		String parametro = box.getSelectedItem().toString();
		String paramentroSQL = "";
		
	    switch (parametro) {
	    
        case "ID":
        	paramentroSQL = "id_producto"; 
            break;
        case "Referencia":
        	paramentroSQL = "referencia_producto";
            break;
        case "Marca":
        	paramentroSQL = "Marca_producto";
            break;
        case "ID Proveedor":
        	paramentroSQL = "id_producto"; 
            break;
        case "Cantidad":
        	paramentroSQL = "cantidad_producto";
            break;
        case "Costo Unidad":
        	paramentroSQL = "costo_unidad_producto";
            break;
        case "Precio Unidad":
        	paramentroSQL = "precio_unidad_producto"; 
            break;
        case "Color":
        	paramentroSQL = "color_producto";
            break;
        case "Genero":
        	paramentroSQL = "genero_producto";
            break;
        case "Talla":
        	paramentroSQL = "talla_producto";
            break;
        case "Tipo":
        	paramentroSQL = "tipo_calzado"; 
            break;
	    }
		
		return paramentroSQL;
	}
}
