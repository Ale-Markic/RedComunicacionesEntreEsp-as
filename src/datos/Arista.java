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
	
	
	public double getPeso() {
		return this.peso;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Vertice origen: " + this.verticeOrigen );
		str.append("Vertice destino: " + this.verticeDestino);
		str.append("Probabilidad de que el enemigo intercepte el mensaje: " + getPeso());
		return str.toString();
	}
	

}
