package br.com.vinicius.infnet.trabalho.model.service;

import java.util.List;

import br.com.vinicius.infnet.trabalho.model.domain.Tarefa;

public interface TarefaService {
	List<Tarefa> listar();
	List<Tarefa> listarPorGerente(Integer idGerente);
	List<Tarefa> listarPorProjeto(Integer idProjeto);
	List<Tarefa> listarPorUsuario(Integer idUsuario);
	Tarefa consultarPorId(Integer id);
	void salvar(Tarefa usuario);
	void excluir(Integer id);
}