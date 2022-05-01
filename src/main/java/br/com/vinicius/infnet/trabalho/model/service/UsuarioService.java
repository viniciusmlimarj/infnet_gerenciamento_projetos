package br.com.vinicius.infnet.trabalho.model.service;

import java.util.List;

import br.com.vinicius.infnet.trabalho.model.domain.Usuario;

public interface UsuarioService {
	Usuario validar(String email, String senha);
	List<Usuario> listarPorProjeto(Integer id);
	List<Usuario> listarGerentes();
	List<Usuario> listarFuncionarios();
	List<Usuario> listar();
	Usuario consultarPorId(Integer id);
	void salvar(Usuario usuario);
	void excluir(Integer id);
}