package br.com.wsworks.Cars.service;

import br.com.wsworks.Cars.dto.MarcaRequestDTO;
import br.com.wsworks.Cars.entity.MarcaEntity;
import br.com.wsworks.Cars.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public MarcaEntity criarMarca(MarcaRequestDTO marcaRequestDTO) {
        MarcaEntity marcaEntity = new MarcaEntity();
        marcaEntity.setNomeMarca(marcaRequestDTO.getNomeMarca());
        return marcaRepository.save(marcaEntity);
    }

    public MarcaEntity obterMarcaPorId(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public List<MarcaEntity> listarTodasAsMarcas() {
        return marcaRepository.findAll();
    }
}
