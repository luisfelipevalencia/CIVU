package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.ConsultaCliente;
import ventanas.VentanaGestionClientes;

public class ControladorGestionClientes implements ActionListener {
	
	VentanaGestionClientes ventanaGestionClientes;
	Cliente cliente = new Cliente();
	ConsultaCliente consultaCliente = new ConsultaCliente();
	
	
	public ControladorGestionClientes(VentanaGestionClientes ventanaGestionClientes) {
		this.ventanaGestionClientes=ventanaGestionClientes;
		this.ventanaGestionClientes.btnBuscarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnEliminarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnModificarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnRegistrarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnSeleccionar.addActionListener(this);
		this.ventanaGestionClientes.btnLimpiar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionClientes.btnBuscarCliente) {
			if(ventanaGestionClientes.textFieldBuscarClientePorId.getText().isEmpty()==false) {
				
				int id = Integer.valueOf(ventanaGestionClientes.textFieldBuscarClientePorId.getText());
				
				if(consultaCliente.buscar(cliente, id)) {
					//agregar valores a la tabla
					ponerValoresUsuarioEnTabla();
					ventanaGestionClientes.textFieldBuscarClientePorId.setText(null);
				}else {
					ventanaGestionClientes.textFieldBuscarClientePorId.setText(null);
				}
					
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del cliente");
			}
			
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnEliminarCliente) {
			if(ventanaGestionClientes.textFieldIdCliente.getText().isEmpty()==false) {
				int id = Integer.valueOf(ventanaGestionClientes.textFieldIdCliente.getText());
				consultaCliente.eliminar(id);
				ventanaGestionClientes.limpiarCasillas();
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado que desea eliminar");
			}
		}
			
		
		if(e.getSource() == ventanaGestionClientes.btnModificarCliente) {
			if(ventanaGestionClientes.validarCamposLlenos() && ventanaGestionClientes.validarFormatoFecha()) {
				ponerValoresEnModeloUsuario();
				consultaCliente.modificar(cliente);
				ventanaGestionClientes.limpiarCasillas();
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnRegistrarCliente) {
			if(ventanaGestionClientes.validarCamposLlenos() && ventanaGestionClientes.validarFormatoFecha()) {
				ponerValoresEnModeloUsuario();
				consultaCliente.registrar(cliente);
				ventanaGestionClientes.limpiarCasillas();
			}else {
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
			
		}
				
		
		if(e.getSource() == ventanaGestionClientes.btnLimpiar) {
			ventanaGestionClientes.limpiarCasillas();
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnSeleccionar) {
			int fila = ventanaGestionClientes.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
			
		}
		
	}
	
	
	public void ponerValoresEnModeloUsuario() {
		cliente.setId(Integer.valueOf(ventanaGestionClientes.textFieldIdCliente.getText()));
		cliente.setNombre(ventanaGestionClientes.textFieldNombreCliente.getText());
		cliente.setTelefono(ventanaGestionClientes.textFieldTelefonoCliente.getText());
		cliente.setFechaNacimiento(Date.valueOf(ventanaGestionClientes.textFieldFechaNacimientoCliente.getText()));
	}
	
	public void ponerValoresEnArreglo(Object[] arreglo) {
		
		arreglo[0]= cliente.getId();
		arreglo[1]= cliente.getNombre();
		arreglo[2]= cliente.getTelefono();
		arreglo[3]= cliente.getFechaNacimiento();

			
	}
	
	public void ponerValoresUsuarioEnTabla() {
		
		int numCols = ventanaGestionClientes.table.getModel().getColumnCount();

		Object [] valores = new Object[numCols]; 
		        
		 //poner valores de los textfields en arreglo
		ponerValoresEnArreglo(valores);
		
		 ((DefaultTableModel) ventanaGestionClientes.table.getModel()).addRow(valores);
		 
		///agregue mensaje
		 JOptionPane.showMessageDialog(null, "El cliente ha sido encontrado");
		
	}
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		ventanaGestionClientes.textFieldIdCliente.setText((ventanaGestionClientes.table.getValueAt(fila, 0).toString()));
		ventanaGestionClientes.textFieldNombreCliente.setText((String) ventanaGestionClientes.table.getValueAt(fila, 1));
		ventanaGestionClientes.textFieldTelefonoCliente.setText((String) ventanaGestionClientes.table.getValueAt(fila, 2));
		
		Date dateObj = (Date) ventanaGestionClientes.table.getValueAt(fila, 3);
		String fecha = dateObj.toString();
		ventanaGestionClientes.textFieldFechaNacimientoCliente.setText(fecha);
		
	}

}
