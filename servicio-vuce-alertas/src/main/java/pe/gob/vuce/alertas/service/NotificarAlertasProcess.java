package pe.gob.vuce.alertas.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.gob.vuce.alertas.dto.TipoAlertaDTO;

@Component
public class NotificarAlertasProcess implements CommandLineRunner {

	private final NotificarAlertasService notificarAlertasService;

	public NotificarAlertasProcess(NotificarAlertasService notificarAlertasService) {
		this.notificarAlertasService = notificarAlertasService;
	}

	@Override
	public void run(String... args) throws Exception {

		GestorAlertasService gestorAlertasService = new GestorAlertasService();
		List<TipoAlertaDTO> tipoAlertas = gestorAlertasService.obtenerTipoAlertas();
		for (TipoAlertaDTO tipoAlertaDTO : tipoAlertas) {
			notificarAlertasService.enviarAlertasPorTipoIncidente(tipoAlertaDTO);
		}

	}

}
