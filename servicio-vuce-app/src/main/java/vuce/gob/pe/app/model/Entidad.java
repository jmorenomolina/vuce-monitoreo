/*
 * Copyright 2018 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vuce.gob.pe.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Skinet
 */
@Entity
@Table(name = "ENTIDAD", schema="MTOBJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e")
    , @NamedQuery(name = "Entidad.findByIdEntidad", query = "SELECT e FROM Entidad e WHERE e.idEntidad = :idEntidad")
    , @NamedQuery(name = "Entidad.findByEntidad", query = "SELECT e FROM Entidad e WHERE e.entidad = :entidad")
    , @NamedQuery(name = "Entidad.findByNombreEntidad", query = "SELECT e FROM Entidad e WHERE e.nombreEntidad = :nombreEntidad")
    , @NamedQuery(name = "Entidad.findByCorreoSoporte", query = "SELECT e FROM Entidad e WHERE e.correoSoporte = :correoSoporte")
    , @NamedQuery(name = "Entidad.findBySlaDisponibilidadTransaccion", query = "SELECT e FROM Entidad e WHERE e.slaDisponibilidadTransaccion = :slaDisponibilidadTransaccion")
    , @NamedQuery(name = "Entidad.findBySlaConfirmacionTransaccion", query = "SELECT e FROM Entidad e WHERE e.slaConfirmacionTransaccion = :slaConfirmacionTransaccion")
    , @NamedQuery(name = "Entidad.findBySlaProcesamientoNotificacion", query = "SELECT e FROM Entidad e WHERE e.slaProcesamientoNotificacion = :slaProcesamientoNotificacion")
    , @NamedQuery(name = "Entidad.findBySlaFrecuenciaLectura", query = "SELECT e FROM Entidad e WHERE e.slaFrecuenciaLectura = :slaFrecuenciaLectura")
    , @NamedQuery(name = "Entidad.findBySlaFrecuenciaLecturaPm", query = "SELECT e FROM Entidad e WHERE e.slaFrecuenciaLecturaPm = :slaFrecuenciaLecturaPm")})
public class Entidad implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ENTIDAD")
    private String entidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ENTIDAD")
    private String nombreEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO_SOPORTE")
    private String correoSoporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SLA_DISPONIBILIDAD_TRANSACCION")
    private BigInteger slaDisponibilidadTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SLA_CONFIRMACION_TRANSACCION")
    private BigInteger slaConfirmacionTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SLA_PROCESAMIENTO_NOTIFICACION")
    private BigInteger slaProcesamientoNotificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SLA_FRECUENCIA_LECTURA")
    private BigInteger slaFrecuenciaLectura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SLA_FRECUENCIA_LECTURA_PM")
    private BigInteger slaFrecuenciaLecturaPm;
 
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ENTIDAD")
    private Integer idEntidad;
    
    

    public Entidad() {
    }

    public Entidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Entidad(Integer idEntidad, String entidad, String nombreEntidad, String correoSoporte, BigInteger slaDisponibilidadTransaccion, BigInteger slaConfirmacionTransaccion, BigInteger slaProcesamientoNotificacion, BigInteger slaFrecuenciaLectura, BigInteger slaFrecuenciaLecturaPm) {
        this.idEntidad = idEntidad;
        this.entidad = entidad;
        this.nombreEntidad = nombreEntidad;
        this.correoSoporte = correoSoporte;
        this.slaDisponibilidadTransaccion = slaDisponibilidadTransaccion;
        this.slaConfirmacionTransaccion = slaConfirmacionTransaccion;
        this.slaProcesamientoNotificacion = slaProcesamientoNotificacion;
        this.slaFrecuenciaLectura = slaFrecuenciaLectura;
        this.slaFrecuenciaLecturaPm = slaFrecuenciaLecturaPm;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }


    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getCorreoSoporte() {
        return correoSoporte;
    }

    public void setCorreoSoporte(String correoSoporte) {
        this.correoSoporte = correoSoporte;
    }

    public BigInteger getSlaDisponibilidadTransaccion() {
        return slaDisponibilidadTransaccion;
    }

    public void setSlaDisponibilidadTransaccion(BigInteger slaDisponibilidadTransaccion) {
        this.slaDisponibilidadTransaccion = slaDisponibilidadTransaccion;
    }

    public BigInteger getSlaConfirmacionTransaccion() {
        return slaConfirmacionTransaccion;
    }

    public void setSlaConfirmacionTransaccion(BigInteger slaConfirmacionTransaccion) {
        this.slaConfirmacionTransaccion = slaConfirmacionTransaccion;
    }

    public BigInteger getSlaProcesamientoNotificacion() {
        return slaProcesamientoNotificacion;
    }

    public void setSlaProcesamientoNotificacion(BigInteger slaProcesamientoNotificacion) {
        this.slaProcesamientoNotificacion = slaProcesamientoNotificacion;
    }

    public BigInteger getSlaFrecuenciaLectura() {
        return slaFrecuenciaLectura;
    }

    public void setSlaFrecuenciaLectura(BigInteger slaFrecuenciaLectura) {
        this.slaFrecuenciaLectura = slaFrecuenciaLectura;
    }

    public BigInteger getSlaFrecuenciaLecturaPm() {
        return slaFrecuenciaLecturaPm;
    }

    public void setSlaFrecuenciaLecturaPm(BigInteger slaFrecuenciaLecturaPm) {
        this.slaFrecuenciaLecturaPm = slaFrecuenciaLecturaPm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        return !((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad)));
    }

    @Override
    public String toString() {
        return "vuce.gob.pe.app.model.Entidad[ idEntidad=" + idEntidad + " ]";
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

  

}
