package br.edu.fateczl.WebServiceExemplo.repository;

import br.edu.fateczl.WebServiceExemplo.model.entity.JogadorTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorTimeRepository extends JpaRepository<JogadorTime, Integer> {
    JogadorTime udfJogadorIdade(Integer cod);
}
