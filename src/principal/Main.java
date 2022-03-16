package principal;

import java.io.IOException;

import controlador.ControladorLogin;
import recibo.ReciboVenta;
import ventanas.VentanaLogin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		VentanaLogin ventanaLogin = new VentanaLogin();
		ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
		controladorLogin.iniciar();
		 
		

	}

}
