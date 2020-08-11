// Esperar a que la página termine de cargar
$(function() {
    $.get("http://localhost/beneficencia/api/ayudas", function(data) {
        $.each(data, function() {
            // Crear fila
            let tr = $('<tr>')
                    .append('<th class="text-nowrap">' + this.id + '</th>')
                    .append('<td class="text-nowrap">' + this.beneficiario.ciudad.nombreCiudad + '</td>')
                    .append('<td>' + this.motivo + '</td>')
                    .append('<td class="text-nowrap">' + this.monto + '</td>');

            // Agregar fila a la tabla
            $('#cuerpo').append(tr);
        });
    });
});
