package br.com.wsworks.Cars.service;

import br.com.wsworks.Cars.dto.CarroRequestDTO;
import br.com.wsworks.Cars.entity.Carro;
import br.com.wsworks.Cars.entity.Modelo;
import br.com.wsworks.Cars.repository.CarroRepository;
import br.com.wsworks.Cars.repository.ModeloRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public Carro criarCarro(CarroRequestDTO carroRequestDTO) {
        Carro carro = new Carro();
        carro.setTimestampCadastro(carroRequestDTO.getTimestampCadastro());
        // Mapear outros campos da DTO para a entidade Carro.

        Modelo modelo = modeloRepository.findById(carroRequestDTO.getModeloId())
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        carro.setModelo(modelo);
        carro.setAno(carroRequestDTO.getAno());
        carro.setCombustivel(carroRequestDTO.getCombustivel());
        carro.setNumPortas(carroRequestDTO.getNumPortas());
        carro.setCor(carroRequestDTO.getCor());

        return carroRepository.save(carro);
    }

    public Carro obterCarroPorId(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    // Implementar outros métodos de serviço conforme necessário, como atualizar e excluir carros.

}
