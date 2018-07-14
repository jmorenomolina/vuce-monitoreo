package pruebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.vuce.monitoreo.component.SolicitudEntidadComponent;
import pe.gob.vuce.monitoreo.entity.SolicitudEntidad;

@SpringBootApplication

public class PruebaCargaJSON  {

	public static void main(String[] args) {
		try {
			run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void run() throws Exception {
		try {
			String archivo = "C:\\Proyectos\\vuce_workspace\\proyectos\\tmp\\solicitudentidad2.txt";
			BufferedReader reader = new BufferedReader(new FileReader(archivo));
			StringBuilder stringBuilder = new StringBuilder();
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			// delete the last new line separator
		//	stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			reader.close();

			String cadena = stringBuilder.toString();

			SolicitudEntidad solicitudEntidad = new ObjectMapper().readValue(cadena, SolicitudEntidad.class);

			System.out.println("llegué");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
