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
@Table(name = "GRAFICO_TRANSACCION_INCIDENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GraficoTransaccionIncidente.findAll", query = "SELECT g FROM GraficoTransaccionIncidente g")
    , @NamedQuery(name = "GraficoTransaccionIncidente.findByEntidad", query = "SELECT g FROM GraficoTransaccionIncidente g WHERE g.entidad = :entidad")
    , @NamedQuery(name = "GraficoTransaccionIncidente.findByCantidadIncidentes", query = "SELECT g FROM GraficoTransaccionIncidente g WHERE g.cantidadIncidentes = :cantidadIncidentes")})
public class GraficoTransaccionIncidente implements Serializable {

    private static final long serialVersionUID = 1L;
   
    
    @Id
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
    @Column(name = "CANTIDAD_INCIDENTES")
    private BigInteger cantidadIncidentes;

    public GraficoTransaccionIncidente() {
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

    public BigInteger getCantidadIncidentes() {
        return cantidadIncidentes;
    }

    public void setCantidadIncidentes(BigInteger cantidadIncidentes) {
        this.cantidadIncidentes = cantidadIncidentes;
    }
    
}
