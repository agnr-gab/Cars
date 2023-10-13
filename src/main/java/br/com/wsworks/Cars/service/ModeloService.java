package br.com.wsworks.Cars.service;

import br.com.wsworks.Cars.dto.ModeloRequestDTO;
import br.com.wsworks.Cars.entity.ModeloEntity;
import br.com.wsworks.Cars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    public ModeloEntity criarModelo(ModeloRequestDTO modeloRequestDTO) {
        ModeloEntity modeloEntity = new ModeloEntity();
        modeloEntity.setNome(modeloRequestDTO.getNome());
        modeloEntity.setValorFipe(modeloRequestDTO.getValorFipe());

        //Adicionar lógica adicional aqui, por exemplo, associar a marca ao modelo.

        return modeloRepository.save(modeloEntity);
    }

    public ModeloEntity obterModeloPorId(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    //Adicionar tratamento de exceções, validações e lógica de negócios

}
