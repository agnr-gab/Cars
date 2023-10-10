package br.com.wsworks.Cars.controller;

import br.com.wsworks.Cars.entity.Marca;
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
    public Marca criarMarca(@RequestBody Marca marca) {
        return marcaRepository.save(marca);
    }

    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    // Outros endpoints (PUT, DELETE)

}
