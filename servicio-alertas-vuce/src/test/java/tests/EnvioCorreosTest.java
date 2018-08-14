package tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.vuce.alertas.ServicioAlertasVuceApplication;
import pe.gob.vuce.alertas.component.InformeIncidentesComponent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServicioAlertasVuceApplication.class)
@Transactional
public class EnvioCorreosTest {

	@Autowired
    private InformeIncidentesComponent mailComponent;
	
	public EnvioCorreosTest() {
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
	public void enviarInformeIncidentes() {
		
		try {
			
			mailComponent.enviarInformeIncidentes(false);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	
}
