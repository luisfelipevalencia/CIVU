package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Cliente;
import modelo.ConsultaCliente;
import modelo.ConsultaInventario;
import modelo.ConsultaVentas;
import modelo.Item;
import modelo.Usuario;
import recibo.ReciboVenta;
import ventanas.VentanaGestionClientes;
import ventanas.VentanaPrincipal;
import ventanas.VentanaVentas;

public class ControladorVentas implements ActionListener, MouseListener, KeyListener{
	
	int numeroConsecutivoVenta;
	boolean verificacionCliente = false;
	Usuario empleado;
	VentanaPrincipal ventanaPrincipal;
	VentanaGestionClientes ventanaGestionClientes;
	ControladorGestionClientes controladorGestionClientes;
	VentanaVentas ventanaVentas;
	ConsultaVentas consultaVentas = new ConsultaVentas();
	ConsultaInventario consultaInventario = new ConsultaInventario();
	Item item;
	Cliente cliente;
	ConsultaCliente consultaCliente = new ConsultaCliente();
	
	
	
	public ControladorVentas (VentanaVentas ventanaVentas, VentanaPrincipal ventanaPrincipal, Usuario empleado) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaVentas = ventanaVentas;
		this.empleado = empleado;
		this.ventanaVentas.btnAgregarItem.addActionListener(this);
		this.ventanaVentas.btnBuscarItem.addActionListener(this);
		this.ventanaVentas.btnEliminarRegistroTabla.addActionListener(this);
		this.ventanaVentas.btnVenta.addActionListener(this);
		this.ventanaVentas.btnLimpiarRegistrosTabla.addActionListener(this);
		this.ventanaVentas.btnComprobarCliente.addActionListener(this);
		this.ventanaVentas.btnReserva.addActionListener(this);
		this.ventanaVentas.table_1.addMouseListener(this);
		this.ventanaVentas.textFieldDescuento.addKeyListener(this);
		consultaInventario.poblarTablaItemVentas(ventanaVentas.table_1);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaVentas.btnAgregarItem) {
			
			if(ventanaVentas.textFieldIdCliente.getText().isEmpty() == false) {
			
				if(verificacionCliente == true) {
				
				
				
					if(ventanaVentas.textFieldIdItem.getText().isEmpty()==false && ventanaVentas.comboCantidad.getSelectedIndex()!=0 ){
					
						
						
						
						String idItem = ventanaVentas.textFieldIdItem.getText();
						int cantidad = Integer.valueOf((ventanaVentas.comboCantidad.getSelectedItem()).toString());
						item = new Item();
						
						if(consultaInventario.buscarItemVenta(idItem, item)) {
							
							int resultado = buscarIDItemEnTabla(Integer.parseInt(idItem),ventanaVentas.table);
							
							if(resultado == 0) {
								
								if(cantidad <= item.getCantidad()  ) {
									
									int subtotal = cantidad*item.getPrecioUnidad();
						        	
						        	Object tbData[] = {item.getId(), item.getReferencia(), cantidad, item.getPrecioUnidad(), subtotal};
						        	
						        	DefaultTableModel tblModel = (DefaultTableModel)ventanaVentas.table.getModel();
						        	
						        	tblModel.addRow(tbData);
						        	
						        	calcularSubtotal();
						        	calcularTotal();
						        	
						        	ventanaVentas.textFieldIdItem.setText(null);
						        	ventanaVentas.comboCantidad.setSelectedIndex(0);
						        	
								
								}else {
								
									JOptionPane.showMessageDialog(null, "La cantidad ingresada es mayor a la cantidad disponible");
								}
								
							}else {
								
								if(resultado == 1) {
									calcularSubtotal();
								}
							}
							
						
						}else {
							JOptionPane.showMessageDialog(null, "Ingrese un ID valido");
						}
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Indique el ID del Item y la cantidad");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Verifique la cedula del Cliente");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese la cedula del cliente");
			}
				
				
		}
		
		
		
		
		
		if(e.getSource() == ventanaVentas.btnBuscarItem) {
			
		}
		
		
		if(e.getSource() == ventanaVentas.btnEliminarRegistroTabla) {
			
			if(ventanaVentas.table.getSelectionModel().isSelectionEmpty()==false) {
				int fila = ventanaVentas.table.getSelectedRow();
				
				ventanaVentas.model.removeRow(fila);
				
				calcularSubtotal();
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No se selecciono ningun registro");
			}
		}
		
		if(e.getSource() == ventanaVentas.btnVenta) {
			
			if(verificacionCliente == true) {
				
				if(ventanaVentas.table.getRowCount()>0) {
					
					consultaVentas.registrarVenta(ventanaVentas, empleado.getId());
					consultaVentas.actualizarCantidades(ventanaVentas);
					consultaVentas.registrarDetalleVenta(ventanaVentas);
					
					
					ventanaVentas.borrarElementosTabla(ventanaVentas.model_1);
					consultaInventario.poblarTablaItemVentas(ventanaVentas.table_1);
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Agregue un item");
				}
				
			}else {
				 JOptionPane.showMessageDialog(null, "Verifique la cedula del cliente");
			}
			
			
		}
		
		if(e.getSource() == ventanaVentas.btnLimpiarRegistrosTabla) {
			ventanaVentas.borrarElementosTabla(ventanaVentas.model);
			ventanaVentas.textFieldSubtotal.setText(null);
			ventanaVentas.textFieldDescuento.setText(null);
			ventanaVentas.textFieldTotal.setText(null);
		}
		
		if(e.getSource() == ventanaVentas.btnComprobarCliente) {
			
			if(ventanaVentas.textFieldIdCliente.getText().isEmpty() == false) {
			
				cliente = new Cliente();
				int idCliente = Integer.parseInt(ventanaVentas.textFieldIdCliente.getText());
				
				if(consultaCliente.confirmarExistenciaCliente(idCliente)) {
					
					 JOptionPane.showMessageDialog(null, "Verificación exitosa, el cliente esta registrado");
					 verificacionCliente = true;
					
				}else {
					
					ventanaGestionClientes = new VentanaGestionClientes(); 
					controladorGestionClientes = new ControladorGestionClientes(ventanaGestionClientes);
					
					
					ventanaGestionClientes.setSize(885, 485);
					ventanaGestionClientes.setLocation(0, 0);
					ventanaPrincipal.panelPrincipalVentanas.removeAll();
					ventanaPrincipal.panelPrincipalVentanas.add(ventanaGestionClientes);
					ventanaPrincipal.panelPrincipalVentanas.revalidate();
					ventanaPrincipal.panelPrincipalVentanas.repaint();
				}
				
			}else {
				
				//
				JOptionPane.showMessageDialog(null, "Ingrese la cedula del cliente");
			}
			
		}
		
		if(e.getSource() == ventanaVentas.btnReserva) {
			
			if(verificacionCliente == true) {
				
				if(ventanaVentas.table.getRowCount()>0) {
					
					consultaVentas.registrarReserva(ventanaVentas, empleado.getId());
					consultaVentas.actualizarCantidades(ventanaVentas);
					consultaVentas.registrarDetalleReserva(ventanaVentas);
					
					ventanaVentas.borrarElementosTabla(ventanaVentas.model_1);
					consultaInventario.poblarTablaItemVentas(ventanaVentas.table_1);
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Agregue un item");
				}
				
			}else {
				 JOptionPane.showMessageDialog(null, "Verifique la cedula del cliente");
			}
			
		}
		
		
	}
	
	public int buscarIDItemEnTabla(int numeroID, JTable table) {
		
		int opcion = 0;
		int numeroFilas= table.getRowCount();
		
		
		for(int i=0; i<numeroFilas; i++) {
			
			int valor = (int) table.getValueAt(i, 0);
			
			if (numeroID == valor) {
				
				int cantidad = Integer.parseInt(ventanaVentas.comboCantidad.getSelectedItem().toString());
				
				if(cantidad <= item.getCantidad()) {
					
					table.setValueAt(cantidad, i, 2);
					JOptionPane.showMessageDialog(null, "Cantidad Actualizada");
					opcion= 1;
					i=numeroFilas;
				}else {
					JOptionPane.showMessageDialog(null, "La cantidad ingresada es mayor a la cantidad disponible");
					opcion= 2;
					i=numeroFilas;
				}
				
				
			}
		}
		
		System.out.println(opcion);
		return opcion;
	}
	
	
	public void calcularSubtotal() {
		
		int sumaSubtotales = 0;
    	
    	if(ventanaVentas.table.getRowCount()>0) {
    		
    		int numeroFilas = ventanaVentas.table.getRowCount();
    		
    		for(int i=0; i<numeroFilas; i++) {

    			sumaSubtotales = (int)ventanaVentas.table.getValueAt(i, 4) + sumaSubtotales;
    		}
    		
    		ventanaVentas.textFieldSubtotal.setText(Integer.toString(sumaSubtotales));
    		
    	}else {
    		ventanaVentas.textFieldSubtotal.setText(Integer.toString(sumaSubtotales));
    	}
    	
	}
	
	public void calcularTotal() {
		
		if(ventanaVentas.textFieldDescuento.getText().isEmpty()) {
			int subtotal = Integer.valueOf(ventanaVentas.textFieldSubtotal.getText());
			ventanaVentas.textFieldTotal.setText(Integer.toString(subtotal));
		}else {
			int subtotal = Integer.valueOf(ventanaVentas.textFieldSubtotal.getText());
			int descuento = Integer.valueOf(ventanaVentas.textFieldDescuento.getText());
			int total = subtotal - descuento;
			
			ventanaVentas.textFieldTotal.setText(Integer.toString(total));
		}
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaVentas.table_1) {
			
			int numerofila = ventanaVentas.table_1.getSelectedRow();
			
			TableModel model = ventanaVentas.table_1.getModel();
			
			ventanaVentas.textFieldIdItem.setText((ventanaVentas.table_1.getValueAt(numerofila, 0)).toString());
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
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ventanaVentas.textFieldDescuento) {
			
			
			if(ventanaVentas.textFieldDescuento.getText().isEmpty()==false ) {
				
					int subtotal = Integer.valueOf(ventanaVentas.textFieldSubtotal.getText());
					int descuento = Integer.valueOf(ventanaVentas.textFieldDescuento.getText());
					int total = subtotal - descuento;
					
					ventanaVentas.textFieldTotal.setText(Integer.toString(total));
				
			}else {
				int subtotal = Integer.valueOf(ventanaVentas.textFieldSubtotal.getText());
				ventanaVentas.textFieldTotal.setText(Integer.toString(subtotal));
			}

		}
	}

	
	

}
