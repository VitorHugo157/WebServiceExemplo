package br.edu.fateczl.WebServiceExemplo.repository;

import br.edu.fateczl.WebServiceExemplo.model.entity.Times;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface TimesRepository extends JpaRepository<Times, Integer> {
    @Procedure(name = "Times.spCrudTimes")
    String spCrudTimes(@Param("cod") String cod, @Param("id") Integer id,
                       @Param("nome") String nome, @Param("cidade") String cidade);
}
