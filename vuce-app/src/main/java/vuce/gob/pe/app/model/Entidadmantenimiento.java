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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Skinet
 */
@Entity
@Table(name = "ENTIDADMANTENIMIENTO", schema="MTOBJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidadmantenimiento.findAll", query = "SELECT e FROM Entidadmantenimiento e")
    , @NamedQuery(name = "Entidadmantenimiento.findByFechaInicio", query = "SELECT e FROM Entidadmantenimiento e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Entidadmantenimiento.findByFechaFin", query = "SELECT e FROM Entidadmantenimiento e WHERE e.fechaFin = :fechaFin")
    , @NamedQuery(name = "Entidadmantenimiento.findByIdEntidadMantenimiento", query = "SELECT e FROM Entidadmantenimiento e WHERE e.idEntidadMantenimiento = :idEntidadMantenimiento")})
public class Entidadmantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTIDADMANTENIMIENTO_SEQ")
    @SequenceGenerator(sequenceName = "ENTIDADMANTENIMIENTO_SEQ", name = "ENTIDADMANTENIMIENTO_SEQ")
    @Column(name = "ID_ENTIDAD_MANTENIMIENTO")
    private Integer idEntidadMantenimiento;
    
    
    @JoinColumn(name = "ID_ENTIDAD", referencedColumnName = "ID_ENTIDAD")
    @ManyToOne(optional = false)
    private Entidad idEntidad;

    public Entidadmantenimiento() {
    }

    public Entidadmantenimiento(Integer idEntidadMantenimiento) {
        this.idEntidadMantenimiento = idEntidadMantenimiento;
    }

    public Entidadmantenimiento(Integer idEntidadMantenimiento, Date fechaInicio, Date fechaFin) {
        this.idEntidadMantenimiento = idEntidadMantenimiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdEntidadMantenimiento() {
        return idEntidadMantenimiento;
    }

    public void setIdEntidadMantenimiento(Integer idEntidadMantenimiento) {
        this.idEntidadMantenimiento = idEntidadMantenimiento;
    }

    public Entidad getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidad idEntidad) {
        this.idEntidad = idEntidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidadMantenimiento != null ? idEntidadMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidadmantenimiento)) {
            return false;
        }
        Entidadmantenimiento other = (Entidadmantenimiento) object;
        return !((this.idEntidadMantenimiento == null && other.idEntidadMantenimiento != null) || (this.idEntidadMantenimiento != null && !this.idEntidadMantenimiento.equals(other.idEntidadMantenimiento)));
    }

    @Override
    public String toString() {
        return "Entidadmantenimiento{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", idEntidadMantenimiento=" + idEntidadMantenimiento + ", idEntidad=" + idEntidad + '}';
    }

}
