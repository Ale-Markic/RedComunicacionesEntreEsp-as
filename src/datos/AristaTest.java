package datos;

import static org.junit.Assert.*;
import org.junit.Test;

public class AristaTest {
	
	@Test
	public void crearPesoDeAristaDevuelveTrue() {
		Arista arista = new Arista(null,null);
		double min = 0.0;
		double max = 1.0;
		
		assertTrue(arista.getPeso() >= min && arista.getPeso() <= max);
	}
}
