doneConfirmation = false;

$("#InvestigacionForm").validetta({
  realTime: true,
  bubblePosition: "bottom",
  bubbleGapTop: 10,
  bubbleGapLeft: -5,
  validators: {
    callback: {
      rango: {
        callback: function (el, value) {
          if (value > 0 && value < 10000) {
            return true;
          }
          return false;
        },
        errorMessage: "valor fuera de rango",
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
        investigacionPost();
        doneConfirmation = false;
      }
    });
  }
}

function error(e) {
  swal("Se encontraron errores", "Corrige los errores en los campos", "error");
}
