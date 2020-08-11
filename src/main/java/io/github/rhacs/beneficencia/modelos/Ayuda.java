package io.github.rhacs.beneficencia.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import io.github.rhacs.beneficencia.Constantes;

@Entity
@Table(name = Constantes.TABLA_AYUDAS)
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = Constantes.SECUENCIA_AYUDAS, sequenceName = Constantes.SECUENCIA_AYUDAS)
public class Ayuda {

    // Atributos
    // -----------------------------------------------------------------------------------------

    /**
     * Identificador numérico de la {@link Ayuda}
     */
    @Id
    @GeneratedValue(generator = Constantes.SECUENCIA_AYUDAS, strategy = GenerationType.SEQUENCE)
    @Column(name = "ayudaid", nullable = false, unique = true, updatable = false)
    private Long id;

    /**
     * Monto de la {@link Ayuda}
     */
    @NotNull
    @Min(1)
    @Column(name = "monto", nullable = false)
    private Long monto;

    /**
     * Motivo de la {@link Ayuda}
     */
    @NotNull
    @Size(max = 25)
    @Column(name = "motivo")
    private String motivo;

    /**
     * {@link Beneficiario} de la {@link Ayuda}
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beneficiarioid", nullable = false)
    private Beneficiario beneficiario;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Ayuda}
     */
    public Ayuda() {

    }

    /**
     * Crea una nueva instancia del objeto {@link Ayuda}
     * 
     * @param id           identificador numérico
     * @param monto        monto
     * @param motivo       motivo
     * @param beneficiario {@link Beneficiario}
     */
    public Ayuda(Long id, Long monto, String motivo, Beneficiario beneficiario) {
        this.id = id;
        this.monto = monto;
        this.motivo = motivo;
        this.beneficiario = beneficiario;
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
     * @return el monto
     */
    public Long getMonto() {
        return monto;
    }

    /**
     * @return el motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @return la información del {@link Beneficiario}
     */
    public Beneficiario getBeneficiario() {
        return beneficiario;
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
     * @param monto el monto a establecer
     */
    public void setMonto(Long monto) {
        this.monto = monto;
    }

    /**
     * @param motivo el motivo a establecer
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @param beneficiario el {@link Beneficiario} a establecer
     */
    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
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

        Ayuda other = (Ayuda) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("Ayuda [id=%s, monto=%s, motivo=%s]", id, monto, motivo);
    }

}
