package datos;

import java.math.BigDecimal;
import java.util.HashMap;

public class Vertice {
	private String nombre;
	private BigDecimal coordenadaX;
	private BigDecimal coordenadaY;
	
	private HashMap <String, Vertice> vertices;
	
	public Vertice (String nombre, BigDecimal coordenadaX, BigDecimal coordenadaY) {
		this.nombre = nombre;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public BigDecimal getCoordX() {
		return this.coordenadaX;
	}
	
	public BigDecimal getCoordY() {
		return this.coordenadaY;
	}

	@Override
	public String toString() {
		StringBuilder vertice = new StringBuilder();
		vertice.append("nombre: " + getNombre());
		vertice.append(System.lineSeparator());
		vertice.append("Coordenada X: " + getCoordX());
		vertice.append(System.lineSeparator());
		vertice.append("Coordenada Y: " + getCoordY());
		
		return vertice.toString();
	}
}