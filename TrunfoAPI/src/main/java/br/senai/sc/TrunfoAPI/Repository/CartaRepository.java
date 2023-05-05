package br.senai.sc.TrunfoAPI.Repository;

import br.senai.sc.TrunfoAPI.Model.Entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta,Long> {
}
