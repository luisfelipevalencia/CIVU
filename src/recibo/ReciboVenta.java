package recibo;

import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JTable;


import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;

import modelo.ConsultaCliente;
import modelo.ConsultaVentas;
import modelo.Usuario;
import ventanas.VentanaVentas;

public class ReciboVenta {
	
	VentanaVentas ventanaVentas;
	ConsultaVentas consultaVentas = new ConsultaVentas();
	ConsultaCliente consultaCliente = new ConsultaCliente();
	
	public ReciboVenta(VentanaVentas ventanaVentas) {
		this.ventanaVentas=ventanaVentas;
	}
	
	public void crearPdf(Usuario empleado, int idCliente , JTable tabla) throws IOException{
		String path = "C:\\Users\\Felipe\\Desktop\\recibo.pdf";
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		
		PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
		PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		
		String idEmpleado = String.valueOf(empleado.getId());
		String idClient = String.valueOf(idCliente);
		LocalDate fecha = LocalDate.now();
		
		String nombreClient = consultaCliente.obtenerNombreUsuario(idCliente);
		String idVenta = String.valueOf(consultaVentas.obtenerIdVenta());
		
		Text title = new Text("CALZADO EZE\n").setBold().setFontSize(20);
		Text title1 = new Text("FACTURA VENTA\n\n").setBold().setFontSize(15);
		Text fechaRecibo = new Text("Fecha: "+fecha+"\n");
		Text numeroFactura = new Text("Numero de factura: "+idVenta+"\n");
		Text vendedor = new Text("Vendedor: "+idEmpleado+"\n\n");
		Text title2 = new Text("Informacion del cliente\n").setBold();
		Text nombreCliente = new Text("Nombre: "+nombreClient+ "\n");
		Text cedulaCliente = new Text("Cedula: "+idClient+ "\n\n");
		
		 Table table = new Table(new float[] {2,2,2,2,2});
		 table.setWidth(500);
		 
		 adicionarHeaders(table, bold);
		 adicionarElementoJTable(tabla,table);
		 
		 int total = Integer.valueOf(ventanaVentas.textFieldTotal.getText());
		 
		 int descuento = 0;
		 
		 if(ventanaVentas.textFieldDescuento.getText().isEmpty()==false) {
			 
			 descuento = Integer.valueOf(ventanaVentas.textFieldDescuento.getText());
		 }
		 
		 adicionarDescuento(descuento, table);
		 adicionarTotal(total, table);
		
		document.add(new Paragraph().add(title).add(title1).add(fechaRecibo).add(numeroFactura).add(vendedor).add(title2).add(nombreCliente).add(cedulaCliente).add(table));
		
		
		document.close();
	}
	
	
	public void crearPdfReservas(Usuario empleado, int idCliente , JTable tabla) throws IOException{
		String path = "C:\\Users\\Felipe\\Desktop\\recibo.pdf";
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		
		PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
		PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		
		String idEmpleado = String.valueOf(empleado.getId());
		String idClient = String.valueOf(idCliente);
		LocalDate fecha = LocalDate.now();
		
		String nombreClient = consultaCliente.obtenerNombreUsuario(idCliente);
		String idVenta = String.valueOf(consultaVentas.obtenerIdReserva());
		
		Text title = new Text("CALZADO EZE\n").setBold().setFontSize(20);
		Text title1 = new Text("FACTURA RESERVA\n\n").setBold().setFontSize(15);
		Text fechaRecibo = new Text("Fecha: "+fecha+"\n");
		Text numeroFactura = new Text("Numero de factura: "+idVenta+"\n");
		Text vendedor = new Text("Vendedor: "+idEmpleado+"\n\n");
		Text title2 = new Text("Informacion del cliente\n").setBold();
		Text nombreCliente = new Text("Nombre: "+nombreClient+ "\n");
		Text cedulaCliente = new Text("Cedula: "+idClient+ "\n\n");
		
		 Table table = new Table(new float[] {2,2,2,2,2});
		 table.setWidth(500);
		 
		 adicionarHeaders(table, bold);
		 adicionarElementoJTable(tabla,table);
		 
		 int total = Integer.valueOf(ventanaVentas.textFieldTotal.getText());
		 
		 int descuento = 0;
		 
		 if(ventanaVentas.textFieldDescuento.getText().isEmpty()==false) {
			 
			 descuento = Integer.valueOf(ventanaVentas.textFieldDescuento.getText());
		 }
		 
		 adicionarDescuento(descuento, table);
		 adicionarTotal(total, table);
		
		document.add(new Paragraph().add(title).add(title1).add(fechaRecibo).add(numeroFactura).add(vendedor).add(title2).add(nombreCliente).add(cedulaCliente).add(table));
		
		
		document.close();
	}
	
	
	public void adicionarHeaders(Table table, PdfFont font) {
		
		table.addHeaderCell(new Cell().add((new Paragraph("ID")).setFont(font)));
		table.addHeaderCell(new Cell().add((new Paragraph("REFERENCIA")).setFont(font)));
		table.addHeaderCell(new Cell().add((new Paragraph("CANTIDAD")).setFont(font)));
		table.addHeaderCell(new Cell().add((new Paragraph("PRECIO")).setFont(font)));
		table.addHeaderCell(new Cell().add((new Paragraph("SUBTOTAL")).setFont(font)));
		
	}
	

	
	public void adicionarElementoJTable (JTable jtable,Table table) {
		
		int numero = jtable.getRowCount();
		for(int i=0;i<numero;i++) {
			
			int id = (int) jtable.getValueAt(i, 0);
			String ref = (String) jtable.getValueAt(i, 1);
			int cantidad = (int) jtable.getValueAt(i, 2);
			int precio = (int) jtable.getValueAt(i, 3);
			int subtotal = (int) jtable.getValueAt(i, 4);
			
		
			table.addCell(new Paragraph(String.valueOf(id)));
			table.addCell(new Paragraph(ref));
			table.addCell(new Paragraph(String.valueOf(cantidad)));
			table.addCell(new Paragraph(String.valueOf(precio)));
			table.addCell(new Paragraph(String.valueOf(subtotal)));
		}	
	}
	
	
	public void adicionarTotal(int total, Table table) {
		table.addCell(new Paragraph(""));
		table.addCell(new Paragraph(""));
		table.addCell(new Paragraph(""));
		table.addCell(new Paragraph("TOTAL").setBold());
		table.addCell(new Paragraph(String.valueOf(total)));
	}
	
	public void adicionarDescuento(int descuento, Table table) {
		table.addCell(new Paragraph(""));
		table.addCell(new Paragraph(""));
		table.addCell(new Paragraph(""));
		table.addCell(new Paragraph("DESCUENTO").setBold());
		table.addCell(new Paragraph(String.valueOf(descuento)));
	}
	

}
