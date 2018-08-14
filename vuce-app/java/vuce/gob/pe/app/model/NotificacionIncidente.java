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
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author Skinet
 */
@Entity
@Table(name = "NOTIFICACION_INCIDENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificacionIncidente.findAll", query = "SELECT n FROM NotificacionIncidente n")
    , @NamedQuery(name = "NotificacionIncidente.findByTipo", query = "SELECT n FROM NotificacionIncidente n WHERE n.tipo = :tipo")
    , @NamedQuery(name = "NotificacionIncidente.findByEntidad", query = "SELECT n FROM NotificacionIncidente n WHERE n.entidad = :entidad")
    , @NamedQuery(name = "NotificacionIncidente.findByVcId", query = "SELECT n FROM NotificacionIncidente n WHERE n.vcId = :vcId")
    , @NamedQuery(name = "NotificacionIncidente.findByVeId", query = "SELECT n FROM NotificacionIncidente n WHERE n.veId = :veId")
    , @NamedQuery(name = "NotificacionIncidente.findByTipoMensaje", query = "SELECT n FROM NotificacionIncidente n WHERE n.tipoMensaje = :tipoMensaje")
    , @NamedQuery(name = "NotificacionIncidente.findByTipoDocumento", query = "SELECT n FROM NotificacionIncidente n WHERE n.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "NotificacionIncidente.findByNumeroDocumento", query = "SELECT n FROM NotificacionIncidente n WHERE n.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "NotificacionIncidente.findByFechaRecepcion", query = "SELECT n FROM NotificacionIncidente n WHERE n.fechaRecepcion = :fechaRecepcion")
    , @NamedQuery(name = "NotificacionIncidente.findByFechaProcesamiento", query = "SELECT n FROM NotificacionIncidente n WHERE n.fechaProcesamiento = :fechaProcesamiento")
    , @NamedQuery(name = "NotificacionIncidente.findByAntiguedad", query = "SELECT n FROM NotificacionIncidente n WHERE n.antiguedad = :antiguedad")})

@NamedStoredProcedureQueries({		
		@NamedStoredProcedureQuery(name = "anularNotificacion", procedureName = "ANULAR_NOTIFICACION", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "vc_id", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class) }),
		@NamedStoredProcedureQuery(name = "reprocesarNotificacion", procedureName = "REPROCESAR_NOTIFICACION", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "vc_id", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class) }) })
public class NotificacionIncidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TIPO")
    private BigInteger tipo;
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_ENTIDAD")
    private Integer idEntidad;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ENTIDAD")
    private String entidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VC_ID")
    private BigInteger vcId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VE_ID")
    private BigInteger veId;
    @Size(max = 20)
    @Column(name = "TIPO_MENSAJE")
    private String tipoMensaje;
    @Size(max = 20)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Id
    @Size(max = 20)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Column(name = "FECHA_RECEPCION")   
    private String fechaRecepcion;
    @Column(name = "FECHA_PROCESAMIENTO")
    private String fechaProcesamiento;
    @Column(name = "ANTIGUEDAD")
    private BigInteger antiguedad;
    @Lob
    @Column(name = "XML")
    private String xml;

    public NotificacionIncidente() {
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }    
    public BigInteger getTipo() {
        return tipo;
    }

    public void setTipo(BigInteger tipo) {
        this.tipo = tipo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public BigInteger getVcId() {
        return vcId;
    }

    public void setVcId(BigInteger vcId) {
        this.vcId = vcId;
    }

    public BigInteger getVeId() {
        return veId;
    }

    public void setVeId(BigInteger veId) {
        this.veId = veId;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(String fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public BigInteger getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(BigInteger antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
    
}
