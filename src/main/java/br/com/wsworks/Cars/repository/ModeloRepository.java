package br.com.wsworks.Cars.repository;

import br.com.wsworks.Cars.entity.ModeloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<ModeloEntity, Long> {
}
