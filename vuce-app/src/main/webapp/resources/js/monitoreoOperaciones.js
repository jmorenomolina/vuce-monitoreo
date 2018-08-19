var contextApi = "http://localhost:9000/api";
        $(document).ready(function () {
            
            
                        
            actionOperaciones.executeEntidades();
            actionOperaciones.executeAllReport();
            
           
            setInterval(function(){ 
                        console.log("refresh");
                        actionOperaciones.executeAllReport();                    
                    }, 10000);
            
        });
        
        
        
        var actionOperaciones = {
                          
                
                executeAllReport: function () {
               
                        actionOperaciones.executeOperacionesTable(false);
                        actionOperaciones.executeOperacionesLineBarPeticiones();
                        actionOperaciones.executeOperacionesLineBarFallas();
               
                },
                executeEntidades: function () {
                        $.ajax({
                                url: contextApi + "/entidades",
                                complete: function () {
                                    var selectDemo = $('#entidades');
                                    selectDemo.selectpicker('refresh');
                                }
                        }).done(function (data) {
                            var $select = $('#entidades');
                            $select.find('option').remove();
                            $select.append('<option value="-1" selected="selected">Todos</option>');
                            $.each(data, function (key, value)
                            {
                                $select.append('<option value=' + value.idEntidad + '>' + value.entidad + '</option>');
                            });
                        });
                },
                executeOperacionesTable: function (isNew) {
                    $.ajax({
                        url: contextApi + "/reporte/operaciones",
                        data: $("#form-search").serialize()
                    }).done(function (data) {
                        var dataSet = [];
                        $.each(data, function (key, value)
                        {
                            var row = [];                             
                            row.push(value.nombreOperacion);
                            row.push(value.fechaSolicitud);
                            row.push(value.horaSolicitud);                            
                            row.push(value.cantidadPeticiones);
                            row.push(value.cantidadFallas);
                            
                            if(value.fiabilidad<90){
                              row.push("<span class='operaciones-red'>"+value.fiabilidad+"</span>");
                            }else{
                              row.push("<span>"+value.fiabilidad+"</span>");  
                            }
                            
                             if(value.tiempoRespuestaProm>60000){
                              row.push("<span class='operaciones-red'>"+value.tiempoRespuestaProm+"</span>");
                            }else{
                              row.push("<span>"+value.tiempoRespuestaProm+"</span>");  
                            }
                        
                            row.push(value.tiempoRespuestaMin);                              
                            row.push(value.tiempoRespuestaMax);     
                            dataSet.push(row);
                        });
                        if(isNew){
                            graphic.createTable("tb-operaciones",dataSet,true); 
                        }else{
                            graphic.updateTable("tb-operaciones",dataSet,true);  
                        }
                           
                    });
                },
                executeOperacionesLineBarPeticiones: function () {
                    $.ajax({
                        url: contextApi + "/reporte/operaciones/grafico",
                        data: $("#form-search").serialize()
                    }).done(function (data) {
                        var dataSet = [];
                        var fechas = [];
                        var resultados = [];
                        $.each(data, function (key, value)
                        {       
                            resultados.push(value.cantidadPeticiones);
                            fechas.push(value.horaSolicitud);                           
                        });
                        var data = {
                            label: 'Peticiones',                           
                            backgroundColor: 'rgba(48, 90, 210, 0.7)',
                            borderColor:  'rgba(48, 90, 210, 0.7)',
                            data: resultados,                            
                            borderWidth: 0,
                            fill: false
                        };
                        dataSet.push(data);                        
                        graphic.createLine("distribucion-peticiones", fechas, dataSet,"Cantidad");
                           
                    });
                },
                  executeOperacionesLineBarFallas: function () {
                    $.ajax({
                        url: contextApi + "/reporte/operaciones/grafico",
                        data: $("#form-search").serialize()
                    }).done(function (data) {
                          var dataSet = [];
                          var fechas = [];
                          var resultados = [];
                        $.each(data, function (key, value)
                        {       
                            resultados.push(value.tiempoRespuestaProm);
                            fechas.push(value.horaSolicitud);  
                        });
                                                
                        
                         var data = {
                            label: 'Tiempo Promedio',                           
                            backgroundColor: 'rgba(241, 33, 33, 0.7)',
                            borderColor:  'rgba(241, 33, 33, 0.7)',
                            data: resultados,                            
                            borderWidth: 0,
                            fill: false
                        };
                    
                                          
                        
                        dataSet.push(data);
                        
                        graphic.createLine("distribucion-fallas", fechas, dataSet,"Cantidad");
                       
                        
                           
                    });
                }
                
                
                

        }