package br.com.wsworks.Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaRequestDTO {
    private Long id;
    private String nomeMarca;
}
