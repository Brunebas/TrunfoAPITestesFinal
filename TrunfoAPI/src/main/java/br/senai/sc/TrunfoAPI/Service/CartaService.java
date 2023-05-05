package br.senai.sc.TrunfoAPI.Service;

import br.senai.sc.TrunfoAPI.Model.Entity.Carta;
import br.senai.sc.TrunfoAPI.Repository.CartaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartaService {

    private CartaRepository cartaRepository;


    public Carta cadastro(Carta carta) {
        return cartaRepository.save(carta);
    }

    public List<Carta> buscarTodos() {
        return cartaRepository.findAll();
    }

    public Carta editar(Carta carta) {
        return cartaRepository.save(carta);
    }

    public Carta buscar(Long id) {
        return cartaRepository.findById(id).get();
    }

    public void excluir(Long id) {
        cartaRepository.deleteById(id);
    }
}
