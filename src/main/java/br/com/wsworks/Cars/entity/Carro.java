package br.com.wsworks.Cars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Entity
@Table(name = "carros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timestampCadastro;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;

}
