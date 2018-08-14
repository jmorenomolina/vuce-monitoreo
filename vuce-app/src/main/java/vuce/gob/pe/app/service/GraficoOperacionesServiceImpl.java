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

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuce.gob.pe.app.model.GraficoOperacion;
import vuce.gob.pe.app.repository.GraficoOperacionRepository;

/**
 *
 * @author Skinet
 */
@Service
@Transactional
public class GraficoOperacionesServiceImpl implements GraficoOperacionesService{

    @Autowired
    private GraficoOperacionRepository  graficoOperacionesServiceRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<GraficoOperacion> findAll() {
        return (List<GraficoOperacion>)graficoOperacionesServiceRepository.findAll();
    }

    @Override
    public List<GraficoOperacion> findByEntitidades(List<Integer> selectedValues,Date fechaDesde,Date fechaHasta) {
       return this.entityManager.createQuery("SELECT g FROM GraficoOperacion g WHERE g.graficoOperacionPk.idEntidad in (:selectedValues)", GraficoOperacion.class)
				.setParameter("selectedValues", selectedValues)
                                .getResultList();
    }

 
}
