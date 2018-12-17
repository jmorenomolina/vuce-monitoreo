  

var dateOption ={
		 autoclose: true,
         format: 'dd/mm/yyyy'
};

$(document).ready(function () {  
	 table.createSimpleTable("tb-mantenimiento-entidad");
	 api.callEntidadesMantenimiento();
	 api.callMantenimientoEntidad();
	
	
	 $('#dp-fechadesde-man').datepicker(dateOption); 
     $('#dp-fechahasta-man').datepicker(dateOption);
     
     $("#dp-fechadesde-man").val(util.getDate());
     $("#dp-fechahasta-man").val(util.getDate());
     
     
     document.getElementById("btn-execute-registrar-man").onclick = function () {
     	api.callRegistarMantenimiento( $("#entidades").val(),$("#dp-fechadesde-man").val(),$("#dp-fechahasta-man").val() );
     
     	
     };
     
   
     
	    
});


function editarmantenimiento(id){
	console.log("Editar Mantenimiento: "+id);
}