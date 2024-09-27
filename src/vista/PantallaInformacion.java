package vista;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PantallaInformacion {
	
	private JFrame _frameInformacion;
	private JTextArea areaDeTexto;
	
	
	public PantallaInformacion() {
		initialize();
	}
	
	public void initialize() {
		inicializarElFrame();
		
		JPanel panel = new JPanel();
		configurarPanel(panel);

		
		
		areaDeTexto = new JTextArea();
		inicializarAreaDeTexto(panel);
		
		cargarArchivoConInformacion(panel);
		
		configurarVolverAtras(panel);
		
		
		_frameInformacion.getContentPane().add(panel);
		_frameInformacion.setVisible(true);
		

	}
	
	
	private void cargarArchivoConInformacion(JPanel panel) {
		String rutaArchivoConInformacion = "/recursos/prueba.txt";
		InputStream inputStream = getClass().getResourceAsStream(rutaArchivoConInformacion);
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
			String linea;
			while((linea = reader.readLine()) != null) {
				areaDeTexto.append(linea);
			}
		} catch(IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al leer el archivo: " ,e.getMessage(), JOptionPane.ERROR_MESSAGE);
			_frameInformacion.dispose();
		}
		panel.add(areaDeTexto);
	}
	
	
	private void configurarVolverAtras(JPanel panel) {
		JButton volverAtras = new JButton("volver atras");
		volverAtras.setBounds(225, 350, 200, 61);
		panel.add(volverAtras);
		
		volverAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaInicio pantallaInicio = new PantallaInicio();
				_frameInformacion.dispose();
			}
		});
		
	}
	
	private void configurarPanel(JPanel panel) {
		
		panel.setBackground(setearColorDelFondo());
		panel.setLayout(null);
		panel.setBounds(0, 0, 700, 500);
	}
	
	private void inicializarAreaDeTexto(JPanel panel) {
		areaDeTexto.setBounds(85, 25, 500, 300);
		areaDeTexto.setEditable(false);
		areaDeTexto.setLineWrap(true);
		areaDeTexto.setWrapStyleWord(true);
		areaDeTexto.setFont(new Font("Arial", Font.BOLD, 15));
	}
	
	private void inicializarElFrame() {
		_frameInformacion = new JFrame("Informacion");
		_frameInformacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_frameInformacion.setBounds(0, 0, 700, 500);
		_frameInformacion.setResizable(false);
		_frameInformacion.getContentPane().setLayout(null);
		_frameInformacion.setLocationRelativeTo(null);

	}
	private Color setearColorDelFondo() {
		Color colorFondo = new Color(194, 113, 138);		
		return colorFondo;
	}

}
