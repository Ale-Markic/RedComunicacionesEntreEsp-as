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
		System.out.println("pase por aca");
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

}