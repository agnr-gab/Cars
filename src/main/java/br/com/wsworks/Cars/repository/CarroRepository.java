package br.com.wsworks.Cars.repository;

import br.com.wsworks.Cars.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
