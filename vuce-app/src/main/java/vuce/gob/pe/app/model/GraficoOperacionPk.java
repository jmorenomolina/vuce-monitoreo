/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuce.gob.pe.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Skinet
 */
@Embeddable
public class GraficoOperacionPk implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ENTIDAD")
    private Integer idEntidad;
      
    @Size(max = 10)
    @Column(name = "FECHA_SOLICITUD")
    private String fechaSolicitud;

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    @Override
    public String toString() {
        return "GraficoOperacionPk{" + "idEntidad=" + idEntidad + ", fechaSolicitud=" + fechaSolicitud + '}';
    }

    
}
