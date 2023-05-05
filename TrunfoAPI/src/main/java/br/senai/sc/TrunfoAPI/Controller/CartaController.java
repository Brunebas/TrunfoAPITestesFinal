package br.senai.sc.TrunfoAPI.Controller;

import br.senai.sc.TrunfoAPI.Model.Entity.Carta;
import br.senai.sc.TrunfoAPI.Model.DTO.CartaDTO;
import br.senai.sc.TrunfoAPI.Service.CartaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/carta")
public class CartaController {
    private final CartaService cartaService;

    @PostMapping("/criar")
    public ResponseEntity<Carta> cadastro(@RequestBody CartaDTO cartaDTO) {
        Carta carta = new Carta();
        BeanUtils.copyProperties(cartaDTO, carta);
        return ResponseEntity.ok(cartaService.cadastro(carta));
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Carta>> buscarTodos() {
        return ResponseEntity.ok(cartaService.buscarTodos());
    }

    @GetMapping("/buscarUm/{id}")
    public ResponseEntity<Carta> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(cartaService.buscar(id));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        cartaService.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Carta> editar(@PathVariable Long id,@RequestBody CartaDTO cartaDTO){
        Carta carta = cartaService.buscar(id);
        BeanUtils.copyProperties(cartaDTO,carta);
        return ResponseEntity.ok(cartaService.editar(carta));
    }

}
