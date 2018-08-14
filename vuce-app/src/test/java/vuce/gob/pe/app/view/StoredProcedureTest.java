package vuce.gob.pe.app.view;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import vuce.gob.pe.app.ConsolaMonitoreoApplication;

import vuce.gob.pe.app.service.TransaccionIncidenteService;
import vuce.gob.pe.app.rest.dto.ReenviarTransaccionResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConsolaMonitoreoApplication.class)
@Transactional
public class StoredProcedureTest {

    @Autowired
    private TransaccionIncidenteService repository;

    public StoredProcedureTest() {
        // TODO Auto-generated constructor stub
    }

    @BeforeClass
    public static void init() {

    }

    @Before
    public void setup() {
    }



    @Test
    @Ignore
    public void reenviarTransaccionProcedure() {
        try {
            
            List<String> ids = new ArrayList<>();
            ids.add("123");
            ids.add("3235");
            
            List<ReenviarTransaccionResponse> reponse = repository.reenviarTransaccion(ids);
            if(reponse!=null && !reponse.isEmpty()){
                   reponse.forEach(System.out::println);
            }else{
                System.out.println("Lista Vacia");
            }
         

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
/*
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

    }*/
}
