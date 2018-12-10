var contextApi = "http://localhost:9000/api";

var tableSalida = null;
var tableEntrada = null;

var xmlSalida = [];   
var ebXmlSalida = [];  
var errorSalida = [];  


var xmlEntrada = [];   
var ebXmlEntrada = [];  
var errorEntrada = [];  



var api = {	
	   callIntervalo: function () {
	          $.ajax({
	                  url: contextApi + "/intervalo",
	                  dataType: "json",	                 
	          }).done(function (data) {
	        	  console.log("Intervalo: "+data.valorParametro);
	        	  /*setInterval(function(){                       
		               api.callTransmisionesConIncidentes();                    
		           }, data.valorParametro);*/
	          });
	  },
	  callMinFecha: function () {
          $.ajax({
                  url: contextApi + "/fechaminima",
                  dataType: "json",	                 
          }).done(function (data) {
        	 
        	  
        	  $('#dp-fechadesde-tra-inc').attr('data-date-start-date','-'+data.valorParametro+'d');
        	  $('#dp-fechadesde-tra').attr('data-date-start-date','-'+data.valorParametro+'d');
        	  
        		var dateOption ={
       				 autoclose: true,
       		         format: 'dd/mm/yyyy'
       	  	  };
        	  $('#dp-fechadesde-tra-inc').datepicker(dateOption).on('changeDate',function(e){
        			if(util.validateDate('dp-fechadesde-tra-inc','dp-fechahasta-tra-inc')){
                   		api.callTransmisionesConIncidentes();
                   	}else{                   		
                   		alert("La fecha Hasta debe ser mayor a la fecha Desde");
                   	}
              });
        	  
        	  $('#dp-fechadesde-tra').datepicker(dateOption).on('changeDate',function(e){
      			if(!util.validateDate('dp-fechadesde-tra','dp-fechahasta-tra')){
      				alert("La fecha Hasta debe ser mayor a la fecha Desde");
                }
              });
        	  
        	  
        	  
        	  
        	  
              $('#dp-fechadesde-tra').datepicker(dateOption);  
        	
          });
	  },
	 callEntidades: function () {
              $.ajax({
                      url: contextApi + "/entidades",
                      dataType: "json",
                      complete: function () {
                          var selectDemo = $('#entidades');
                          selectDemo.selectpicker('refresh');
                          
                          var selectDetener= $('#entidades-detener');
                          selectDetener.selectpicker('refresh');
                          
                          var selectReprocesar= $('#entidades-reeprocesar-n8');
                          selectReprocesar.selectpicker('refresh');
                       }
              }).done(function (data) {
                  var $select = $('#entidades');
                  $select.find('option').remove();
                  $select.append('<option value="%" selected="selected">Todas</option>');
                  
                  var $selectEntidadesDetener = $('#entidades-detener');
                  var $selectEntidadesReeprocesar = $('#entidades-reeprocesar-n8');
                  
                  $selectEntidadesDetener.find('option').remove();
                  
                  $.each(data, function (key, value)
                  {
                      $select.append('<option value=' + value.idEntidad + '>' + value.descripcion + '</option>');                      
                      $selectEntidadesDetener.append('<option value=' + value.idEntidad + '>' + value.descripcion + '</option>');
                      $selectEntidadesReeprocesar.append('<option value=' + value.idEntidad + '>' + value.descripcion + '</option>');
                      
                     
                  });
              });
      },	
      callTipoMensajes: function () {
	          $.ajax({
	                  url: contextApi + "/tipomensaje",
	                  dataType: "json",
	                  complete: function () {
	                      var selectDemo = $('#tipomensajes');
	                      selectDemo.selectpicker('refresh');
	                   }
	          }).done(function (data) {
	              var $select = $('#tipomensajes');
	              $select.find('option').remove();
	              $select.append('<option value="%" selected="selected">Todos</option>');
	              $.each(data, function (key, value)
	              {
	                  $select.append('<option value=' + value.valorParametro + '>' + value.valorParametro + '</option>');
	              });
	          });
	  },
	  callTipoDocumentos: function () {
          $.ajax({
                  url: contextApi + "/tipodocumentos",
                  dataType: "json",
                  complete: function () {
                      var selectDemo = $('#tipo-documentos');
                      selectDemo.selectpicker('refresh');
                   }
          }).done(function (data) {
              var $select = $('#tipo-documentos');
              $select.find('option').remove();
              $select.append('<option value="%" selected="selected">Todos</option>');
              $.each(data, function (key, value)
              {
                  $select.append('<option value=' + value.valorParametro + '>' + value.valorParametro + '</option>');
              });
          });
	  },	
	  callTipoTransmision: function () {
          $.ajax({
                  url: contextApi + "/tipotransmision",
                  dataType: "json",
                  complete: function () {
                      var selectDemo = $('#tipo-transmision');
                      selectDemo.selectpicker('refresh');
                   }
          }).done(function (data) {
              var $select = $('#tipo-transmision');
              $select.find('option').remove();
              $select.append('<option value="1" >Todos</option>');
              $.each(data, function (key, value)
              {
                  $select.append('<option selected="selected" value=' + value.valorParametro + '>' + value.descParametro + '</option>');
              });
          });
	  },	
	  callTipoIncidente: function () {
	          $.ajax({
	                  url: contextApi + "/tipoincidente",
	                  dataType: "json",
	                  complete: function () {
	                      var selectDemo = $('#tipo-incidente');
	                      selectDemo.selectpicker('refresh');
	                   }
	          }).done(function (data) {
	              var $select = $('#tipo-incidente');
	              $select.find('option').remove();
	              $select.append('<option value="%" selected="selected">Todos</option>');
	              $.each(data, function (key, value)
	              {
	            	  $select.append('<option value=' + value.valorParametro + '>' + value.descParametro + '</option>');
	              });
	          });
	  },	
	  
	  callEstadoVuceCentral: function () {
	          $.ajax({
	                  url: contextApi + "/estado/vucecentral",
	                  dataType: "json",
	                  complete: function () {
	                      var selectDemo = $('#estado-vc-central');
	                      selectDemo.selectpicker('refresh');
	                   }
	          }).done(function (data) {
	              var $select = $('#estado-vc-central');
	              $select.find('option').remove();
	              $select.append('<option value="%" selected="selected">Todos</option>');
	              $.each(data, function (key, value)
	              {
	            	  $select.append('<option value=' + value.valorParametro + '>' + value.descParametro + '</option>');
	              });
	          });
	  },
	  callEstadoVuceEntidad: function () {
	          $.ajax({
	                  url: contextApi + "/estado/vuceentidad",
	                  dataType: "json",
	                  complete: function () {
	                      var selectDemo = $('#estado-vc-entidad');
	                      selectDemo.selectpicker('refresh');
	                   }
	          }).done(function (data) {
	              var $select = $('#estado-vc-entidad');
	              $select.find('option').remove();
	              $select.append('<option value="%" selected="selected">Todos</option>');
	              $.each(data, function (key, value)
	              {
	            	  $select.append('<option value=' + value.valorParametro + '>' + value.descParametro + '</option>');
	              });
	          });
	  },
	  
	  callTransmisionesConIncidentes : function () {
		  if(util.validateDate('dp-fechadesde-tra-inc','dp-fechahasta-tra-inc')){
      				  
		    var labels = [];
		    var dataEntrada =[];
		    var dataSalida =[];
			$.ajax({
				url: contextApi + "/transmisionesconincidentes",			 
			    dataType: "json",
			    data: {
			    	fechaIncio:$("#dp-fechadesde-tra-inc").val(),
	            	fechaFin:$("#dp-fechahasta-tra-inc").val()
			    },
			    error:function(e){
			    	console.log(e);			    	
			    }		   
			}).done(function(response) {
				 for(var i=0;i<response.length;i++){
					 labels.push(response[i].siglaEntidad);					 
				 }				 
				 for(var j=0;j<response.length;j++){
					 dataEntrada.push(response[j].cantidadTrasmisionEntrada);	
					 dataSalida.push(response[j].cantidadTrasmisionSalida);							 
				 }
				 chart.transmisionesConIncidencia(labels,dataEntrada,dataSalida)
			});
		  }
		},	
		handleTransmisionesSalidaConError: function(){			
			$('#modal-reenviar-transmisiones').modal('toggle');			
			if (!$.fn.DataTable.isDataTable( '#tb-salida-log' ) ) {
				table.createSimpleTable("tb-salida-log");				
            }else{
            	table.cleanTable("tb-salida-log");
            }			
			var checkboxes = $('input[name="ck-salida"]');
			$.each(checkboxes, function()
            {
				if ($(this).prop('checked')) {				
					api.callTransmisionReenviarSalidaConError($(this).attr("row"),$(this).attr("vcid"),$(this).attr("vctransaccion"),$(this).attr("veid"),$(this).attr("vetransaccion"));
				}				
            });			
			$('#modal-tb-salida-log').modal('toggle');
			
		},
		callTransmisionReenviarSalidaConError : function (id,vc_id,vc_transaccion,ve_id,ve_transaccion) {
				var parameter = {vcId:vc_id,vcTransaccion:vc_transaccion,veId:ve_id,veTransaccion:ve_transaccion};				
				$.ajax({
					url: contextApi + "/transmision/reenviar/salida/conerror",			 
				    dataType: "json",
				    contentType: "application/json; charset=utf-8",
				    type: 'PUT',
				    data: JSON.stringify(parameter),
				    error:function(e){
				    	console.log(e);			    	
				    }		   
				}).done(function(response) {					
					$("#tb-salida-log").DataTable().row.add([id,response.resultadoMensaje]).draw();	
				});		    
		},
		handleTransmisionHabilitar: function(){			
			$('#modal-habilitar-transmisiones').modal('toggle');			
			if (!$.fn.DataTable.isDataTable( '#tb-salida-log' ) ) {
				table.createSimpleTable("tb-salida-log");				
            }else{
            	table.cleanTable("tb-salida-log");
            }			
			var checkboxes = $('input[name="ck-salida"]');
			$.each(checkboxes, function()
            {
				if ($(this).prop('checked')) {				
					api.callTransmisionHabilitar($(this).attr("row"),$(this).attr("veid"));
				}				
            });			
			$('#modal-tb-salida-log').modal('toggle');
			
		},
		callTransmisionHabilitar : function (id,ve_id) {
			var parameter = {veId:ve_id};				
			$.ajax({
				url: contextApi + "/transmision/habilitar",			 
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
			    type: 'PUT',
			    data: JSON.stringify(parameter),
			    error:function(e){
			    	console.log(e);			    	
			    }		   
			}).done(function(response) {					
				$("#tb-salida-log").DataTable().row.add([id,response.resultadoMensaje]).draw();	
			});		    
		},
		handleTransmisionesReeprocesar: function(){			
			$('#modal-reprocesar-transmisiones').modal('toggle');			
			if (!$.fn.DataTable.isDataTable( '#tb-salida-log' ) ) {
				table.createSimpleTable("tb-salida-log");				
            }else{
            	table.cleanTable("tb-salida-log");
            }			
			var checkboxes = $('input[name="ck-entrada"]');
			$.each(checkboxes, function()
            {
				if ($(this).prop('checked')) {				
					api.callTransmisionReeprocesar($(this).attr("row"),$(this).attr("vcid"),$(this).attr("vctransaccion"),$(this).attr("veid"),$(this).attr("vetransaccion"));
				}				
            });			
			$('#modal-tb-salida-log').modal('toggle');
			
		},
		callTransmisionReeprocesar : function (id,vc_id,vc_transaccion,ve_id,ve_transaccion) {
				var parameter = {vcId:vc_id,vcTransaccion:vc_transaccion,veId:ve_id,veTransaccion:ve_transaccion};				
				$.ajax({
					url: contextApi + "/transmision/reprocesar/entrada/conerror",			 
				    dataType: "json",
				    contentType: "application/json; charset=utf-8",
				    type: 'PUT',
				    data: JSON.stringify(parameter),
				    error:function(e){
				    	console.log(e);			    	
				    }		   
				}).done(function(response) {					
					$("#tb-salida-log").DataTable().row.add([id,response.resultadoMensaje]).draw();	
				});		    
		},
		handleTransmisionesAnular: function(){			
			$('#modal-anular-transmisiones').modal('toggle');			
			if (!$.fn.DataTable.isDataTable( '#tb-salida-log' ) ) {
				table.createSimpleTable("tb-salida-log");				
            }else{
            	table.cleanTable("tb-salida-log");
            }			
			var checkboxes = $('input[name="ck-entrada"]');
			$.each(checkboxes, function()
            {
				if ($(this).prop('checked')) {				
					api.callTransmisionAnular($(this).attr("row"),$(this).attr("vcid"),$(this).attr("vctransaccion"),$(this).attr("veid"),$(this).attr("vetransaccion"));
				}				
            });			
			$('#modal-tb-salida-log').modal('toggle');
			
		},
		callTransmisionAnular : function (id,vc_id,vc_transaccion,ve_id,ve_transaccion) {
				var parameter = {vcId:vc_id,vcTransaccion:vc_transaccion,veId:ve_id,veTransaccion:ve_transaccion};
				
				$.ajax({
					url: contextApi + "/transmision/anular/entrada/conerror",			 
				    dataType: "json",
				    contentType: "application/json; charset=utf-8",
				    type: 'PUT',
				    data: JSON.stringify(parameter),
				    error:function(e){
				    	console.log(e);			    	
				    }		   
				}).done(function(response) {					
					$("#tb-salida-log").DataTable().row.add([id,response.resultadoMensaje]).draw();	
				});		    
		},
		callTransmisionDetener : function (entidad_id,fecha_incio,fecha_fin) {
			
			if (!$.fn.DataTable.isDataTable( '#tb-salida-log' ) ) {
				table.createSimpleTable("tb-salida-log");				
            }else{
            	table.cleanTable("tb-salida-log");
            }
			
			var parameter = {entidadId:entidad_id,fechaInicio:fecha_incio,fechaFin:fecha_fin};				
			$.ajax({
				url: contextApi + "/transmision/detener",			 
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
			    type: 'PUT',
			    data: JSON.stringify(parameter),
			    error:function(e){
			    	console.log(e);			    	
			    },
			    complete : function(){
			    	$('#modal-detener-transmisiones').modal('toggle');	
			    }
			}).done(function(response) {					
				$("#tb-salida-log").DataTable().row.add([response.resultadoValor,response.resultadoMensaje]).draw();	
				$('#modal-tb-salida-log').modal('toggle');
			});		    
		},
		callTransmisionReeprocesarN8 : function (entidad_id,fecha_incio,fecha_fin) {
			
			if (!$.fn.DataTable.isDataTable( '#tb-salida-log' ) ) {
				table.createSimpleTable("tb-salida-log");				
            }else{
            	table.cleanTable("tb-salida-log");
            }
			
			var parameter = {entidadId:entidad_id,fechaInicio:fecha_incio,fechaFin:fecha_fin};				
			$.ajax({
				url: contextApi + "/transmision/reprocesar/entrada/n8/conerror",			 
			    dataType: "json",
			    contentType: "application/json; charset=utf-8",
			    type: 'PUT',
			    data: JSON.stringify(parameter),
			    error:function(e){
			    	console.log(e);			    	
			    },
			    complete : function(){
			    	$('#modal-reeprocesar-n8').modal('toggle');	
			    }
			}).done(function(response) {					
				$("#tb-salida-log").DataTable().row.add([response.resultadoValor,response.resultadoMensaje]).draw();	
				$('#modal-tb-salida-log').modal('toggle');
			});		    
		},
		callTransmisiones: function () {
			
			 util.activateReenviarTransmisionesIncorrectamente(false);
			
	          $.ajax({
	              url: contextApi + "/transmisiones",
	              dataType: "json",
	              data: util.createRequestFiltro()
	          }).done(function (data, textStatus, xhr) {
	              
	             if(xhr.status===200){                            
	                   
	                  var dataSetSalida = [];
	                  var dataSetEntrada = [];
	        
	                  
	                  var cantidadSalida = 1;
	                  var cantidadEntrada = 1;
	                  $.each(data, function (key, value)
	                  {
	                     	                      
	                      var rowSalidaXml = []; 	                      
	                      var rowSalidaEbXml = []; 	
	                      var rowSalidaError = []; 	 
	                      
	                      var rowEntradaXml = []; 	                      
	                      var rowEntradaEbXml = []; 	  
	                      var rowEntradaError = []; 
	                      
	                      /*Si tipo es de Salida*/
	                      if(value.tipo==="2"){
	                    	  
	                    	  if(value.tipoIncidente===2){
	                    		  util.activateReenviarTransmisionesIncorrectamente(true);
	                    		  if(value.estadoVe===10){
	                    			 util.activateHabilitarTransmisiones(true); 
	                    		  }
	                    	  }
	                    	  
	                    	  var rowSalida = [];   	                    	
	                    	  rowSalida.push(cantidadSalida);
	                    	  if(value.tieneIncidente===1){
	                    		  rowSalida.push("<input type='checkbox' row='"+cantidadSalida+"' vcid='"+value.vcId+"' vctransaccion='"+value.tipoMensaje+"' veid='"+value.veId+"' vetransaccion='"+value.tipoMensaje+"' name='ck-salida' />");
	                    	  }else{
	                    		  rowSalida.push("");
	                    	  }	   
	                    	  
	                    	  if(value.tieneIncidente===1){
	                    		  rowSalida.push("<div class='border-radius tipo-transacciones tipo-transacciones-" + value.tipoIncidente + "'></div>");  
	                    	  }else{
	                    		  rowSalida.push("<div class='border-radius tipo-transacciones tipo-transacciones-0'></div>"); 
	                    	  }	                    	  
	                    	  
	                    	  rowSalida.push(value.entidadSigla);
	                    	  rowSalida.push(value.formato);
	                    	  rowSalida.push(value.vcId);
	                    	  rowSalida.push(value.estadoVc);	                    	  
	                    	  rowSalida.push(value.veId);
	                    	  rowSalida.push(value.estadoVe);
	                    	  rowSalida.push(value.tipoMensaje);
	                    	  rowSalida.push(value.tipoDocumento);
	                    	  rowSalida.push(value.numeroDocumento);
	                    	  rowSalida.push(value.fechaRegistroSalida);
	                    	  rowSalida.push(value.fechaActualizacionSalida);	                    	  
	                    	  rowSalida.push(value.antiguedadSalida+ " min");
	                    	  
	                    	  if(value.xml  !== null){
	                    		  rowSalida.push("<a href='javascript:util.showXmlSalida("+cantidadSalida+");'>Ver</a>");  
	                              rowSalidaXml.push(cantidadSalida);
	                              rowSalidaXml.push(value.xml);
	                              xmlSalida.push(rowSalidaXml);
	                           }else{
	                        	   rowSalida.push("");    
	                           }
	                    	  
	                    	  
	                    	  if(value.ebxml  !== null){
	                    		  rowSalida.push("<a href='javascript:util.showEbXmlSalida("+cantidadSalida+");'>Ver</a>");  
	                    		  rowSalidaEbXml.push(cantidadSalida);
	                    		  rowSalidaEbXml.push(value.ebxml);	                              
	                              ebXmlSalida.push(rowSalidaEbXml);
	                           }else{
	                        	   rowSalida.push("");    
	                           }
	                    	
	                    	  
	                    	  
	                    	  if(value.error  !== null){
	                    		  rowSalida.push("<a href='javascript:util.showErrorSalida("+cantidadSalida+");'>Ver</a>");  
	                    		  rowSalidaError.push(cantidadSalida);
	                    		  rowSalidaError.push(value.error);	                              
	                    		  errorSalida.push(rowSalidaError);
	                           }else{
	                        	   rowSalida.push("");  
	                           }
	                    	  
	                    	  
	                    	  cantidadSalida++;	    
	                    	  dataSetSalida.push(rowSalida);
	                     }else{
	                          var rowEntrada = [];   
	                          	                          
	                          if(value.tipoIncidente===2){
	                    		 util.activateButtonFooter(true);	                    		 
	                    	  }
	                          
	                    	  rowEntrada.push(cantidadEntrada);
	                    	
	                    	  
	                    	  if(value.tipoIncidente===3){
	                    		  rowEntrada.push("<input type='checkbox' row='"+cantidadEntrada+"' vcid='"+value.vcId+"' vctransaccion='"+value.tipoMensaje+"' veid='"+value.veId+"' vetransaccion='"+value.tipoMensaje+"' name='ck-entrada' />");
	                    	  }else{
	                    		  rowEntrada.push("");
	                    	  }	 
	                    	  
	                    	  if(value.tieneIncidente===1){
	                    		  rowEntrada.push("<div class='border-radius tipo-transacciones tipo-transacciones-" + value.tipoIncidente + "'></div>");  
	                    	  }else{
	                    		  rowEntrada.push("<div class='border-radius tipo-transacciones tipo-transacciones-0'></div>"); 
	                    	  }	   
	                    	  
	           
	                    	  rowEntrada.push(value.entidadSigla);
	                    	  rowEntrada.push(value.formato);
	                    	  rowEntrada.push(value.vcId);
	                    	  rowEntrada.push(value.estadoVc);	                    	  
	                    	  rowEntrada.push(value.veId);
	                    	  rowEntrada.push(value.estadoVe);
	                    	  rowEntrada.push(value.tipoMensaje);
	                    	  rowEntrada.push(value.tipoDocumento);
	                    	  rowEntrada.push(value.numeroDocumento);
	                    	  rowEntrada.push(value.fechaRegistroEntrada);
	                    	  rowEntrada.push(value.fechaActualizacionEntrada);	                    	  
	                    	  rowEntrada.push(value.antiguedadEntrada+ " min");	                    	  
	                    	  
	                    	  if(value.xml  !== null){
	                    		  rowEntrada.push("<a href='javascript:util.showXmlEntrada("+cantidadEntrada+");'>Ver</a>");  
	                              rowEntradaXml.push(cantidadEntrada);
	                              rowEntradaXml.push(value.xml);
	                              xmlEntrada.push(rowEntradaXml);
	                           }else{
	                        	   rowEntrada.push("");    
	                           }
	                    	  
	                    	  
	                    	  if(value.ebxml  !== null){
	                    		  rowEntrada.push("<a href='javascript:util.showEbXmlEntrada("+cantidadEntrada+");'>Ver</a>");  
	                    		  rowEntradaEbXml.push(cantidadEntrada);
	                    		  rowEntradaEbXml.push(value.ebxml);	                              
	                              ebXmlEntrada.push(rowEntradaEbXml);
	                           }else{
	                        	   rowEntrada.push("");    
	                           }
	                    	  
	                    	  
	                    	  if(value.error  !== null){
	                    		  rowEntrada.push("<a href='javascript:util.showErrorEntrada("+cantidadEntrada+");'>Ver</a>");  
	                    		  rowEntradaError.push(cantidadEntrada);
	                    		  rowEntradaError.push(value.error);	                              
	                    		  errorEntrada.push(rowEntradaError);
	                           }else{
	                        	   rowEntrada.push("");  
	                           }
	                    	  
	                    	  
	                    	  rowEntrada.push("");
	                    	  cantidadEntrada++;
	                    	  dataSetEntrada.push(rowEntrada);
	                     }
	                    
	                  });
	                  
	           	                  
	                  table.update("tb-transmisiones-salida",dataSetSalida); 
	                  table.update("tb-transmisiones-entrada",dataSetEntrada); 
	                  
	                  
	              }else{
	                    
	              }
	          
	                                       
	          });
	      },
	      callConfiguracionMonitoreo: function () {				
	    	     var parameter = {entidadId:null};
		          $.ajax({
		              url: contextApi + "/transmision/obtener/configuracion/monitoreo",
		              dataType: "json",
					  contentType: "application/json; charset=utf-8",
					  type: 'PUT',
					  data: JSON.stringify(parameter),
					  error:function(e){
					    console.log(e);			    	
					  }
		          }).done(function (data, textStatus, xhr) {
		             if(xhr.status===200){ 
		                  var dataSet= [];		                 
		                  $.each(data, function (key, value)
		                  {	   
	                    	  var row = [];   	                    	
	                    	  row.push(value.entidad);
	                    	  row.push("<input class='input-sla' type='text' id='"+value.entidadId+"-sla1' value='"+value.valorSla1+"' />");
	                    	  row.push("<input class='input-sla' type='text' id='"+value.entidadId+"-sla2' value='"+value.valorSla2+"' />");
	                    	  row.push("<input class='input-sla' type='text' id='"+value.entidadId+"-sla3' value='"+value.valorSla3+"' />");
	                    	  row.push("<input class='input-sla' type='text' id='"+value.entidadId+"-sla4' value='"+value.valorSla4+"' />");
	                    	  row.push("<input class='input-sla' type='text' id='"+value.entidadId+"-sla5' value='"+value.valorSla5+"' />");	                    	  
	                    	  row.push("<button type='button' onclick='api.handleConfiguracionMonitoreoActualizar("+value.entidadId+")' class='btn btn-primary'>Guardar</button>");	                    	  
	                    	  dataSet.push(row);
	                    
		                  });          
		                  table.update("tb-configurar-sla",dataSet); 	
		              }                       
		          });
		      },
		      handleConfiguracionMonitoreoActualizar: function(entidadId){		
		    	  $("#sla-mensaje").html("");
		    	  
					var sla1 = $("#"+entidadId+"-sla1").val();
					var sla2 = $("#"+entidadId+"-sla2").val();
					var sla3 =  $("#"+entidadId+"-sla3").val();
					var sla4 =  $("#"+entidadId+"-sla4").val();
					var sla5 =  $("#"+entidadId+"-sla5").val();
					
					api.callConfiguracionMonitoreoActualizar(entidadId,"SLA1",sla1);
					api.callConfiguracionMonitoreoActualizar(entidadId,"SLA2",sla2);
					api.callConfiguracionMonitoreoActualizar(entidadId,"SLA3",sla3);
					api.callConfiguracionMonitoreoActualizar(entidadId,"SLA4",sla4);
					api.callConfiguracionMonitoreoActualizar(entidadId,"SLA5",sla5);
					
					$("#sla-mensaje").html("Se guardaron correctamente los SLAs");
					
			 },
		     callConfiguracionMonitoreoActualizar : function (entidad_id,sla_nombre,sla_valor) {								
				
				var parameter = {entidadId:entidad_id,correoSoporte:null,slaNombre:sla_nombre,slaValor:sla_valor,estado:null};				
				$.ajax({
					url: contextApi + "/transmision/actualizar/configuracion/monitoreo",			 
				    dataType: "json",
				    contentType: "application/json; charset=utf-8",
				    type: 'PUT',
				    data: JSON.stringify(parameter),
				    error:function(e){
				    	console.log(e);	
				    	//$("#sla-mensaje").html("Error al actualizar los registros SLAs");
				    }
				});		    
			}
	  
};








