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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "GRAFICO_OPERACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GraficoOperacion.findAll", query = "SELECT g FROM GraficoOperacion g")
    , @NamedQuery(name = "GraficoOperacion.findByEntidad", query = "SELECT g FROM GraficoOperacion g WHERE g.entidad = :entidad")
    , @NamedQuery(name = "GraficoOperacion.findBySumCantidadPeticiones", query = "SELECT g FROM GraficoOperacion g WHERE g.sumCantidadPeticiones = :sumCantidadPeticiones")
    , @NamedQuery(name = "GraficoOperacion.findBySumCantidadFallas", query = "SELECT g FROM GraficoOperacion g WHERE g.sumCantidadFallas = :sumCantidadFallas")

})
public class GraficoOperacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected GraficoOperacionPk graficoOperacionPk;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ENTIDAD")
    private String entidad;

    @Column(name = "SUM_CANTIDAD_PETICIONES")
    private BigInteger sumCantidadPeticiones;
    @Column(name = "SUM_CANTIDAD_FALLAS")
    private BigInteger sumCantidadFallas;

    public GraficoOperacion() {
    }

    public GraficoOperacionPk getGraficoOperacionPk() {
        return graficoOperacionPk;
    }

    public void setGraficoOperacionPk(GraficoOperacionPk graficoOperacionPk) {
        this.graficoOperacionPk = graficoOperacionPk;
    }
    

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public BigInteger getSumCantidadPeticiones() {
        return sumCantidadPeticiones;
    }

    public void setSumCantidadPeticiones(BigInteger sumCantidadPeticiones) {
        this.sumCantidadPeticiones = sumCantidadPeticiones;
    }

    public BigInteger getSumCantidadFallas() {
        return sumCantidadFallas;
    }

    public void setSumCantidadFallas(BigInteger sumCantidadFallas) {
        this.sumCantidadFallas = sumCantidadFallas;
    }

}
