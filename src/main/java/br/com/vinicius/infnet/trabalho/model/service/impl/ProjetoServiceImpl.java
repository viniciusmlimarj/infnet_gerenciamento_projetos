package br.com.vinicius.infnet.trabalho.model.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Projeto;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.repository.ProjetoRepository;
import br.com.vinicius.infnet.trabalho.model.service.ProjetoService;
import br.com.vinicius.infnet.trabalho.model.service.UsuarioService;

@Service
public class ProjetoServiceImpl implements ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public List<Projeto> listarProjetosPorGerente(Integer id) {
		return projetoRepository.findAll(id, Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	
	@Override
	public List<Projeto> listarProjetosPorFuncionario(Integer id) {
		return projetoRepository.findByRecursosId(id, Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	@Override
	public List<Projeto> listar() {
		return projetoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	@Override
	public Projeto consultarPorId(Integer id) {
		return projetoRepository.findById(id).orElseGet(null);
	}
	
	@Override
	public void salvar(Projeto projeto) {
		projetoRepository.save(projeto);
	}
	
	@Override
	public void excluir(Integer id) {
		projetoRepository.deleteById(id);
	}
	
	@Override
	public void iniciar(Integer id) {
		Projeto projeto = consultarPorId(id);
		projeto.setIniciado(true);
		projeto.setDataInicio(LocalDate.now());
		salvar(projeto);
	}
	
	@Override
	public void associarRecurso(Integer idProjeto, Integer idRecurso) {
		Projeto projeto = consultarPorId(idProjeto);
		Usuario usuario = usuarioService.consultarPorId(idRecurso);
		
		List<Usuario> recursos = projeto.getRecursos();
		recursos.add(usuario);
		projeto.setRecursos(recursos);
		
		salvar(projeto);
	}
	
	@Override
	public void excluirRecurso(Integer idProjeto, Integer idRecurso) {
		Projeto projeto = consultarPorId(idProjeto);
		Usuario usuario = usuarioService.consultarPorId(idRecurso);
		
		List<Usuario> recursos = projeto.getRecursos();
		recursos.remove(usuario);
		projeto.setRecursos(recursos);
		
		salvar(projeto);
	}
}