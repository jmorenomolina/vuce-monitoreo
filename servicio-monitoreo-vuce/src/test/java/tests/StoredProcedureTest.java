package tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.vuce.monitoreo.ServicioMonitoreoVuceApplication;
import pe.gob.vuce.monitoreo.repository.SolicitudEntidadRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServicioMonitoreoVuceApplication.class)
@Transactional
public class StoredProcedureTest {

	@Autowired
    private SolicitudEntidadRepository repository;
	
	public StoredProcedureTest() {
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public static void init() {

	}

	@Before
	public void setup() {
	}

	public static String id = "123";
	
	@Test
	public void reenviarTransaccionProcedure() {
		try {
			
			String mensajeError = repository.reenviarTransaccion(id);
		    System.out.println("reenviarTransaccion: " + mensajeError);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	@Test
	public void reprocesarNotificacionProcedure() {
		try {
			
			String mensajeError = repository.reprocesarNotificacion(id);
		    System.out.println("reprocesarNotificacion: " + mensajeError);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	@Test
	public void anularNotificacionProcedure() {
		try {
			
			String mensajeError = repository.anularNotificacion(id);
		    System.out.println("anularNotificacion: " + mensajeError);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
