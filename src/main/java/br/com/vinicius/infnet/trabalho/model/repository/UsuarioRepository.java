package br.com.vinicius.infnet.trabalho.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.infnet.trabalho.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u where email = :email and senha = :senha")
	Usuario validarUsuario(String email, String senha);
	
	List<Usuario> findAll(Sort by);
	List<Usuario> findByPerfilId(Integer id);
	List<Usuario> findByProjetosId(Integer id);
}