package br.com.vinicius.infnet.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.vinicius.infnet.trabalho.model.domain.Tarefa;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.ProjetoService;
import br.com.vinicius.infnet.trabalho.model.service.TarefaService;
import br.com.vinicius.infnet.trabalho.model.service.UsuarioService;

@Controller
public class TarefaController {
	
	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/tarefa")
	public String listar(Model model, @SessionAttribute("usuarioLogado") Usuario usuario) {
		if (usuario.getPerfil().isAdministrador()) {
			model.addAttribute("lista", tarefaService.listar());
		} else if (usuario.getPerfil().isGerente()) {
			model.addAttribute("lista", tarefaService.listarPorGerente(usuario.getId()));
		} else {
			model.addAttribute("lista", tarefaService.listarPorUsuario(usuario.getId()));
		}

		return "tarefa/lista";
	}
	
	@GetMapping(value = "/tarefa/novo")
	public String exibirInclusao(Model model, Integer idProjeto, @SessionAttribute("usuarioLogado") Usuario usuario) {
		if (idProjeto != null) {
			model.addAttribute("idProjeto", idProjeto);
		} else {
			if (usuario.getPerfil().isAdministrador() ) {
				model.addAttribute("projetos", projetoService.listar());
			} else if (usuario.getPerfil().isGerente()) {
				model.addAttribute("projetos", projetoService.listarProjetosPorGerente(usuario.getId()));
			} else {
				model.addAttribute("projetos", projetoService.listarProjetosPorFuncionario(idProjeto));
			}
		}
		
		if (!usuario.getPerfil().isAdministrador() && !usuario.getPerfil().isGerente()) {
			model.addAttribute("idFuncionario", usuario.getId());
		}
		
		model.addAttribute("funcionarios", usuarioService.listarFuncionarios());
		
		return "tarefa/edicao";
	}
	
	@GetMapping(value = "/tarefa/{id}")
	public String consultar(Model model, @PathVariable Integer id, @SessionAttribute("usuarioLogado") Usuario usuario) {
		if (!usuario.getPerfil().isAdministrador() && !usuario.getPerfil().isGerente()) {
			model.addAttribute("idFuncionario", usuario.getId());
		}
		model.addAttribute("funcionarios", usuarioService.listarFuncionarios());
		
		Tarefa tarefa = tarefaService.consultarPorId(id);
		model.addAttribute("tarefa", tarefa);
		model.addAttribute("idProjeto", tarefa.getProjeto().getId());
		return "tarefa/edicao";
	}
	
	@PostMapping(value = "/tarefa/salvar") 
	public String salvar(Model model, Tarefa tarefa) {
		String mensagem;
		if (tarefa.getId() != null) {
			mensagem = "Tarefa alterada com sucesso.";
		} else {
			mensagem = "Tarefa incluída com sucesso.";
		}
		tarefaService.salvar(tarefa);
		model.addAttribute("mensagem", mensagem);
		return "redirect:/tarefa";
	}
	
	@GetMapping(value = "/tarefa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		tarefaService.excluir(id);
		model.addAttribute("mensagem", "Tarefa excluída com sucesso.");
		return "redirect:/tarefa";
	}
}