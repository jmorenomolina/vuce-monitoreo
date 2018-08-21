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
import vuce.gob.pe.app.model.TransaccionIncidente;
import vuce.gob.pe.app.rest.dto.ReenviarTransaccionResponse;

/**
 *
 * @author Skinet
 */
public interface TransaccionIncidenteService {
    
    public List<TransaccionIncidente> findAll();
     
    public List<TransaccionIncidente> findByEntitidades(List<Integer> entidades,List<String> tipoMensajes,List<String> tipoDocumentos,Date fechadesde,Date fechaHasta,String nroDocumento);  
    
    public List<ReenviarTransaccionResponse> reenviarTransaccion(List<String> trasmisiones);
     
    
}
