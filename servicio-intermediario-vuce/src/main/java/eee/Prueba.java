package eee;

import java.io.StringReader;
import java.util.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.stream.StreamSource;

import pe.gob.vuce.esquema.notificacion.NotificacionType;
import pe.gob.vuce.esquema.notificacion.ObjectFactory;
import pe.gob.vuce.processor.ProcesadorMensajesVUCEException;

public class Prueba {

	public Prueba() {

	}

	public static void main(String[] args) {

		String bin = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pjxub3RpZmljYWNpb24geG1sbnM9Ik5vdGlmaWNhY2lvbi0xLjAiPjxudW1lcm9Ob3RpZmljYWNpb24+MTIzPC9udW1lcm9Ob3RpZmljYWNpb24+PHRpcG9NZW5zYWplPk4yPC90aXBvTWVuc2FqZT48ZW50aWRhZD43MDwvZW50aWRhZD48ZG9jdW1lbnRvPjx0aXBvPk88L3RpcG8+PG51bWVybz4yMDE4MDA2MTMwPC9udW1lcm8+PHRhc2E+NTUuMDwvdGFzYT48L2RvY3VtZW50bz48ZG9jdW1lbnRvUmVmZXJlbmNpYT48dGlwbz48L3RpcG8+PG51bWVybz48L251bWVybz48L2RvY3VtZW50b1JlZmVyZW5jaWE+PHRleHRvPjwvdGV4dG8+PGVycm9yZXMvPjwvbm90aWZpY2FjaW9uPg==";
		byte[] decodedBytes = Base64.getDecoder().decode(bin);
		String decodedString = new String(decodedBytes);
		
		try {
			NotificacionType notificacionType = (NotificacionType) getObjectFromXMLString(decodedString,
					ObjectFactory.class);
			System.out.println("hola: " + notificacionType.getEntidad());
		} catch (ProcesadorMensajesVUCEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(decodedString);
	}

	public static <T> Object getObjectFromXMLString(String xmlString, Class<?> objectFactory)
			throws pe.gob.vuce.processor.ProcesadorMensajesVUCEException {
		Object object = null;
		try {
			// org.eclipse.persistence.jaxb.JAXBContextFactory x;
			JAXBContext jaxbContext = JAXBContext.newInstance(objectFactory);
			object = ((JAXBElement<T>) jaxbContext.createUnmarshaller()
					.unmarshal(new StreamSource(new StringReader(xmlString)))).getValue();
		} catch (Exception e) {
			throw new pe.gob.vuce.processor.ProcesadorMensajesVUCEException(e);
		}
		return object;
	}
}
