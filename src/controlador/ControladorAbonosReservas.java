package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import modelo.ConsultaAbonosReservas;
import modelo.Usuario;
import recibo.ReciboAbono;
import ventanas.VentanaAbonosReservas;

public class ControladorAbonosReservas implements ActionListener, MouseListener {
	
	VentanaAbonosReservas ventanaAbonos;
	Usuario empleado;
	ConsultaAbonosReservas consultaAbonosReservas = new ConsultaAbonosReservas();
	ReciboAbono reciboAbono;
	
	public ControladorAbonosReservas(VentanaAbonosReservas ventanaAbonos, Usuario empleado) {
		this.ventanaAbonos = ventanaAbonos;
		this.empleado = empleado;
		this.ventanaAbonos.btnBuscarReserva.addActionListener(this);
		this.ventanaAbonos.btnCancelarReserva.addActionListener(this);
		this.ventanaAbonos.btnRegistrarAbono.addActionListener(this);
		this.ventanaAbonos.btnBuscarAbono.addActionListener(this);
		this.ventanaAbonos.btnActualizarTablaAbonos.addActionListener(this);
		this.ventanaAbonos.btnActualizarTablaReserva.addActionListener(this);
		this.ventanaAbonos.table.addMouseListener(this);
		this.ventanaAbonos.table_1.addMouseListener(this);
		
		consultaAbonosReservas.poblarTablaReservas(ventanaAbonos.table_1);
		consultaAbonosReservas.poblarTablaAbonos(ventanaAbonos.table);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaAbonos.btnBuscarReserva) {
			if(ventanaAbonos.textFieldBuscarReserva.getText().isEmpty()==false) {
				ventanaAbonos.borrarElementosTabla(ventanaAbonos.model_1);
				consultaAbonosReservas.buscarReserva(ventanaAbonos, ventanaAbonos.table_1);
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese la cedula del cliente");
			}
		}
		
		if(e.getSource() == ventanaAbonos.btnBuscarAbono) {
			if(ventanaAbonos.textFieldBuscarAbono.getText().isEmpty()==false) {
				ventanaAbonos.borrarElementosTabla(ventanaAbonos.model);
				consultaAbonosReservas.buscarAbono(ventanaAbonos, ventanaAbonos.table);
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID de la reserva");
			}
		}
		
		
		if(e.getSource() == ventanaAbonos.btnCancelarReserva) {
			
			if(ventanaAbonos.textFieldIdReserva.getText().isEmpty()==false) {
				
				consultaAbonosReservas.cancelarReservas(ventanaAbonos);
				consultaAbonosReservas.cancelarReservaActualizarCantidadesProducto(ventanaAbonos);
				
				ventanaAbonos.borrarElementosTabla(ventanaAbonos.model_1);
				consultaAbonosReservas.poblarTablaReservas(ventanaAbonos.table_1);
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID de la reserva");
			}
			
		}
		
		if(e.getSource() == ventanaAbonos.btnRegistrarAbono) {
			
			if(ventanaAbonos.textFieldIdReservaAbonos.getText().isEmpty()==false && ventanaAbonos.textFieldCantidadAbono.getText().isEmpty()==false) {
				
				consultaAbonosReservas.registrarAbono(ventanaAbonos);
				consultaAbonosReservas.actualizarSaldoPendienteAbono(ventanaAbonos);
				
				reciboAbono = new ReciboAbono(ventanaAbonos);
				try {
					reciboAbono.crearPdfAbono(empleado);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ventanaAbonos.borrarElementosTabla(ventanaAbonos.model_1);
				consultaAbonosReservas.poblarTablaReservas(ventanaAbonos.table_1);
				
				ventanaAbonos.borrarElementosTabla(ventanaAbonos.model);
				consultaAbonosReservas.poblarTablaAbonos(ventanaAbonos.table);
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID de la Reserva y la cantidad");
			}
			
		}
		
		if(e.getSource() == ventanaAbonos.btnActualizarTablaAbonos) {
			ventanaAbonos.borrarElementosTabla(ventanaAbonos.model);
			consultaAbonosReservas.poblarTablaAbonos(ventanaAbonos.table);
		}
		
		if(e.getSource() == ventanaAbonos.btnActualizarTablaReserva) {
			ventanaAbonos.borrarElementosTabla(ventanaAbonos.model_1);
			consultaAbonosReservas.poblarTablaReservas(ventanaAbonos.table_1);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaAbonos.table_1) {
			
			int numerofila = ventanaAbonos.table_1.getSelectedRow();
			
			//TableModel model = ventanaAbonos.table_1.getModel();
			
			ventanaAbonos.textFieldIdReservaAbonos.setText((ventanaAbonos.table_1.getValueAt(numerofila, 0)).toString());
			ventanaAbonos.textFieldIdReserva.setText((ventanaAbonos.table_1.getValueAt(numerofila, 0)).toString());
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
