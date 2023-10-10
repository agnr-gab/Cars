package br.com.wsworks.Cars.repository;

import br.com.wsworks.Cars.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
