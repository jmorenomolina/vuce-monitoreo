var resetCanvas = function (canvasId) {
    $('#' + canvasId).prev().remove();
    $('#' + canvasId).remove();
    $('#parent-' + canvasId).html('<canvas id="' + canvasId + '"></canvas>');
};


var graphic = {
    createBar: function (canvasId, entidades, resultados, title) {
        resetCanvas(canvasId);
        var ctxBar = document.getElementById(canvasId).getContext('2d');
        var myChart = new Chart(ctxBar, {
            type: 'bar',
            data: {
                labels: entidades,
                datasets: [{
                        label: title,
                        data: resultados,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.7)',
                            'rgba(54, 162, 235, 0.7)',
                            'rgba(255, 206, 86, 0.7)',
                            'rgba(75, 192, 192, 0.7)',
                            'rgba(153, 102, 255, 0.7)',
                            'rgba(255, 159, 64, 0.7)'
                        ],
                        borderColor: [
                            'rgba(255,99,132,1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 0
                    }]
            },
            options: {
                legend: {
                    display: true,
                    labels: {
                        fontColor: 'rgb(0, 0, 0)'
                    }
                },

                responsive: true,

                scales: {

                    xAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: 'Entidad'
                            }

                        }],
                    yAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: 'Incidentes'
                            },
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                }
            }
        });
    },
    createLine: function (canvasId,fechas, datasetsParam,Ytitle) {
        resetCanvas(canvasId);
 
        var ctxBar = document.getElementById(canvasId).getContext('2d');
        var myChartLine = new Chart(ctxBar, {
            type: 'line',
            data: {
                labels: fechas,
                datasets: datasetsParam                
            },
            options: {
                legend: {
                    display: true,
                    labels: {
                        fontColor: 'rgb(0, 0, 0)'
                    }
                },
                responsive: true,
                scales: {
                    xAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: 'Hora'
                            }
                        }],
                    yAxes: [{
                            display: true,
                            scaleLabel: {
                                display: true,
                                labelString: Ytitle
                            },
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                }
            }
        });
    },
    createTable: function (idTable,dataSet,pagingParam) {            
        $('#'+idTable).DataTable({        
            "pageLength": 10,
             data: dataSet,
            'paging': pagingParam,
            'lengthChange': false,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': false,
            "scrollX": true,
            'language': {
                'lengthMenu': "Mostrar _MENU_ registros por pagina",
                'zeroRecords': "No encontrado.",
                'info': "Mostrar pagina _PAGE_ de _PAGES_",
                'infoEmpty': "Registros no disponibles",
                'infoFiltered': "(filtered from _MAX_ total records)"
            }
        });
    },
    createSimpleTable: function (idTable,dataSet) {            
        $('#'+idTable).DataTable({        
            "pageLength": 10,
            'paging': false,
             data: dataSet,
            'lengthChange': false,
            'searching': false,
            'ordering': false,
            'info': false,
            'autoWidth': false,
            "scrollX": false            
        });
    },
    updateTable : function(idTable,dataSet){
        $('#'+idTable).dataTable().fnClearTable();
        $('#'+idTable).dataTable().fnAddData(dataSet);        
    },
    cleanTable : function(idTable){
        $('#'+idTable).dataTable().fnClearTable();      
    }
    

};
