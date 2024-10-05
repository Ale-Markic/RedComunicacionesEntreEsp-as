package datos;

public class Arista {
	private Vertice verticeOrigen;
	private Vertice verticeDestino;
	private double peso; // es la probabilidad de que el enemigo intercepte esta arista
	
	public Arista (Vertice verticeOrigen, Vertice verticeDestino) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.peso = crearProbabilidadRandom();
	}
	
	
	private double crearProbabilidadRandom() {
		return Math.random();
	}
	

}
