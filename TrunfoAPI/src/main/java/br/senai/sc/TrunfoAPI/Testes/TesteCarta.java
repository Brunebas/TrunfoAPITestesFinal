package br.senai.sc.TrunfoAPI.Testes;

import br.senai.sc.TrunfoAPI.Controller.CartaController;
import br.senai.sc.TrunfoAPI.Model.DTO.CartaDTO;
import br.senai.sc.TrunfoAPI.Model.Entity.Carta;
import br.senai.sc.TrunfoAPI.Service.CartaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TesteCarta {

    @InjectMocks
    private CartaController cartaController;

    @Mock
    private CartaService cartaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastro() {
        CartaDTO cartaDTO = new CartaDTO();
        Carta carta = new Carta();
        when(cartaService.cadastro(any(Carta.class))).thenReturn(carta);
        ResponseEntity<Carta> response = cartaController.cadastro(cartaDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(carta, response.getBody());
        verify(cartaService).cadastro(any(Carta.class));
    }

    @Test
    public void testBuscarTodos() {
        List<Carta> cartas = Arrays.asList(new Carta(), new Carta());
        when(cartaService.buscarTodos()).thenReturn(cartas);
        ResponseEntity<List<Carta>> response = cartaController.buscarTodos();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cartas, response.getBody());
        verify(cartaService).buscarTodos();
    }

    @Test
    public void testBuscar() {
        Long id = 1L;
        Carta carta = new Carta();
        when(cartaService.buscar(id)).thenReturn(carta);
        ResponseEntity<Carta> response = cartaController.buscar(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(carta, response.getBody());
        verify(cartaService).buscar(id);
    }

    @Test
    public void testExcluir() {
        Long id = 1L;
        cartaController.excluir(id);
        verify(cartaService).excluir(id);
    }

    @Test
    public void testEditar() {
        Long id = 1L;
        CartaDTO cartaDTO = new CartaDTO();
        Carta carta = new Carta();
        when(cartaService.buscar(id)).thenReturn(carta);
        when(cartaService.editar(any(Carta.class))).thenReturn(carta);
        ResponseEntity<Carta> response = cartaController.editar(id, cartaDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(carta, response.getBody());
        verify(cartaService).buscar(id);
        verify(cartaService).editar(any(Carta.class));
    }
}
