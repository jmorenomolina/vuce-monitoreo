var contextApi = "http://localhost:9000/api";

var tableSalida = null;
var tableEntrada = null;

var resetCanvas = function (canvasId) {
    $('#' + canvasId).prev().remove();
    $('#' + canvasId).remove();
    $('#parent-' + canvasId).html('<canvas id="' + canvasId + '"></canvas>');
};

var api = {	
	callEntidades: function () {
              $.ajax({
                      url: contextApi + "/entidades",
                      dataType: "json",
                      complete: function () {
                          var selectDemo = $('#entidades');
                          selectDemo.selectpicker('refresh');
                       }
              }).done(function (data) {
                  var $select = $('#entidades');
                  $select.find('option').remove();
                  $select.append('<option value="%" selected="selected">Todas</option>');
                  $.each(data, function (key, value)
                  {
                      $select.append('<option value=' + value.idEntidad + '>' + value.descripcion + '</option>');
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
	              $select.append('<option value="%" selected="selected">Todas</option>');
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
	                  
	                  xmlTransacciones = [];
	                  ebXmlTransacciones = [];
	                  var cantidadSalida = 1;
	                  var cantidadEntrada = 1;
	                  $.each(data, function (key, value)
	                  {
	                     	                      
	                      var rowTransaccionXml = []; 
	                      var rowTransaccionEbXml = []; 	          
	                      
	                      /*Si tipo es de Salida*/
	                      if(value.tipo==="2"){
	                    	  
	                    	  if(value.tipoIncidente===2){
	                    		  util.activateReenviarTransmisionesIncorrectamente(true);
	                    	  }
	                    	  
	                    	  var rowSalida = [];   	                    	
	                    	  rowSalida.push(cantidadSalida);
	                    	  if(value.tieneIncidente===1){
	                    		  rowSalida.push("<input type='checkbox' row='"+cantidadSalida+"' vcid='"+value.vcId+"' vctransaccion='"+value.tipoMensaje+"' veid='"+value.veId+"' vetransaccion='"+value.tipoMensaje+"' name='ck-salida' />");
	                    	  }else{
	                    		  rowSalida.push("");
	                    	  }	   
	                    	  
	                    	  if(value.tieneIncidente===1){
	                    		  rowSalida.push("<div class='border-radius tipo-transacciones-" + value.tipoIncidente + "'></div>");  
	                    	  }else{
	                    		  rowSalida.push("<div class='border-radius tipo-transacciones-0'></div>"); 
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
	                    	  rowSalida.push(value.xml);
	                    	  rowSalida.push(value.ebxml);
	                    	  rowSalida.push(value.error);
	                    	  cantidadSalida++;	    
	                    	  dataSetSalida.push(rowSalida);
	                     }else{
	                          var rowEntrada = [];   
	                    	  rowEntrada.push(cantidadEntrada);
	                    	  if(value.tieneIncidente===1){
	                    		  rowEntrada.push("<input type='checkbox' name='vcid' value='"+value.vcId+"'/>");
	                    	  }else{
	                    		  rowEntrada.push("");
	                    	  }	                    	  
	                    	  rowEntrada.push("<div class='tipo-transacciones-" + value.tipoIncidente + "'></div>");
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
	                    	  rowEntrada.push(value.xml);
	                    	  rowEntrada.push(value.ebxml);
	                    	  rowEntrada.push(value.error);
	                    	  rowEntrada.push("");
	                    	  cantidadEntrada++;
	                    	  dataSetEntrada.push(rowEntrada);
	                     }
	                    
	                  });
	                  
	           	                  
	                  table.update("tb-transmisiones-salida",dataSetSalida); 
	                  //table.update("tb-transmisiones-entrada",dataSetEntrada); 
	                  
	                  
	              }else{
	                    
	              }
	          
	                                       
	          });
	      }
	  
	  
	  
};



var chart={
	transmisionesConIncidencia : function(labelsParam,dataEntrada,dataSalida){
		resetCanvas("transmisiones-incidentes-entidad");
		var barChartData = {
				labels : labelsParam,
				datasets : [ {
					label : 'Salida',
					backgroundColor : 'rgb(255, 99, 132)',
					data : dataSalida
				}, {
					label : 'Entrada',
					backgroundColor : 'rgb(75, 192, 192)',
					data : dataEntrada
				} ]
			};		
		
		var ctx = document.getElementById('transmisiones-incidentes-entidad').getContext('2d');
		window.myBar = new Chart(ctx,
			{
				type : 'bar',
				data : barChartData,
				options : {
					title : {
						display : true,
						text : 'Total de Transmisiones con incidentes por entidad'
					},
					tooltips : {
						mode : 'index',
						intersect : false
					},
					responsive : true,
					scales : {
						xAxes : [ {
							stacked : true,
						} ],
						yAxes : [ {
							stacked : true
						} ]
					}
				}
			});
	}			
}

var table={
		 optionTable : function(){
			var option = {    
		        	'lengthChange': false,
		            'searching': false,
		            'ordering': false,
		            'info': true,
		            'autoWidth': false,
		            "scrollX": true,	
		            
		            'language': {
		                'lengthMenu': "Mostrar _MENU_ registros por pagina",
		                'zeroRecords': "No encontrado.",
		                'info': "Mostrar pagina _PAGE_ de _PAGES_",
		                'infoEmpty': " ",
		                'infoFiltered': "(filtered from _MAX_ total records)"
		            }
		        };
			return option; 
		 },
	   	 create: function (idTable,salida) {
	   		 if(salida){
	   			tableSalida = $('#'+idTable).DataTable(table.optionTable());
	   		 }else{
	   			tableEntrada = $('#'+idTable).DataTable(table.optionTable());
	   		 }
	   	
	   	 },
	   	 createSimpleTable: function (idTable) {
	   		 $('#'+idTable).DataTable({        
	            "pageLength": 25,
	            'paging': false,
	            'lengthChange': false,
	            'searching': false,
	            'ordering': false,
	            'info': false,
	            'autoWidth': false,
	            "scrollX": false            
	         });	   	
		   	
		 },
		 update : function(idTable,dataSet){
		    $('#'+idTable).dataTable().fnClearTable();
		    $('#'+idTable).dataTable().fnAddData(dataSet); 
		    util.setTamanoTableSalida();		
		 },
		 cleanTable : function(idTable){
		     $('#'+idTable).dataTable().fnClearTable();      
		 }
}


