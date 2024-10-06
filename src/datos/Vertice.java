package datos;

import java.math.BigDecimal;

public class Vertice {
	private String nombre;
	private BigDecimal coordenadaX;
	private BigDecimal coordenadaY;
	
	
	
	
	
	
	
	public Vertice (String nombre, BigDecimal coordenadaX, BigDecimal coordenadaY) {
		this.nombre = nombre;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}