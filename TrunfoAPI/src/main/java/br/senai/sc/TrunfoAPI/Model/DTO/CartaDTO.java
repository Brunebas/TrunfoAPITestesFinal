package br.senai.sc.TrunfoAPI.Model.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaDTO {
    private String nome;
    private int vida;
    private int dano;
    private int idade;
    private int beleza;
}
