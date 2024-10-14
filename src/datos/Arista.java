package datos;

public class Arista {
	private Vertice verticeOrigen;
	private Vertice verticeDestino;
	private double peso; // es la probabilidad de que el enemigo intercepte esta arista
	
	public Arista(Vertice verticeOrigen, Vertice verticeDestino, double peso) {
		revisarEntradaCorrectaDeValores(verticeOrigen, verticeDestino, peso);
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.peso = peso;
	}
	
	
	private void revisarEntradaCorrectaDeValores(Vertice verticeOrigen, Vertice verticeDestino, double peso) {
		if(!(pesoIngresadoEsCorrecto(peso))) {
			throw new RuntimeException("El valor ingresado debe estar entre 0.0 y 1.0");
		}
		if(!(verticesIngresadosSonCorrectos(verticeOrigen, verticeDestino))) {
			throw new RuntimeException("La Arista tiene que tener vertices de destino y origen distintos");
		}
		
		//TAMBIEN DEBERIA VERIFICAR QUE NO SE REPITAN LAS ARISTAS CON UN CICLO FOR O ALGO QUE CONTROLE Y PASE POR TODAS LAS ARISTAS PARA QUE NO SE REPITAN
	}
	
	
	
	private boolean pesoIngresadoEsCorrecto(double peso) {
		if(peso < 0.0 || peso > 1.0) {
			return false;
		}
		return true;
	}
	private boolean verticesIngresadosSonCorrectos(Vertice verticeOrigen, Vertice verticeDestino) {
		if(verticeOrigen == null || verticeDestino == null) {
			return false;
		}
		if(verticeOrigen.equals(verticeDestino)) {
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Arista)) {
			return false;
		}
		Arista aux = (Arista) obj;
		return aux.getPeso() == this.getPeso() && aux.getVerticeOrigen() == this.getVerticeOrigen() && aux.getVerticeDestino() == this.getVerticeDestino();
	}
	
	
	
	public boolean ExisteUnion() {			
		return true;
	}
	
	public Vertice getVerticeOrigen() {
		return this.verticeOrigen;
	}
	public Vertice getVerticeDestino() {
		return this.verticeDestino;
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
