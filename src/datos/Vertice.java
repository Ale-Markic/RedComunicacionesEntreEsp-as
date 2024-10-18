package datos;

import java.math.BigDecimal;

public class Vertice {
	private String nombre;
	private BigDecimal coordenadaX;
	private BigDecimal coordenadaY;
	
	public Vertice (String nombre, BigDecimal coordenadaX, BigDecimal coordenadaY) {
		validarEntradaDeVertice(nombre, coordenadaX, coordenadaY);
		this.nombre = nombre;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	
	
	private void validarEntradaDeVertice(String nombre, BigDecimal coordenadaX, BigDecimal coordenadaY) {
		if(nombre == null) {
			throw new RuntimeException("ingresar nombre");
		}
		if(nombre == "") {
			throw new RuntimeException("el nombre no puede estar vacio");
		}
		validarCoordenadas(coordenadaX, coordenadaY);
	}
	
	private void validarCoordenadas(BigDecimal coordenadaX, BigDecimal coordenadaY) {
		if(coordenadaX == null || coordenadaY == null) {
			throw new RuntimeException("Esto nunca deberia pasar pero por las dudas");
		}
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