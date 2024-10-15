package datos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Grafo {

	private Map<Vertice, Set<Arista>> adjList;  // Lista de adyacencia

	// Constructor para inicializar el grafo vacío
	public Grafo() {
		this.adjList = new HashMap<>();
	}
	
	// Método de Dijkstra para encontrar el camino más corto
    public Map<Vertice, Double> dijkstra(Vertice origen) {
        Map<Vertice, Double> distancias = new HashMap<>();
        PriorityQueue<Vertice> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
        Set<Vertice> procesados = new HashSet<>();

        // Inicializar las distancias
        for (Vertice v : adjList.keySet()) {
            distancias.put(v, Double.MAX_VALUE); // Inicializar con infinito
        }
        distancias.put(origen, 0.0);
        colaPrioridad.add(origen);

        while (!colaPrioridad.isEmpty()) {
            Vertice actual = colaPrioridad.poll();
            if (!procesados.add(actual)) continue; // Si ya fue procesado, lo ignoramos

            for (Arista arista : obtenerVecinos(actual)) {
                Vertice vecino = arista.ObtenerVerticeDestino();
                double nuevaDistancia = distancias.get(actual) + arista.getPeso();

                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    colaPrioridad.add(vecino);
                }
            }
        }
        return distancias;
    }
    
    public Set<Arista> kruskal() {
        Set<Arista> mst = new HashSet<>();
        UnionFind uf = new UnionFind();

        // Inicializar todos los vértices en conjuntos disjuntos
        for (Vertice vertice : adjList.keySet()) {
            uf.makeSet(vertice);
        }

        // Crear una lista de todas las aristas y ordenarlas por peso
        List<Arista> aristas = new ArrayList<>();
        for (Set<Arista> setAristas : adjList.values()) {
            aristas.addAll(setAristas);
        }
        aristas.sort(Comparator.comparingDouble(Arista::getPeso));

        // Procesar cada arista en orden creciente de peso
        for (Arista arista : aristas) {
            Vertice origen = arista.ObtenerVerticeOrigen();
            Vertice destino = arista.ObtenerVerticeDestino();

            // Si los vértices no están en el mismo conjunto, agregamos la arista al MST
            if (uf.find(origen) != uf.find(destino)) {
                mst.add(arista);
                uf.union(origen, destino);
            }
        }

        return mst;
    }

	// Método para agregar una arista entre dos vértices
    public void agregarArista(String origen, String destino, double peso) {
        Vertice verticeOrigen = ObtenerVertice(origen);
        Vertice verticeDestino = ObtenerVertice(destino);

        if (verticeOrigen == null || verticeDestino == null) {
            throw new IllegalArgumentException("Uno o ambos vértices no existen en el grafo.");
        }

        Arista arista = new Arista(verticeOrigen, verticeDestino, peso);
        adjList.get(verticeOrigen).add(arista);

        // Si es un grafo no dirigido, también agrega la arista en la dirección opuesta
        Arista aristaInversa = new Arista(verticeDestino, verticeOrigen, peso);
        adjList.get(verticeDestino).add(aristaInversa);
    }
    
    public void eliminarArista(String origen, String destino) {
        // Obtener los vértices correspondientes a los nombres de origen y destino
        Vertice verticeOrigen = ObtenerVertice(origen);
        Vertice verticeDestino = ObtenerVertice(destino);

        if (verticeOrigen == null || verticeDestino == null) {
            throw new IllegalArgumentException("Uno o ambos vértices no existen en el grafo.");
        }

        // Obtener el conjunto de aristas del vértice de origen
        Set<Arista> aristasOrigen = adjList.get(verticeOrigen);
        Set<Arista> aristasDestino = adjList.get(verticeDestino);

        // Remover la arista que conecta origen -> destino
        aristasOrigen.removeIf(arista -> arista.ObtenerVerticeDestino().equals(verticeDestino));

        // Si es un grafo no dirigido, remover también la arista destino -> origen
        aristasDestino.removeIf(arista -> arista.ObtenerVerticeDestino().equals(verticeOrigen));
    }
    
    public Vertice ObtenerVertice(String nombre) {
        for (Vertice vertice : adjList.keySet()) {
            if (vertice.getNombre().equals(nombre)) {
                return vertice; // Devolver el vértice existente
            }
        }
        return null; // Si no se encuentra, devolver null
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


	// Obtener los vecinos de un vértice
	public Set<Arista> obtenerVecinos(Vertice vertice) {
		return adjList.get(vertice);
	}

	public void verificarValores(Vertice origen, Vertice destino, double peso) {
		if(origen == null || destino == null) {
			throw new RuntimeException("Debe ingresar vertices validos");
		}
		if(peso > 1.0 || peso < 0.0) {
			throw new RuntimeException("Debe ingresar un peso valido");
		}
	}


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
