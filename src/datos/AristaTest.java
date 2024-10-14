package datos;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AristaTest {
	Vertice verticeGenerico1;
	Vertice verticeGenerico2;
	Vertice verticeNull;
	Arista happyPath;
	
	
	@Before
	public void setUp() {
		BigDecimal coordX = BigDecimal.valueOf(-34.0000);
		BigDecimal coordX2 = BigDecimal.valueOf(-20.334);
		BigDecimal coordY = BigDecimal.valueOf(32.213);
		BigDecimal coordY2 = BigDecimal.valueOf(33.213);
		Vertice verticeGenerico1 = new Vertice("Vertice", coordX, coordY);
		Vertice verticeGenerico2 = new Vertice("Espia", coordX2, coordY2);
		Vertice verticeNull = null;

	}
	
	@Test(expected = RuntimeException.class)
	public void crearAristaOrigenNuloDevuelveError() {
		Arista nueva = new Arista(verticeNull, verticeGenerico1, 0.5);
	}
	
	@Test(expected = RuntimeException.class)
	public void crearAristaDestinoNuloDevuelveError() {
		Arista nueva = new Arista(verticeGenerico1, verticeNull, 0.5);
	}
	
	@Test(expected = RuntimeException.class)
	public void pesoInvalidoAltoArrojaError() {
		Arista nueva = new Arista(verticeGenerico1, verticeGenerico2, 1.1);
	}
	
	@Test(expected = RuntimeException.class)
	public void pesoInvalidoBajoArrojaError() {
		Arista nueva = new Arista(verticeGenerico1, verticeGenerico2, -0.1);
	}
	
	@Test(expected = RuntimeException.class)
	public void mismoVerticeDeOrigenYDestinoArrojaError() {
		Arista nueva = new Arista(verticeGenerico1, verticeGenerico1, 0.6);
	}
	

	
	@Test
	public void equalsDevuelveTrue() {
		BigDecimal coordX = BigDecimal.valueOf(-34.0000);
		BigDecimal coordX2 = BigDecimal.valueOf(-20.334);
		BigDecimal coordY = BigDecimal.valueOf(32.213);
		BigDecimal coordY2 = BigDecimal.valueOf(33.213);
		Vertice verticeGenerico1 = new Vertice("Vertice", coordX, coordY);
		Vertice verticeGenerico2 = new Vertice("Espia", coordX2, coordY2);
		//AGREGO ESTO OTRA VEZ PORQUE POR ALGUN MOTIVO NO SE INICIALIZA EN EL @BEFORE
		
		Arista nueva = new Arista(verticeGenerico1, verticeGenerico2, 0.4);
		Arista nueva2 = new Arista(verticeGenerico1, verticeGenerico2, 0.4);
		
		assertTrue(nueva.equals(nueva2));
	}
	
	
	
	@Test
	public void equalsDevuelveFalse() {
		BigDecimal coordX = BigDecimal.valueOf(-34.0000);
		BigDecimal coordX2 = BigDecimal.valueOf(-20.334);
		BigDecimal coordY = BigDecimal.valueOf(32.213);
		BigDecimal coordY2 = BigDecimal.valueOf(33.213);
		Vertice verticeGenerico1 = new Vertice("Vertice", coordX, coordY);
		Vertice verticeGenerico2 = new Vertice("Espia", coordX2, coordY2);
		//AGREGO ESTO OTRA VEZ PORQUE POR ALGUN MOTIVO NO SE INICIALIZA EN EL @BEFORE
		
		Arista nueva = new Arista(verticeGenerico1, verticeGenerico2, 0.4);
		Arista nueva2 = new Arista(verticeGenerico1, verticeGenerico2, 0.5);
		
		assertFalse(nueva.equals(nueva2));
	}
	
	
	
}
