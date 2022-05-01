package br.com.vinicius.infnet.trabalho.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.infnet.trabalho.model.domain.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Integer> {

	List<Tarefa> findByProjetoId(Integer id);
	
	@Query("from Tarefa t where t.projeto.gerente.id = :id")
	List<Tarefa> findByGerente(Integer id);
	
	@Query("from Tarefa t where t.funcionario.id = :id")
	List<Tarefa> findAll(Integer id);
	
	List<Tarefa> findAll();
}