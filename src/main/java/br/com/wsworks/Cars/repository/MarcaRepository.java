package br.com.wsworks.Cars.repository;

import br.com.wsworks.Cars.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {
}
