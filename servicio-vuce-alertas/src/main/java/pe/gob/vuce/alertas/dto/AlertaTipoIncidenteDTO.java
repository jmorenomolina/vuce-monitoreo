package pe.gob.vuce.alertas.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlertaTipoIncidenteDTO {
	
	private String codigoAlerta;
	
	//Distinto de tipo 6
	private Date fechaHora;
	private Integer duracion = 0;
	private Integer cantidadTxIncidente;	
	private List<IncidenteDTO> incidentes = new ArrayList<IncidenteDTO>();
	
	//Solo para tipo6
	//incluye el nombre de la entidad
	private Integer cantidadTxSalida;
	private Integer cantidadSolicitudRN1;
	private Integer cantidadSolicitudRN2;
	
	public AlertaTipoIncidenteDTO() {
		super();
	}
	
	public Integer getCantidadTxSalida() {
		return cantidadTxSalida;
	}

	public void setCantidadTxSalida(Integer cantidadTxSalida) {
		this.cantidadTxSalida = cantidadTxSalida;
	}

	public Integer getCantidadSolicitudRN1() {
		return cantidadSolicitudRN1;
	}

	public void setCantidadSolicitudRN1(Integer cantidadSolicitudRN1) {
		this.cantidadSolicitudRN1 = cantidadSolicitudRN1;
	}

	public Integer getCantidadSolicitudRN2() {
		return cantidadSolicitudRN2;
	}

	public void setCantidadSolicitudRN2(Integer cantidadSolicitudRN2) {
		this.cantidadSolicitudRN2 = cantidadSolicitudRN2;
	}

	public Date getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public Integer getDuracion() {
		return duracion;
	}
	
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	public Integer getCantidadTxIncidente() {
		return cantidadTxIncidente;
	}
	
	public void setCantidadTxIncidente(Integer cantidadTxIncidente) {
		this.cantidadTxIncidente = cantidadTxIncidente;
	}
	
	public List<IncidenteDTO> getIncidentes() {
		return incidentes;
	}
	
	public void setIncidentes(List<IncidenteDTO> alertaIncidentes) {
		this.incidentes = alertaIncidentes;
	}
	
	public String getCodigoAlerta() {
		return codigoAlerta;
	}

	public void setCodigoAlerta(String codigoAlerta) {
		this.codigoAlerta = codigoAlerta;
	}

	
}
