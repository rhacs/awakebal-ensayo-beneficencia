package io.github.rhacs.beneficencia.modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.github.rhacs.beneficencia.Constantes;

@Entity
@Table(name = Constantes.TABLA_CIUDADES)
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = Constantes.SECUENCIA_CIUDADES, sequenceName = Constantes.SECUENCIA_CIUDADES)
public class Ciudad {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico de la {@link Ciudad}
     */
    @Id
    @GeneratedValue(generator = Constantes.SECUENCIA_CIUDADES, strategy = GenerationType.SEQUENCE)
    @Column(name = "ciudadid", nullable = false, unique = true, updatable = false)
    private Long id;

    /**
     * Nombre de la {@link Ciudad}
     */
    @Column(name = "nombreciudad", nullable = false, unique = true)
    private String nombreCiudad;

    /**
     * Listado de {@link Beneficiario}s
     */
    @OneToMany(mappedBy = "ciudad")
    private Set<Beneficiario> beneficiarios;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Ciudad}
     */
    public Ciudad() {
        beneficiarios = new HashSet<>();
    }

    /**
     * Crea una nueva instancia del objeto {@link Ciudad}
     * 
     * @param id            identificador numérico
     * @param nombreCiudad  nombre
     * @param beneficiarios listado de {@link Beneficiario}s
     */
    public Ciudad(Long id, String nombreCiudad, Set<Beneficiario> beneficiarios) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
        this.beneficiarios = beneficiarios;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico
     */
    public Long getId() {
        return id;
    }

    /**
     * @return el nombre
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * @return el listado de {@link Beneficiario}s
     */
    public Set<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador numérico a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nombreCiudad el nombre de la ciudad a establecer
     */
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    /**
     * @param beneficiarios el listado de {@link Beneficiario}s a establecer
     */
    public void setBeneficiarios(Set<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreCiudad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Ciudad other = (Ciudad) obj;

        return Objects.equals(id, other.id) && Objects.equals(nombreCiudad, other.nombreCiudad);
    }

    @Override
    public String toString() {
        return String.format("Ciudad [id=%s, nombreCiudad=%s, beneficiarios=%s]", id, nombreCiudad, beneficiarios);
    }

}
