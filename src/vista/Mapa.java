package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

public class Mapa {

	private JFrame frame;
	private JMapViewer mapa;
	private JPanel panelMapa;
	private ArrayList <Coordinate> coordenadas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa window = new Mapa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mapa() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		inicializarFrame();
		
		panelMapa = new JPanel();
		configurarPanelMapa();
		
		mapa = new JMapViewer();
		configurarMapa();
		
		
		
		detectarCoordenada();
		
		frame.setVisible(true);
	}
	
	
	private void detectarCoordenada() {
		coordenadas = new ArrayList<Coordinate>();
		
		mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					Coordinate agregarMarcador = (Coordinate) mapa.getPosition(e.getPoint());
					coordenadas.add(agregarMarcador);
					String nombreEspia = JOptionPane.showInputDialog("Nombre del espia: ");
					mapa.addMapMarker(agregarPuntoEnElMapa(nombreEspia, agregarMarcador));
				}
			}
			
		});
		
	}
	
	private MapMarker agregarPuntoEnElMapa(String nombreEspia, Coordinate agregarMarcador) {
		MapMarker punto = new MapMarkerDot(nombreEspia, agregarMarcador);
		
		return punto;
	}
	
	private void configurarPanelMapa() {
		panelMapa.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panelMapa.setBackground(setearColorDeFondo());
		
		frame.add(panelMapa);
	}
	
	private void configurarMapa() {
		mapa.setDisplayPosition(coordenadaDeInicio(), 5);
		mapa.setSize(panelMapa.getWidth() - 250, panelMapa.getHeight());

		
		frame.getContentPane().add(mapa);
	}
	
	
	
	private void inicializarFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mapa");
		frame.getContentPane().setLayout(null);
		
		//Obtener el dispositivo grafico y poner el JFrame en pantalla completa
		GraphicsDevice dispositivoGrafico = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		dispositivoGrafico.setFullScreenWindow(frame);
		
	}
	
	private Coordinate coordenadaDeInicio() {
		Coordinate coordenadaInicio = new Coordinate(-34.521, -58.7008);
		
		return coordenadaInicio;
	}
	private Color setearColorDeFondo() {
		Color colorFondo = new Color(255, 191, 0);
		
		return colorFondo;
	}

}
