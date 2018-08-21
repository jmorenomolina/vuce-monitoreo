var contextApi = "http://localhost:9000/api";


        $(document).ready(function () {            
            
            $('#check-transacciones-all').change(function() {
                var checkboxes = $('input[name="transaccion"]');
                checkboxes.prop('checked', $(this).is(':checked'));
            });
            
            $('#check-notificaciones-all').change(function() {
                var checkboxes = $('input[name="notificacion"]');
                checkboxes.prop('checked', $(this).is(':checked'));
            });
  
  
            $('#datepickerDesde').datepicker({
                autoclose: true,
                dateFormat: 'dd/mm/yyyy'
            });
            
            $('#datepickerHasta').datepicker({
                autoclose: true,
                dateFormat: 'dd/mm/yyyy'
            });
            
            $("#datepickerDesde").val(action.getDate());
            $("#datepickerHasta").val(action.getDate());
            
            
            document.getElementById("filtrar-incidentes").onclick = function () {
                action.executeAllReport();
            };
            document.getElementById("btn-renviar-trasmisiones").onclick = function () {
                action.executeReenviarTransacciones();
            };
            
            document.getElementById("btn-anular-notificacion").onclick = function () {
                action.executeAnularNotificacion()();
            };
            
            document.getElementById("btn-reprocesar-notificacion").onclick = function () {
                action.executeReProcesarNotificacion();
            };
            
            
            
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            });
            
            
            action.executeEntidades();
            action.executeTipoMensajes();
            action.executeTransaccionIncidentes();
            action.executeNotificacionIncidentes();
            action.executeTransaccionIncidentesTable(true);
            action.executeNotificacionIncidentesTable(true);
            action.executeFrecuenciaLectura(true);
            /*
             setInterval(function(){ 
                        console.log("refresh");
                        action.executeAllReport();                    
                    }, 30000);*/
            
        });
        
        
        
        var action = {
                 
                 getDate: function () {               
                    var today = new Date();
                    var dd = today.getDate();
                    var mm = today.getMonth()+1; //January is 0!
                    var yyyy = today.getFullYear();
                    if(dd<10) {
                        dd = '0'+dd;
                    } 

                    if(mm<10) {
                        mm = '0'+mm;
                    } 

                    return dd + '/' + mm + '/' + yyyy;
               
                },          
                executeAllReport: function () {
                        action.executeTransaccionIncidentes();
                        action.executeNotificacionIncidentes();
                        action.executeTransaccionIncidentesTable(false);
                        action.executeNotificacionIncidentesTable(false);
                        action.executeFrecuenciaLectura(false);
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
                            $select.append('<option value="-1" selected="selected">Todas</option>');
                            $.each(data, function (key, value)
                            {
                                $select.append('<option value=' + value.idEntidad + '>' + value.entidad + '</option>');
                            });
                        });
                },
                executeTipoMensajes: function () {
                        $.ajax({
                                url: contextApi + "/tipomensajes",
                                complete: function () {
                                    var select = $('#tipomensajes');
                                    select.selectpicker('refresh');
                                }
                        }).done(function (data) {
                            var $select = $('#tipomensajes');
                            $select.find('option').remove();
                            $select.append('<option value="-1" selected="selected">Todos</option>');
                            $.each(data, function (key, value)
                            {
                                $select.append('<option value=' + value.codigo + '>' + value.codigo + '</option>');
                            });
                        });
                },
                executeTransaccionIncidentes: function () {
                        $.ajax({
                            url: contextApi + "/reporte/transaccion/incidentes",
                            data: $("#form-search").serialize()
                        }).done(function (data) {
                            
                            
                            var entidades = [];
                            var resultados = [];
                            $.each(data, function (key, value)
                            {
                                entidades.push(value.entidad);
                                resultados.push(value.cantidadIncidentes);
                            });
                            graphic.createBar("transacciones-procesadas", entidades, resultados, "Transacciones");
                        });
                },
                executeNotificacionIncidentes: function () {
                        $.ajax({
                            url: contextApi + "/reporte/notificacion/incidentes",
                            data: $("#form-search").serialize()
                        }).done(function (data) {
                            var entidades = [];
                            var resultados = [];
                            $.each(data, function (key, value)
                            {
                                entidades.push(value.entidad);
                                resultados.push(value.cantidadIncidentes);
                            });
                            graphic.createBar("notificaciones-incidencias", entidades, resultados, "Notificaciones");
                        });
                },
                executeTransaccionIncidentesTable: function (isNew) {
                    $.ajax({
                        url: contextApi + "/reporte/transaccion/con/incidentes",
                        data: $("#form-search").serialize()
                    }).done(function (data, textStatus, xhr) {
                        
                       if(xhr.status===200){                            
                             
                            var dataSet = [];
                            $.each(data, function (key, value)
                            {
                                var row = [];                            
                                row.push((value.tipo===3)? "<input type='checkbox' name='transaccion' value='"+value.idTransmision+"'/>":"");                            
                                row.push("<div class='tipo-transacciones-" + value.tipo + "'></div>");
                                row.push(value.entidad);
                                row.push(value.idTransmision);
                                row.push(value.tipoMensaje);
                                row.push(value.tipoDocumento);
                                row.push(value.numeroDocumento);
                                row.push(value.tamanoAdjuntos);
                                row.push(value.fechaCreacion);
                                row.push(value.fechaPrimeraLectura);
                                row.push(value.fechaConfirmacion);
                                row.push(value.antiguedad+ " min");
                                row.push(value.cantidadLecturas);
                                row.push("Ver");
                                row.push("Ver");
                                dataSet.push(row);
                            });
                            if(isNew){
                                graphic.createTable("tb-transaccion-incidente",dataSet,true); 
                            }else{
                                graphic.updateTable("tb-transaccion-incidente",dataSet);  
                            } 
                            
                        }else{
                               var dataSet = [];
                               graphic.cleanTable("tb-transaccion-incidente");  
                        }
                    
                                                 
                    });
                },
                executeReenviarTransacciones: function(){                                        
                    $.ajax({
                        url: contextApi + "/reporte/transaccion/reenviar",
                        data: $('input[name="transaccion"]:checked').serialize()
                    }).done(function (data) {
                        
                       
                        var dataSet = [];
                        $.each(data, function (key, value)
                        {
                            var row = []; 
                            row.push(value.idTransmision);
                            row.push(value.resultado);
                            dataSet.push(row);
                        });
                        action.executeTransaccionIncidentesTable(false);    
                        
                        $('#modal-reenviar-transacciones').modal('toggle');
                        
                        if ( !$.fn.DataTable.isDataTable( '#tb-respuesta-transaccion' ) ) {
                            graphic.createTable("tb-respuesta-transaccion",dataSet,false); 
                        }else{
                            graphic.updateTable("tb-respuesta-transaccion",dataSet,false);   
                        }                        
                        $('#modal-reenviar-transacciones-response').modal('toggle');                        
                    });                    
                },
                executeAnularNotificacion: function(){                                        
                    $.ajax({
                        url: contextApi + "/reporte/notificacion/anular",
                        data: $('input[name="notificacion"]:checked').serialize()
                    }).done(function (data) {
                        var dataSet = [];
                        $.each(data, function (key, value)
                        {
                            var row = []; 
                            row.push(value.vcId);
                            row.push(value.resultado);
                            dataSet.push(row);
                        });
                        action.executeNotificacionIncidentesTable(false);    
                        
                        $("#span-text").html("Anular");
                        $('#modal-anular-notificacion').modal('toggle');
                        
                        if ( !$.fn.DataTable.isDataTable( '#tb-respuesta-notificacion' ) ) {
                            graphic.createTable("tb-respuesta-notificacion",dataSet,false); 
                        }else{
                            graphic.updateTable("tb-respuesta-notificacion",dataSet,false);   
                        }                        
                        $('#modal-notificacion-response').modal('toggle');                        
                    });                    
                },
                executeReProcesarNotificacion: function(){                                        
                    $.ajax({
                        url: contextApi + "/reporte/notificacion/reprocesar",
                        data: $('input[name="notificacion"]:checked').serialize()
                    }).done(function (data) {
                        var dataSet = [];
                        $.each(data, function (key, value)
                        {
                            var row = []; 
                            row.push(value.vcId);
                            row.push(value.resultado);
                            dataSet.push(row);
                        });
                        action.executeNotificacionIncidentesTable(false);    
                   
                        $('#modal-reprocesar-notificacion').modal('toggle');
                        
                        if ( !$.fn.DataTable.isDataTable( '#tb-respuesta-notificacion' ) ) {
                            graphic.createTable("tb-respuesta-notificacion",dataSet,false); 
                        }else{
                            graphic.updateTable("tb-respuesta-notificacion",dataSet,false);   
                        }                        
                        $('#modal-notificacion-response').modal('toggle');                        
                    });                    
                },
                executeNotificacionIncidentesTable: function (isNew) {
                    $.ajax({
                        url: contextApi + "/reporte/notificacion/con/incidentes",
                        data: $("#form-search").serialize()
                    }).done(function (data, textStatus, xhr) {
                        if(xhr.status===200){    
                          var dataSet = [];
                            $.each(data, function (key, value)
                            {
                                var row = [];                            
                                row.push((value.tipo===2)? "<input type='checkbox' name='notificacion' value='"+value.vcId+"' />":"");                            
                                row.push("<div class='tipo-transacciones-" + value.tipo + "'></div>");
                                row.push(value.entidad);
                                row.push(value.veId);
                                row.push(value.vcId);
                                row.push(value.tipoMensaje);
                                row.push(value.tipoDocumento);
                                row.push(value.numeroDocumento);
                                row.push(value.fechaRecepcion);
                                row.push(value.fechaProcesamiento);                              
                                row.push(value.antiguedad + " min");                        
                                row.push("Ver");
                                dataSet.push(row);
                            });
                            if(isNew){
                                graphic.createTable("tb-notificacion-incidente",dataSet,true); 
                            }else{
                                graphic.updateTable("tb-notificacion-incidente",dataSet,true);  
                            }
                        }else{
                            graphic.cleanTable("tb-notificacion-incidente");
                        }
                        
                           
                    });
                },
                executeFrecuenciaLectura: function (isNew) {
                    $.ajax({
                        url: contextApi + "/reporte/frecuencia/lectura",
                        data: $("#form-search").serialize()
                    }).done(function (data) {
                        var dataSet = [];
                        $.each(data, function (key, value)
                        {
                            var row = [];
                            row.push(value.entidad);   
                            row.push("<div class='tipo-frecuencia-" + value.enMantenimiento + "'></div>");
                            row.push(value.frecuenciaLecturaEsperada +" min");   
                            row.push(value.frecuenciaLecturaActual+" min");   
                            row.push("<div class='tipo-frecuencia-cumplimiento-" + value.cumpleFrecuenciaLectura + "'></div>");                        
                            dataSet.push(row);
                        });
                        if(isNew){
                            graphic.createTable("tb-frecuencia-transacciones",dataSet,true); 
                        }else{
                            graphic.updateTable("tb-frecuencia-transacciones",dataSet,true);  
                        }
                           
                    });
                }
                

        }