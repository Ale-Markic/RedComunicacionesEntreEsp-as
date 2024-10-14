package controladores;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.Map;

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
		
		vista.AccionClickEnMapa(new accionClickDentrodelMapa());
		
		vista.CrearNuevoEspia(new accionCrearEspia());
		
	
	}
	
	class accionesdeComunicacion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent eventoRealizado) {
			System.out.print("Funcionando");
			//Hay que seguir desde acá
		}
	} 
	
	class accionClickDentrodelMapa implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			
						
			vista.MostrarPantallaDeCracionEspias(e);
						
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
		
	
	    class accionCrearEspia implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            String nombreEspia = vista.ObetenerNombreEspia(); // Obtener nombre del espía	            
	            Coordinate coord = vista.ObtenerCoordenadasClick();
	            Vertice nuevoVertice = new Vertice (nombreEspia,BigDecimal.valueOf(coord.getLon()),BigDecimal.valueOf(coord.getLat()));
	            
	            //Latitud = Y
	            //Longitud X
	            
	            if(!logica.existeVertice(nombreEspia)) {
	            	
	            	
	            	logica.agregarVertice(nuevoVertice);
	            	            	
	            	vista.crearPunto(nombreEspia, coord);
		            vista.ocultarPanelCreacionEspia();
		            vista.borrarNombreEspia();
		            
		            vista.IngresarEspiaAlListadoDesplegable(logica.ListaDeEspiasEspias());
		            logica.ImprimirNombresVertices();
		            vista.actualizarVistaMapa();
	            	
	            }
	            
	               
	        
	        }
	    }
		
		
	
	
}
