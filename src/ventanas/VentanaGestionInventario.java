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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaGestionInventario extends JPanel {
	public JTextField textFieldBuscarItem;
	public JTable table;
	DefaultTableModel model;
	public JButton btnBuscarItem;
	public 	JButton btnListaInventario;
	public JButton btnRegistrarItem;
	public JButton btnModificarItem;
	public JButton btnEliminarItem;
	public JButton btnLimpiar;
	public JTextField textFieldCantidad;
	public JTextField textFieldCostoUnidad;
	public JTextField textFieldPrecioUnidad;
	public JTextField textFieldReferencia;
	public JTextField textFieldIdItem;
	
	public JComboBox comboBoxProveedor;
	public JComboBox comboBoxColor;
	public JComboBox comboBoxTalla;
	public JComboBox comboBoxTipo;
	public JComboBox comboBoxGenero;
	public JTextField textFieldMarca;
	public JComboBox comboBoxArgumentoBusqueda;
	

	/**
	 * Create the panel.
	 */
	public VentanaGestionInventario() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventario");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 257, 828, 2);
		add(separator_6);
		
		textFieldBuscarItem = new JTextField();
		textFieldBuscarItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
	
				/*
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
				*/
				
				if(textFieldBuscarItem.getText().length()>= 50) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 50 caracteres o menos");
				}
				
			}
		});
		textFieldBuscarItem.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarItem.setColumns(10);
		textFieldBuscarItem.setBorder(null);
		textFieldBuscarItem.setBackground(Color.WHITE);
		textFieldBuscarItem.setBounds(176, 270, 525, 20);
		add(textFieldBuscarItem);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 153, 255));
		separator_7.setBounds(176, 293, 525, 2);
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
		btnBuscarItem.setBounds(711, 270, 142, 25);
		add(btnBuscarItem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 307, 823, 124);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		Object[] column = {"ID", "Referencia", "Proveedor","Cantidad","Precio","Costo","Tipo", "Genero", "Marca","Talla","Color"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnListaInventario = new JButton("LISTA INVENTARIO");
		btnListaInventario.setForeground(Color.WHITE);
		btnListaInventario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnListaInventario.setBorder(null);
		btnListaInventario.setBackground(new Color(0, 51, 153));
		btnListaInventario.setBounds(30, 442, 143, 25);
		add(btnListaInventario);
		
		JLabel lblNewLabel_1 = new JLabel("Id Proveedor");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(260, 80, 120, 17);
		add(lblNewLabel_1);
		
		comboBoxProveedor = new JComboBox();
		comboBoxProveedor.setBackground(Color.WHITE);
		comboBoxProveedor.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxProveedor.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxProveedor.setBounds(260, 99, 120, 20);
		add(comboBoxProveedor);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(260, 139, 120, 17);
		add(lblNewLabel_1_1);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldCantidad.getText().length()>= 7) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 7 numeros o menos");
					
				}	
			}
		});
		textFieldCantidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBorder(null);
		textFieldCantidad.setBackground(Color.WHITE);
		textFieldCantidad.setBounds(260, 158, 120, 20);
		add(textFieldCantidad);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Color");
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(420, 139, 120, 17);
		add(lblNewLabel_1_1_1);
		
		comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"", "Blanco", "Negro", "Beige", "Oro", "Cafe", "Gris", "Azul", "Amarillo", "Rojo", "Naranja"}));
		comboBoxColor.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxColor.setBackground(Color.WHITE);
		comboBoxColor.setBounds(420, 158, 120, 20);
		add(comboBoxColor);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Marca");
		lblNewLabel_1_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(30, 198, 190, 17);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Tipo");
		lblNewLabel_1_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(580, 139, 120, 17);
		add(lblNewLabel_1_1_3);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBackground(Color.WHITE);
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Botas", "Tenis", "Sandalias", "Casuales", "Formales", "Tacones", "Mocasines"}));
		comboBoxTipo.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxTipo.setBounds(580, 158, 120, 20);
		add(comboBoxTipo);
		
		textFieldCostoUnidad = new JTextField();
		textFieldCostoUnidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldCostoUnidad.getText().length()>= 7) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 7 numeros o menos");
				
				}
			}
		});
		textFieldCostoUnidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldCostoUnidad.setColumns(10);
		textFieldCostoUnidad.setBorder(null);
		textFieldCostoUnidad.setBackground(Color.WHITE);
		textFieldCostoUnidad.setBounds(260, 217, 120, 20);
		add(textFieldCostoUnidad);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo Unidad");
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(260, 198, 120, 17);
		add(lblNewLabel_1_1_1_1);
		
		textFieldPrecioUnidad = new JTextField();
		textFieldPrecioUnidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldPrecioUnidad.getText().length()>= 7) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 7 numeros o menos");
				}
			}
		});
		textFieldPrecioUnidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldPrecioUnidad.setColumns(10);
		textFieldPrecioUnidad.setBorder(null);
		textFieldPrecioUnidad.setBackground(Color.WHITE);
		textFieldPrecioUnidad.setBounds(420, 99, 120, 20);
		add(textFieldPrecioUnidad);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("Precio Unidad");
		lblNewLabel_1_1_3_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_3_2.setBounds(420, 80, 120, 17);
		add(lblNewLabel_1_1_3_2);
		
		comboBoxTalla = new JComboBox();
		comboBoxTalla.setBackground(Color.WHITE);
		comboBoxTalla.setModel(new DefaultComboBoxModel(new String[] {"", "33", "33.5", "34", "34.5", "35", "35.5", "36", "36.5", "37", "37.5", "38", "38.5", "39", "39.5", "40", "40,5", "41", "41,5", "42", "42,5", "43", "43,5", "44"}));
		comboBoxTalla.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxTalla.setBounds(580, 99, 120, 20);
		add(comboBoxTalla);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Talla");
		lblNewLabel_1_1_3_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_3_1.setBounds(580, 80, 120, 17);
		add(lblNewLabel_1_1_3_1);
		
		comboBoxGenero = new JComboBox();
		comboBoxGenero.setBackground(Color.WHITE);
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"", "Hombre", "Mujer"}));
		comboBoxGenero.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxGenero.setBounds(420, 217, 120, 20);
		add(comboBoxGenero);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Genero");
		lblNewLabel_1_1_3_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_3_1_1.setBounds(420, 198, 120, 17);
		add(lblNewLabel_1_1_3_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Referencia");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(30, 139, 120, 17);
		add(lblNewLabel_1_1_1_1_1_1);
		
		textFieldReferencia = new JTextField();
		textFieldReferencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
				
				if(textFieldReferencia.getText().length()>=40) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 40 caracteres o menos");
				}
				
			}
		});
		textFieldReferencia.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldReferencia.setColumns(10);
		textFieldReferencia.setBorder(null);
		textFieldReferencia.setBackground(Color.WHITE);
		textFieldReferencia.setBounds(30, 158, 190, 20);
		add(textFieldReferencia);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ID Item");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(31, 80, 189, 17);
		add(lblNewLabel_1_1_1_1_1);
		
		textFieldIdItem = new JTextField();
		textFieldIdItem.setEditable(false);
		textFieldIdItem.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdItem.setColumns(10);
		textFieldIdItem.setBorder(null);
		textFieldIdItem.setBackground(Color.WHITE);
		textFieldIdItem.setBounds(30, 99, 190, 20);
		add(textFieldIdItem);
		
		btnRegistrarItem = new JButton("REGISTRAR");
		btnRegistrarItem.setForeground(Color.WHITE);
		btnRegistrarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnRegistrarItem.setBorder(null);
		btnRegistrarItem.setBackground(new Color(0, 51, 153));
		btnRegistrarItem.setBounds(740, 80, 113, 25);
		add(btnRegistrarItem);
		
		btnModificarItem = new JButton("MODIFICAR");
		btnModificarItem.setForeground(Color.WHITE);
		btnModificarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnModificarItem.setBorder(null);
		btnModificarItem.setBackground(new Color(0, 51, 153));
		btnModificarItem.setBounds(740, 124, 113, 25);
		add(btnModificarItem);
		
		btnEliminarItem = new JButton("ELIMINAR");
		btnEliminarItem.setForeground(Color.WHITE);
		btnEliminarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnEliminarItem.setBorder(null);
		btnEliminarItem.setBackground(new Color(0, 51, 153));
		btnEliminarItem.setBounds(740, 168, 113, 25);
		add(btnEliminarItem);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(0, 51, 153));
		btnLimpiar.setBounds(740, 212, 113, 25);
		add(btnLimpiar);
		
		textFieldMarca = new JTextField();
		textFieldMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
				
				if(textFieldMarca.getText().length()>=40) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 40 caracteres o menos");
				}
				
				
			}
		});
		textFieldMarca.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldMarca.setColumns(10);
		textFieldMarca.setBorder(null);
		textFieldMarca.setBackground(Color.WHITE);
		textFieldMarca.setBounds(30, 217, 190, 20);
		add(textFieldMarca);
		
		comboBoxArgumentoBusqueda = new JComboBox();
		comboBoxArgumentoBusqueda.setBackground(Color.WHITE);
		comboBoxArgumentoBusqueda.setModel(new DefaultComboBoxModel(new String[] {"", "ID", "Referencia", "Marca", "ID Proveedor", "Cantidad", "Costo Unidad", "Precio Unidad", "Color", "Genero", "Talla", "Tipo"}));
		comboBoxArgumentoBusqueda.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxArgumentoBusqueda.setBounds(30, 270, 136, 25);
		add(comboBoxArgumentoBusqueda);
		
		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setForeground(new Color(0, 153, 255));
		separator_7_1.setBounds(30, 122, 190, 2);
		add(separator_7_1);
		
		JSeparator separator_7_1_1 = new JSeparator();
		separator_7_1_1.setForeground(new Color(0, 153, 255));
		separator_7_1_1.setBounds(260, 122, 120, 2);
		add(separator_7_1_1);
		
		JSeparator separator_7_1_2 = new JSeparator();
		separator_7_1_2.setForeground(new Color(0, 153, 255));
		separator_7_1_2.setBounds(420, 122, 120, 4);
		add(separator_7_1_2);
		
		JSeparator separator_7_1_3 = new JSeparator();
		separator_7_1_3.setForeground(new Color(0, 153, 255));
		separator_7_1_3.setBounds(580, 122, 121, 2);
		add(separator_7_1_3);
		
		JSeparator separator_7_1_4 = new JSeparator();
		separator_7_1_4.setForeground(new Color(0, 153, 255));
		separator_7_1_4.setBounds(30, 181, 190, 2);
		add(separator_7_1_4);
		
		JSeparator separator_7_1_5 = new JSeparator();
		separator_7_1_5.setForeground(new Color(0, 153, 255));
		separator_7_1_5.setBounds(30, 240, 190, 2);
		add(separator_7_1_5);
		
		JSeparator separator_7_1_1_1 = new JSeparator();
		separator_7_1_1_1.setForeground(new Color(0, 153, 255));
		separator_7_1_1_1.setBounds(260, 181, 120, 2);
		add(separator_7_1_1_1);
		
		JSeparator separator_7_1_1_2 = new JSeparator();
		separator_7_1_1_2.setForeground(new Color(0, 153, 255));
		separator_7_1_1_2.setBounds(260, 240, 120, 2);
		add(separator_7_1_1_2);
		
		JSeparator separator_7_1_1_3 = new JSeparator();
		separator_7_1_1_3.setForeground(new Color(0, 153, 255));
		separator_7_1_1_3.setBounds(420, 181, 120, 2);
		add(separator_7_1_1_3);
		
		JSeparator separator_7_1_1_4 = new JSeparator();
		separator_7_1_1_4.setForeground(new Color(0, 153, 255));
		separator_7_1_1_4.setBounds(420, 240, 120, 2);
		add(separator_7_1_1_4);
		
		JSeparator separator_7_1_1_5 = new JSeparator();
		separator_7_1_1_5.setForeground(new Color(0, 153, 255));
		separator_7_1_1_5.setBounds(580, 181, 120, 2);
		add(separator_7_1_1_5);

	}
	
	public void limpiarCasillas() {
		
		textFieldCantidad.setText(null);
		textFieldCostoUnidad.setText(null);
		textFieldPrecioUnidad.setText(null);
		textFieldReferencia.setText(null);
		textFieldIdItem.setText(null);
		textFieldMarca.setText(null);
		
		comboBoxProveedor.setSelectedIndex(0);
		comboBoxColor.setSelectedIndex(0);
		comboBoxTalla.setSelectedIndex(0);
		comboBoxTipo.setSelectedIndex(0);
		comboBoxGenero.setSelectedIndex(0);
		
		
	}
	
	
	public void borrarElementosTabla() {
		 
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
