package apps;


import controladores.ControlCentral;
import datos.Grafo;
import vista.Mapa;
import vista.PantallaInformacion;
import vista.PantallaInicio;

public class Main {
	
	public static void main(String[] args) {
		
		PantallaInicio panInicio = new PantallaInicio();
		panInicio.visible();

	}
	
	public static void principal() {
		Mapa vista = new Mapa();
		Grafo logica = new Grafo();
		ControlCentral control = new ControlCentral(vista,logica);
		vista.visible();
	}
	
	public static void panInformacion() {
		PantallaInformacion panInformacion = new PantallaInformacion();
		panInformacion.visible();
	}
}
