package datos;

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;


public class VerticeTest {
	BigDecimal coordX = BigDecimal.valueOf(-32.678);
	BigDecimal coordY = BigDecimal.valueOf(33.453);
	
	
	@Test
	public void happyPathNoDevuelveNingunError() {
		Vertice nuevo = new Vertice("Espia 1", BigDecimal.valueOf(-32.012), BigDecimal.valueOf(12.345));
		
		assertTrue(nuevo.getNombre().equals("Espia 1"));
		assertTrue(nuevo.getCoordX().equals(BigDecimal.valueOf(-32.012)));
		assertTrue(nuevo.getCoordY().equals(BigDecimal.valueOf(12.345)));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void nombreNuloDevuelveError() {
		Vertice nuevo = new Vertice(null, coordX, coordY);
	}
	
	@Test(expected = RuntimeException.class)
	public void nombreVacioDevuelveError() {
		Vertice nuevo = new Vertice("", coordX, coordY);
	}
	
	@Test(expected = RuntimeException.class)
	public void algunaCoordenadaEsNullDevuelveError() {//no deberia pasar nunca pero por las dudas
		Vertice nuevo = new Vertice("espia 1", null, coordY);
	}

}
