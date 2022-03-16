package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ventanas.VentanaGestionInventario;
import ventanas.VentanaVentas;

public class ConsultaVentas extends Conexion{
	
	
	
	 public void poblarTablaItemVentas(JTable table) {
	    	
	    	
	        Connection con = getConnection();
	        String sql = "SELECT * FROM producto ORDER BY id_producto";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	
	        	
	        	int id = rs.getInt("id_producto");
	        	int cantidad = rs.getInt("cantidad_producto");
	        	int precioUnidad = rs.getInt("precio_unidad_producto");
	        	int costoUnidad = rs.getInt("costo_unidad_producto");
	        	int idProveedor = rs.getInt("id_proveedor");
	        	String tipo = rs.getString("tipo_calzado");
	        	String marca = rs.getString("marca_producto");
	        	String talla = rs.getString("talla_producto");
	        	String color = rs.getString("color_producto");
	        	String referencia = rs.getString("referencia_producto");
	        	String genero = rs.getString("genero_producto");
	        	
	        	
	        	Object tbData[] = {id, referencia, cantidad, precioUnidad};
	        	
	        	DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
	        	
	        	tblModel.addRow(tbData);
	           }
	        	
	           
	        }catch(SQLException e) {
	            System.err.println(e);

	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    	
	    }
	
	
	public void traerNumeroConsecutivoVentas(int numeroVentas) {
		
        Connection con = getConnection();
        String sql = "SELECT * FROM contador_ventas";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
           
           while(rs.next()){
        	   
        	numeroVentas = rs.getInt("numero_venta");

           }
        	
           
        }catch(SQLException e) {
            System.err.println(e);

        } finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }

	}
	
	
	public boolean registrarVenta(VentanaVentas ventanaVentas, int idEmpleado){
		
		int cedulaCliente = Integer.parseInt(ventanaVentas.textFieldIdCliente.getText());
		int cedulaEmpleado = idEmpleado;
		LocalDate date = LocalDate.now();
		Date fechaVenta = Date.valueOf(date);
		int descuento;
		if(ventanaVentas.textFieldDescuento.getText().isEmpty()) {
			descuento = 0;
		}else {
			descuento = Integer.parseInt(ventanaVentas.textFieldDescuento.getText());
		}
		int totalVenta = Integer.parseInt(ventanaVentas.textFieldTotal.getText());
		
			
			
			Connection con = getConnection();
	        String sql = "INSERT INTO ventas (cedula_cliente, cedula_empleado, fecha_venta, descuento_venta, total_venta)"
	        		+ "values ('"+cedulaCliente+"', '"+cedulaEmpleado+"','"+fechaVenta+"','"+descuento+"','"+totalVenta+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro exitoso");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Registro fallido");
	         	   return false;
	            }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
        
    }
	
	
    public void actualizarCantidades(VentanaVentas ventanaVentas){
    	
    	int numeroFilas = ventanaVentas.table.getRowCount();
    	
    	for(int i=0; i<numeroFilas;i++) {
		
			Connection con = getConnection();
			
			int idItem = (int) ventanaVentas.table.getValueAt(i, 0);
			int cantidad = (int) ventanaVentas.table.getValueAt(i, 2);
			
			
				
			String sql = "UPDATE producto SET cantidad_producto=cantidad_producto-'"+cantidad+"' WHERE id_producto='"+idItem+"'";
			        	
				
		        try{
		        	
		        	Statement st = con.createStatement();
		            int ejecucion = st.executeUpdate(sql);
		            
		            if(ejecucion != 0) {
		         	   JOptionPane.showMessageDialog(null, "Cantidad de producto actualizada");
		         	   //return true;
		            }else {
		         	   JOptionPane.showMessageDialog(null, "Cambio fallido, no se pudo actualizar la cantidad");
		         	   //return false;
		            }
		           
		           
		        }catch(SQLException e) {
		            System.err.println(e);
		           // return false;
		        } finally{
		            try{
		                con.close();
		            }catch (SQLException e){
		                System.err.println(e);
		            }
		        }
        
    	}
    }
    
    
    
	public void registrarDetalleVenta(VentanaVentas ventanaVentas){
		
		int numeroFilas = ventanaVentas.table.getRowCount();
		int idVenta = obtenerIdVenta();
		
		for(int i=0; i<numeroFilas;i++) {
			
			int idProducto = (int) (ventanaVentas.table.getValueAt(i,0));
			int cantidad = (int) (ventanaVentas.table.getValueAt(i,2));
					
			Connection con = getConnection();
			
	        String sql = "INSERT INTO detalle_ventas (id_venta, id_producto, cantidad)"
	        		+ "values ('"+idVenta+"', '"+idProducto+"','"+cantidad+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro detalle de venta exitoso");
	         	   
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Registro detalle de venta fallido");
	         	  
	            }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
		}
		
        
    }
    
    
	public int obtenerIdVenta() {
		int idVenta=0;
		
        Connection con = getConnection();
        String sql = "SELECT max(id_venta) as maximo FROM ventas";
        
        try{
        	
        	
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				idVenta = rs.getInt("maximo");
			}

        	
           
        }catch(SQLException e) {
            System.err.println(e);

        } finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
        
        
		return idVenta;
			
	}
	
	
	public boolean registrarReserva(VentanaVentas ventanaVentas, int idEmpleado){
		
		int cedulaCliente = Integer.parseInt(ventanaVentas.textFieldIdCliente.getText());
		int cedulaEmpleado = idEmpleado;
		LocalDate date = LocalDate.now();
		Date fechaReserva = Date.valueOf(date);
		int descuento;
		String estadoReserva = "Activo";
		
		if(ventanaVentas.textFieldDescuento.getText().isEmpty()) {
			descuento = 0;
		}else {
			descuento = Integer.parseInt(ventanaVentas.textFieldDescuento.getText());
		}
		
		int totalReserva = Integer.parseInt(ventanaVentas.textFieldTotal.getText());
		
			
			
			Connection con = getConnection();
	        String sql = "INSERT INTO reservas (cedula_cliente, cedula_empleado, fecha_reserva, saldo_pendiente, estado_reserva, total_reserva, descuento )"
	        		+ "values ('"+cedulaCliente+"', '"+cedulaEmpleado+"','"+fechaReserva+"','"+totalReserva+"', '"+estadoReserva+"','"+totalReserva+"','"+descuento+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Reserva exitosa");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Reserva fallida");
	         	   return false;
	            }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
        
    }
	
	public int obtenerIdReserva() {
		int idReserva=0;
		
        Connection con = getConnection();
        String sql = "SELECT max(id_reserva) as maximo FROM reservas";
        
        try{
        	
        	
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				idReserva = rs.getInt("maximo");
			}

        	
           
        }catch(SQLException e) {
            System.err.println(e);

        } finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
        
        
		return idReserva;
			
	}
	
	
	public int obtenerIdAbono() {
		int idAbono=0;
		
        Connection con = getConnection();
        String sql = "SELECT max(id_abono) as maximo FROM abonos";
        
        try{
        	
        	
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				idAbono = rs.getInt("maximo");
			}

        	
           
        }catch(SQLException e) {
            System.err.println(e);

        } finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
        
        
		return idAbono;
			
	}
	
	
	
	
	
	public void registrarDetalleReserva(VentanaVentas ventanaVentas){
		
		int numeroFilas = ventanaVentas.table.getRowCount();
		int idReserva = obtenerIdReserva();
		
		for(int i=0; i<numeroFilas;i++) {
			
			int idProducto = (int) (ventanaVentas.table.getValueAt(i,0));
			int cantidad = (int) (ventanaVentas.table.getValueAt(i,2));
					
			Connection con = getConnection();
			
	        String sql = "INSERT INTO detalle_reservas (id_reserva, id_producto, cantidad)"
	        		+ "values ('"+idReserva+"', '"+idProducto+"','"+cantidad+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro detalle de reserva exitoso");
	         	   
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Registro detalle de reserva fallido");
	         	  
	            }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
		}

    }
	
	
}
