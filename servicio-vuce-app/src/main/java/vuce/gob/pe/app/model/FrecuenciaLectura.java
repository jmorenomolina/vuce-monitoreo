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
@Table(name = "FRECUENCIA_LECTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrecuenciaLectura.findAll", query = "SELECT f FROM FrecuenciaLectura f")
    , @NamedQuery(name = "FrecuenciaLectura.findByIdEntidad", query = "SELECT f FROM FrecuenciaLectura f WHERE f.idEntidad = :idEntidad")
    , @NamedQuery(name = "FrecuenciaLectura.findByEntidad", query = "SELECT f FROM FrecuenciaLectura f WHERE f.entidad = :entidad")
    , @NamedQuery(name = "FrecuenciaLectura.findByEnMantenimiento", query = "SELECT f FROM FrecuenciaLectura f WHERE f.enMantenimiento = :enMantenimiento")
    , @NamedQuery(name = "FrecuenciaLectura.findByFrecuenciaLecturaEsperada", query = "SELECT f FROM FrecuenciaLectura f WHERE f.frecuenciaLecturaEsperada = :frecuenciaLecturaEsperada")
    , @NamedQuery(name = "FrecuenciaLectura.findByFrecuenciaLecturaActual", query = "SELECT f FROM FrecuenciaLectura f WHERE f.frecuenciaLecturaActual = :frecuenciaLecturaActual")
    , @NamedQuery(name = "FrecuenciaLectura.findByCumpleFrecuenciaLectura", query = "SELECT f FROM FrecuenciaLectura f WHERE f.cumpleFrecuenciaLectura = :cumpleFrecuenciaLectura")})
public class FrecuenciaLectura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ENTIDAD")
    private Integer idEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ENTIDAD")
    private String entidad;
    @Column(name = "EN_MANTENIMIENTO")
    private BigInteger enMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRECUENCIA_LECTURA_ESPERADA")
    private BigInteger frecuenciaLecturaEsperada;
    @Column(name = "FRECUENCIA_LECTURA_ACTUAL")
    private BigInteger frecuenciaLecturaActual;
    @Column(name = "CUMPLE_FRECUENCIA_LECTURA")
    private BigInteger cumpleFrecuenciaLectura;

    public FrecuenciaLectura() {
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public BigInteger getEnMantenimiento() {
        return enMantenimiento;
    }

    public void setEnMantenimiento(BigInteger enMantenimiento) {
        this.enMantenimiento = enMantenimiento;
    }

    public BigInteger getFrecuenciaLecturaEsperada() {
        return frecuenciaLecturaEsperada;
    }

    public void setFrecuenciaLecturaEsperada(BigInteger frecuenciaLecturaEsperada) {
        this.frecuenciaLecturaEsperada = frecuenciaLecturaEsperada;
    }

    public BigInteger getFrecuenciaLecturaActual() {
        return frecuenciaLecturaActual;
    }

    public void setFrecuenciaLecturaActual(BigInteger frecuenciaLecturaActual) {
        this.frecuenciaLecturaActual = frecuenciaLecturaActual;
    }

    public BigInteger getCumpleFrecuenciaLectura() {
        return cumpleFrecuenciaLectura;
    }

    public void setCumpleFrecuenciaLectura(BigInteger cumpleFrecuenciaLectura) {
        this.cumpleFrecuenciaLectura = cumpleFrecuenciaLectura;
    }
    
}
