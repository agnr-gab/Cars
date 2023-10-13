package br.com.wsworks.Cars.repository;

import br.com.wsworks.Cars.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
        Optional<CarroEntity> findCarroById(Long carroId);
}
