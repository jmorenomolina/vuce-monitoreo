package pruebas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import junit.framework.TestCase;
import ws.crossnet.apn.vuce.mediador.router.ProcesadorMensajesVUCEException;
import ws.crossnet.apn.vuce.mediador.router.RouterVUCE;
import ws.crossnet.apn.vuce.mediador.router.RouterVUCEHelper;
import ws.crossnet.apn.vuce.vucentws.VucentWS;
import ws.crossnet.apn.vuce.vucentws.VucentWSPortType;

public class TestingMediador extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testDescargarTransacciones() {

		VucentWSPortType servicioVUCE = new VucentWS().getVucentWSHttpSoap11Endpoint();
		List<DataHandler> result = (List<DataHandler>) servicioVUCE.obtenerTransaccionesPendientes(74);

		System.out.println("Inicio de descarga");

		for (Iterator<DataHandler> iterator = result.iterator(); iterator.hasNext();) {
			DataHandler dataHandler = (DataHandler) iterator.next();
			try {
				RouterVUCEHelper.guardarDataHandler_("transaccion", dataHandler, "zip");
				System.out.println("archivo guardado");
			} catch (ProcesadorMensajesVUCEException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin de descarga");

	}

	public void testProcesarTransaccion() {

		String fileName = "c:/tmp/transacciones/N61_1.zip";
		DataSource fds = new FileDataSource(fileName);
		DataHandler handler = new DataHandler(fds);
		List<DataHandler> dhList = new ArrayList<DataHandler>();
		dhList.add(handler);
		RouterVUCE router = new RouterVUCE();
		router.obtenerTransaccionesPendientes(dhList);
		System.out.println("Todo ok!!");

	}

}
