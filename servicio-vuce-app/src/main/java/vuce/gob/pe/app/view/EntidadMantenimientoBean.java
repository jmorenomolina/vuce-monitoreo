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
package vuce.gob.pe.app.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import vuce.gob.pe.app.model.Entidad;
import vuce.gob.pe.app.model.Entidadmantenimiento;
import vuce.gob.pe.app.repository.EntidadMantebimientoRepository;
import vuce.gob.pe.app.repository.EntidadRepository;

/**
 *
 * @author Consultor
 */
@Component
@ViewScoped
public class EntidadMantenimientoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @Autowired
    private final EntidadMantebimientoRepository repositoryEntidadMantenimiento = null;
    
    @Autowired
    private final EntidadRepository repositoryEntidad = null;
    
    @Getter
    @Setter
    private List<Entidadmantenimiento> mantenimientos;
    
    @Getter
    @Setter
    private Entidadmantenimiento mantenimiento;    
    
    @Getter
    @Setter
    private List<Entidad> entidades;
    
    @Getter
    @Setter
    private Entidad entidad;
    
    @Getter
    @Setter
    private Boolean disabledForm = Boolean.TRUE;
    
    @Getter
    @Setter
    private Date currentDate = new Date();

  
    
    @PostConstruct
    public void init() {
        logger.info("EntidadMantenimientoBean [{}]", "init");        
        mantenimientos = (List<Entidadmantenimiento>) repositoryEntidadMantenimiento.findAll();        
        entidades = (List<Entidad>) repositoryEntidad.findAll(); 
        mantenimiento = new Entidadmantenimiento();
    }
    
    public void activateForm() {
        logger.info("EntidadMantenimientoBean [{}]", "activateForm");        
        disabledForm = Boolean.FALSE;
       /* if(Optional.ofNullable(this.getMantenimiento()).isPresent()){
            Entidad entidadTemp = this.getEntidades().stream().filter(e->Objects.equals(e.getIdEntidad(), this.getMantenimiento().getIdEntidad().getIdEntidad())).findAny().orElse(null);
            this.setEntidad(entidadTemp);
        }*/
    }
    
    public void addMantenimiento() {
        logger.info("EntidadMantenimientoBean [{}] [{}]", "addMantenimiento",mantenimiento.toString());        
        try {
            Entidadmantenimiento mantenimientoInsert = new Entidadmantenimiento();            
            mantenimientoInsert.setIdEntidad(entidad);   
            mantenimientoInsert.setFechaFin(mantenimiento.getFechaFin());
            mantenimientoInsert.setFechaInicio(mantenimiento.getFechaInicio());            
            repositoryEntidadMantenimiento.save(mantenimientoInsert);       
            mantenimientos = (List<Entidadmantenimiento>) repositoryEntidadMantenimiento.findAll();      
            this.addMessage(FacesMessage.SEVERITY_INFO, "Se registro el mantenimiento para la entidad " + entidad.getEntidad() + " correctamente", null);
            entidad = null;
            disabledForm = Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Error [addMantenimiento]", e);
            this.addMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar el mantenimiento", null);
        }        
    }
    
    public void updateMantenimiento() {
        try {            
            mantenimiento.setIdEntidadMantenimiento(entidad.getIdEntidad()); 
            repositoryEntidadMantenimiento.save(mantenimiento);
            this.addMessage(FacesMessage.SEVERITY_INFO, "Se actualizo el mantemiento  correctamente", null);
            entidad = null;
            disabledForm = Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Error [updateEntidad]", e);
            this.addMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el mantenimiento", null);
        }        
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<Entidadmantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Entidadmantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Entidadmantenimiento getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(Entidadmantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public List<Entidad> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<Entidad> entidades) {
		this.entidades = entidades;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Boolean getDisabledForm() {
		return disabledForm;
	}

	public void setDisabledForm(Boolean disabledForm) {
		this.disabledForm = disabledForm;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Logger getLogger() {
		return logger;
	}

	public EntidadMantebimientoRepository getRepositoryEntidadMantenimiento() {
		return repositoryEntidadMantenimiento;
	}

	public EntidadRepository getRepositoryEntidad() {
		return repositoryEntidad;
	}
    
    
    
}
