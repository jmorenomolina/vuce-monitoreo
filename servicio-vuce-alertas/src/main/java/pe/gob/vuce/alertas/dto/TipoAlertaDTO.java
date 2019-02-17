package pe.gob.vuce.alertas.dto;

public class TipoAlertaDTO {

	private String to;
	private String cc;
	private String nombreEntidad;
	private Long frecuenciaVerificacion;
	private Long tiempoSuspension;
	private Integer tipoIncidente;
	private String descripcionAlerta;

	public TipoAlertaDTO() {
		super();
	}

	public TipoAlertaDTO(String entidad, String to, String cc, long frecuenciaVerificacion, long tiempoSuspension,
			int tipoIncidente, String descripcionAlerta) {
		super();
		this.nombreEntidad = entidad;
		this.to = to;
		this.cc = cc;
		this.tiempoSuspension = tiempoSuspension;
		this.tipoIncidente = tipoIncidente;
		this.frecuenciaVerificacion = frecuenciaVerificacion;
		this.descripcionAlerta = descripcionAlerta;
	}

	public String getDescripcionAlerta() {
		return descripcionAlerta;
	}

	public void setDescripcionAlerta(String descripcionAlerta) {
		this.descripcionAlerta = descripcionAlerta;
	}

	public String getCc() {
		return cc;
	}

	public String getNombreEntidad() {
		return nombreEntidad;
	}

	public Long getFrecuenciaVerificacion() {
		return frecuenciaVerificacion;
	}

	public Long getTiempoSuspension() {
		return tiempoSuspension;
	}

	public Integer getTipoIncidente() {
		return tipoIncidente;
	}

	public String getTo() {
		return to;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public void setNombreEntidad(String entidad) {
		this.nombreEntidad = entidad;
	}

	public void setFrecuenciaVerificacion(Long frecuenciaVerificacion) {
		this.frecuenciaVerificacion = frecuenciaVerificacion;
	}

	public void setTiempoSuspension(Long tiempoSuspension) {
		this.tiempoSuspension = tiempoSuspension;
	}

	public void setTiempoSuspensión(Long pausa) {
		this.tiempoSuspension = pausa;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setTipoIncidente(Integer tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

}
