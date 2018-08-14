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

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuce.gob.pe.app.model.TransaccionIncidente;
import vuce.gob.pe.app.repository.TransaccionIncidenteRepository;
import vuce.gob.pe.app.rest.dto.ReenviarTransaccionResponse;

/**
 *
 * @author Skinet
 */
@Service
@Transactional
public class TransaccionIncidenteServiceImpl implements TransaccionIncidenteService{

    @Autowired
    private TransaccionIncidenteRepository  transaccionIncidenteRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<TransaccionIncidente> findAll() {
        return (List<TransaccionIncidente>)transaccionIncidenteRepository.findAll();
    }

    @Override
    public List<TransaccionIncidente> findByEntitidades(List<Integer> selectedValues) {
       return this.entityManager.createQuery("SELECT g FROM TransaccionIncidente g WHERE g.idEntidad in (:selectedValues)", TransaccionIncidente.class)
				.setParameter("selectedValues", selectedValues)
                                .getResultList();
    }

    @Override
    public List<ReenviarTransaccionResponse> reenviarTransaccion(List<String> trasmisiones) {
        List<ReenviarTransaccionResponse> resultado = new ArrayList<>();
        if(!trasmisiones.isEmpty()){
            trasmisiones.forEach(t->{
                resultado.add(new ReenviarTransaccionResponse(t, transaccionIncidenteRepository.reenviarTransaccion(t)));
            });
        }       
        return resultado;    
    }
    
}
