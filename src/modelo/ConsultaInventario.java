package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ventanas.VentanaGestionInventario;

public class ConsultaInventario extends Conexion {
	
	
	  public void buscar (String parametroBusqueda, JTextField casilla, JTable table){
		  	
		  
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	      
	        String sql = "SELECT * FROM producto WHERE "+ parametroBusqueda + "='"+casilla.getText()+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           

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
			        	
			        	
			        	Object tbData[] = {id, referencia, idProveedor, cantidad, precioUnidad, costoUnidad, tipo, genero, marca, talla, color};
			        	
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
	  
	  
	  public boolean buscarItemVenta (String idItem, Item item){
		  	
		  	int idArticulo = Integer.valueOf(idItem); 
		  
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	      
	        String sql = "SELECT * FROM producto WHERE id_producto = '"+idArticulo+"'";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           if(rs.next()) {
		          
		        	   item.setId(idArticulo);
		        	   item.setCantidad(rs.getInt("cantidad_producto"));
		        	   item.setPrecioUnidad(rs.getInt("precio_unidad_producto"));
		        	   item.setCostoUnidad(rs.getInt("costo_unidad_producto"));
		        	   item.setIdProveedor(rs.getInt("id_proveedor"));
		        	   item.setTipo(rs.getString("tipo_calzado"));
		        	   item.setMarca(rs.getString("marca_producto"));
		        	   item.setTalla(rs.getString("talla_producto"));
		        	   item.setColor(rs.getString("color_producto"));
		        	   item.setReferencia(rs.getString("referencia_producto"));
		        	   item.setGenero(rs.getString("genero_producto")); 
		        	   
		        return true;	   	   
		           
	          }else {
	        	  
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
	  
	  
	  public void buscarArticulosTablaVentas (String parametroBusqueda, JTextField casilla, JTable table){
		  	
		  
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	      
	        String sql = "SELECT * FROM producto WHERE "+ parametroBusqueda + "='"+casilla.getText()+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           

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
			        	
			        	
			        	Object tbData[] = {id, referencia, cantidad, precioUnidad, talla, color, genero};
			        	
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
	  
	  
	  
	  
	  
	    public boolean confirmarExistenciaUsuario(int id){
	        
	    	int idUsu = id;
	        Connection con = getConnection();
	        String sql = "SELECT * FROM empleados WHERE cedula_empleado='"+idUsu+"'";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(rs+"este es el resultado de rs");
	           
	           if(rs.next()){
	        	   System.out.println("si existe el usuario");
	               return true;
	           }else {
	        	   System.out.println("no existe el usuario");
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
	  
	  
		public boolean registrar(VentanaGestionInventario ventanaGestionInventario){
			
			int cantidad = Integer.parseInt(ventanaGestionInventario.textFieldCantidad.getText());
			int precioUnidad = Integer.parseInt(ventanaGestionInventario.textFieldPrecioUnidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInventario.textFieldCostoUnidad.getText());
			int idProveedor = Integer.parseInt((String) ventanaGestionInventario.comboBoxProveedor.getSelectedItem());
			String tipo = (String) ventanaGestionInventario.comboBoxTipo.getSelectedItem();
			String marca = ventanaGestionInventario.textFieldMarca.getText();
			String talla = (String) ventanaGestionInventario.comboBoxTalla.getSelectedItem();
			String color = (String) ventanaGestionInventario.comboBoxColor.getSelectedItem();
			String referencia = ventanaGestionInventario.textFieldReferencia.getText();
			String genero =(String) ventanaGestionInventario.comboBoxGenero.getSelectedItem();
			
				
				
				
				Connection con = getConnection();
		        String sql = "INSERT INTO producto (cantidad_producto, precio_unidad_producto, costo_unidad_producto, id_proveedor, tipo_calzado, marca_producto, talla_producto, color_producto, referencia_producto, genero_producto)"
		        		+ "values ('"+cantidad+"', '"+precioUnidad+"','"+costoUnidad+"','"+idProveedor+"','"+tipo+"','"+marca+"','"+talla+"','"+color+"','"+referencia+"','"+genero+"')";
		        
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
		
		
	    public boolean eliminar(int id){
	        
	        Connection con = getConnection();
	        int idItem = id;
	        String sql = "DELETE from producto WHERE id_producto='"+idItem+"'";
	        
	        try{
	        	Statement st = con.createStatement();
	            int ejecucion = st.executeUpdate(sql);
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro eliminado");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Error, no se elimino el registro");
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
	    
	    
	    public boolean modificar(VentanaGestionInventario ventanaGestionInventario){
	    	
	    	int fila = ventanaGestionInventario.table.getSelectedRow();
	    	
	    	int id = Integer.parseInt(ventanaGestionInventario.textFieldIdItem.getText());
	    	int cantidad = Integer.parseInt(ventanaGestionInventario.textFieldCantidad.getText());
			int precioUnidad = Integer.parseInt(ventanaGestionInventario.textFieldPrecioUnidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInventario.textFieldCostoUnidad.getText());
			int idProveedor = (Integer) ventanaGestionInventario.comboBoxProveedor.getSelectedItem();
			String tipo = (ventanaGestionInventario.comboBoxTipo.getSelectedItem()).toString();
			String marca = ventanaGestionInventario.textFieldMarca.getText();
			String talla = (ventanaGestionInventario.comboBoxTalla.getSelectedItem()).toString();
			String color = (ventanaGestionInventario.comboBoxColor.getSelectedItem()).toString();
			String referencia = ventanaGestionInventario.textFieldReferencia.getText();
			String genero = (ventanaGestionInventario.comboBoxGenero.getSelectedItem()).toString();
			
			
			Connection con = getConnection();
				
			String sql = "UPDATE producto SET cantidad_producto='"+cantidad+"', precio_unidad_producto='"+precioUnidad+"', costo_unidad_producto='"+costoUnidad+"', id_proveedor='"+idProveedor+"', tipo_calzado='"+tipo+"', marca_producto='"+marca+"', talla_producto='"+talla+"', color_producto='"+color+"', referencia_producto='"+referencia+"', genero_producto='"+genero+"' WHERE id_producto='"+id+"'";
			        	
				
		        try{
		        	
		        	Statement st = con.createStatement();
		            int ejecucion = st.executeUpdate(sql);
		            
		            if(ejecucion != 0) {
		         	   JOptionPane.showMessageDialog(null, "Cambio exitoso");
		         	   return true;
		            }else {
		         	   JOptionPane.showMessageDialog(null, "Cambio fallido");
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
	    
	    
	    public void poblarTabla(JTable table) {
	    	
	    	
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
	        	
	        	
	        	Object tbData[] = {id, referencia, idProveedor, cantidad, precioUnidad, costoUnidad, tipo, genero, marca, talla, color};
	        	
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
	    
	    
	    public void llenarComboBox(JComboBox box) {
	    	
	    	ArrayList<String> lista = new ArrayList<String>();
	    	
	        Connection con = getConnection();
	        String sql = "SELECT * FROM proveedores";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	lista.add(rs.getString("id_proveedor"));
	        		        	
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
	        
	    	for(int i=0; i<lista.size();i++) {
	    		box.addItem(lista.get(i));
	    	}
	    	
	    	
	    }
	    
	    
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
		        	
		        	
		        	Object tbData[] = {id, referencia, cantidad, precioUnidad, talla, color, genero};
		        	
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
	    
	
	
	

}
