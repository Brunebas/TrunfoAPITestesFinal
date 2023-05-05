package br.senai.sc.TrunfoAPI.Testes;
import br.senai.sc.TrunfoAPI.Controller.UsuarioController;
import br.senai.sc.TrunfoAPI.Model.DTO.UsuarioDTO;
import br.senai.sc.TrunfoAPI.Model.Entity.Usuario;
import br.senai.sc.TrunfoAPI.Service.UsuarioService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserTest {
    private UsuarioDTO user;

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        user = new UsuarioDTO();
    }

    @Test
    public void testCadastro() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNick("john_doe");
        usuarioDTO.setSenha("123456");
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNick(usuarioDTO.getNick());
        usuario.setSenha(usuarioDTO.getSenha());
        when(usuarioService.cadastro(any(Usuario.class))).thenReturn(usuario);
        ResponseEntity<Usuario> response = usuarioController.cadastro(usuarioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(usuarioService).cadastro(any(Usuario.class));
    }

    @Test
    public void testBuscarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNick("john_doe");
        usuario1.setSenha("123456");
        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNick("jane_smith");
        usuario2.setSenha("abcdef");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        when(usuarioService.buscarTodos()).thenReturn(usuarios);
        ResponseEntity<List<Usuario>> response = usuarioController.buscarTodos();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarios, response.getBody());
        verify(usuarioService).buscarTodos();
    }
    @Test
    public void testBuscar() {
        Long usuarioId = 1L;

        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        usuario.setNick("john_doe");
        usuario.setSenha("123456");
        when(usuarioService.buscar(usuarioId)).thenReturn(usuario);
        ResponseEntity<Usuario> response = usuarioController.buscar(usuarioId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(usuarioService).buscar(usuarioId);
    }

    @Test
    public void testExcluir() {
        Long id = 1L;
        usuarioController.excluir(id);
        verify(usuarioService, times(1)).excluir(id);
    }

    @Test
    public void testEditar() {
        Long id = 1L;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Usuario usuario = new Usuario();
        when(usuarioService.buscar(id)).thenReturn(usuario);
        when(usuarioService.editar(any(Usuario.class))).thenReturn(usuario);
        ResponseEntity<Usuario> response = usuarioController.editar(id, usuarioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).buscar(id);
        verify(usuarioService, times(1)).editar(any(Usuario.class));
    }
}
