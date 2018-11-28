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
        showXmlNotificacion: function(idTransaccion){
            for(var i=0;i<xmlNotificaciones.length;i++){
                if(xmlNotificaciones[i][0]===idTransaccion){
                   $('#modal-xml').modal('show');
                   setTimeout(function(){  editor.setValue(xmlNotificaciones[i][1]); }, 1000);
                   return;
                }
            }                    
        }
}