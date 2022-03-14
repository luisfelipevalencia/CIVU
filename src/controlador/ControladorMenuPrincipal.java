

package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import modelo.Usuario;
import ventanas.VentanaAbonosReservas;
import ventanas.VentanaGestionClientes;
import ventanas.VentanaGestionInventario;
import ventanas.VentanaGestionProveedores;
import ventanas.VentanaGestionUsuarios;
import ventanas.VentanaInformes;
import ventanas.VentanaPerfil;
import ventanas.VentanaPrincipal;
import ventanas.VentanaVentas;

public class ControladorMenuPrincipal implements ActionListener{
	
	VentanaPrincipal ventanaPrincipal;
	VentanaPerfil ventanaPerfil;
	VentanaGestionUsuarios ventanaGestionUsuarios;
	VentanaGestionClientes ventanaGestionClientes;
	VentanaGestionProveedores ventanaGestionProveedores;
	VentanaGestionInventario ventanaGestionInventario;
	VentanaVentas ventanaVentas;
	VentanaInformes ventanaInformes;
	VentanaAbonosReservas ventanaAbonos;
	ControladorPerfil controladorPerfil;
	ControladorGestionUsuarios controladorGestionUsuarios;
	ControladorGestionClientes controladorGestionClientes;
	ControladorGestionProveedores controladorGestionProveedores;
	ControladorGestionInventario controladorGestionInventario;
	ControladorVentas controladorVentas;
	ControladorAbonosReservas controladorAbonosReservas;
	ControladorInformes controladorInformes;
	Usuario empleado;
	
	
public ControladorMenuPrincipal(VentanaPrincipal ventanaPrincipal, Usuario empleado) {
	this.ventanaPrincipal = ventanaPrincipal;
	this.empleado = empleado;
	this.ventanaPrincipal.btnPerfil.addActionListener(this);
	this.ventanaPrincipal.btnGestionUsuarios.addActionListener(this);
	this.ventanaPrincipal.btnGestionClientes.addActionListener(this);
	this.ventanaPrincipal.btnGestionProveedores.addActionListener(this);
	this.ventanaPrincipal.btnInventario.addActionListener(this);
	this.ventanaPrincipal.btnVentas.addActionListener(this);
	this.ventanaPrincipal.btnReportes.addActionListener(this);
	this.ventanaPrincipal.btnAbonos.addActionListener(this);
	this.ventanaPrincipal.btnSalir.addActionListener(this); 
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaPrincipal.btnPerfil) {
			ventanaPerfil = new VentanaPerfil();
			controladorPerfil= new ControladorPerfil(ventanaPerfil,empleado);
			controladorPerfil.ponerInformacionUsuario();
			mostrarPanel(ventanaPerfil);
			
		}
		
		if(e.getSource() == ventanaPrincipal.btnGestionUsuarios) {
			ventanaGestionUsuarios = new VentanaGestionUsuarios();
			controladorGestionUsuarios = new ControladorGestionUsuarios(ventanaGestionUsuarios);
			mostrarPanel(ventanaGestionUsuarios);
		}
		
		if(e.getSource() == ventanaPrincipal.btnGestionClientes) {
			ventanaGestionClientes = new VentanaGestionClientes();
			controladorGestionClientes = new ControladorGestionClientes(ventanaGestionClientes);
			mostrarPanel(ventanaGestionClientes);
		}
	
		if(e.getSource() == ventanaPrincipal.btnGestionProveedores) {
			ventanaGestionProveedores = new VentanaGestionProveedores();
			controladorGestionProveedores = new ControladorGestionProveedores(ventanaGestionProveedores);
			mostrarPanel(ventanaGestionProveedores);
		}
	
		if(e.getSource() == ventanaPrincipal.btnInventario) {
			ventanaGestionInventario = new VentanaGestionInventario();
			controladorGestionInventario  = new ControladorGestionInventario(ventanaGestionInventario);
			//controlador gestion inventario
			mostrarPanel(ventanaGestionInventario);
			
		}
	
		if(e.getSource() == ventanaPrincipal.btnVentas) {
			ventanaVentas = new VentanaVentas();
			controladorVentas = new ControladorVentas(ventanaVentas, ventanaPrincipal, empleado);
			mostrarPanel(ventanaVentas);
		}
	
		if(e.getSource() == ventanaPrincipal.btnAbonos) {
			ventanaAbonos = new VentanaAbonosReservas();
			controladorAbonosReservas = new ControladorAbonosReservas(ventanaAbonos, empleado);
			mostrarPanel(ventanaAbonos);
		}
		
		if(e.getSource() == ventanaPrincipal.btnReportes) {
			ventanaInformes = new VentanaInformes();
			controladorInformes = new ControladorInformes(ventanaInformes);
			mostrarPanel(ventanaInformes);
		}
		
	
		if(e.getSource() == ventanaPrincipal.btnSalir) {
			ventanaPrincipal.dispose();
		}
	}
	
	
	
	public void mostrarPanel(JPanel panel) {
		
		panel.setSize(885, 485);
		panel.setLocation(0, 0);
		ventanaPrincipal.panelPrincipalVentanas.removeAll();
		ventanaPrincipal.panelPrincipalVentanas.add(panel);
		ventanaPrincipal.panelPrincipalVentanas.revalidate();
		ventanaPrincipal.panelPrincipalVentanas.repaint();
	}


}
