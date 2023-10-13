package br.com.wsworks.Cars.service;

import br.com.wsworks.Cars.dto.CarroRequestDTO;
import br.com.wsworks.Cars.dto.CarroResponseDTO;
import br.com.wsworks.Cars.entity.CarroEntity;
import br.com.wsworks.Cars.entity.ModeloEntity;
import br.com.wsworks.Cars.mapper.CarroMapper;
import br.com.wsworks.Cars.repository.CarroRepository;
import br.com.wsworks.Cars.repository.ModeloRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private CarroMapper carroMapper;

    public CarroEntity criarCarro(CarroRequestDTO carroRequestDTO) {
        CarroEntity carroEntity = new CarroEntity();
        carroEntity.setTimestampCadastro(carroRequestDTO.getTimestampCadastro());

        ModeloEntity modeloEntity = modeloRepository.findById(carroRequestDTO.getModeloId())
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        carroEntity.setModeloEntity(modeloEntity);
        carroEntity.setAno(carroRequestDTO.getAno());
        carroEntity.setCombustivel(carroRequestDTO.getCombustivel());
        carroEntity.setNumPortas(carroRequestDTO.getNumPortas());
        carroEntity.setCor(carroRequestDTO.getCor());

        return carroRepository.save(carroEntity);
    }

    public CarroResponseDTO obterCarroPorId(Long id) {
        Optional<CarroEntity> carro = Optional.ofNullable(carroRepository.findCarroById(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Id do carro informado: %d não localizado", id)));
        return CarroMapper.INSTANCE.toDTO(carro.get());
    }

    public List<CarroResponseDTO> listarCarros() {
        List<CarroEntity> carros = carroRepository.findAll();
        return Collections.singletonList(carroMapper.toDTO((CarroEntity) carros));
    }

    public CarroEntity atualizarCarro(Long id, CarroRequestDTO carroRequestDTO) {
        CarroEntity carroExistente = carroRepository.findById(id).orElse(null);
        if (carroExistente != null) {
            carroMapper.updateFromDTO(carroRequestDTO, carroExistente);
            CarroEntity carroAtualizado = carroRepository.save(carroExistente);
            return carroMapper.toEntity(carroAtualizado);
        }
        return null;
    }

    public void excluirCarro(Long id) {
        carroRepository.deleteById(id);
    }

}
