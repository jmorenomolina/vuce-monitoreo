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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vuce.gob.pe.app.model.GraficoMetricasOperaciones;
import vuce.gob.pe.app.repository.GraficoMetricasOperacionesRepository;

/**
 *
 * @author Skinet
 */
@Service
@Transactional
public class GraficoMetricasOperacionesImpl implements GraficoMetricasOperacionesService{

    @Autowired
    private GraficoMetricasOperacionesRepository  graficoOperacionesServiceRepository;
    
 
    @Override
    public List<GraficoMetricasOperaciones> findAll() {
        return (List<GraficoMetricasOperaciones>)graficoOperacionesServiceRepository.findAll();
    }


 
}
