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

import vuce.gob.pe.app.dto.ConfiguracionMonitoreoDTO;
import vuce.gob.pe.app.dto.MensajeSalidaDTO;
import vuce.gob.pe.app.dto.RequestFiltrarTransmisionesDTO;
import vuce.gob.pe.app.dto.TrasmisionDTO;
import vuce.gob.pe.app.dto.TrasmisionIncidenteDTO;
import vuce.gob.pe.app.util.RestAppException;

/**
 *
 * @author cquevedo
 */
public interface TransmisionesService {
    
    public List<TrasmisionIncidenteDTO> obtenerTransmisionesConIncidente(Date fechaInicio,Date fechaFin) throws RestAppException;
    
    public List<ConfiguracionMonitoreoDTO> obtenerConfiguracionMonitoreo(Integer entidadId) throws RestAppException;
     
    public List<TrasmisionDTO> filtrarTransmisiones(RequestFiltrarTransmisionesDTO request)  throws RestAppException;
    
    public MensajeSalidaDTO reenviarTransaccionSalidaConError(Integer vcId,String vcTransaccion,Integer veId, String veTransaccion)  throws RestAppException; 
    
    public MensajeSalidaDTO habilitarTransmision(Integer veId)  throws RestAppException;    
    
    public MensajeSalidaDTO reprocesarTransaccionEntradaConError(Integer vcId,String vcTransaccion,Integer veId,String veTransaccion)  throws RestAppException;
    
    public MensajeSalidaDTO anularTransaccionEntradaConError(Integer veId, String veTransaccion,Integer vcId,String vcTransaccion)  throws RestAppException;
        
    public MensajeSalidaDTO reporcesarTransaccionEntradaN8ConError(Integer entidadId,Date fechaInicio,Date fechaFin)  throws RestAppException;
    
    public void actualizarConfiguracionMonitoreo(Integer entidadId,String correoSoporte,String slaNombre, Integer slaValor,String estado)  throws RestAppException;
    
    public MensajeSalidaDTO detenerTrasmision(Integer entidadId,Date fechaInicio,Date fechaFin)  throws RestAppException;   
    
}
