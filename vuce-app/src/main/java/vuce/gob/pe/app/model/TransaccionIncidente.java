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
@Table(name = "TRANSACCION_INCIDENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransaccionIncidente.findAll", query = "SELECT t FROM TransaccionIncidente t")
    , @NamedQuery(name = "TransaccionIncidente.findByTipo", query = "SELECT t FROM TransaccionIncidente t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TransaccionIncidente.findByEntidad", query = "SELECT t FROM TransaccionIncidente t WHERE t.entidad = :entidad")
    , @NamedQuery(name = "TransaccionIncidente.findByIdTransmision", query = "SELECT t FROM TransaccionIncidente t WHERE t.idTransmision = :idTransmision")
    , @NamedQuery(name = "TransaccionIncidente.findByTipoMensaje", query = "SELECT t FROM TransaccionIncidente t WHERE t.tipoMensaje = :tipoMensaje")
    , @NamedQuery(name = "TransaccionIncidente.findByTipoDocumento", query = "SELECT t FROM TransaccionIncidente t WHERE t.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "TransaccionIncidente.findByNumeroDocumento", query = "SELECT t FROM TransaccionIncidente t WHERE t.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "TransaccionIncidente.findByTamanoAdjuntos", query = "SELECT t FROM TransaccionIncidente t WHERE t.tamanoAdjuntos = :tamanoAdjuntos")
    , @NamedQuery(name = "TransaccionIncidente.findByFechaCreacion", query = "SELECT t FROM TransaccionIncidente t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TransaccionIncidente.findByFechaPrimeraLectura", query = "SELECT t FROM TransaccionIncidente t WHERE t.fechaPrimeraLectura = :fechaPrimeraLectura")
    , @NamedQuery(name = "TransaccionIncidente.findByFechaConfirmacion", query = "SELECT t FROM TransaccionIncidente t WHERE t.fechaConfirmacion = :fechaConfirmacion")
    , @NamedQuery(name = "TransaccionIncidente.findByAntiguedad", query = "SELECT t FROM TransaccionIncidente t WHERE t.antiguedad = :antiguedad")
    , @NamedQuery(name = "TransaccionIncidente.findByCantidadLecturas", query = "SELECT t FROM TransaccionIncidente t WHERE t.cantidadLecturas = :cantidadLecturas")})


@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "reenviarTransaccion", procedureName = "REENVIAR_TRANSACCION", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_transmision", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "mensaje", type = String.class) })})
public class TransaccionIncidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TIPO")
    private BigInteger tipo;
    @Basic(optional = false)
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
    @Column(name = "ID_TRANSMISION")
    private BigInteger idTransmision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "TIPO_MENSAJE")
    private String tipoMensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Column(name = "TAMANO_ADJUNTOS")
    private BigInteger tamanoAdjuntos;
    @Size(max = 16)
    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;
    @Size(max = 16)
    @Column(name = "FECHA_PRIMERA_LECTURA")
    private String fechaPrimeraLectura;
    @Size(max = 16)
    @Column(name = "FECHA_CONFIRMACION")
    private String fechaConfirmacion;
    @Column(name = "ANTIGUEDAD")
    private BigInteger antiguedad;
    @Column(name = "CANTIDAD_LECTURAS")
    private BigInteger cantidadLecturas;
    @Lob
    @Column(name = "EBXML")
    private String ebxml;
    @Lob
    @Column(name = "MENSAJEXML")
    private String mensajexml;

    public TransaccionIncidente() {
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

    public BigInteger getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(BigInteger idTransmision) {
        this.idTransmision = idTransmision;
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

    public BigInteger getTamanoAdjuntos() {
        return tamanoAdjuntos;
    }

    public void setTamanoAdjuntos(BigInteger tamanoAdjuntos) {
        this.tamanoAdjuntos = tamanoAdjuntos;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaPrimeraLectura() {
        return fechaPrimeraLectura;
    }

    public void setFechaPrimeraLectura(String fechaPrimeraLectura) {
        this.fechaPrimeraLectura = fechaPrimeraLectura;
    }

    public String getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(String fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public BigInteger getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(BigInteger antiguedad) {
        this.antiguedad = antiguedad;
    }

    public BigInteger getCantidadLecturas() {
        return cantidadLecturas;
    }

    public void setCantidadLecturas(BigInteger cantidadLecturas) {
        this.cantidadLecturas = cantidadLecturas;
    }

    public String getEbxml() {
        return ebxml;
    }

    public void setEbxml(String ebxml) {
        this.ebxml = ebxml;
    }

    public String getMensajexml() {
        return mensajexml;
    }

    public void setMensajexml(String mensajexml) {
        this.mensajexml = mensajexml;
    }
    
}
