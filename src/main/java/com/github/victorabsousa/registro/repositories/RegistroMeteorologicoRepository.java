
package com.github.victorabsousa.registro.repositories;

import com.github.victorabsousa.registro.entities.RegistroMeteorologico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroMeteorologicoRepository
        extends JpaRepository<RegistroMeteorologico, Long> {
}
