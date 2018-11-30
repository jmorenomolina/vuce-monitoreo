 var util = {                 
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
        setTamanoTableSalida:function(){
        	var cantidad = $("#cantidad-filas-mostrar").val();
        	if(cantidad!==""){
        	  tableSalida.page.len( cantidad ).draw();        		
        	}else{
        	  tableSalida.page.len( 10 ).draw();	
        	}
        	
        },
        setTamanoTableEntrada:function(){
        	var cantidad = $("#cantidad-filas-mostrar-entrada").val();
        	if(cantidad!==""){
        	  tableEntrada.page.len( cantidad ).draw();        		
        	}else{
        		tableEntrada.page.len( 10 ).draw();	
        	}
        	
        },
        showXmlNotificacion: function(idTransaccion){
            for(var i=0;i<xmlNotificaciones.length;i++){
                if(xmlNotificaciones[i][0]===idTransaccion){
                   $('#modal-xml').modal('show');
                   setTimeout(function(){  editor.setValue(xmlNotificaciones[i][1]); }, 1000);
                   return;
                }
            }                    
        },
        activateReenviarTransmisionesIncorrectamente: function(activate){
        	$("#ck-transmisiones-salida-error").prop("disabled", !activate); 
        	$("#btn-reenviar-transmisiones").prop("disabled", !activate); 
        },
        activateHabilitarTransmisiones: function(activate){
        	$("#btn-habilitar-transmisiones").prop("disabled", !activate); 
        },
        activateButtonFooter: function(activate){
        	$("#ck-transmisiones-entrada-error").prop("disabled", !activate); 
        	$("#btn-reeprocesar-transmision").prop("disabled", !activate); 
        	$("#btn-anular-transmision").prop("disabled", !activate); 
        },
        resetPanelFiltro:function(){
        	 $("#entidades").val('%');
             $("#entidades").selectpicker("refresh");             
             $("#tipomensajes").val('%');
             $("#tipomensajes").selectpicker("refresh");             
             $("#tipo-documentos").val('%');
             $("#tipo-documentos").selectpicker("refresh");             
             $("#dp-fechadesde-tra").val(util.getDate());
             $("#dp-fechahasta-tra").val(util.getDate());             
             $("#nrodocumento").val("");                          
             $("#tipo-transmision").val("2");
             $("#tipo-transmision").selectpicker("refresh");             
             $("#tipo-incidente").val('%');
             $("#tipo-incidente").selectpicker("refresh");             
             $("#estado-vc-central").val('%');
             $("#estado-vc-central").selectpicker("refresh");             
             $("#estado-vc-entidad").val('%');
             $("#estado-vc-entidad").selectpicker("refresh");             
             $("#vc-id").val("");  
             $("#ve-id").val("");   
             
             //util.activateReenviarTransmisionesIncorrectamente(false);
             
        },
        createRequestFiltro: function(){  
        
        	util.validateRequestCbo("entidades",'%');
        	util.validateRequestCbo("tipomensajes",'%');
        	util.validateRequestCbo("tipo-documentos",'%');        	
        	util.validateRequestCbo("tipo-transmision","1");
        	util.validateRequestCbo("tipo-incidente",'%');
        	util.validateRequestCbo("estado-vc-central",'%');
        	util.validateRequestCbo("estado-vc-entidad",'%');        	
        	
        	var entidades = $("#entidades").val();
        	var tipomensajes = $("#tipomensajes").val();
        	var tipodocumentos = $("#tipo-documentos").val();        	
        	var tipoTransmision = $("#tipo-transmision").val();
        	var tipoIncidente = $("#tipo-incidente").val();
        	var estadoVcCentral = $("#estado-vc-central").val();
        	var estadoVcEntidad = $("#estado-vc-entidad").val();
        	
        	var request ={
    			entidades :   (entidades.length==1 && entidades[0]==="%" ) ? entidades.join("|")  : util.arrayRemove(entidades,"%").join("|"),
    			tipoMensaje : (tipomensajes.length==1 && tipomensajes[0]==="%" ) ? tipomensajes.join("|") : util.arrayRemove(tipomensajes,"%").join("|"),
    			tipoDocumento :(tipodocumentos.length==1 && tipodocumentos[0]==="%" ) ? tipodocumentos.join("|") :  util.arrayRemove(tipodocumentos,"%").join("|"),
    			fechaInicio : $("#dp-fechadesde-tra").val(),
    			fechaFin: $("#dp-fechahasta-tra").val(),
    			numeroDocumento: $("#nrodocumento").val(),    			
    			tipoTransmision :   (tipoTransmision.length==1 && tipoTransmision[0]==="1" ) ? tipoTransmision.join("|")  : util.arrayRemove(tipoTransmision,"1").join("|"),
    			tipoIncidente : (tipoIncidente.length==1 && tipoIncidente[0]==="%" ) ? tipoIncidente.join("|") : util.arrayRemove(tipoIncidente,"%").join("|"),
    			estadoVc : (estadoVcCentral.length==1 && estadoVcCentral[0]==="%" ) ? estadoVcCentral.join("|") :  util.arrayRemove(estadoVcCentral,"%").join("|"),
    			estadoVe : (estadoVcEntidad.length==1 && estadoVcEntidad[0]==="%" ) ? estadoVcEntidad.join("|")  : util.arrayRemove(estadoVcEntidad,"%").join("|"),
    			vcId : $("#vc-id").val(),
    			veId: $("#ve-id").val()	
        	}
        	return request;    
        },
        arrayRemove : function (arr, value) {
    	   return arr.filter(function(ele){
    	       return ele != value;
    	   });

    	},
    	validateRequestCbo:function(id,defaultValue){
    		if($("#"+id).val().length==0){
        		$("#"+id).val(defaultValue);
        		$("#"+id).selectpicker("refresh"); 
        	}    		
    	}
}