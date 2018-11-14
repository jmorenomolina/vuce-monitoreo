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
package vuce.gob.pe.app.rest.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import vuce.gob.pe.app.dto.TrasmisionDTO;
import vuce.gob.pe.app.model.Entidad;
import vuce.gob.pe.app.repository.EntidadRepository;
import vuce.gob.pe.app.service.TransmisionesService;

/**
 *
 * @author cquevedo
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private final EntidadRepository repositoryEntidad = null;
    
    
    @Autowired
    private final TransmisionesService repositoryTransmisionesService = null;


    @RequestMapping(value = "/entidades", method = RequestMethod.GET)
    public ResponseEntity<List<Entidad>> entidades() {

        List<Entidad> entidades = (List<Entidad>) repositoryEntidad.findAll();
        if (entidades.isEmpty()) {
            return new ResponseEntity<List<Entidad>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entidades, HttpStatus.OK);
    }

    

    @RequestMapping(value = "/tramisiones", method = RequestMethod.GET)
    public ResponseEntity<List<TrasmisionDTO>> trasmisiones() {

        List<TrasmisionDTO> transmisiones = (List<TrasmisionDTO>) repositoryTransmisionesService.obtenerTransmisionesConIncidente(new Date(), new Date());
        if (transmisiones.isEmpty()) {
            return new ResponseEntity<List<TrasmisionDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transmisiones, HttpStatus.OK);
    }
    


}
