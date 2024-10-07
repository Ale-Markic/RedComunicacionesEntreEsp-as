package controladores;

import datos.ArchivosJSON;
import datos.Vertice;


public class ControladorDeArchivos {
	
	public static void crearArchivoDeVertices() {
		ArchivosJSON.crearJsonDeVertices();
	}
	
	public static void crearArchivoDeAristas() {
		ArchivosJSON.crearJsonDeAristas();
	}
	
	public static void agregarVerticeAJSON(Vertice vertice) {
		ArchivosJSON.agregarVertice(vertice);
	}

}
