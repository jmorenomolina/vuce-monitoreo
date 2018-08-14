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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Skinet
 */
@Entity
@Table(name = "MONITOREO_OPERACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonitoreoOperacion.findAll", query = "SELECT m FROM MonitoreoOperacion m")
    , @NamedQuery(name = "MonitoreoOperacion.findByEntidad", query = "SELECT m FROM MonitoreoOperacion m WHERE m.entidad = :entidad")
    , @NamedQuery(name = "MonitoreoOperacion.findByNombreOperacion", query = "SELECT m FROM MonitoreoOperacion m WHERE m.nombreOperacion = :nombreOperacion")
    , @NamedQuery(name = "MonitoreoOperacion.findByFechaSolicitud", query = "SELECT m FROM MonitoreoOperacion m WHERE m.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "MonitoreoOperacion.findByCantidadPeticiones", query = "SELECT m FROM MonitoreoOperacion m WHERE m.cantidadPeticiones = :cantidadPeticiones")
    , @NamedQuery(name = "MonitoreoOperacion.findByCantidadFallas", query = "SELECT m FROM MonitoreoOperacion m WHERE m.cantidadFallas = :cantidadFallas")
    , @NamedQuery(name = "MonitoreoOperacion.findByFiabilidad", query = "SELECT m FROM MonitoreoOperacion m WHERE m.fiabilidad = :fiabilidad")
    , @NamedQuery(name = "MonitoreoOperacion.findByTiempoRespuestaProm", query = "SELECT m FROM MonitoreoOperacion m WHERE m.tiempoRespuestaProm = :tiempoRespuestaProm")
    , @NamedQuery(name = "MonitoreoOperacion.findByTiempoRespuestaMin", query = "SELECT m FROM MonitoreoOperacion m WHERE m.tiempoRespuestaMin = :tiempoRespuestaMin")
    , @NamedQuery(name = "MonitoreoOperacion.findByTiempoRespuestaMax", query = "SELECT m FROM MonitoreoOperacion m WHERE m.tiempoRespuestaMax = :tiempoRespuestaMax")})
public class MonitoreoOperacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID")
    private Integer id;
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
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_OPERACION")
    private String nombreOperacion;
    @Size(max = 10)
    @Column(name = "FECHA_SOLICITUD")
    private String fechaSolicitud;
    @Column(name = "CANTIDAD_PETICIONES")
    private BigInteger cantidadPeticiones;
    @Column(name = "CANTIDAD_FALLAS")
    private BigInteger cantidadFallas;
    @Column(name = "FIABILIDAD")
    private BigInteger fiabilidad;
    @Column(name = "TIEMPO_RESPUESTA_PROM")
    private BigInteger tiempoRespuestaProm;
    @Column(name = "TIEMPO_RESPUESTA_MIN")
    private BigInteger tiempoRespuestaMin;
    @Column(name = "TIEMPO_RESPUESTA_MAX")
    private BigInteger tiempoRespuestaMax;

    public MonitoreoOperacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public BigInteger getCantidadPeticiones() {
        return cantidadPeticiones;
    }

    public void setCantidadPeticiones(BigInteger cantidadPeticiones) {
        this.cantidadPeticiones = cantidadPeticiones;
    }

    public BigInteger getCantidadFallas() {
        return cantidadFallas;
    }

    public void setCantidadFallas(BigInteger cantidadFallas) {
        this.cantidadFallas = cantidadFallas;
    }

    public BigInteger getFiabilidad() {
        return fiabilidad;
    }

    public void setFiabilidad(BigInteger fiabilidad) {
        this.fiabilidad = fiabilidad;
    }

    public BigInteger getTiempoRespuestaProm() {
        return tiempoRespuestaProm;
    }

    public void setTiempoRespuestaProm(BigInteger tiempoRespuestaProm) {
        this.tiempoRespuestaProm = tiempoRespuestaProm;
    }

    public BigInteger getTiempoRespuestaMin() {
        return tiempoRespuestaMin;
    }

    public void setTiempoRespuestaMin(BigInteger tiempoRespuestaMin) {
        this.tiempoRespuestaMin = tiempoRespuestaMin;
    }

    public BigInteger getTiempoRespuestaMax() {
        return tiempoRespuestaMax;
    }

    public void setTiempoRespuestaMax(BigInteger tiempoRespuestaMax) {
        this.tiempoRespuestaMax = tiempoRespuestaMax;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }
        
}
