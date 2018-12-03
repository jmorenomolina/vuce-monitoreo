package vuce.gob.pe.app.rest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vuce.gob.pe.app.dto.ConfiguracionMonitoreoDTO;
import vuce.gob.pe.app.dto.ConfiguracionMonitoreoResponseDTO;
import vuce.gob.pe.app.dto.MensajeSalidaDTO;
import vuce.gob.pe.app.dto.RequestFiltrarTransmisionesDTO;
import vuce.gob.pe.app.dto.TrasmisionDTO;
import vuce.gob.pe.app.dto.TrasmisionIncidenteDTO;
import vuce.gob.pe.app.model.Entidad;
import vuce.gob.pe.app.model.Parametro;
import vuce.gob.pe.app.repository.EntidadRepository;
import vuce.gob.pe.app.repository.ParametroRepository;
import vuce.gob.pe.app.rest.parameter.ConfiguracionMonitoreoInput;
import vuce.gob.pe.app.rest.parameter.ConfiguracionMonitoreoObtenerInput;
import vuce.gob.pe.app.rest.parameter.HabilitarInput;
import vuce.gob.pe.app.rest.parameter.TransmisionDetenerInput;
import vuce.gob.pe.app.rest.parameter.TransmisonEntradaN8Input;
import vuce.gob.pe.app.rest.parameter.TrasmisionInput;
import vuce.gob.pe.app.service.TransmisionesService;
import vuce.gob.pe.app.service.mapper.ConverterToConfiguracionMonitoreoResponseDTO;
import vuce.gob.pe.app.util.Converter;
import vuce.gob.pe.app.util.RestAppException;

/**
 *
 * @author cquevedo
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	private final EntidadRepository repositoryEntidad = null;
	
	@Autowired
	private final ParametroRepository repositoryParametro = null;	
	

	@Autowired
	private final TransmisionesService repositoryTransmisionesService = null;

	private final String FORMAT_DATE = "dd/MM/yyyy";
	
	
	@RequestMapping(value = "/tipodocumentos", method = RequestMethod.GET)
	public ResponseEntity<List<Parametro>> tipodocumentos() {
		List<Parametro> parametros = (List<Parametro>) repositoryParametro.findByTipoParametro("TIPODOC");
		if (parametros.isEmpty()) {
			return new ResponseEntity<List<Parametro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(parametros, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tipomensaje", method = RequestMethod.GET)
	public ResponseEntity<List<Parametro>> tipomensajes() {
		List<Parametro> parametros = (List<Parametro>) repositoryParametro.findByTipoParametro("TIPOMSJ");
		if (parametros.isEmpty()) {
			return new ResponseEntity<List<Parametro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(parametros, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tipotransmision", method = RequestMethod.GET)
	public ResponseEntity<List<Parametro>> tipotransmision() {
		List<Parametro> parametros = (List<Parametro>) repositoryParametro.findByTipoParametro("TIPOTRAN");
		if (parametros.isEmpty()) {
			return new ResponseEntity<List<Parametro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(parametros, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tipoincidente", method = RequestMethod.GET)
	public ResponseEntity<List<Parametro>> tipoincidente() {
		List<Parametro> parametros = (List<Parametro>) repositoryParametro.findByTipoParametro("TIPOINCI");
		if (parametros.isEmpty()) {
			return new ResponseEntity<List<Parametro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(parametros, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/estado/vucecentral", method = RequestMethod.GET)
	public ResponseEntity<List<Parametro>> estadoVuceCentral() {
		List<Parametro> parametros = (List<Parametro>) repositoryParametro.findByTipoParametro("ESTVUCCENT");
		if (parametros.isEmpty()) {
			return new ResponseEntity<List<Parametro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(parametros, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/estado/vuceentidad", method = RequestMethod.GET)
	public ResponseEntity<List<Parametro>> estadoVuceEntidad() {
		List<Parametro> parametros = (List<Parametro>) repositoryParametro.findByTipoParametro("ESTVUCENT");
		if (parametros.isEmpty()) {
			return new ResponseEntity<List<Parametro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(parametros, HttpStatus.OK);
	}
	
		
	@RequestMapping(value = "/entidades", method = RequestMethod.GET)
	public ResponseEntity<List<Entidad>> entidades() {

		List<Entidad> entidades = (List<Entidad>) repositoryEntidad.findAll();
		if (entidades.isEmpty()) {
			return new ResponseEntity<List<Entidad>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(entidades, HttpStatus.OK);
	}

	private ResponseEntity crearMensajeRespuestaError(RestAppException e) {
		logger.info("crearMensajeRespuestaError: [{}]",e.getDeveloperMessage());
		MensajeSalidaDTO response = new MensajeSalidaDTO();
		response.setResultadoMensaje(e.getDeveloperMessage());
		response.setResultadoValor(500);
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

	}

	
	@RequestMapping(value = "/transmisionesconincidentes", method = RequestMethod.GET)
	public ResponseEntity<List<TrasmisionIncidenteDTO>> trasmisionesConIncidente(
			@RequestParam(required = false, value = "fechaIncio") String fechaIncio,
			@RequestParam(required = false, value = "fechaFin") String fechaFin) {
		
		logger.info("trasmisionesConIncidente  fechaIncio: [{}] fechaFin: [{}]",
				fechaIncio,fechaFin);
		
		List<TrasmisionIncidenteDTO> transmisiones;
		try {
			transmisiones = (List<TrasmisionIncidenteDTO>) repositoryTransmisionesService
					.obtenerTransmisionesConIncidente(Converter.convertToDate(fechaIncio, FORMAT_DATE), Converter.convertToDate(fechaFin, FORMAT_DATE));
			if (transmisiones.isEmpty()) {
				return new ResponseEntity<List<TrasmisionIncidenteDTO>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(transmisiones, HttpStatus.OK);
		} catch (RestAppException e) {
			//return new ResponseEntity<List<TrasmisionIncidenteDTO>>(HttpStatus.NO_CONTENT);
			return this.crearMensajeRespuestaError(e);
		}

	}

	@RequestMapping(value = "/transmisiones", method = RequestMethod.GET)
	public ResponseEntity<List<TrasmisionDTO>> trasmisiones(

			@RequestParam(required = false, value = "entidades") String entidades,
			@RequestParam(required = false, value = "fechaInicio") String fechaInicio,
			@RequestParam(required = false, value = "fechaFin") String fechaFin,
			@RequestParam(required = false, value = "tipoMensaje") String tipoMensaje,
			@RequestParam(required = false, value = "tipoDocumento") String tipoDocumento,
			@RequestParam(required = false, value = "numeroDocumento") String numeroDocumento,
			@RequestParam(required = false, value = "tipoTransmision") String tipoTransmision,
			@RequestParam(required = false, value = "tipoIncidente") String tipoIncidente,
			@RequestParam(required = false, value = "estadoVc") String estadoVc,
			@RequestParam(required = false, value = "estadoVe") String estadoVe,
			@RequestParam(required = false, value = "vcId") String vcId,
			@RequestParam(required = false, value = "veId") String veId
			
			) {

		RequestFiltrarTransmisionesDTO request = new RequestFiltrarTransmisionesDTO();
		request.setCodigoEntidad(entidades);
		request.setFechaInicio(Converter.convertToDate(fechaInicio, FORMAT_DATE));
		request.setFechaFin(Converter.convertToDate(fechaFin, FORMAT_DATE));
		request.setTipoMensaje(tipoMensaje);
		request.setTipoDocumento(tipoDocumento);
		request.setNumeroDocumento(numeroDocumento);
		request.setTipoTransmision(tipoTransmision);
		request.setTipoIncidente(tipoIncidente);
		request.setEstadoVc(estadoVc);
		request.setEstadoVe(estadoVe);
		request.setVcId(vcId);
		request.setVeId(veId);

		logger.info("Filtrar Transmisiones: " + request.toString());

		try {
			List<TrasmisionDTO> transmisiones = (List<TrasmisionDTO>) repositoryTransmisionesService
					.filtrarTransmisiones(request);
			if (transmisiones.isEmpty()) {
				return new ResponseEntity<List<TrasmisionDTO>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(transmisiones, HttpStatus.OK);
		} catch (RestAppException e) {
			//return new ResponseEntity<List<TrasmisionDTO>>(HttpStatus.NO_CONTENT);
			return this.crearMensajeRespuestaError(e);
		}
	}

	@RequestMapping(value = "/transmision/reenviar/salida/conerror", method = RequestMethod.PUT)
	public ResponseEntity<MensajeSalidaDTO> trasmisionReenviarSalidaConError(
			@RequestBody TrasmisionInput trasmisionInput) {

		logger.info("TrasmisionReenviarSalidaConError vcId: [{}] vcTransaccion: [{}] veId: [{}] veTransaccion: [{}]",
				trasmisionInput.getVcId(), trasmisionInput.getVcTransaccion(), trasmisionInput.getVeId(), trasmisionInput.getVeTransaccion());

		try {
			MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService
					.reenviarTransaccionSalidaConError(trasmisionInput.getVcId(), trasmisionInput.getVcTransaccion(), trasmisionInput.getVeId(), trasmisionInput.getVeTransaccion());
			if (!Optional.ofNullable(response).isPresent()) {
				return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RestAppException e) {
			//return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			return this.crearMensajeRespuestaError(e);
		}
	}

	@RequestMapping(value = "/transmision/habilitar", method = RequestMethod.PUT)
	public ResponseEntity<MensajeSalidaDTO> transmisionHabilitar(
			@RequestBody HabilitarInput input) {
		logger.info("transmisionHabilitar  veId: [{}] ", input.getVeId());
		try {
			MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService.habilitarTransmision(input.getVeId());
			if (!Optional.ofNullable(response).isPresent()) {
				return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RestAppException e) {
			//return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			return this.crearMensajeRespuestaError(e);
		}
	}

	@RequestMapping(value = "/transmision/reprocesar/entrada/conerror", method = RequestMethod.PUT)
	public ResponseEntity<MensajeSalidaDTO> trasmisionReprocesarEntradaConError(
			@RequestBody TrasmisionInput trasmisionInput) {

		logger.info("TrasmisionReprocesarEntradaConError vcId: [{}]  vcTransaccion: [{}]", trasmisionInput.getVcId(), trasmisionInput.getVcTransaccion());
		try {
			MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService.reprocesarTransaccionEntradaConError(trasmisionInput.getVcId(), trasmisionInput.getVcTransaccion(), trasmisionInput.getVeId(), trasmisionInput.getVeTransaccion());
			if (!Optional.ofNullable(response).isPresent()) {
				return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RestAppException e) {			
			return this.crearMensajeRespuestaError(e);
		}
	}

	@RequestMapping(value = "/transmision/anular/entrada/conerror", method = RequestMethod.PUT)
	public ResponseEntity<MensajeSalidaDTO> trasmisionAnularEntradaConError(
			@RequestBody TrasmisionInput trasmisionInput) {

		logger.info("TrasmisionAnularEntradaConError veId: [{}] veTransaccion: [{}] vcId: [{}] vcTransaccion: [{}] ",
				trasmisionInput.getVeId(), trasmisionInput.getVeTransaccion(), trasmisionInput.getVcId(), trasmisionInput.getVcTransaccion());
		try {
			MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService
					.anularTransaccionEntradaConError(trasmisionInput.getVeId(), trasmisionInput.getVeTransaccion(), trasmisionInput.getVcId(), trasmisionInput.getVcTransaccion());
			if (!Optional.ofNullable(response).isPresent()) {
				return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RestAppException e) {
			return this.crearMensajeRespuestaError(e);
		}
	}

	@RequestMapping(value = "/transmision/reprocesar/entrada/n8/conerror", method = RequestMethod.PUT)
	public ResponseEntity<MensajeSalidaDTO> trasmisionReprocesarEntradaN8ConError(@RequestBody TransmisonEntradaN8Input input) {

		logger.info("TrasmisionReprocesarEntradaConError entidadId: [{}]  fechaInicio: [{}]  fechaFin: [{}]", input.getEntidadId(),
				input.getFechaInicio(), input.getFechaFin());
		try {
			MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService
					.reporcesarTransaccionEntradaN8ConError(input.getEntidadId(),
							Converter.convertToDate(input.getFechaInicio(), FORMAT_DATE), 
							Converter.convertToDate(input.getFechaFin(), FORMAT_DATE));
			if (!Optional.ofNullable(response).isPresent()) {
				return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RestAppException e) {
			return this.crearMensajeRespuestaError(e);
		}
	}

	
	@RequestMapping(value = "/transmision/obtener/configuracion/monitoreo", method = RequestMethod.PUT)
	public ResponseEntity<List<ConfiguracionMonitoreoResponseDTO>> obtenerConfiguracionMonitoreo(
			@RequestBody ConfiguracionMonitoreoObtenerInput input) {

		logger.info("obtenerConfiguracionMonitoreo entidadId: [{}] ",input.getEntidadId());
		
		try {
			List<Entidad> entidades = (List<Entidad>) repositoryEntidad.findAll();
			if (!entidades.isEmpty()) {
				logger.info("obtenerConfiguracionMonitoreo paso: [{}] Size[{}]",1,entidades.size());				
				List<ConfiguracionMonitoreoDTO> responseConf = repositoryTransmisionesService.obtenerConfiguracionMonitoreo(input.getEntidadId());
				
				logger.info("obtenerConfiguracionMonitoreo paso: [{}] Size[{}]",2,responseConf.size());
				
				List<ConfiguracionMonitoreoResponseDTO> response = ConverterToConfiguracionMonitoreoResponseDTO.converter(entidades, responseConf);
				
				if (response.isEmpty()) {
					logger.info("obtenerConfiguracionMonitoreo paso: [{}] ",3);
					return new ResponseEntity<List<ConfiguracionMonitoreoResponseDTO>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(response, HttpStatus.OK);				
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}			
			
		} catch (RestAppException e) {
			return this.crearMensajeRespuestaError(e);
		}
	}
	
	
	@RequestMapping(value = "/transmision/actualizar/configuracion/monitoreo", method = RequestMethod.PUT)
	public ResponseEntity<MensajeSalidaDTO> actualizarConfiguracionMonitoreo(
			@RequestBody ConfiguracionMonitoreoInput input) {

		logger.info("actualizarConfiguracionMonitoreo entidadId: [{}]  correoSoporte: [{}]  slaNombre: [{}]  slaValor: [{}]   estado: [{}]",input.getEntidadId(),input.getCorreoSoporte(), input.getSlaNombre(), input.getSlaValor(), input.getEstado());
		
		try {
			repositoryTransmisionesService.actualizarConfiguracionMonitoreo(input.getEntidadId(),input.getCorreoSoporte(), input.getSlaNombre(), input.getSlaValor(), input.getEstado());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RestAppException e) {
			return this.crearMensajeRespuestaError(e);
		}
	}
	
	
	@RequestMapping(value = "/transmision/detener", method = RequestMethod.PUT)
	public ResponseEntity<MensajeSalidaDTO> transmisionDetener(
			@RequestBody TransmisionDetenerInput input) {
		logger.info("transmisionHabilitar  entidadId: [{}] fechaIncio [{}]  fechaFin [{}]", input.getEntidadId(),input.getFechaInicio(),input.getFechaFin());
		try {
			MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService.detenerTrasmision(input.getEntidadId(),Converter.convertToDate(input.getFechaInicio(), FORMAT_DATE),Converter.convertToDate(input.getFechaFin(), FORMAT_DATE));
			if (!Optional.ofNullable(response).isPresent()) {
				return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RestAppException e) {
			//return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
			return this.crearMensajeRespuestaError(e);
		}
	}

}
