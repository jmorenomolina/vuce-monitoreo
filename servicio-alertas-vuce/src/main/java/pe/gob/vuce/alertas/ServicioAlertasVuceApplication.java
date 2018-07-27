package pe.gob.vuce.alertas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServicioAlertasVuceApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(ServicioAlertasVuceApplication.class, args);
	}

}
