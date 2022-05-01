package br.com.vinicius.infnet.trabalho.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.infnet.trabalho.model.domain.Projeto;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Integer> {
	
	@Query("from Projeto p where p.gerente.id = :id")
	List<Projeto> findAll(Integer id, Sort by);
	
	List<Projeto> findByRecursosId(Integer id, Sort by);
	
	List<Projeto> findAll(Sort by);
}