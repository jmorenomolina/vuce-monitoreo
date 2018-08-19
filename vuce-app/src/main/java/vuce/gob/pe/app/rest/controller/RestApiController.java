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

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vuce.gob.pe.app.model.Entidad;
import vuce.gob.pe.app.model.FrecuenciaLectura;
import vuce.gob.pe.app.model.GraficoMetricasOperaciones;
import vuce.gob.pe.app.model.GraficoNotificacionIncidente;
import vuce.gob.pe.app.model.GraficoTransaccionIncidente;
import vuce.gob.pe.app.model.MetricasOperaciones;
import vuce.gob.pe.app.model.NotificacionIncidente;
import vuce.gob.pe.app.model.TransaccionIncidente;
import vuce.gob.pe.app.repository.EntidadRepository;
import vuce.gob.pe.app.rest.dto.AnularNotificacionResponse;
import vuce.gob.pe.app.service.FrecuenciaLecturaService;
import vuce.gob.pe.app.service.GraficoNotificacionIncidenteService;
import vuce.gob.pe.app.service.GraficoTransaccionIncidenteService;
import vuce.gob.pe.app.service.NotificacionIncidenteService;
import vuce.gob.pe.app.service.TransaccionIncidenteService;
import vuce.gob.pe.app.rest.dto.ReenviarTransaccionResponse;
import vuce.gob.pe.app.rest.dto.ReprocesarNotificacionResponse;
import vuce.gob.pe.app.service.GraficoMetricasOperacionesService;
import vuce.gob.pe.app.service.MetricasOperacionesService;

/**
 *
 * @author Consultor
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Inject
    private final EntidadRepository repositoryEntidad = null;

    @Autowired
    private final TransaccionIncidenteService repositoryTransaccionIncidente = null;

    @Autowired
    private final NotificacionIncidenteService repositoryNotificacionIncidente = null;

    @Autowired
    private final GraficoTransaccionIncidenteService repositoryGraficoTransaccion = null;

    @Autowired
    private final GraficoNotificacionIncidenteService repositoryGraficoNotificacion = null;

    @Autowired
    private final FrecuenciaLecturaService repositoryFrecuenciaLectura = null;

    @Autowired
    private final MetricasOperacionesService repositoryMetricasOperacionesService = null;

    @Autowired
    private final GraficoMetricasOperacionesService repositoryGraficoOperacionesService = null;

    private static final String ALL_DATA = "-1";

    @RequestMapping(value = "/entidades", method = RequestMethod.GET)
    public ResponseEntity<List<Entidad>> entidades() {

        List<Entidad> entidades = (List<Entidad>) repositoryEntidad.findAll();
        if (entidades.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entidades, HttpStatus.OK);
    }

    @RequestMapping(value = "/reporte/transaccion/incidentes", method = RequestMethod.GET)
    public ResponseEntity<List<GraficoTransaccionIncidente>> reporteTransaccionesIncidentes(@RequestParam(name = "entidades", required = false) List<String> entidades) {
        List<GraficoTransaccionIncidente> reporte;
        if (entidades != null && !entidades.isEmpty()) {
            List<Integer> entidadesInteger = new ArrayList<>();
            entidades.forEach(e -> {
                if (!ALL_DATA.equals(e)) {
                    entidadesInteger.add(Integer.parseInt(e));
                }
            });
            if (entidadesInteger.isEmpty()) {
                reporte = repositoryGraficoTransaccion.findAll();
            } else {
                reporte = repositoryGraficoTransaccion.findByEntitidades(entidadesInteger);
            }

        } else {
            reporte = repositoryGraficoTransaccion.findAll();
        }

        if (reporte.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @RequestMapping(value = "/reporte/notificacion/incidentes", method = RequestMethod.GET)
    public ResponseEntity<List<GraficoNotificacionIncidente>> reporteNoptificacionIncidentes(@RequestParam(name = "entidades", required = false) List<String> entidades) {

        List<GraficoNotificacionIncidente> reporte;
        if (entidades != null && !entidades.isEmpty()) {
            List<Integer> entidadesInteger = new ArrayList<>();
            entidades.forEach(e -> {
                if (!ALL_DATA.equals(e)) {
                    entidadesInteger.add(Integer.parseInt(e));
                }
            });
            if (entidadesInteger.isEmpty()) {
                reporte = repositoryGraficoNotificacion.findAll();
            } else {
                reporte = repositoryGraficoNotificacion.findByEntitidades(entidadesInteger);
            }

        } else {
            reporte = repositoryGraficoNotificacion.findAll();
        }

        if (reporte.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @RequestMapping(value = "/reporte/transaccion/con/incidentes", method = RequestMethod.GET)
    public ResponseEntity<List<TransaccionIncidente>> transaccionConIncidentes(@RequestParam(name = "entidades", required = false) List<String> entidades) {
        List<TransaccionIncidente> transacciones;
        if (entidades != null && !entidades.isEmpty()) {
            List<Integer> entidadesInteger = new ArrayList<>();
            entidades.forEach(e -> {
                if (!ALL_DATA.equals(e)) {
                    entidadesInteger.add(Integer.parseInt(e));
                }
            });
            if (entidadesInteger.isEmpty()) {
                transacciones = repositoryTransaccionIncidente.findAll();
            } else {
                transacciones = repositoryTransaccionIncidente.findByEntitidades(entidadesInteger);
            }

        } else {
            transacciones = repositoryTransaccionIncidente.findAll();
        }
        if (transacciones.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transacciones, HttpStatus.OK);

    }

    @RequestMapping(value = "/reporte/notificacion/con/incidentes", method = RequestMethod.GET)
    public ResponseEntity<List<NotificacionIncidente>> notificacionConIncidentes(@RequestParam(name = "entidades", required = false) List<String> entidades) {
        List<NotificacionIncidente> noticaciones;
        if (entidades != null && !entidades.isEmpty()) {
            List<Integer> entidadesInteger = new ArrayList<>();
            entidades.forEach(e -> {
                if (!ALL_DATA.equals(e)) {
                    entidadesInteger.add(Integer.parseInt(e));
                }
            });
            if (entidadesInteger.isEmpty()) {
                noticaciones = repositoryNotificacionIncidente.findAll();
            } else {
                noticaciones = repositoryNotificacionIncidente.findByEntitidades(entidadesInteger);
            }

        } else {
            noticaciones = repositoryNotificacionIncidente.findAll();
        }
        if (noticaciones.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(noticaciones, HttpStatus.OK);
    }

    @RequestMapping(value = "/reporte/transaccion/reenviar", method = RequestMethod.GET)
    public ResponseEntity<List<ReenviarTransaccionResponse>> transaccionesReenviar(@RequestParam(name = "transaccion", required = true) List<String> transaccion) {
        List<ReenviarTransaccionResponse> response = new ArrayList();
        if (transaccion != null && !transaccion.isEmpty()) {
            response = repositoryTransaccionIncidente.reenviarTransaccion(transaccion);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reporte/notificacion/anular", method = RequestMethod.GET)
    public ResponseEntity<List<AnularNotificacionResponse>> anularNotificacion(@RequestParam(name = "notificacion", required = true) List<String> notificacion) {
        List<AnularNotificacionResponse> response = new ArrayList();
        if (notificacion != null && !notificacion.isEmpty()) {
            response = repositoryNotificacionIncidente.anularNotificacion(notificacion);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reporte/notificacion/reprocesar", method = RequestMethod.GET)
    public ResponseEntity<List<ReprocesarNotificacionResponse>> reprocesarNotificacion(@RequestParam(name = "notificacion", required = true) List<String> notificacion) {
        List<ReprocesarNotificacionResponse> response = new ArrayList();
        if (notificacion != null && !notificacion.isEmpty()) {
            response = repositoryNotificacionIncidente.reprocesarNotificacion(notificacion);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reporte/frecuencia/lectura", method = RequestMethod.GET)
    public ResponseEntity<List<FrecuenciaLectura>> frecuenciaLectura(@RequestParam(name = "entidades", required = false) List<String> entidades) {
        List<FrecuenciaLectura> frecuenciaLectura;
        if (entidades != null && !entidades.isEmpty()) {
            List<Integer> entidadesInteger = new ArrayList<>();
            entidades.forEach(e -> {
                if (!ALL_DATA.equals(e)) {
                    entidadesInteger.add(Integer.parseInt(e));
                }
            });
            if (entidadesInteger.isEmpty()) {
                frecuenciaLectura = repositoryFrecuenciaLectura.findAll();
            } else {
                frecuenciaLectura = repositoryFrecuenciaLectura.findByEntitidades(entidadesInteger);
            }

        } else {
            frecuenciaLectura = repositoryFrecuenciaLectura.findAll();
        }
        if (frecuenciaLectura.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(frecuenciaLectura, HttpStatus.OK);
    }

    @RequestMapping(value = "/reporte/operaciones", method = RequestMethod.GET)
    public ResponseEntity<List<MetricasOperaciones>> obtenerOperaciones() {
        List<MetricasOperaciones> operaciones = repositoryMetricasOperacionesService.findAll();
        if (operaciones.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(operaciones, HttpStatus.OK);
    }

    @RequestMapping(value = "/reporte/operaciones/grafico", method = RequestMethod.GET)
    public ResponseEntity<List<GraficoMetricasOperaciones>> obtenerOperacionesGrafico() {

        List<GraficoMetricasOperaciones> operaciones = operaciones = repositoryGraficoOperacionesService.findAll();

        if (operaciones.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(operaciones, HttpStatus.OK);
    }

}
