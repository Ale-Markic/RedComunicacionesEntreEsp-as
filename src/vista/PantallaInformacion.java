package vista;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
import javax.swing.JScrollPane;
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
		panel.setLayout(new BorderLayout());
		_frameInformacion.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		areaDeTexto = new JTextArea();
		areaDeTexto.setEditable(false);
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		cargarArchivoConInformacion();
		
		JButton volverAtras = new JButton("volver atras");
		volverAtras.setBounds(550, 638, 200, 61);
		_frameInformacion.getContentPane().add(volverAtras);
		volverAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaInicio pantallaInicio = new PantallaInicio();
				_frameInformacion.dispose();
			}
		});
		
		
		_frameInformacion.setVisible(true);
		

	}
	
	
	public void cargarArchivoConInformacion() {
		String rutaArchivoConInformacion = "/recursos/prueba.txt";
		InputStream inputStream = getClass().getResourceAsStream(rutaArchivoConInformacion);
		
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
			String linea;
			while((linea = reader.readLine()) != null) {
				areaDeTexto.append(linea + "/n");
			}
		} catch(IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al leer el archivo: " ,e.getMessage(), JOptionPane.ERROR_MESSAGE);
			_frameInformacion.dispose();
		}
		_frameInformacion.add(areaDeTexto);
		
		
	}
	
	private void inicializarElFrame() {
		_frameInformacion = new JFrame("Informacion");
		_frameInformacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Obtener el dispositivo grafico y poner el JFrame en pantalla completa
		GraphicsDevice dispositivoGrafico = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		dispositivoGrafico.setFullScreenWindow(_frameInformacion);
	}

}
