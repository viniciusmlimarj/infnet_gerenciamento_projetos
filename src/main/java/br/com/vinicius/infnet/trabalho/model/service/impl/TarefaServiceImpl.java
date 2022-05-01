package br.com.vinicius.infnet.trabalho.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Tarefa;
import br.com.vinicius.infnet.trabalho.model.repository.TarefaRepository;
import br.com.vinicius.infnet.trabalho.model.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;

	@Override
	public List<Tarefa> listar() {
		return tarefaRepository.findAll();
	}
	
	@Override
	public List<Tarefa> listarPorGerente(Integer idGerente) {
		return tarefaRepository.findByGerente(idGerente);
	}
	
	@Override
	public List<Tarefa> listarPorProjeto(Integer idProjeto) {
		return tarefaRepository.findByProjetoId(idProjeto);
	}
	
	@Override
	public List<Tarefa> listarPorUsuario(Integer idUsuario) {
		return tarefaRepository.findAll(idUsuario);
	}
	
	@Override
	public Tarefa consultarPorId(Integer id) {
		return tarefaRepository.findById(id).orElseGet(null);
	}
	
	@Override
	public void salvar(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}
	
	@Override
	public void excluir(Integer id) {
		tarefaRepository.deleteById(id);
	}
}