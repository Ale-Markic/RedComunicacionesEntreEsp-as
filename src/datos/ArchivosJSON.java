package datos;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArchivosJSON {
	
	
	public static void agregarVertice(Vertice vertice) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = gson.toJson(vertice);
		String filepath = "Vertices.json";
		
		System.out.println("Hasta aca llegue bien, con el siguiente vertice: ");
		System.out.println(vertice.toString());
		
	}
	
	
	
	
	
	
	public static void crearJsonDeVertices() {
		try(FileWriter writer = new FileWriter("Vertices.json")){
			System.out.println("Archivo JSON de vertices creado con exito");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearJsonDeAristas() {
		try(FileWriter writer = new FileWriter("Aristas.json")){
			System.out.println("Archivo JSON de aristas creado con exito");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
