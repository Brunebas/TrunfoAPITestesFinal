package br.senai.sc.TrunfoAPI.Repository;

import br.senai.sc.TrunfoAPI.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
