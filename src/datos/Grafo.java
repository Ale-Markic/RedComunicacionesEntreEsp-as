package datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {

	private Map<Vertice, Set<Arista>> adjList;  // Lista de adyacencia

	// Constructor para inicializar el grafo vacío
	public Grafo() {
		this.adjList = new HashMap<>();
	}

	public boolean existeVertice(String  _vertice) {

		for(Vertice vertice : adjList.keySet()) {
			if(vertice.getNombre().equals(_vertice)) {

				return true;
			}
		}
		return false;

	}

	// Método para agregar un vértice al grafo
	public void agregarVertice(Vertice vertice) {

		if(!existeVertice(vertice.getNombre())) {
			adjList.putIfAbsent(vertice, new HashSet<>());
		}
		else {
			throw new RuntimeException("no se puede agregar 2 veces el mismo vertice");
		}
	}

	// Método para agregar una arista entre dos vértices
	public void agregarArista(Vertice origen, Vertice destino, double peso) {
		agregarVertice(origen);
		agregarVertice(destino);

		Arista arista = new Arista(origen, destino, peso);
		adjList.get(origen).add(arista);
		System.out.println(obtenerVecinos(origen).toString());

		// Si es un grafo no dirigido, también agrega la arista en la dirección opuesta
		Arista aristaInversa = new Arista(destino, origen, peso);
		adjList.get(destino).add(aristaInversa);
	}

	public List<String> ListaDeEspiasEspias(){

		List <String> nombres = new ArrayList<String>();

		for(Vertice Obtenernombre: adjList.keySet()) {
			nombres.add(Obtenernombre.getNombre());

		}
		return nombres;

	}

	public void ImprimirNombresVertices() {
		for(Vertice nombres: adjList.keySet()) {
			System.out.print(nombres.getNombre());
		}
	}


	// Obtener los vecinos de un vértice
	public Set<Arista> obtenerVecinos(Vertice vertice) {
		return adjList.get(vertice);
	}

	// Método para imprimir el grafo
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vertice vertice : adjList.keySet()) {
			sb.append(vertice.toString()).append(" -> ");
			for (Arista arista : adjList.get(vertice)) {
				sb.append(arista.toString()).append(", ");
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	public Map<Vertice, Set<Arista>> getAdjList(){
		return this.adjList;
	}

}
