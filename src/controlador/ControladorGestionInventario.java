package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo.ConsultaInventario;
import modelo.Item;
import ventanas.VentanaGestionInventario;

public class ControladorGestionInventario implements ActionListener, MouseListener {

	VentanaGestionInventario ventanaGestionInventario;
	Item zapato = new Item();
	ConsultaInventario consultaInventario = new ConsultaInventario();
	
	public ControladorGestionInventario(VentanaGestionInventario ventanaGestionInventario){
		this.ventanaGestionInventario = ventanaGestionInventario;
		this.ventanaGestionInventario.btnBuscarItem.addActionListener(this);
		this.ventanaGestionInventario.btnEliminarItem.addActionListener(this);
		this.ventanaGestionInventario.btnLimpiar.addActionListener(this);
		this.ventanaGestionInventario.btnListaInventario.addActionListener(this);
		this.ventanaGestionInventario.btnModificarItem.addActionListener(this);
		this.ventanaGestionInventario.btnRegistrarItem.addActionListener(this);
		this.ventanaGestionInventario.table.addMouseListener(this);
		consultaInventario.llenarComboBox(ventanaGestionInventario.comboBoxProveedor);
		consultaInventario.poblarTabla(ventanaGestionInventario.table);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionInventario.btnBuscarItem) {
			
			ventanaGestionInventario.borrarElementosTabla();
			
			String parametroBusqueda = ventanaGestionInventario.parametroBusquedaItem((ventanaGestionInventario.comboBoxArgumentoBusqueda));
			
			consultaInventario.buscar(parametroBusqueda, ventanaGestionInventario.textFieldBuscarItem, ventanaGestionInventario.table);
			
			ventanaGestionInventario.textFieldBuscarItem.setText(null);
			ventanaGestionInventario.comboBoxArgumentoBusqueda.setSelectedIndex(0);
			
		}
		
		if(e.getSource() == ventanaGestionInventario.btnRegistrarItem) {
			if(ventanaGestionInventario.validarCamposVacios()==false) {
				consultaInventario.registrar(ventanaGestionInventario);
				ventanaGestionInventario.limpiarCasillas();
				ventanaGestionInventario.borrarElementosTabla();
				consultaInventario.poblarTabla(ventanaGestionInventario.table);
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos");
			}
		}
		
		if(e.getSource() == ventanaGestionInventario.btnModificarItem) {
			
			if(ventanaGestionInventario.validarCamposVacios()==false) {
				consultaInventario.modificar(ventanaGestionInventario);
				ventanaGestionInventario.limpiarCasillas();
				ventanaGestionInventario.borrarElementosTabla();
				consultaInventario.poblarTabla(ventanaGestionInventario.table);
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos");
			}
		}
		
		if(e.getSource() == ventanaGestionInventario.btnEliminarItem) {
			
			if(ventanaGestionInventario.textFieldIdItem.getText().isEmpty()==false) {
			
				int id = Integer.valueOf(ventanaGestionInventario.textFieldIdItem.getText());
				
				consultaInventario.eliminar(id);
				ventanaGestionInventario.limpiarCasillas();
				ventanaGestionInventario.borrarElementosTabla();
				consultaInventario.poblarTabla(ventanaGestionInventario.table);
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del producto que desea eliminar");
			}
		}
		
		
		if(e.getSource() == ventanaGestionInventario.btnListaInventario) {
			ventanaGestionInventario.borrarElementosTabla();
			consultaInventario.poblarTabla(ventanaGestionInventario.table);
		}
		
		if(e.getSource() == ventanaGestionInventario.btnLimpiar) {
			ventanaGestionInventario.limpiarCasillas();
		}
		
		
	}
	
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		
		ventanaGestionInventario.textFieldIdItem.setText((ventanaGestionInventario.table.getValueAt(fila, 0)).toString());
		ventanaGestionInventario.textFieldCantidad.setText((ventanaGestionInventario.table.getValueAt(fila, 3)).toString());
		ventanaGestionInventario.textFieldPrecioUnidad.setText((ventanaGestionInventario.table.getValueAt(fila, 4)).toString());
		ventanaGestionInventario.textFieldCostoUnidad.setText((ventanaGestionInventario.table.getValueAt(fila, 5)).toString());
		ventanaGestionInventario.comboBoxProveedor.getModel().setSelectedItem(ventanaGestionInventario.table.getValueAt(fila, 2));
		ventanaGestionInventario.comboBoxTipo.getModel().setSelectedItem(ventanaGestionInventario.table.getValueAt(fila, 6));
		ventanaGestionInventario.textFieldMarca.setText((ventanaGestionInventario.table.getValueAt(fila, 8)).toString());
		ventanaGestionInventario.comboBoxTalla.getModel().setSelectedItem(ventanaGestionInventario.table.getValueAt(fila, 9));
		ventanaGestionInventario.comboBoxColor.getModel().setSelectedItem(ventanaGestionInventario.table.getValueAt(fila, 10));
		ventanaGestionInventario.textFieldReferencia.setText((ventanaGestionInventario.table.getValueAt(fila, 1)).toString());
		ventanaGestionInventario.comboBoxGenero.getModel().setSelectedItem(ventanaGestionInventario.table.getValueAt(fila, 7));
		
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ventanaGestionInventario.table) {
			int fila = ventanaGestionInventario.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionInventario.borrarElementosTabla();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
