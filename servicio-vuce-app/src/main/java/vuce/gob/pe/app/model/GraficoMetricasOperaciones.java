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
@Table(name = "GRAFICO_METRICAS_OPERACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GraficoMetricasOperaciones.findAll", query = "SELECT g FROM GraficoMetricasOperaciones g")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findById", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.id = :id")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByNombreOperacion", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.nombreOperacion = :nombreOperacion")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByFechaSolicitud", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByHoraSolicitud", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.horaSolicitud = :horaSolicitud")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByCantidadPeticiones", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.cantidadPeticiones = :cantidadPeticiones")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByCantidadFallas", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.cantidadFallas = :cantidadFallas")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByFiabilidad", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.fiabilidad = :fiabilidad")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByTiempoRespuestaProm", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.tiempoRespuestaProm = :tiempoRespuestaProm")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByTiempoRespuestaMin", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.tiempoRespuestaMin = :tiempoRespuestaMin")
    , @NamedQuery(name = "GraficoMetricasOperaciones.findByTiempoRespuestaMax", query = "SELECT g FROM GraficoMetricasOperaciones g WHERE g.tiempoRespuestaMax = :tiempoRespuestaMax")})
public class GraficoMetricasOperaciones implements Serializable {

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

    public GraficoMetricasOperaciones() {
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
