package pe.gob.vuce.alertas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ALERTA_PLANTILLA database table.
 * 
 */
@Entity
@Table(name="ALERTA_PLANTILLA")
@NamedQuery(name="AlertaPlantilla.findAll", query="SELECT a FROM AlertaPlantilla a")
public class AlertaPlantilla implements Serializable {
	private static final long serialVersionUID = 1L;

	private String asunto;
	
	@Id
	@Column(name="ID_ALERTA_CONFIGURACION")
	private BigDecimal idAlertaConfiguracion;

	private String query;

	public AlertaPlantilla() {
	}


	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public BigDecimal getIdAlertaConfiguracion() {
		return this.idAlertaConfiguracion;
	}

	public void setIdAlertaConfiguracion(BigDecimal idAlertaConfiguracion) {
		this.idAlertaConfiguracion = idAlertaConfiguracion;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}