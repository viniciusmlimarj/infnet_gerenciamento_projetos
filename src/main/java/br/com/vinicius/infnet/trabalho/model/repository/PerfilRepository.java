package br.com.vinicius.infnet.trabalho.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.infnet.trabalho.model.domain.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer> {
	List<Perfil> findAll(Sort by);
}