package vista;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import apps.Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaInicio {
	
	private boolean comenzar;
	private JFrame _frame;
	private JPanel _contenido;
	private JLabel _lblImagen;
	private JButton _btnComenzar;
	private JButton _btnInformacion;
	private Timer _temporizador;
	private int _indiceImagen = 0;
	private String [] _imagenes = {
			"/recursos/Imagen espias 1.jpg",
			"/recursos/Imagen espias 2.jpg",
			"/recursos/Imagen mundo 1.jpg",
			"/recursos/Imagen espias 3.jpg",
			"/recursos/Imagen espias 4.jpg",
			"/recursos/Imagen espias 5.jpg",
			"/recursos/Imagen mundo 2.jpg",
			"/recursos/Imagen espias 6.jpg",
			"/recursos/Imagen espias 7.jpg",
			"/recursos/Imagen Argentina conectada con pins.jpg"
	};
	
	/*
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio window = new PantallaInicio();
					window._frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public PantallaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		comenzar = false;
		inicializarElJFrame();
		

		
		_contenido = new JPanel();
		configurarContenido();
		
		_lblImagen = new JLabel();
		configurarImagenes();
		
		configurarBtnComenzar();
		
		_btnInformacion = new JButton("Mas Informacion");
		configurarBtnInformacion();
		
		iniciarTemporizador();
		
		_frame.getContentPane().add(_contenido);
		_frame.setVisible(true);
	}
	
	/**
	 * Metodo principal de encargarse de cambiar las imagenes cada cierto tiempo
	 */
	private void iniciarTemporizador() {
		int intervalo = 3000; //3000ms = 3s
		_temporizador = new Timer(intervalo, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_temporizador.stop();
				desvanecerImagen();
			}
		});
		_temporizador.start();
	}
	
	/**
	 * Cambia la imagen que se ve por pantalla
	 */
	private void cambiarImagen() {
		_indiceImagen ++;
		if(_indiceImagen < _imagenes.length) {
			//Aca se carga la imagen
			ImageIcon icono = new ImageIcon(getClass().getResource(_imagenes[_indiceImagen]));
			Image imagen = icono.getImage();
			_lblImagen.setIcon(new ImageIcon(imagen));
		}
		else {
			reiniciarIndiceImagen();
		}
		agregarBotonesALaImagen();
	}
	
	/**
	 * Metodo encargado de ir opacando la imagen actual. llama a {@link #cambiarImagen()} cuando se 
	 * terminó de opacar la imagen acutal
	 */
	private void desvanecerImagen() {
		Timer desvanecer = new Timer (10, new ActionListener() {
		float opacidad = 1.0f;
			
		@Override
		public void actionPerformed(ActionEvent e) {
			opacidad -= 0.01f;
			if(opacidad <= 0) {
				((Timer) e.getSource()).stop();
				cambiarImagen();
				_temporizador.restart();
			}
			else
			{
				_lblImagen.setIcon(new ImageIcon(aplicarTransparencia(_imagenes[_indiceImagen], opacidad)));
			}
		
		}
		});
		desvanecer.start();
	}
	
	private Image aplicarTransparencia(String rutaImagen, float opacidad) {
		//Cargar la imagen original
		ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
		Image imagen = icono.getImage();
		
		//Crear una imagen cambiada
		BufferedImage imagenCambiada = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D graficos2D = imagenCambiada.createGraphics();
		configurarGraficos2D(graficos2D, opacidad, imagen);
		
		return imagenCambiada;
	}
	
	
	private void configurarGraficos2D(Graphics2D graficos2D, float opacidad, Image imagen) {
		graficos2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacidad));
		graficos2D.drawImage(imagen, 0, 0, null);
		graficos2D.dispose();
	}
	
	private void inicializarElJFrame() {
		_frame = new JFrame("Pantalla de carga");
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		_frame.setLocationRelativeTo(null);
		
		//Obtener el dispositivo grafico y poner el JFrame en pantalla completa
		GraphicsDevice dispositivoGrafico = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		dispositivoGrafico.setFullScreenWindow(_frame);
	}
	
	private void configurarContenido() {
		_contenido.setLayout(null);
		_contenido.setBackground(new Color(0,0,0));
		_contenido.setBounds(0, 0, _frame.getWidth(),_frame.getHeight() );
	}
	
	private void configurarImagenes() {
		_lblImagen.setIcon(new ImageIcon(getClass().getResource(_imagenes[_indiceImagen])));
		_lblImagen.setBounds(110, 50, 1138, 650);
		_contenido.add(_lblImagen);
	}
	
	private void configurarBtnComenzar() {
		_btnComenzar = new JButton("Comenzar");
		_btnComenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.principal();
				_frame.dispose();
			}
		});
		_btnComenzar.setBounds(345, 538, 200, 61);
		_lblImagen.add(_btnComenzar);
	}
	
	private void configurarBtnInformacion() {
		_btnInformacion.setBounds(555,  538, 200, 61);
		_lblImagen.add(_btnInformacion);
		
		_btnInformacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.panInformacion();
				_frame.dispose();
			}
			
		});
	}
	
	public boolean getComenzar() {
		return this.comenzar;
	}
	
	private void agregarBotonesALaImagen() {
		_lblImagen.add(_btnComenzar);
		_lblImagen.add(_btnInformacion);
	}
	
	private void reiniciarIndiceImagen() {
		this._indiceImagen = 0;
	}
	
	public void visible() {
		this._frame.setVisible(true);
	}

}
