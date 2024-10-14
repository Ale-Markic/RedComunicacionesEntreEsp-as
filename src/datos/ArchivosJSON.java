package datos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArchivosJSON {
	
	
	public static void agregarVertice(Vertice vertice) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = gson.toJson(vertice);
		String filepath = "/recursos/prueba.txt";
		
		try(FileWriter writer = new FileWriter(filepath)){
			//writer.write(json);
			System.out.println(json.toString());
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/*
	
	public static void crearJsonDeVertices() {
		try(FileWriter writer = new FileWriter("Vertices.json")){
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
	*/

}
