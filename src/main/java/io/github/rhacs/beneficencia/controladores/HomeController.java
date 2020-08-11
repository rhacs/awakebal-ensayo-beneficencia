package io.github.rhacs.beneficencia.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.rhacs.beneficencia.modelos.Ayuda;
import io.github.rhacs.beneficencia.modelos.Beneficiario;
import io.github.rhacs.beneficencia.repositorios.AyudasRepositorio;
import io.github.rhacs.beneficencia.repositorios.BeneficiariosRepositorio;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Autowired
    private AyudasRepositorio ayudasRepositorio;

    @Autowired
    private BeneficiariosRepositorio beneficiariosRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra el listado de {@link Ayuda}s
     * 
     * @param modelo objeto {@link Model} con el modelo de la vista
     * @return un objeto {@link String} con la respuesta a la solicitud
     */
    @GetMapping
    public String verListado(Model modelo) {
        // Buscar todos los beneficiarios
        List<Beneficiario> beneficiarios = beneficiariosRepositorio.findAll(Sort.by("nombre"));

        // Agregar listado al modelo
        modelo.addAttribute("beneficiarios", beneficiarios);

        // Agregar objeto ayuda al modelo
        modelo.addAttribute("ayuda", new Ayuda());

        // Mostrar vista
        return "listado";
    }

    // Solicitudes POST
    // -----------------------------------------------------------------------------------------

    /**
     * Procesa el formulario para agregar una nueva {@link Ayuda}
     * 
     * @param ayuda         objeto {@link Ayuda} con la información a agregar
     * @param bindingResult objeto {@link BindingResult} que contiene los errores de
     *                      validación
     * @param modelo        objeto {@link Model} que contiene el modelo de la vista
     * @return un objeto {@link String} con la respuesta a la solicitud
     */
    @PostMapping
    public String procesarFormulario(@Valid Ayuda ayuda, BindingResult bindingResult, Model modelo) {
        // Verificar si hay errores
        if (bindingResult.hasErrors()) {
            // Buscar todos los beneficiarios
            List<Beneficiario> beneficiarios = beneficiariosRepositorio.findAll(Sort.by("nombre"));

            // Agregar listado al modelo
            modelo.addAttribute("beneficiarios", beneficiarios);

            // Mostrar vista
            return "listado";
        }

        // Agregar ayuda al repositorio
        ayudasRepositorio.save(ayuda);

        // Redireccionar
        return "redirect:/";
    }

}
