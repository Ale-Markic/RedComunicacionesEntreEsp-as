package controladores;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import datos.Vertice;
import datos.Arista;
import datos.Grafo;
import vista.Mapa;

public class ControlCentral {

	private Mapa vista;
	private Grafo logica;
	
	
	public ControlCentral(Mapa vista,Grafo logica) {
		this.vista= vista;
		this.logica= logica;
		
		vista.BotonEstablecerComunicacion(new accionesdeComunicacion());
		vista.botonBorrarComunicacion(new accionDeBorrarComunicacion());
		vista.obtenerElementosDelComboBox(new accionesDelComboBox());
		vista.btnBorrarEspia(new accionDeBorrarEspiaEnelTextField());
		vista.btnBorrarEspiaDos(new accionDeBorrarEspiaEnElTexField_1());
		vista.BuscarCaminoMinimo(new accionCaminoMinimo());
		
		vista.AccionClickEnMapa(new accionClickDentrodelMapa());
		
		vista.CrearNuevoEspia(new accionCrearEspia());
	}
	
	class accionCaminoMinimo implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent eventoRealizado) {
  		  Set<Arista> mst = logica.kruskal();

	        // Imprimir las aristas del MST
	        for (Arista arista : mst) {
	            System.out.println(arista.toString());
	        }
		}
	}
	
	class accionesDelComboBox implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent eventoRealizado) {
			vista.llenarLosCamposDeTexto();
		}
	}
	
	class accionDeBorrarComunicacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent eventoRealizado) {
			vista.verificarQueLosCamposNoEstenVacios();
		}
	}
	
	class accionesdeComunicacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent eventoRealizado) {
			vista.verificarQueLosCamposNoEstenVacios();
			 double peso = vista.pedirPesoDeLaArista();
			
			if(logica.existeVertice(vista.getNombreEspiaTextField()) && logica.existeVertice(vista.getNombreEspiaTextField_1())) {
				logica.agregarArista(vista.getNombreEspiaTextField(),vista.getNombreEspiaTextField_1(), peso);
				
				
				Vertice espia1 = logica.ObtenerVertice(vista.getNombreEspiaTextField());
				Vertice espia2 = logica.ObtenerVertice(vista.getNombreEspiaTextField_1());
				
				Coordinate coordenada1 = new Coordinate( espia1.getCoordX().doubleValue(),espia1.getCoordY().doubleValue());
				Coordinate coordenada2 = new Coordinate( espia2.getCoordX().doubleValue(),espia2.getCoordY().doubleValue());
				
				vista.dibujarLinea(coordenada1,coordenada2);
				vista.actualizarVistaMapa();
				
			}
		}
	} 
	
	
	class accionCrearEspia implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String nombreEspia = vista.ObetenerNombreEspia(); // Obtener nombre del espía	            
			Coordinate coord = vista.ObtenerCoordenadasClick();
			Vertice nuevoVertice = new Vertice (nombreEspia,BigDecimal.valueOf(coord.getLat()),BigDecimal.valueOf(coord.getLon()));

			if(!logica.existeVertice(nombreEspia)) {

				logica.agregarVertice(nuevoVertice);

				vista.crearPunto(nombreEspia, coord);
				vista.ocultarPanelCreacionEspia();
				vista.borrarNombreEspia();

				vista.IngresarEspiaAlListadoDesplegable(logica.ListaDeEspiasEspias());
				vista.actualizarVistaMapa();

			}	        
		}
	}
	
	class accionDeBorrarEspiaEnElTexField_1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent eventoRealizado) {
			vista.borrarStrinEnTextField_1();
		}
	}
	
	class accionDeBorrarEspiaEnelTextField implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent eventoRelizado) {
			vista.borrarStringEnTextField();
		}
	}
	
	class accionClickDentrodelMapa implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {			
			vista.MostrarPantallaDeCracionEspias(e);					
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
		
	
	
}
