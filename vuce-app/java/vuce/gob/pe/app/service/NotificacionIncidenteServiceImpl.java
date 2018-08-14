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
import vuce.gob.pe.app.model.NotificacionIncidente;
import vuce.gob.pe.app.repository.NotificacionIncidenteRepository;
import vuce.gob.pe.app.rest.dto.AnularNotificacionResponse;
import vuce.gob.pe.app.rest.dto.ReenviarTransaccionResponse;
import vuce.gob.pe.app.rest.dto.ReprocesarNotificacionResponse;

/**
 *
 * @author Skinet
 */
@Service
@Transactional
public class NotificacionIncidenteServiceImpl implements NotificacionIncidenteService {

    @Autowired
    private NotificacionIncidenteRepository notificacionIncidenteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NotificacionIncidente> findAll() {
        return (List<NotificacionIncidente>) notificacionIncidenteRepository.findAll();
    }

    @Override
    public List<NotificacionIncidente> findByEntitidades(List<Integer> selectedValues) {
        return this.entityManager.createQuery("SELECT g FROM NotificacionIncidente g WHERE g.idEntidad in (:selectedValues)", NotificacionIncidente.class)
                .setParameter("selectedValues", selectedValues)
                .getResultList();
    }

    @Override
    public List<AnularNotificacionResponse> anularNotificacion(List<String> vcIds) {
        List<AnularNotificacionResponse> resultado = new ArrayList<>();
        if (!vcIds.isEmpty()) {
            vcIds.forEach(t -> {
                resultado.add(new AnularNotificacionResponse(t, notificacionIncidenteRepository.anularNotificacion(t)));
            });
        }
        return resultado;
    }

    @Override
    public List<ReprocesarNotificacionResponse> reprocesarNotificacion(List<String> vcIds) {
        List<ReprocesarNotificacionResponse> resultado = new ArrayList<>();
        if (!vcIds.isEmpty()) {
            vcIds.forEach(t -> {
                resultado.add(new ReprocesarNotificacionResponse(t, notificacionIncidenteRepository.reprocesarNotificacion(t)));
            });
        }
        return resultado;
    }

}
