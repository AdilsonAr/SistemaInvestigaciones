doneConfirmation = false;

$("#AdministradoresForm").validetta({
    realTime: false,
    bubblePosition: "bottom",
    bubbleGapTop: 10,
    bubbleGapLeft: -5,
    validators: {
        callback: {
            clave: {
                callback: function (el, value) {
                    if (document.getElementById('clave2').value==value) {
                        return true;
                    }
                    return false;
                },
                errorMessage: "Las contraseñas no coinciden",
            },
            clave2: {
                callback: function (el, value) {
                    if (document.getElementById('clave').value==value) {
                        return true;
                    }
                    return false;
                },
                errorMessage: "Las contraseñas no coinciden",
            },
            longitud: {
                callback: function (el, value) {
                    if (value.length<8) {
                        return true;
                    }
                    return false;
                },
                errorMessage: "Use al menos 8 caractéres",
            },
        },
    },
    onValid: function (e) {
        valid(e);
    },
    onError: function (e) {
        error(e);
    },
});

function valid(e) {
    if (!doneConfirmation) {
        e.preventDefault();

        swal({
            title: "Esta seguro?",
            text: "Los datos seran enviados!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((accepted) => {
            if (accepted) {
                doneConfirmation = true;

                var datos = $("#AdministradoresForm");
                datos.submit();
                
                doneConfirmation = false;
            }
        });
    }
}

function error(e) {
    swal("Se encontraron errores", "Corrige los errores en los campos", "error");
}
