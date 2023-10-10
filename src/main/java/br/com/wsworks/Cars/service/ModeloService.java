package br.com.wsworks.Cars.service;

import br.com.wsworks.Cars.dto.ModeloRequestDTO;
import br.com.wsworks.Cars.entity.Modelo;
import br.com.wsworks.Cars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    public Modelo criarModelo(ModeloRequestDTO modeloRequestDTO) {
        Modelo modelo = new Modelo();
        modelo.setNome(modeloRequestDTO.getNome());
        modelo.setValorFipe(modeloRequestDTO.getValorFipe());

        //Adicionar lógica adicional aqui, por exemplo, associar a marca ao modelo.

        return modeloRepository.save(modelo);
    }

    public Modelo obterModeloPorId(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    //Adicionar tratamento de exceções, validações e lógica de negócios

}
