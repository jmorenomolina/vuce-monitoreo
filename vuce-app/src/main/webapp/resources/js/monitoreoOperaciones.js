var contextApi = "http://localhost:9000/api";
        $(document).ready(function () {
            
            $('#datepickerDesde').datepicker({
                autoclose: true,
                dateFormat: 'dd/mm/yyyy'
           });
            
            $('#datepickerHasta').datepicker({
                autoclose: true,
                dateFormat: 'dd/mm/yyyy'
           });
            
               
            $("#datepickerDesde").val(actionOperaciones.getDate());
            $("#datepickerHasta").val(actionOperaciones.getDate());
            
            
            
            document.getElementById("filtrar-incidentes").onclick = function () {
                actionOperaciones.executeAllReport();
              
            };
            
            
            $(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
            
            
            actionOperaciones.executeEntidades();
            actionOperaciones.executeAllReport();
            /*
             setInterval(function(){ 
                        console.log("refresh");
                        action.executeAllReport();                    
                    }, 60000);*/
            
        });
        
        
        
        var actionOperaciones = {
                          
                getDate: function () {
               
                    var today = new Date();
                    var dd = today.getDate();
                    var mm = today.getMonth()+1; //January is 0!
                    var yyyy = today.getFullYear();

                    if(dd<10) {
                        dd = '0'+dd
                    } 

                    if(mm<10) {
                        mm = '0'+mm
                    } 

                    return dd + '/' + mm + '/' + yyyy;
               
                },
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
                            row.push(value.entidad);
                            row.push(value.nombreOperacion);
                            row.push(value.fechaSolicitud);
                            row.push(value.cantidadPeticiones);
                            row.push(value.cantidadFallas);
                            
                            if(value.fiabilidad<90){
                              row.push("<span class='operaciones-red'>"+value.fiabilidad+"</span>");
                            }else{
                              row.push("<span>"+value.fiabilidad+"</span>");  
                            }
                            
                             if(value.tiempoRespuestaProm>60){
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
                            if(value.entidad==="APN"){
                                resultados.push(value.sumCantidadPeticiones);
                                fechas.push(value.graficoOperacionPk.fechaSolicitud);
                            }
                           
                           
                        });
                                                
                        
                        var dataApn = {
                            label: 'APN',
                            backgroundColor: 'rgba(255, 99, 132, 0.7)',
                            borderColor:  'rgba(255, 99, 132, 0.7)',
                            data: resultados,                            
                            borderWidth: 0,
                            fill: false
                        };
                    
                        
                  
                        var resultados = [];
                        $.each(data, function (key, value)
                        {  
                            if(value.entidad==="SENASA"){
                                resultados.push(value.sumCantidadPeticiones);
                              
                            }
                           
                        });
                        
                         var dataSenasa = {
                            label: 'Senasa',
                            backgroundColor:   'rgba(153, 102, 255, 1)',
                            borderColor:      'rgba(153, 102, 255, 1)',
                            data: resultados,                            
                            borderWidth: 0,
                            fill: false
                        };                       
                        
                        dataSet.push(dataApn);
                        dataSet.push(dataSenasa);
                        
                        graphic.createLine("distribucion-peticiones", fechas, dataSet,"Peticiones");
                       
                        
                           
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
                            if(value.entidad==="APN"){
                                resultados.push(value.sumCantidadFallas);
                                fechas.push(value.graficoOperacionPk.fechaSolicitud);
                            }
                           
                           
                        });
                                                
                        
                        var dataApn = {
                            label: 'APN',
                            backgroundColor: 'rgba(255, 99, 132, 0.7)',
                            borderColor:  'rgba(255, 99, 132, 0.7)',
                            data: resultados,                            
                            borderWidth: 0,
                            fill: false
                        };
                    
                        
                  
                        var resultados = [];
                        $.each(data, function (key, value)
                        {  
                            if(value.entidad==="SENASA"){
                                resultados.push(value.sumCantidadFallas);
                              
                            }
                           
                        });
                        
                         var dataSenasa = {
                            label: 'Senasa',
                            backgroundColor:   'rgba(153, 102, 255, 1)',
                            borderColor:      'rgba(153, 102, 255, 1)',
                            data: resultados,                            
                            borderWidth: 0,
                            fill: false
                        };                       
                        
                        dataSet.push(dataApn);
                        dataSet.push(dataSenasa);
                        
                             graphic.createLine("distribucion-fallas", fechas, dataSet,"Fallas");
                       
                        
                           
                    });
                }
                
                
                

        }