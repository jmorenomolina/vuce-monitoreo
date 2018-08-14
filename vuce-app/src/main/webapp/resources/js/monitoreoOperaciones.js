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
            
               
            $("#datepickerDesde").val(action.getDate());
            $("#datepickerHasta").val(action.getDate());
            
            
            
            document.getElementById("filtrar-incidentes").onclick = function () {
                action.executeAllReport();
            };
            
            
            $(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
            
            
            action.executeEntidades();
            action.executeNotificacionIncidentesTable();
            /*
             setInterval(function(){ 
                        console.log("refresh");
                        action.executeAllReport();                    
                    }, 60000);*/
            
        });
        
        
        
        var action = {
                          
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
               
                        action.executeNotificacionIncidentesTable(false);
               
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
                executeNotificacionIncidentesTable: function (isNew) {
                    $.ajax({
                        url: contextApi + "/reporte/notificacion/con/incidentes",
                        data: $("#form-search").serialize()
                    }).done(function (data) {
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
                           
                    });
                }
                
                

        }