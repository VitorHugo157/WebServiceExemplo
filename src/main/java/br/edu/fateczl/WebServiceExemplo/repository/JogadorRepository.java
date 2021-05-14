package br.edu.fateczl.WebServiceExemplo.repository;

import br.edu.fateczl.WebServiceExemplo.model.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
    List<Jogador> findJogadoresDataConv();
    Jogador findJogadorDataConv(Integer cod);
}
