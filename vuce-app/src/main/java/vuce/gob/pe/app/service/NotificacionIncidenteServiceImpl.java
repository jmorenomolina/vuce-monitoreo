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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuce.gob.pe.app.model.NotificacionIncidente;
import vuce.gob.pe.app.repository.NotificacionIncidenteRepository;
import vuce.gob.pe.app.rest.dto.AnularNotificacionResponse;
import vuce.gob.pe.app.rest.dto.ReenviarTransaccionResponse;
import vuce.gob.pe.app.rest.dto.ReprocesarNotificacionResponse;
import static vuce.gob.pe.app.service.TransaccionIncidenteServiceImpl.logger;

/**
 *
 * @author Skinet
 */
@Service
@Transactional
public class NotificacionIncidenteServiceImpl implements NotificacionIncidenteService {

    public static final Logger logger = LoggerFactory.getLogger(NotificacionIncidenteServiceImpl.class);
    
    @Autowired
    private NotificacionIncidenteRepository notificacionIncidenteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NotificacionIncidente> findAll() {
        return (List<NotificacionIncidente>) notificacionIncidenteRepository.findAll();
    }

    @Override
    public List<NotificacionIncidente> findByEntitidades(List<Integer> entidades, List<String> tipoMensajes, List<String> tipoDocumentos, Date fechadesde, Date fechahasta, String nroDocumento,List<String> tipoNotificacion) {
        
        logger.info("{}", entidades);
        logger.info("{}", tipoMensajes);
        logger.info("{}", tipoDocumentos);
        logger.info("{}", fechadesde);
        logger.info("{}", fechahasta);
        logger.info("{}", nroDocumento);

        String sql = "SELECT g FROM NotificacionIncidente g WHERE "
                + "( :nroDocumento IS NULL OR (  :nroDocumento is NOT NULL and g.numeroDocumento in (:nroDocumento)  ) ) AND ";
        if (entidades != null) {
            sql += "( g.idEntidad in (:entidades) ) AND ";
        }
        if (tipoMensajes != null) {
            sql += "( g.tipoMensaje in (:tipoMensajes) ) AND ";
        }
        if (tipoDocumentos != null) {
            sql += "( g.tipoDocumento in (:tipoDocumentos) ) AND ";
        }
        
        if (tipoNotificacion != null && !tipoNotificacion.isEmpty()) {
            sql += "( g.tipo in (:tipoNotificacion) ) AND ";
        }
        
        sql += " 1=1 ";

        Query query = this.entityManager.createQuery(sql, NotificacionIncidente.class);
        query.setParameter("nroDocumento", nroDocumento);
        if (entidades != null) {
            query.setParameter("entidades", entidades);
        }
        if (tipoMensajes != null) {
            query.setParameter("tipoMensajes", tipoMensajes);
        }
        if (tipoDocumentos != null) {
            query.setParameter("tipoDocumentos", tipoDocumentos);
        }        
       
        if (tipoNotificacion != null && !tipoNotificacion.isEmpty()) {  
            List<BigInteger> tipos = new ArrayList<>();
            tipoNotificacion.forEach(t->{          
                tipos.add(new BigInteger(t));
            });            
            query.setParameter("tipoNotificacion", tipos);
  
        }
        
        return query.getResultList();
        
       
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
