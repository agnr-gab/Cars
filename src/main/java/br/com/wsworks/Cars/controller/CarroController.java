package br.com.wsworks.Cars.controller;

import br.com.wsworks.Cars.dto.CarroRequestDTO;
import br.com.wsworks.Cars.dto.CarroResponseDTO;
import br.com.wsworks.Cars.entity.Carro;
import br.com.wsworks.Cars.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
@CrossOrigin(origins = "*")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<CarroResponseDTO> criarCarro(@RequestBody CarroRequestDTO carroRequestDTO) {
        Carro carro = new Carro();
        carro.setTimestampCadastro(carroRequestDTO.getTimestampCadastro());

        Carro novoCarro = carroService.criarCarro(carroRequestDTO);
        CarroResponseDTO carroResponseDTO = new CarroResponseDTO();
        carroResponseDTO.setId(novoCarro.getId());

        return new ResponseEntity<>(carroResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> obterCarro(@PathVariable Long id) {
        Carro carro = carroService.obterCarroPorId(id);

        if (carro != null) {
            // Mapear a entidade para a DTO de resposta
            CarroResponseDTO carroResponseDTO = new CarroResponseDTO();
            carroResponseDTO.setId(carro.getId());
            // Mapear outros campos da entidade para a DTO de resposta.

            return ResponseEntity.ok(carroResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
