package br.com.wsworks.Cars.controller;

import br.com.wsworks.Cars.dto.ModeloRequestDTO;
import br.com.wsworks.Cars.dto.ModeloResponseDTO;
import br.com.wsworks.Cars.entity.ModeloEntity;
import br.com.wsworks.Cars.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelos")
@CrossOrigin(origins = "*")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ResponseEntity<ModeloResponseDTO> criarModelo(@RequestBody ModeloRequestDTO modeloRequestDTO) {
        ModeloEntity modeloEntity = modeloService.criarModelo(modeloRequestDTO);

        // Mapeie a entidade resultante para a DTO de resposta
        ModeloResponseDTO modeloResponseDTO = new ModeloResponseDTO();
        modeloResponseDTO.setId(modeloEntity.getId());
        modeloResponseDTO.setNome(modeloEntity.getNome());
        modeloResponseDTO.setValorFipe(modeloEntity.getValorFipe());

        //Adicionar mapeamento adicional, como a marca associada, se necessário.

        return new ResponseEntity<>(modeloResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloResponseDTO> obterModelo(@PathVariable Long id) {
        ModeloEntity modeloEntity = modeloService.obterModeloPorId(id);

        if (modeloEntity != null) {
            // Mapeie a entidade para a DTO de resposta
            ModeloResponseDTO modeloResponseDTO = new ModeloResponseDTO();
            modeloResponseDTO.setId(modeloEntity.getId());
            modeloResponseDTO.setNome(modeloEntity.getNome());
            modeloResponseDTO.setValorFipe(modeloEntity.getValorFipe());

            // Adicionar mapeamento adicional, como a marca associada, se necessário.

            return ResponseEntity.ok(modeloResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
