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
import vuce.gob.pe.app.model.TransaccionIncidente;
import vuce.gob.pe.app.repository.TransaccionIncidenteRepository;
import vuce.gob.pe.app.rest.dto.ReenviarTransaccionResponse;

/**
 *
 * @author Skinet
 */
@Service
@Transactional
public class TransaccionIncidenteServiceImpl implements TransaccionIncidenteService {

    public static final Logger logger = LoggerFactory.getLogger(TransaccionIncidenteServiceImpl.class);

    @Autowired
    private TransaccionIncidenteRepository transaccionIncidenteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TransaccionIncidente> findAll() {
        return (List<TransaccionIncidente>) transaccionIncidenteRepository.findAll();
    }

    @Override
    public List<ReenviarTransaccionResponse> reenviarTransaccion(List<String> trasmisiones) {
        List<ReenviarTransaccionResponse> resultado = new ArrayList<>();
        if (!trasmisiones.isEmpty()) {
            trasmisiones.forEach(t -> {
                resultado.add(new ReenviarTransaccionResponse(t, transaccionIncidenteRepository.reenviarTransaccion(t)));
            });
        }
        return resultado;
    }

    @Override
    public List<TransaccionIncidente> findByEntitidades(List<Integer> entidades, List<String> tipoMensajes, List<String> tipoDocumentos, Date fechadesde, Date fechahasta, String nroDocumento,List<String> tipoTransaccion) {

        logger.info("{}", entidades);
        logger.info("{}", tipoMensajes);
        logger.info("{}", tipoDocumentos);
        logger.info("{}", fechadesde);
        logger.info("{}", fechahasta);
        logger.info("{}", nroDocumento);

        String sql = "SELECT g FROM TransaccionIncidente g WHERE "
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
        /*
        if (fechadesde != null) {
            sql += "( :p_fecha_desde IS NULL OR ( :p_fecha_desde IS NOT NULL AND to_date(g.fechaCreacion,'dd/mm/yyyy') >= TO_DATE(:p_fecha_desde,'dd/mm/yyyy'))) AND ";
        }
        
        if (fechahasta != null) {
            sql += "( :p_fecha_hasta IS NULL OR ( :p_fecha_hasta IS NOT NULL AND to_date(g.fechaCreacion,'dd/mm/yyyy') <= TO_DATE(:p_fecha_hasta,'dd/mm/yyyy'))) AND ";
        }*/
        
        if (tipoTransaccion != null && !tipoTransaccion.isEmpty()) {
             if(tipoTransaccion.size()<2){
                 if(!tipoTransaccion.get(0).equals("0")){
                     sql += "( g.tipo in (:tipoTransaccion) ) AND ";
                 }               
             }
            
        }

        sql += " 1=1 ";

        Query query = this.entityManager.createQuery(sql);
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
        if (tipoTransaccion != null && !tipoTransaccion.isEmpty()) {
            
            List<BigInteger> tipos = new ArrayList<>();
            if(tipoTransaccion.size()<2){
                if(!tipoTransaccion.get(0).equals("0")){
                    tipoTransaccion.forEach(t->{          
                        tipos.add(new BigInteger(t));
                    });
                   query.setParameter("tipoTransaccion", tipos);
                }
            } 
        }
        
        /*
        if (fechadesde != null) {
            query.setParameter("p_fecha_desde", fechadesde);
        }
        if (fechahasta != null) {
            query.setParameter("p_fecha_hasta", fechahasta);
        }*/

        return query.getResultList();
    }

}