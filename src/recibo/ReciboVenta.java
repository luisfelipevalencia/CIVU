package recibo;

import java.io.IOException;

import javax.swing.JTable;
import javax.swing.text.StyleConstants.FontConstants;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;

import modelo.Cliente;
import modelo.ConsultaVentas;
import modelo.Usuario;

public class ReciboVenta {
	
	Usuario Empleado;
	Cliente cliente;
	JTable tabla;
	ConsultaVentas consultaVentas = new ConsultaVentas();
	
	public ReciboVenta(Usuario empleado, Cliente cliente , JTable tabla) {
		this.Empleado = empleado;
		this.cliente = cliente;
		this.tabla = tabla;
	}
	
	public void crearPdf() throws IOException{
		String path = "C:\\Users\\Felipe\\Desktop\\recibo.pdf";
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		
		
		Text title = new Text("CALZADO EZE\n").setBold().setFontSize(20);
		Text title1 = new Text("FACTURA\n\n").setBold().setFontSize(15);
		Text fechaRecibo = new Text("Fecha:\n");
		Text numeroFactura = new Text("Numero de factura:\n");
		Text vendedor = new Text("Vendedor: "+cliente.getNombre()+"\n\n");
		Text title2 = new Text("Informacion del cliente\n").setBold();
		Text nombreCliente = new Text("Nombre:\n");
		Text cedulaCliente = new Text("Cedula:\n");
		
		document.add(new Paragraph().add(title).add(title1).add(fechaRecibo).add(numeroFactura).add(vendedor).add(title2).add(nombreCliente).add(cedulaCliente));
		
		
		
		
		document.close();
	}
	

}
