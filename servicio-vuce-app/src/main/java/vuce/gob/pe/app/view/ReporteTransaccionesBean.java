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
package vuce.gob.pe.app.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Consultor
 */
@Component
@ViewScoped
public class ReporteTransaccionesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Getter
    @Setter
    private List<String> entidades = new ArrayList<>();
    @Getter
    @Setter
    private String entidadesJson;

    @Getter
    @Setter
    private List<Integer> cantidades = new ArrayList<>();
    @Getter
    @Setter
    private String cantidadesJson;

    @Getter
    @Setter
    private String entidad;

  
    private List<String> contacts;

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @PostConstruct
    public void init() {
/*
        transaccionesSinConfirmar = repository.findAll();
        if (Optional.ofNullable(transaccionesSinConfirmar).isPresent() && !transaccionesSinConfirmar.isEmpty()) {
            transaccionesSinConfirmar.stream().filter(distinctByKey(b -> b.getEntidad())).forEach(e -> {
                entidades.add(e.getEntidad().toUpperCase());
            });

            /*por cada entidad el numero de transacciones*/
/*
            entidades.forEach(e -> {
                TransaccionSinConfirmar entidadTemp = new TransaccionSinConfirmar();
                entidadTemp.setEntidad(e);

                logger.info("Buscando: " + entidadTemp.getEntidad());

                Integer cantidad = Collections.frequency(transaccionesSinConfirmar, entidadTemp);
                cantidades.add(cantidad);
            });

            try {
                ObjectMapper mapper = new ObjectMapper();
                entidadesJson = mapper.writeValueAsString(entidades);
                logger.info("entidadesJson: " + entidadesJson);

                cantidadesJson = mapper.writeValueAsString(cantidades);
                logger.info("cantidades: " + cantidadesJson);

            } catch (JsonProcessingException ex) {
                java.util.logging.Logger.getLogger(ReporteTransaccionesBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ResumenTransaccionesDTO demo1 = new ResumenTransaccionesDTO();
        demo1.setEntidad("SENASA");
        demo1.setIncidentes(55);
        demo1.setNotificaciones(520);
        demo1.setTransacciones(800);
        ResumenTransaccionesDTO demo2 = new ResumenTransaccionesDTO();
        demo2.setEntidad("APN");
        demo2.setIncidentes(80);
        demo2.setNotificaciones(380);
        demo2.setTransacciones(460);
        ResumenTransaccionesDTO demo3 = new ResumenTransaccionesDTO();
        demo3.setEntidad("DICAPI");
        demo3.setIncidentes(36);
        demo3.setNotificaciones(726);
        demo3.setTransacciones(938);
        ResumenTransaccionesDTO demo4 = new ResumenTransaccionesDTO();
        demo4.setEntidad("OSINERGMIN");
        demo4.setIncidentes(10);
        demo4.setNotificaciones(428);
        demo4.setTransacciones(768);

        resumenTransacciones.add(demo1);
        resumenTransacciones.add(demo2);
        resumenTransacciones.add(demo3);
        resumenTransacciones.add(demo4);
*/
    }

}
