package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultaUsuario;
import modelo.Usuario;
import ventanas.VentanaGestionUsuarios;

public class ControladorGestionUsuarios implements ActionListener{
	
	
	VentanaGestionUsuarios ventanaGestionUsuarios;
	Usuario empleado = new Usuario();
	ConsultaUsuario consultaUsuario = new ConsultaUsuario();
	
	public ControladorGestionUsuarios(VentanaGestionUsuarios ventanaGestionUsuarios) {
		this.ventanaGestionUsuarios=ventanaGestionUsuarios;
		this.ventanaGestionUsuarios.btnBuscarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnEliminarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnModificarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnRegistrar.addActionListener(this);
		this.ventanaGestionUsuarios.btnLimpiar.addActionListener(this);
		this.ventanaGestionUsuarios.btnSeleccionar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Metodo para buscar un usuario en la base de datos y poner su infomracion en la tabla
		if(e.getSource() == ventanaGestionUsuarios.btnBuscarUsuario) {
			
			if(ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.getText().isEmpty()==false) {
			
				int id = Integer.valueOf(ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.getText());
				
				if(consultaUsuario.buscar(empleado, id)) {
					//agregar valores a la tabla
					ponerValoresUsuarioEnTabla();
					ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.setText(null);
				
				}else {
					ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.setText(null);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado");
			}
			
		}
		
		//metodo para eliminar un usuario de la base de datos
		if(e.getSource() == ventanaGestionUsuarios.btnEliminarUsuario) {
				if(ventanaGestionUsuarios.textFieldIdUsuario.getText().isEmpty()==false) {
					int id = Integer.valueOf(ventanaGestionUsuarios.textFieldIdUsuario.getText());
					consultaUsuario.eliminar(id);
					ventanaGestionUsuarios.limpiarCasillas();
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado que desea eliminar");
				}
		}
			
		//metodo que modifica informacion de un empleado
		if(e.getSource() == ventanaGestionUsuarios.btnModificarUsuario) {
			
			if(ventanaGestionUsuarios.validarCamposLlenos() && ventanaGestionUsuarios.validarFormatoFecha()) {
				ponerValoresEnModeloUsuario();
				consultaUsuario.modificar(empleado);
				ventanaGestionUsuarios.limpiarCasillas();
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
			
		}
		
		//metodo para registrar un empleado en la base de datos
		if(e.getSource() == ventanaGestionUsuarios.btnRegistrar) {
			
			if(ventanaGestionUsuarios.validarCamposLlenos() && ventanaGestionUsuarios.validarFormatoFecha()) {
				ponerValoresEnModeloUsuario();
				consultaUsuario.registrar(empleado);
				ventanaGestionUsuarios.limpiarCasillas();
			}else {
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
		}
		
		//metodo para limpiar las casillas
		if(e.getSource() == ventanaGestionUsuarios.btnLimpiar) {
			ventanaGestionUsuarios.limpiarCasillas();
		}
		
		//metodo para seleccionar un registro de la tabla y poner sus valores en las casillas
		if(e.getSource() == ventanaGestionUsuarios.btnSeleccionar) {

			int fila = ventanaGestionUsuarios.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
		}
	
		
	}
	
	
	public void ponerValoresEnModeloUsuario() {
		empleado.setId(Integer.valueOf(ventanaGestionUsuarios.textFieldIdUsuario.getText()));
		empleado.setNombre(ventanaGestionUsuarios.textFieldNombreUsuario.getText());
		empleado.setTelefono(ventanaGestionUsuarios.textFieldTelefonoUsuario.getText());
		empleado.setCargo(ventanaGestionUsuarios.textFieldCargoUsuario.getText());
		empleado.setPassword(ventanaGestionUsuarios.textFieldPasswordUsuario.getText());
		empleado.setFechaNacimiento(Date.valueOf(ventanaGestionUsuarios.textFieldFechaNacimientoUsuario.getText()));
	}
	
	public void ponerValoresEnArreglo(Object[] arreglo) {
		
		arreglo[0]= empleado.getId();
		arreglo[1]= empleado.getNombre();
		arreglo[2]= empleado.getTelefono();
		arreglo[3]= empleado.getCargo();
		arreglo[4]= empleado.getPassword(); 
		arreglo[5]= empleado.getFechaNacimiento();

			
	}
	
	public void ponerValoresUsuarioEnTabla() {
		
		int numCols = ventanaGestionUsuarios.table.getModel().getColumnCount();

		Object [] valores = new Object[numCols]; 
		        
		 //poner valores de los textfields en arreglo
		ponerValoresEnArreglo(valores);
		
		 ((DefaultTableModel) ventanaGestionUsuarios.table.getModel()).addRow(valores);
		 
		///agregue mensaje
		 JOptionPane.showMessageDialog(null, "El empleado ha sido encontrado");
		
	}
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		ventanaGestionUsuarios.textFieldIdUsuario.setText((ventanaGestionUsuarios.table.getValueAt(fila, 0).toString()));
		ventanaGestionUsuarios.textFieldNombreUsuario.setText((String) ventanaGestionUsuarios.table.getValueAt(fila, 1));
		ventanaGestionUsuarios.textFieldTelefonoUsuario.setText((String) ventanaGestionUsuarios.table.getValueAt(fila, 2));
		ventanaGestionUsuarios.textFieldCargoUsuario.setText((String) ventanaGestionUsuarios.table.getValueAt(fila, 3));
		ventanaGestionUsuarios.textFieldPasswordUsuario.setText((String) ventanaGestionUsuarios.table.getValueAt(fila, 4));
		
		Date dateObj = (Date) ventanaGestionUsuarios.table.getValueAt(fila, 5);
		String fecha = dateObj.toString();
		ventanaGestionUsuarios.textFieldFechaNacimientoUsuario.setText(fecha);
		
	}
	
	
	
	

}
