package vuce.gob.pe.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ConsolaMonitoreoApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConsolaMonitoreoApplication.class);
	}
	
	
    public static void main(String[] args) {
        SpringApplication.run(ConsolaMonitoreoApplication.class, args);
    }

  

}
