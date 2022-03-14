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

import ventanas.VentanaAbonosReservas;
import ventanas.VentanaVentas;

public class ConsultaAbonosReservas extends Conexion {

	
	 public void poblarTablaReservas(JTable table) {
	    	
	    	
	        Connection con = getConnection();
	        String sql = "SELECT * FROM reservas ORDER BY id_reserva";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	int idReserva = rs.getInt("id_reserva");
	        	int cedulaCliente = rs.getInt("cedula_cliente");
	        	int cedulaEmpleado = rs.getInt("cedula_empleado");
	        	Date fechaReserva = rs.getDate("fecha_reserva");
	        	int saldoPendiente = rs.getInt("saldo_pendiente");
	        	String estadoReserva = rs.getString("estado_reserva");
	        	int totalReserva = rs.getInt("total_reserva");
	        	int descuento = rs.getInt("descuento");
	        	

	        	Object tbData[] = {idReserva, cedulaCliente, fechaReserva, saldoPendiente, totalReserva, estadoReserva};
	        	
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
	 
	 
		public boolean registrarAbono(VentanaAbonosReservas ventanaAbonos){
			
			int idReserva = Integer.parseInt(ventanaAbonos.textFieldIdReservaAbonos.getText());
			int cantidad = Integer.parseInt(ventanaAbonos.textFieldCantidadAbono.getText());
			LocalDate date = LocalDate.now();
			Date fechaAbono = Date.valueOf(date);
			
				
				
				Connection con = getConnection();
		        String sql = "INSERT INTO abonos (id_reserva, fecha_abono, cantidad_abono)"
		        		+ "values ('"+idReserva+"', '"+fechaAbono+"','"+cantidad+"')";
		        
		        try{
		           
		        	 Statement st = con.createStatement();
		             int ejecucion = st.executeUpdate(sql);
		             
		            if(ejecucion != 0) {
		         	   JOptionPane.showMessageDialog(null, "Registro de abono exitoso");
		         	   return true;
		            }else {
		         	   JOptionPane.showMessageDialog(null, "Registro de abono fallido");
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
	
		public boolean actualizarSaldoPendienteAbono(VentanaAbonosReservas ventanaAbonos){
			
			int idReserva = Integer.parseInt(ventanaAbonos.textFieldIdReservaAbonos.getText());
			int cantidad = Integer.parseInt(ventanaAbonos.textFieldCantidadAbono.getText());

				Connection con = getConnection();
				
				String sql = "UPDATE reservas SET saldo_pendiente=saldo_pendiente-'"+cantidad+"' WHERE id_reserva='"+idReserva+"'";
		        
		        try{
		           
		        	 Statement st = con.createStatement();
		             int ejecucion = st.executeUpdate(sql);
		             
		            if(ejecucion != 0) {
		         	   JOptionPane.showMessageDialog(null, "Saldo pendiente actualizado con exitoso");
		         	   return true;
		            }else {
		         	   JOptionPane.showMessageDialog(null, "Saldo pendiente no pudo ser actualizado");
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
		
		
		
		 public void poblarTablaAbonos(JTable table) {
		    	
		    	
		        Connection con = getConnection();
		        String sql = "SELECT * FROM abonos ORDER BY id_abono";
		        
		        try{
		        	Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
		           
		           while(rs.next()){
		        	   
		        	int idReserva = rs.getInt("id_reserva");
		        	int idAbono = rs.getInt("id_abono");
		        	Date fechaAbono = rs.getDate("fecha_abono");
		        	int cantidadAbono = rs.getInt("cantidad_abono");
		        	

		        	Object tbData[] = {idAbono, idReserva, cantidadAbono,fechaAbono};
		        	
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
		
		 
			public boolean cancelarReservas(VentanaAbonosReservas ventanaAbonos){
				
					int idReserva = Integer.parseInt(ventanaAbonos.textFieldIdReservaAbonos.getText());
					String estadoReserva = "Cancelado";
				
					Connection con = getConnection();
					
					String sql = "UPDATE reservas SET estado_reserva='"+estadoReserva+"' WHERE id_reserva='"+idReserva+"'";
			        
			        try{
			           
			        	 Statement st = con.createStatement();
			             int ejecucion = st.executeUpdate(sql);
			             
			            if(ejecucion != 0) {
			         	   JOptionPane.showMessageDialog(null, "Reserva cancelada con exitoso");
			         	   return true;
			            }else {
			         	   JOptionPane.showMessageDialog(null, "Reserva no pudo ser cancelada");
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
		 
		 
		 public void cancelarReservaActualizarCantidadesProducto(VentanaAbonosReservas ventanaAbonos) {
		    	
			 	int idReserva = Integer.parseInt(ventanaAbonos.textFieldIdReserva.getText());
		    	
		        Connection con = getConnection();
		        String sql = "SELECT * FROM detalle_reservas where id_reserva='"+idReserva+"'";
		        
		        try{
		        	Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					
		           
		           while(rs.next()){
		        	   
		        	int idProducto = rs.getInt("id_producto");
		        	int cantidad = rs.getInt("cantidad");
		        	
		        	Connection con1 = getConnection();
		        	
		        	String sql1 = "UPDATE producto SET cantidad_producto=cantidad_producto+'"+cantidad+"' WHERE id_producto='"+idProducto+"'";
		        	
		        	try{
			        	Statement st1 = con1.createStatement();
						int ejecucion = st1.executeUpdate(sql1);
						
						
						
			            if(ejecucion != 0) {
				         	   JOptionPane.showMessageDialog(null, "Cantidad de producto actualizada");
				         	   //return true;
				            }else {
				         	   JOptionPane.showMessageDialog(null, "Cambio fallido, no se pudo actualizar la cantidad");
				         	   //return false;
				            }
						
			        }catch(SQLException e) {
			            System.err.println(e);

			        } finally{
			            try{
			                con1.close();
			            }catch (SQLException e){
			                System.err.println(e);
			            }
			        }

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
