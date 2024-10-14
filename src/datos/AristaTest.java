package datos;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AristaTest {
	Vertice verticeGenerico;
	Vertice verticeNull;
	
	
	@Before
	public void seUp() {
		BigDecimal coordX = BigDecimal.valueOf(-34.0000);
		BigDecimal coordY = BigDecimal.valueOf(32.213);
		Vertice verticeGenerico = new Vertice("Vertice", coordX, coordY);
		Vertice verticeNull = null;
	}
	
	@Test(expected = RuntimeException.class)
	public void crearAristaOrigenNuloDevuelveError() {
		Arista nueva = new Arista(verticeNull, verticeGenerico, 0.5);
	}
	
	@Test(expected = RuntimeException.class)
	public void crearAristaDestinoNuloDevuelveError() {
		Arista nueva = new Arista(verticeGenerico, verticeNull, 0.5);
	}
	
}
