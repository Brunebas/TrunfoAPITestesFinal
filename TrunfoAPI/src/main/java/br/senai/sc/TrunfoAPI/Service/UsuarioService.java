package br.senai.sc.TrunfoAPI.Service;

import br.senai.sc.TrunfoAPI.Model.Entity.Carta;
import br.senai.sc.TrunfoAPI.Model.Entity.Usuario;
import br.senai.sc.TrunfoAPI.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {

    }

    public Usuario cadastro(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario editar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}
