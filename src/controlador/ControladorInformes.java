package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ventanas.VentanaInformes;

public class ControladorInformes implements ActionListener {
	
	VentanaInformes ventanaInformes;
	
	ControladorInformes(VentanaInformes ventanaInformes){
		this.ventanaInformes = ventanaInformes;
		this.ventanaInformes.btnReporteClientes.addActionListener(this);
		this.ventanaInformes.btnReporteInventario.addActionListener(this);
		this.ventanaInformes.btnReporteProveedores.addActionListener(this);
		this.ventanaInformes.btnReporteVentasDiario.addActionListener(this);
		this.ventanaInformes.btnReporteVentasMensual.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaInformes.btnReporteVentasDiario) {
			
		}
		
		if(e.getSource() == ventanaInformes.btnReporteVentasMensual) {
			
		}
		
		if(e.getSource() == ventanaInformes.btnReporteInventario) {
			
		}
		
		if(e.getSource() == ventanaInformes.btnReporteClientes) {
			
		}
		
		if(e.getSource() == ventanaInformes.btnReporteProveedores) {
			
		}
		
	}
	
	

}
