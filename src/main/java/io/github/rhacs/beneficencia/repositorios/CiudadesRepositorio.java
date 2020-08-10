package io.github.rhacs.beneficencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.beneficencia.modelos.Ciudad;

@Repository
public interface CiudadesRepositorio extends JpaRepository<Ciudad, Long> {

}
