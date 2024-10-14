package apps;


import controladores.ControlCentral;
import datos.Grafo;
import vista.Mapa;

public class Main {
	
	public static void main(String[] args) {

		Mapa vista = new Mapa();
		Grafo logica = new Grafo();
		ControlCentral control = new ControlCentral(vista,logica);
		vista.visible();
	
	}

}
