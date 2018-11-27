var contextApi = "http://localhost:9000/api";



function localJsonpCallback(json) {
	console.log("......xD");
    if (!json.Error) {
    	  alert("error");
    }
    else {
        alert(json);
    }
};

var api = {
		
	callTransmisionesConIncidentes : function () {
		
		  console.log("callTransmisionesConIncidentes.....");
			$.ajax({
				 url: contextApi + "/transmisionesconincidentes",
			 
			    // Tell jQuery we're expecting JSONP
			    dataType: "jsonp",
			    jsonpCallback: 'msgsJsonCallback', 
			    // Tell YQL what we want and that we want JSON
			    data: {
			    	fechaIncio:"2018-11-25",
	            	fechaFin:"2018-11-26"
			    },
			    success: function(json) {
			        console.log("Success") ;
			        console.dir(json) ;
			    },
			    complete: function(jqXHR, textStatus){
			    	
			        console.log(textStatus) ;
			    	console.log(jqXHR) ;
			    },
			   
			});
			    
		    
		    
		}
		
};