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
import vuce.gob.pe.app.model.FrecuenciaLectura;
import vuce.gob.pe.app.repository.FrecuenciaLecturaRepository;

/**
 *
 * @author Skinet
 */
@Service
public class FrecuenciaLecturaServiceImpl implements FrecuenciaLecturaService{

    @Autowired
    private FrecuenciaLecturaRepository  frecuenciaLecturaRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<FrecuenciaLectura> findAll() {
        return (List<FrecuenciaLectura>)frecuenciaLecturaRepository.findAll();
    }

    @Override
    public List<FrecuenciaLectura> findByEntitidades(List<Integer> selectedValues) {
       return this.entityManager.createQuery("SELECT g FROM FrecuenciaLectura g WHERE g.idEntidad in (:selectedValues)", FrecuenciaLectura.class)
				.setParameter("selectedValues", selectedValues)
                                .getResultList();
    }
    
}
