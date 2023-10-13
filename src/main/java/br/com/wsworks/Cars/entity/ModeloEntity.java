package br.com.wsworks.Cars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaEntity marcaEntity;
    private String nome;
    private double valorFipe;

}
