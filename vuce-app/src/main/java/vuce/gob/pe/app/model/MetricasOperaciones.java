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
@Table(name = "METRICAS_OPERACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetricasOperaciones.findAll", query = "SELECT m FROM MetricasOperaciones m")
    , @NamedQuery(name = "MetricasOperaciones.findById", query = "SELECT m FROM MetricasOperaciones m WHERE m.id = :id")
    , @NamedQuery(name = "MetricasOperaciones.findByNombreOperacion", query = "SELECT m FROM MetricasOperaciones m WHERE m.nombreOperacion = :nombreOperacion")
    , @NamedQuery(name = "MetricasOperaciones.findByFechaSolicitud", query = "SELECT m FROM MetricasOperaciones m WHERE m.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "MetricasOperaciones.findByHoraSolicitud", query = "SELECT m FROM MetricasOperaciones m WHERE m.horaSolicitud = :horaSolicitud")
    , @NamedQuery(name = "MetricasOperaciones.findByCantidadPeticiones", query = "SELECT m FROM MetricasOperaciones m WHERE m.cantidadPeticiones = :cantidadPeticiones")
    , @NamedQuery(name = "MetricasOperaciones.findByCantidadFallas", query = "SELECT m FROM MetricasOperaciones m WHERE m.cantidadFallas = :cantidadFallas")
    , @NamedQuery(name = "MetricasOperaciones.findByFiabilidad", query = "SELECT m FROM MetricasOperaciones m WHERE m.fiabilidad = :fiabilidad")
    , @NamedQuery(name = "MetricasOperaciones.findByTiempoRespuestaProm", query = "SELECT m FROM MetricasOperaciones m WHERE m.tiempoRespuestaProm = :tiempoRespuestaProm")
    , @NamedQuery(name = "MetricasOperaciones.findByTiempoRespuestaMin", query = "SELECT m FROM MetricasOperaciones m WHERE m.tiempoRespuestaMin = :tiempoRespuestaMin")
    , @NamedQuery(name = "MetricasOperaciones.findByTiempoRespuestaMax", query = "SELECT m FROM MetricasOperaciones m WHERE m.tiempoRespuestaMax = :tiempoRespuestaMax")})
public class MetricasOperaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_OPERACION")
    private String nombreOperacion;
    @Size(max = 10)
    @Column(name = "FECHA_SOLICITUD")
    private String fechaSolicitud;
    @Size(max = 2)
    @Column(name = "HORA_SOLICITUD")
    private String horaSolicitud;
    @Column(name = "CANTIDAD_PETICIONES")
    private BigInteger cantidadPeticiones;
    @Column(name = "CANTIDAD_FALLAS")
    private BigInteger cantidadFallas;
    @Column(name = "FIABILIDAD")
    private BigDecimal fiabilidad;
    @Column(name = "TIEMPO_RESPUESTA_PROM")
    private BigDecimal tiempoRespuestaProm;
    @Column(name = "TIEMPO_RESPUESTA_MIN")
    private BigDecimal tiempoRespuestaMin;
    @Column(name = "TIEMPO_RESPUESTA_MAX")
    private BigDecimal tiempoRespuestaMax;

    public MetricasOperaciones() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(String horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
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

    public BigDecimal getFiabilidad() {
        return fiabilidad;
    }

    public void setFiabilidad(BigDecimal fiabilidad) {
        this.fiabilidad = fiabilidad;
    }

    public BigDecimal getTiempoRespuestaProm() {
        return tiempoRespuestaProm;
    }

    public void setTiempoRespuestaProm(BigDecimal tiempoRespuestaProm) {
        this.tiempoRespuestaProm = tiempoRespuestaProm;
    }

    public BigDecimal getTiempoRespuestaMin() {
        return tiempoRespuestaMin;
    }

    public void setTiempoRespuestaMin(BigDecimal tiempoRespuestaMin) {
        this.tiempoRespuestaMin = tiempoRespuestaMin;
    }

    public BigDecimal getTiempoRespuestaMax() {
        return tiempoRespuestaMax;
    }

    public void setTiempoRespuestaMax(BigDecimal tiempoRespuestaMax) {
        this.tiempoRespuestaMax = tiempoRespuestaMax;
    }
    
}
