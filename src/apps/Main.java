package apps;


import controladores.ControlCentral;
import datos.Grafo;
import vista.Mapa;
import vista.PantallaInicio;

public class Main {
	
	public static void main(String[] args) {
		
		//PantallaInicio pan = new PantallaInicio();
		
		
		Mapa vista = new Mapa();
		Grafo logica = new Grafo();
		ControlCentral control = new ControlCentral(vista,logica);
		vista.visible();
	}

}
