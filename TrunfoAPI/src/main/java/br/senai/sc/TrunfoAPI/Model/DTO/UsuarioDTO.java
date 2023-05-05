package br.senai.sc.TrunfoAPI.Model.DTO;

import br.senai.sc.TrunfoAPI.Model.Entity.Carta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nick;
    private String senha;
    private List<Carta> baralho;
}
