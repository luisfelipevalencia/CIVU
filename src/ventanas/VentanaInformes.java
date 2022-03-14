package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaInformes extends JPanel {

	public JButton btnReporteVentasDiario;
	public JButton btnReporteVentasMensual;
	public JButton btnReporteInventario;
	public JButton btnReporteProveedores;
	public JButton btnReporteClientes;
	private JLabel lblNewLabel_2;
	

	/**
	 * Create the panel.
	 */
	public VentanaInformes() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reporte de Ventas Diario");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 67, 186, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Reporte de Clientes");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(30, 224, 186, 25);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Reporte de Proveedores");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, 275, 186, 25);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Reporte de Inventario");
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(30, 174, 186, 25);
		add(lblNewLabel_1_3);
		
		btnReporteVentasDiario = new JButton("GENERAR");
		btnReporteVentasDiario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnReporteVentasDiario.setForeground(Color.WHITE);
		btnReporteVentasDiario.setBorder(null);
		btnReporteVentasDiario.setBackground(new Color(0,51,153));
		btnReporteVentasDiario.setBounds(228, 67, 113, 25);
		add(btnReporteVentasDiario);
		
		btnReporteVentasMensual = new JButton("GENERAR");
		btnReporteVentasMensual.setForeground(Color.WHITE);
		btnReporteVentasMensual.setFont(new Font("Roboto", Font.BOLD, 12));
		btnReporteVentasMensual.setBorder(null);
		btnReporteVentasMensual.setBackground(new Color(0, 51, 153));
		btnReporteVentasMensual.setBounds(228, 121, 113, 25);
		add(btnReporteVentasMensual);
		
		btnReporteInventario = new JButton("GENERAR");
		btnReporteInventario.setForeground(Color.WHITE);
		btnReporteInventario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnReporteInventario.setBorder(null);
		btnReporteInventario.setBackground(new Color(0, 51, 153));
		btnReporteInventario.setBounds(228, 174, 113, 25);
		add(btnReporteInventario);
		
		btnReporteProveedores = new JButton("GENERAR");
		btnReporteProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReporteProveedores.setForeground(Color.WHITE);
		btnReporteProveedores.setFont(new Font("Roboto", Font.BOLD, 12));
		btnReporteProveedores.setBorder(null);
		btnReporteProveedores.setBackground(new Color(0, 51, 153));
		btnReporteProveedores.setBounds(228, 275, 113, 25);
		add(btnReporteProveedores);
		
		btnReporteClientes = new JButton("GENERAR");
		btnReporteClientes.setForeground(Color.WHITE);
		btnReporteClientes.setFont(new Font("Roboto", Font.BOLD, 12));
		btnReporteClientes.setBorder(null);
		btnReporteClientes.setBackground(new Color(0, 51, 153));
		btnReporteClientes.setBounds(228, 224, 113, 25);
		add(btnReporteClientes);
		
		lblNewLabel_2 = new JLabel("Reporte de Ventas Mensual");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_2.setBounds(30, 121, 186, 25);
		add(lblNewLabel_2);

	}
	

	
	
}
