package vista;
import java.awt.EventQueue;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Mapa {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panelMapa;
	private JPanel panelDeControl;
	private JMapViewer mapa;
	private ArrayList <Coordinate> coordenadas;
	private JButton btnComunicacion;
	private JButton btnBorrarComunicacion;
	private JButton btnDibujarGrafo;
	private JButton btnBorrarGrafo;
	private JButton btnCaminoMinimo;
	private JButton btnBorrarEspia;
	private JButton btnBorrarEspiaDos;
	private JPanel PanelCreacionEspias;
	private JPanel BarraSuperior;
	private JTextField txtNombreEspia;
	private JButton CrearEspia;
	private JButton CancelarCreacion;
	private JLabel TextoCreacionEspia;
	private Coordinate coordenadasTemporal;
	
	private JComboBox <String>comboBox;
	private List<String> nombresEspias;
	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrueba window = new VistaPrueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
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
		configurarFrame();
		
		panelMapa = new JPanel();
		configurarPanelMapa();

		
		panelDeControl = new JPanel();
		configurarPanelDeControl();
		
		
		mapa = new JMapViewer();
		mapa.setBounds(238, 5, 496, 427);
		
		comboBox = new JComboBox();
		configurarComboBox();
		
		nombresEspias = null;
		
		
		
		comboBox.addItem("Listado de Espias");
		panelDeControl.add(comboBox);
		
		textField = new JTextField();
		configurarTxtArriba();
		
		textField_1 = new JTextField();
		configurarTxtAbajo();
		
		btnComunicacion = new JButton("Establecer comunicacion");
		configurarBtnComunicacion();

		
		btnBorrarComunicacion = new JButton("Borrar comunicacion");
		configurarBtnBorrarComunicacion();

		
		btnDibujarGrafo = new JButton("Dibujar Grafo");
		configurarBtnDibujarGrafo();

		
		btnBorrarGrafo = new JButton("Borrar grafo");
		configurarBtnBorrarGrafo();

		
		btnCaminoMinimo = new JButton("Buscar camino minimo");
		configurarBtnCaminoMinimo();

		
		btnBorrarEspia = new JButton("X");
		configurarBtnBorrarEspia();

		
		btnBorrarEspiaDos = new JButton("X");
		configurarBtnBorrarEspiaDos();

		
		PanelCreacionEspias = new JPanel();
		configurarPanelCreacionEspias();

		
		BarraSuperior = new JPanel();
		configurarPanelBarraSuperior();

		
		txtNombreEspia = new JTextField();
		configurarTxtNombreEspia();

		
		TextoCreacionEspia = new JLabel("¿Desea crear un espía?");
		configurarLblDeseaCrearUnEspia();
		
		CrearEspia = new JButton("Crear");
		configurarBtnCrear();
		
		CancelarCreacion = new JButton("Cancelar");
		configurarBtnCancelar();
		
		ocultarPanelCreacionEspia();
		configurarMapa();
		
	}
	
	



	
	public Coordinate coordenadaDeInicio() {

		Coordinate coordenadaInicio = new Coordinate(-34.521, -58.7008);
		
		return coordenadaInicio;
	}
	
	
	public void AccionClickEnMapa(MouseListener accion) {
		this.mapa.addMouseListener(accion);
	}
	
	private void mostrarPanelCreacionEspia() {
		this.PanelCreacionEspias.setVisible(true);
	}
	
	public void ocultarPanelCreacionEspia() {
		this.PanelCreacionEspias.setVisible(false);
	}
	
	public void BotonEstablecerComunicacion(ActionListener accion) {
		this.btnComunicacion.addActionListener(accion);
	}
	
	public void botonBorrarComunicacion(ActionListener accion) {
		this.btnBorrarComunicacion.addActionListener(accion);
	}
	
	public void CrearNuevoEspia(ActionListener evento) {
		this.CrearEspia.addActionListener(evento);
	}
	
	public void btnBorrarEspia(ActionListener evento) {
		this.btnBorrarEspia.addActionListener(evento);
	}
	
	public void borrarStringEnTextField() {
		textField.setText(null);
	}
	
	public void btnBorrarEspiaDos(ActionListener evento) {
		this.btnBorrarEspiaDos.addActionListener(evento);
	}
	public void borrarStrinEnTextField_1() {
		textField_1.setText(null);
	}
	
	public void obtenerElementosDelComboBox(ActionListener accion) {
		comboBox.addActionListener(accion);
	}
	
	public void llenarLosCamposDeTexto() {
		if(comboBox.getSelectedIndex() == 0) {
			return;
		}
		String nombreEspia = (String) comboBox.getSelectedItem();
		ocuparEspaciosVacios(nombreEspia);
	}
	
	private void ocuparEspaciosVacios(String nombreEspia) {
		if(textField.getText().isBlank()) {
			textField.setText(nombreEspia);
		}
		else {
			textField_1.setText(nombreEspia);
		}
	}
	
	private void guardarCoordenadasClick(Coordinate clickMapa) {
		this.coordenadasTemporal = clickMapa;
	}
	
	
	public void crearPunto(String nombreEspia,Coordinate NuevasCoordenadas) {
		
		Coordinate puntoNuevo = NuevasCoordenadas;
			this.mapa.addMapMarker(agregarPuntoEnElMapa(nombreEspia,NuevasCoordenadas));
		
	}
	
	private MapMarker agregarPuntoEnElMapa(String nombreEspia, Coordinate agregarMarcador) {
		MapMarker punto = new MapMarkerDot(nombreEspia, agregarMarcador);
		
		return punto;
	}
	
	public String ObetenerNombreEspia() {	
		return this.txtNombreEspia.getText();
	}
	
	public Coordinate ObtenerCoordenadasClick() {
		return this.coordenadasTemporal;
	}
	
	private void CancelarCreacionEspia() {
		this.CancelarCreacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				ocultarPanelCreacionEspia();
			}		
			
		});
		
	}
	
	public void MostrarPantallaDeCracionEspias(MouseEvent e) {
		mostrarPanelCreacionEspia();
		guardarCoordenadasClick((Coordinate) this.mapa.getPosition(e.getPoint()));	
		CancelarCreacionEspia();		
		
	}
	
	public boolean seEncuentraEnComboBox(String valor) {
		boolean existe = false;
		for(int i =0; i<comboBox.getItemCount();i++) {
			
			if(comboBox.getItemAt(i).equals(valor)) {
				existe = true;
			}
			
			
		}
		return existe;
	}
	
	public void verificarQueLosCamposNoEstenVacios() {
		if(textField.getText().isBlank() || textField_1.getText().isBlank()) {
			JOptionPane.showMessageDialog(frame, "Ambos campos  de texto deben estar llenos");
		}
	}
	
	public void IngresarEspiaAlListadoDesplegable(List <String> espia) {
		
		for(String valor : espia ) {
			if(!(seEncuentraEnComboBox(valor))) {
			this.comboBox.addItem(valor);
			}}
	}
	
	public void borrarNombreEspia() {
		this.txtNombreEspia.setText("");	
	}
	
	private void configurarBtnCancelar() {
		CancelarCreacion.setBounds(156, 150, 89, 23);
		PanelCreacionEspias.add(CancelarCreacion);
	}
	
	private void configurarBtnCrear() {
		CrearEspia.setBounds(33, 150, 89, 23);
		PanelCreacionEspias.add(CrearEspia);
	}
	
	private void configurarLblDeseaCrearUnEspia() {
		TextoCreacionEspia.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TextoCreacionEspia.setBounds(33, 41, 261, 33);
		PanelCreacionEspias.add(TextoCreacionEspia);
	}
	
	private void configurarTxtNombreEspia() {
		txtNombreEspia.setText("");
		txtNombreEspia.setBounds(33, 85, 243, 43);
		PanelCreacionEspias.add(txtNombreEspia);
		txtNombreEspia.setColumns(10);
	}
	
	private void configurarPanelBarraSuperior() {
		BarraSuperior.setBackground(new Color(0, 0, 139));
		BarraSuperior.setBounds(0, 0, 304, 30);
		PanelCreacionEspias.add(BarraSuperior);
	}
	
	private void configurarPanelCreacionEspias() {
		PanelCreacionEspias.setBackground(Color.WHITE);
		PanelCreacionEspias.setBounds(268, 144, 304, 199);
		mapa.add(PanelCreacionEspias);
		PanelCreacionEspias.setLayout(null);
	}
	
	private void configurarBtnBorrarEspiaDos(){
		btnBorrarEspiaDos.setBounds(144, 135, 62, 23);
		panelDeControl.add(btnBorrarEspiaDos);
	}
	
	private void configurarBtnBorrarEspia() {
		btnBorrarEspia.setBounds(144, 94, 62, 23);
		panelDeControl.add(btnBorrarEspia);
	}
	
	private void configurarBtnCaminoMinimo() {
		btnCaminoMinimo.setBounds(29, 327, 157, 30);
		panelDeControl.add(btnCaminoMinimo);
	}
	
	private void configurarBtnBorrarGrafo() {
		btnBorrarGrafo.setBounds(29, 286, 157, 30);
		panelDeControl.add(btnBorrarGrafo);
	}
	
	private void configurarBtnDibujarGrafo() {
		btnDibujarGrafo.setBounds(29, 245, 157, 30);
		panelDeControl.add(btnDibujarGrafo);
		
	}

	private void configurarBtnBorrarComunicacion() {
		btnBorrarComunicacion.setBounds(29, 204, 157, 30);
		panelDeControl.add(btnBorrarComunicacion);
		
	}

	private void configurarBtnComunicacion() {
		btnComunicacion.setBounds(29, 167, 157, 30);
		panelDeControl.add(btnComunicacion);
		
	}

	private void configurarTxtAbajo() {
		textField_1.setBounds(10, 136, 122, 20);
		textField_1.setText("");
		panelDeControl.add(textField_1);
		textField_1.setColumns(10);
		
	}

	private void configurarTxtArriba() {	
		textField.setBounds(10, 95, 122, 20);
		textField.setText("");
		panelDeControl.add(textField);
		textField.setColumns(10);
	}
	
	private void configurarPanelDeControl() {
		panelDeControl.setBackground(new Color(0, 0, 139));
		panelDeControl.setBounds(873, 0, 226, 471);
		frame.getContentPane().add(panelDeControl);
		panelDeControl.setLayout(null);
		
	}

	private void configurarPanelMapa() {
		panelMapa.setBackground(Color.PINK);
		panelMapa.setBounds(0, 0, 876, 471);
		frame.getContentPane().add(panelMapa);
		
	}

	private void configurarComboBox() {
		comboBox.setBounds(10, 41, 196, 30);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
	}
	
	private void configurarFrame() {
		frame.setBounds(100, 100, 1113, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	private void configurarMapa() {
		mapa.setDisplayPosition(coordenadaDeInicio(), 5);
		mapa.setBounds(0, 0, panelMapa.getWidth(), panelMapa.getHeight());
		panelMapa.setLayout(null);
		this.panelMapa.add(mapa);
		
	}
	
	public void actualizarVistaMapa() {
		this.mapa.revalidate();
	}
	
	public void visible() {
		this.frame.setVisible(true);
	}
}