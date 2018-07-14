package pe.gob.vuce.monitoreo;


import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication
@EnableJms
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean //Listener para recibir los mensajes que envia el servicio intermediario de VUCE
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {

		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}
	
	/*@Override
	public void run(String... strings) throws Exception {
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
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			reader.close();

			String cadena = stringBuilder.toString();

			SolicitudEntidad solicitudEntidad = new ObjectMapper().readValue(cadena, SolicitudEntidad.class);
			cc.registrarSolicitud(solicitudEntidad);
			System.out.println("llegué");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/
}
