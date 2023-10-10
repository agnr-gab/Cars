package br.com.wsworks.Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroResponseDTO {
    private Long id;
    private Timestamp timestampCadastro;
    private ModeloResponseDTO modelo;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;
}
