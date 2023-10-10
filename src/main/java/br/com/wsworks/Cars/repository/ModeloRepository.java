package br.com.wsworks.Cars.repository;

import br.com.wsworks.Cars.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
