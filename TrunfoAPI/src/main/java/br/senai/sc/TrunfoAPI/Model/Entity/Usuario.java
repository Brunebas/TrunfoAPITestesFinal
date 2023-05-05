package br.senai.sc.TrunfoAPI.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nick;
    private String senha;
    @ManyToMany
    @JoinColumn(name = "id_user")
    private List<Carta> baralho;
}
