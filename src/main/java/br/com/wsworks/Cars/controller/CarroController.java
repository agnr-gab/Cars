package br.com.wsworks.Cars.controller;

import br.com.wsworks.Cars.dto.CarroRequestDTO;
import br.com.wsworks.Cars.dto.CarroResponseDTO;
import br.com.wsworks.Cars.entity.CarroEntity;
import br.com.wsworks.Cars.mapper.CarroMapper;
import br.com.wsworks.Cars.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@CrossOrigin(origins = "*")
public class CarroController {

    @Autowired
    private CarroService carroService;
    @Autowired
    private CarroMapper carroMapper;

    @PostMapping
    public ResponseEntity<CarroResponseDTO> criarCarro(@RequestBody CarroRequestDTO carroRequestDTO) {
        CarroEntity carroEntity = new CarroEntity();
        carroEntity.setTimestampCadastro(carroRequestDTO.getTimestampCadastro());

        CarroEntity novoCarroEntity = carroService.criarCarro(carroRequestDTO);
        CarroResponseDTO carroResponseDTO = new CarroResponseDTO();
        carroResponseDTO.setId(novoCarroEntity.getId());

        return new ResponseEntity<>(carroResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> obterCarro(@PathVariable Long id) {
        CarroResponseDTO carroResponseDTO1 = carroService.obterCarroPorId(id);

        if (carroResponseDTO1 != null) {

            CarroResponseDTO carroResponseDTO = new CarroResponseDTO();
            carroResponseDTO.setId(carroResponseDTO1.getId());

            return ResponseEntity.ok(carroResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CarroResponseDTO>> listarCarros() {
        List<CarroResponseDTO> carros = carroService.listarCarros();
        return ResponseEntity.ok(carros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroEntity> atualizarCarro(@PathVariable Long id, @RequestBody CarroRequestDTO carroRequestDTO) {
        CarroEntity carroAtualizado = carroService.atualizarCarro(id, carroRequestDTO);
        if (carroAtualizado != null) {
            return ResponseEntity.ok(carroAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarro(@PathVariable Long id) {
        carroService.excluirCarro(id);
        return ResponseEntity.noContent().build();
    }

}
