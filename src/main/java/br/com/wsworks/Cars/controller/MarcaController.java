package br.com.wsworks.Cars.controller;

import br.com.wsworks.Cars.entity.MarcaEntity;
import br.com.wsworks.Cars.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @PostMapping
    public MarcaEntity criarMarca(@RequestBody MarcaEntity marcaEntity) {
        return marcaRepository.save(marcaEntity);
    }

    @GetMapping
    public List<MarcaEntity> listarMarcas() {
        return marcaRepository.findAll();
    }

    // Outros endpoints (PUT, DELETE)

}
