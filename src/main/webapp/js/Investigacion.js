function investigacionPost() {
    editor.save().then((outputData) => {
        let data = outputData;
        console.log(JSON.stringify(outputData));
        let frm = $("#InvestigacionForm");
        let method = frm.attr("method");
        let action = frm.attr("action");
        let requestData = new FormData($("#InvestigacionForm")[0]);
        requestData.set("documento", JSON.stringify(data));
        
        $.ajax({
            type: method,
            url: action,
            enctype:"multipart/form-data",
            data: requestData,
            processData: false,
            contentType: false,
            success: function (data) {
                swal({
                title: "Mensage",
                text: data.message,
                icon: "info",
                button: "Ok",
            });
            window.location.href = 'http://localhost:8080/SistemaInvestigaciones/Investigacion?action=investigaciones';
            },
            error: function (data) {
                console.log("error");
            },
        });

    }).catch((error) => {
        console.log('Error del editor: ', error)
    });
}


