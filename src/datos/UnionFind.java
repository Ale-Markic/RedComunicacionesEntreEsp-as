package datos;


import java.util.HashMap;
import java.util.Map;

public class UnionFind {
	
	   private Map<Vertice, Vertice> parent = new HashMap<>();
	    private Map<Vertice, Integer> rank = new HashMap<>();

	    // Inicializa los conjuntos disjuntos
	    public void makeSet(Vertice v) {
	        parent.put(v, v);
	        rank.put(v, 0);
	    }

	    // Encuentra el representante del conjunto
	    public Vertice find(Vertice v) {
	        if (!parent.get(v).equals(v)) {
	            parent.put(v, find(parent.get(v)));  // Compresión de camino
	        }
	        return parent.get(v);
	    }

	    // Une dos conjuntos
	    public void union(Vertice v1, Vertice v2) {
	        Vertice root1 = find(v1);
	        Vertice root2 = find(v2);

	        if (!root1.equals(root2)) {
	            // Unión por rango
	            if (rank.get(root1) > rank.get(root2)) {
	                parent.put(root2, root1);
	            } else if (rank.get(root1) < rank.get(root2)) {
	                parent.put(root1, root2);
	            } else {
	                parent.put(root2, root1);
	                rank.put(root1, rank.get(root1) + 1);
	            }
	        }
	    }

}
