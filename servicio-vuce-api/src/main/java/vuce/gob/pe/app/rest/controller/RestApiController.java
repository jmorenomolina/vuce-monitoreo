package vuce.gob.pe.app.rest.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vuce.gob.pe.app.dto.MensajeSalidaDTO;
import vuce.gob.pe.app.dto.RequestFiltrarTransmisionesDTO;
import vuce.gob.pe.app.dto.TrasmisionDTO;
import vuce.gob.pe.app.dto.TrasmisionIncidenteDTO;
import vuce.gob.pe.app.model.Entidad;
import vuce.gob.pe.app.repository.EntidadRepository;
import vuce.gob.pe.app.service.TransmisionesService;

/**
 *
 * @author cquevedo
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private final EntidadRepository repositoryEntidad = null;
    
    
    @Autowired
    private final TransmisionesService repositoryTransmisionesService = null;


    @RequestMapping(value = "/entidades", method = RequestMethod.GET)
    public ResponseEntity<List<Entidad>> entidades() {

        List<Entidad> entidades = (List<Entidad>) repositoryEntidad.findAll();
        if (entidades.isEmpty()) {
            return new ResponseEntity<List<Entidad>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entidades, HttpStatus.OK);
    }

    

    @RequestMapping(value = "/transmisionesconincidentes", method = RequestMethod.GET)
    public ResponseEntity<List<TrasmisionIncidenteDTO>> trasmisionesConIncidente() {
        List<TrasmisionIncidenteDTO> transmisiones = (List<TrasmisionIncidenteDTO>) repositoryTransmisionesService.obtenerTransmisionesConIncidente(new Date(), new Date());
        if (transmisiones.isEmpty()) {
            return new ResponseEntity<List<TrasmisionIncidenteDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transmisiones, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/transmisiones", method = RequestMethod.GET)
    public ResponseEntity<List<TrasmisionDTO>> trasmisiones(
    		
    		@RequestParam(required=false,value="codigoEntidad")  String codigoEntidad,
    		@RequestParam(required=false,value="fechaInicio")  Date fechaInicio,
    		@RequestParam(required=false,value="fechaFin")  Date fechaFin,
    		@RequestParam(required=false,value="tipoMensaje")  String tipoMensaje,
    		@RequestParam(required=false,value="tipoDocumento")  String tipoDocumento,
    		@RequestParam(required=false,value="numeroDocumento")  String numeroDocumento,
    		@RequestParam(required=false,value="tipoTransmision")  String tipoTransmision,
    		@RequestParam(required=false,value="tipoIncidente")  String tipoIncidente,
    		@RequestParam(required=false,value="estadoVc")  String estadoVc,
    		@RequestParam(required=false,value="estadoVe")  String estadoVe,
    		@RequestParam(required=false,value="vcId")  String vcId,
    		@RequestParam(required=false,value="veId")  String veId) {
    	
        RequestFiltrarTransmisionesDTO request = new RequestFiltrarTransmisionesDTO();
        request.setCodigoEntidad(codigoEntidad);
        request.setFechaInicio(fechaInicio);
        request.setFechaFin(fechaFin);
        request.setTipoMensaje(tipoMensaje);
        request.setTipoDocumento(tipoDocumento);
        request.setNumeroDocumento(numeroDocumento);
        request.setTipoTransmision(tipoTransmision);
        request.setTipoIncidente(tipoIncidente);
        request.setEstadoVc(estadoVc);
        request.setEstadoVe(estadoVe);
        request.setVcId(vcId);
        request.setVeId(veId);        
        
        logger.info("Filtrar Transmisiones: "+request.toString());
        
		List<TrasmisionDTO> transmisiones = (List<TrasmisionDTO>) repositoryTransmisionesService.filtrarTransmisiones(request);
        if (transmisiones.isEmpty()) {
            return new ResponseEntity<List<TrasmisionDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transmisiones, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/transmision/reenviar/salida/conerror", method = RequestMethod.GET)
    public ResponseEntity<MensajeSalidaDTO> trasmisionReenviarSalidaConError(    		
    		@RequestParam(required=false,value="vcId")  Integer vcId,
    		@RequestParam(required=false,value="vcTransaccion")  String vcTransaccion,
    		@RequestParam(required=false,value="veId")  Integer veId,
    		@RequestParam(required=false,value="veTransaccion")  String veTransaccion) {
    	
  
        logger.info("TrasmisionReenviarSalidaConError vcId: [{}] vcTransaccion: [{}] veId: [{}] veTransaccion: [{}]", vcId,vcTransaccion,veId,veTransaccion);
        
        MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService.reenviarTransaccionSalidaConError(vcId, vcTransaccion, veId, veTransaccion);
        if (!Optional.ofNullable(response).isPresent()) {
            return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/transmision/habilitar", method = RequestMethod.GET)
    public ResponseEntity<MensajeSalidaDTO> transmisionHabilitar(    		
    		@RequestParam(required=false,value="veId")  Integer veId) {    	
        logger.info("transmisionHabilitar  veId: [{}] ", veId);        
        MensajeSalidaDTO response = (MensajeSalidaDTO) repositoryTransmisionesService.habilitarTransmision(veId);
        if (!Optional.ofNullable(response).isPresent()) {
            return new ResponseEntity<MensajeSalidaDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    


}
