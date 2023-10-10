package br.com.wsworks.Cars.service;

import br.com.wsworks.Cars.dto.MarcaRequestDTO;
import br.com.wsworks.Cars.entity.Marca;
import br.com.wsworks.Cars.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public Marca criarMarca(MarcaRequestDTO marcaRequestDTO) {
        Marca marca = new Marca();
        marca.setNomeMarca(marcaRequestDTO.getNomeMarca());
        return marcaRepository.save(marca);
    }

    public Marca obterMarcaPorId(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public List<Marca> listarTodasAsMarcas() {
        return marcaRepository.findAll();
    }
}
