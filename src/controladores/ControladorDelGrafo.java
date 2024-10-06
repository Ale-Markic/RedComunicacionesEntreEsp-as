package controladores;

import java.math.BigDecimal;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import datos.Vertice;

public class ControladorDelGrafo {
	
	
	public static void crearVertice(String nombre,Coordinate coordenada) {
		BigDecimal coordenadaX = BigDecimal.valueOf(coordenada.getLat());
		BigDecimal coordenadaY = BigDecimal.valueOf(coordenada.getLon());
		
		crearVertice(nombre, coordenadaX, coordenadaY);
	}
	
	private static void crearVertice(String nombre,BigDecimal coordenadaX, BigDecimal coordenadaY) {
		Vertice nuevo = new Vertice(nombre, coordenadaX, coordenadaY);
	}

}
