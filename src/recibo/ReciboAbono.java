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
import ventanas.VentanaAbonosReservas;
import ventanas.VentanaVentas;




public class ReciboAbono {

	
	VentanaAbonosReservas ventanaAbonos;
	ConsultaVentas consultaVentas = new ConsultaVentas();
	ConsultaCliente consultaCliente = new ConsultaCliente();
	
	public ReciboAbono(VentanaAbonosReservas ventanaAbonos) {
		this.ventanaAbonos = ventanaAbonos;
	}
	
	
	
	
	public void crearPdfAbono(Usuario empleado) throws IOException{
		String path = "C:\\Users\\Felipe\\Desktop\\reciboAbono.pdf";
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		
		PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
		PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		
		String reserva =ventanaAbonos.textFieldIdReservaAbonos.getText();
		int idReserva = Integer.parseInt(reserva);
		
		
		int identCliente = consultaCliente.obtenerIdCliente(idReserva);
		
		String idEmpleado = String.valueOf(empleado.getId());
		String idClient = String.valueOf(identCliente);
		
		String cantidadAbono = ventanaAbonos.textFieldCantidadAbono.getText();
		
		LocalDate fecha = LocalDate.now();
		
		String nombreClient = consultaCliente.obtenerNombreUsuario(identCliente);
		String idAbono = String.valueOf(consultaVentas.obtenerIdAbono());
		
		Text title = new Text("CALZADO EZE\n").setBold().setFontSize(20);
		Text title1 = new Text("ABONO\n\n").setBold().setFontSize(15);
		Text fechaRecibo = new Text("Fecha: "+fecha+"\n");
		Text numeroAbono = new Text("ID Abono: "+idAbono+"\n");
		Text vendedor = new Text("Vendedor: "+idEmpleado+"\n\n");
		Text title2 = new Text("Informacion del cliente\n").setBold();
		Text nombreCliente = new Text("Nombre: "+nombreClient+ "\n");
		Text cedulaCliente = new Text("Cedula: "+idClient+ "\n\n");
		Text montoAbono = new Text("ID Reserva: "+reserva+ "   " + "Cantidad: $"+cantidadAbono+"\n");
		
		/*
		 Table table = new Table(new float[] {2,2,2,2,2});
		 table.setWidth(500);
		 
		 adicionarHeaders(table, bold);
		 adicionarElementoJTable(tabla,table);
		 */
		 
		
		document.add(new Paragraph().add(title).add(title1).add(fechaRecibo).add(numeroAbono).add(vendedor).add(title2).add(nombreCliente).add(cedulaCliente).add(montoAbono));
		
		
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
