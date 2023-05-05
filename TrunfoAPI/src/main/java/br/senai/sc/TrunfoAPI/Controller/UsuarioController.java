package br.senai.sc.TrunfoAPI.Controller;

import br.senai.sc.TrunfoAPI.Model.DTO.UsuarioDTO;
import br.senai.sc.TrunfoAPI.Model.Entity.Carta;
import br.senai.sc.TrunfoAPI.Model.Entity.Usuario;
import br.senai.sc.TrunfoAPI.Service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> cadastro(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return ResponseEntity.ok(usuarioService.cadastro(usuario));
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping("/buscarUm/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> editar(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioService.buscar(id);
        BeanUtils.copyProperties(usuarioDTO,usuario);
        return ResponseEntity.ok(usuarioService.editar(usuario));
    }
}
