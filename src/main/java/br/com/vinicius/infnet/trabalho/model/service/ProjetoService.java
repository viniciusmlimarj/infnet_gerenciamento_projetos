package br.com.vinicius.infnet.trabalho.model.service;

import java.util.List;

import br.com.vinicius.infnet.trabalho.model.domain.Projeto;

public interface ProjetoService {
	List<Projeto> listarProjetosPorGerente(Integer id);
	List<Projeto> listarProjetosPorFuncionario(Integer id);
	List<Projeto> listar();
	Projeto consultarPorId(Integer id);
	void salvar(Projeto usuario);
	void excluir(Integer id);
	void iniciar(Integer id);
	void associarRecurso(Integer idProjeto, Integer idRecurso);
	void excluirRecurso(Integer idProjeto, Integer idRecurso);
}