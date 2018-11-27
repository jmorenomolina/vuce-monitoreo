var contextApi = "http://localhost:9000/api";


var resetCanvas = function (canvasId) {
    $('#' + canvasId).prev().remove();
    $('#' + canvasId).remove();
    $('#parent-' + canvasId).html('<canvas id="' + canvasId + '"></canvas>');
};

var api = {		
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


