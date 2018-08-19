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
package vuce.gob.pe.app.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuce.gob.pe.app.model.GraficoNotificacionIncidente;
import vuce.gob.pe.app.repository.GraficoNotificacionIncidenteRepository;

/**
 *
 * @author Skinet
 */
@Service
public class GraficoNotificacionIncidenteServiceImpl implements GraficoNotificacionIncidenteService{

    @Autowired
    private GraficoNotificacionIncidenteRepository  graficoNotificacionIncidenteRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<GraficoNotificacionIncidente> findAll() {
        return (List<GraficoNotificacionIncidente>)graficoNotificacionIncidenteRepository.findAll();
    }

    @Override
    public List<GraficoNotificacionIncidente> findByEntitidades(List<Integer> selectedValues) {
       return this.entityManager.createQuery("SELECT g FROM GraficoNotificacionIncidente g WHERE g.idEntidad in (:selectedValues)", GraficoNotificacionIncidente.class)
				.setParameter("selectedValues", selectedValues)
                                .getResultList();
    }
    
}
