package br.com.wsworks.Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloRequestDTO {
    private Long id;
    private MarcaResponseDTO marca;
    private String nome;
    private double valorFipe;
}
