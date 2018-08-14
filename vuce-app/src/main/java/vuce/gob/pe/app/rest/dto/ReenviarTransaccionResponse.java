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
package vuce.gob.pe.app.rest.dto;

/**
 *
 * @author Skinet
 */
public class ReenviarTransaccionResponse {
    
    private String idTransmision;
    private String resultado;

    public ReenviarTransaccionResponse(String idTransmision, String resultado) {
        this.idTransmision = idTransmision;
        this.resultado = resultado;
    }

    
    public String getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(String idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ReenviarTransaccionResponse{" + "idTransmision=" + idTransmision + ", resultado=" + resultado + '}';
    }
    
    
    
}
