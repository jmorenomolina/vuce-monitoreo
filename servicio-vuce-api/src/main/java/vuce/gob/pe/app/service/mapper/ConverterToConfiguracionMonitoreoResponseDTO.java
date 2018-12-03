package vuce.gob.pe.app.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import vuce.gob.pe.app.dto.ConfiguracionMonitoreoDTO;
import vuce.gob.pe.app.dto.ConfiguracionMonitoreoResponseDTO;
import vuce.gob.pe.app.model.Entidad;

public class ConverterToConfiguracionMonitoreoResponseDTO {

  private ConverterToConfiguracionMonitoreoResponseDTO() {
	  super();
  }

  public static List<ConfiguracionMonitoreoResponseDTO> converter(List<Entidad> entidades ,List<ConfiguracionMonitoreoDTO> configuraciones) {
	  List<ConfiguracionMonitoreoResponseDTO> response = new ArrayList<>();
	  if(Optional.ofNullable(configuraciones).isPresent() && !configuraciones.isEmpty()) {
		  for(ConfiguracionMonitoreoDTO configuracion : configuraciones) {
			  Entidad entidad = ConverterToConfiguracionMonitoreoResponseDTO.findByEntidadId(configuracion, entidades);
			  if(Optional.ofNullable(entidad).isPresent()) {
				 ConfiguracionMonitoreoResponseDTO configuracionAux = ConverterToConfiguracionMonitoreoResponseDTO.findByConfiguracionMonitoreoResponseDTO(response, entidad);
				 if(Optional.ofNullable(configuracionAux).isPresent()) {
					 ConverterToConfiguracionMonitoreoResponseDTO.updateConfigMonitoreo(configuracionAux,configuracion.getSla(), configuracion.getValor());
				 } else {
					 ConfiguracionMonitoreoResponseDTO configNew = ConverterToConfiguracionMonitoreoResponseDTO.createConfigMonitoreo(entidad, configuracion.getSla(), configuracion.getValor());
					 response.add(configNew);
				 }				  
			  }
		  }
	  }	  
	  return response;
  }
  
  private static ConfiguracionMonitoreoResponseDTO findByConfiguracionMonitoreoResponseDTO(List<ConfiguracionMonitoreoResponseDTO> response,Entidad entidad) {
	  return response.stream().filter(e->e.getEntidadId().equals(entidad.getIdEntidad())).findAny().orElse(null);
  }
  
  private static Entidad findByEntidadId(ConfiguracionMonitoreoDTO configuracion,List<Entidad> entidades) {
	  return entidades.stream().filter(e->e.getIdEntidad().equals(configuracion.getEntidadId())).findAny().orElse(null);
  }
  
  private final static String SLA1="SLA1";
  private final static String SLA1SPACE="SLA 1";  
  private final static String SLA2="SLA2";
  private final static String SLA2SPACE="SLA 2";  
  private final static String SLA3="SLA3";
  private final static String SLA3SPACE="SLA 3";  
  private final static String SLA4="SLA4";
  private final static String SLA4SPACE="SLA 4";  
  private final static String SLA5="SLA5";
  private final static String SLA5SPACE="SLA 5";
  
  private static ConfiguracionMonitoreoResponseDTO createConfigMonitoreo(Entidad entidad,String sla,Integer valor) {
	  ConfiguracionMonitoreoResponseDTO conf= new ConfiguracionMonitoreoResponseDTO();
	  conf.setEntidad(entidad.getDescripcion());
	  conf.setEntidadId(entidad.getIdEntidad());
	  if(SLA1.equalsIgnoreCase(sla) || SLA1SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla1(valor);
	  }else if(SLA2.equalsIgnoreCase(sla) || SLA2SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla2(valor);
	  }else if(SLA3.equalsIgnoreCase(sla) || SLA3SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla3(valor);
	  }else if(SLA4.equalsIgnoreCase(sla) || SLA4SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla4(valor);
	  }else if(SLA5.equalsIgnoreCase(sla) || SLA5SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla5(valor);
	  }
	  return conf;
  }
  
  private static ConfiguracionMonitoreoResponseDTO updateConfigMonitoreo(ConfiguracionMonitoreoResponseDTO conf,String sla,Integer valor) {
      if(SLA1.equalsIgnoreCase(sla) || SLA1SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla1(valor);
	  }else if(SLA2.equalsIgnoreCase(sla) || SLA2SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla2(valor);
	  }else if(SLA3.equalsIgnoreCase(sla) || SLA3SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla3(valor);
	  }else if(SLA4.equalsIgnoreCase(sla) || SLA4SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla4(valor);
	  }else if(SLA5.equalsIgnoreCase(sla) || SLA5SPACE.equalsIgnoreCase(sla)) {
		  conf.setValorSla5(valor);
	  }
	  return conf;
  }
}
