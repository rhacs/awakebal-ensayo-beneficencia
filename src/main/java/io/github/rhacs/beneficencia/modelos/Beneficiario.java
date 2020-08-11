package io.github.rhacs.beneficencia.modelos;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.github.rhacs.beneficencia.Constantes;

@Entity
@Table(name = Constantes.TABLA_BENEFICIARIOS)
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = Constantes.SECUENCIA_BENEFICIARIOS, sequenceName = Constantes.SECUENCIA_BENEFICIARIOS)
public class Beneficiario {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico del {@link Beneficiario}
     */
    @Id
    @GeneratedValue(generator = Constantes.SECUENCIA_BENEFICIARIOS, strategy = GenerationType.SEQUENCE)
    @Column(name = "beneficiarioid", nullable = false, unique = true, updatable = false)
    private Long id;

    /**
     * Nombre completo del {@link Beneficiario}
     */
    @Column(name = "nombre", nullable = false)
    private String nombre;

    /**
     * Edad del {@link Beneficiario}
     */
    @Column(name = "edad", nullable = false)
    private int edad;

    /**
     * La {@link Ciudad} del {@link Beneficiario}
     */
    @ManyToOne
    @JoinColumn(name = "ciudadid", nullable = false)
    private Ciudad ciudad;

    /**
     * Listado de {@link Ayuda}s que ha recibido el {@link Beneficiario}
     */
    @OneToMany(mappedBy = "beneficiario")
    private Set<Ayuda> ayudas;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Beneficiario}
     */
    public Beneficiario() {

    }

    /**
     * Crea una nueva instancia del objeto {@link Beneficiario}
     * 
     * @param id     identificador numérico
     * @param nombre nombre
     * @param edad   edad
     */
    public Beneficiario(Long id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
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
     * @return el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return la edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @return la {@link Ciudad}
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * @return el listado de {@link Ayuda}s que ha recibido el {@link Beneficiario}
     */
    public Set<Ayuda> getAyudas() {
        return ayudas;
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
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param edad la edad a establecer
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @param ciudad la {@link Ciudad} a establecer
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @param ayudas el listado de {@link Ayuda}s a establecer
     */
    public void setAyudas(Set<Ayuda> ayudas) {
        this.ayudas = ayudas;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Beneficiario other = (Beneficiario) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("Beneficiario [id=%s, nombre=%s, edad=%s]", id, nombre, edad);
    }

}
