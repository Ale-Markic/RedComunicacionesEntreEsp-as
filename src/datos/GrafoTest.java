package datos;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;


public class GrafoTest {
	
	@Test
	public void seIniciaConGrafoVacio() {
		Grafo grafo = new Grafo();
		assertEquals(true,grafo.getAdjList().isEmpty());
	}
	
	@Test
	public void seAgregaVerticeCorrectamente() {
		Vertice vertice = new Vertice("Espia 1", BigDecimal.valueOf(-32.012), BigDecimal.valueOf(12.345));
		Grafo grafo = new Grafo();
		grafo.agregarVertice(vertice);
		
		assertEquals(1, grafo.getAdjList().size());
	}
	
	@Test(expected = RuntimeException.class)
	public void agregarDosVecesElMismoVerticeArrojaError() {
		Vertice vertice = new Vertice("Espia 1", BigDecimal.valueOf(-32.012), BigDecimal.valueOf(12.345));
		Vertice vertice2 = new Vertice("Espia 1", BigDecimal.valueOf(-32.012), BigDecimal.valueOf(12.345));
		Grafo grafo = new Grafo();
		grafo.agregarVertice(vertice);
		grafo.agregarVertice(vertice2);
	}
	
	@Test(expected = RuntimeException.class)
	public void agregarVerticeNullArrojaError() {
		Vertice vertice = null;
		Grafo grafo = new Grafo();
		grafo.agregarVertice(vertice);

	}
}
