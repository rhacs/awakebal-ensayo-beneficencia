package io.github.rhacs.beneficencia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rhacs.beneficencia.modelos.Ayuda;
import io.github.rhacs.beneficencia.repositorios.AyudasRepositorio;

@RestController
@RequestMapping(path = "/api/ayudas", produces = MediaType.APPLICATION_JSON_VALUE)
public class AyudasRestController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Autowired
    private AyudasRepositorio repositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el listado de {@link Ayuda}s
     * 
     * @return un objeto {@link ResponseEntity} con la respuesta a la solicitud
     */
    @GetMapping
    public ResponseEntity<List<Ayuda>> listadoAyudas() {
        // Buscar todas las ayudas
        List<Ayuda> ayudas = repositorio.findAll(Sort.by(Direction.DESC, "id"));

        // Crear respuesta y devolver resultado
        return ResponseEntity.status(HttpStatus.OK).body(ayudas);
    }

}
