package br.com.vinicius.infnet.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.vinicius.infnet.trabalho.model.domain.Projeto;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.ClienteService;
import br.com.vinicius.infnet.trabalho.model.service.ProjetoService;
import br.com.vinicius.infnet.trabalho.model.service.TarefaService;
import br.com.vinicius.infnet.trabalho.model.service.UsuarioService;

@Controller
public class ProjetoController {
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TarefaService tarefaService;

	private void listarInterno(Model model, Usuario usuario) {
		if (usuario.getPerfil().isAdministrador()) {
			model.addAttribute("lista", projetoService.listar());
		} else if (usuario.getPerfil().isGerente()) {
			model.addAttribute("lista", projetoService.listarProjetosPorGerente(usuario.getId()));
		} else {
			model.addAttribute("lista", projetoService.listarProjetosPorFuncionario(usuario.getId()));
		}
	}
	
	@GetMapping(value = "/projeto")
	public String listar(Model model, @SessionAttribute("usuarioLogado") Usuario usuario) {
		listarInterno(model, usuario);
		return "projeto/lista";
	}
	
	@GetMapping(value = "/projeto/novo")
	public String exibirInclusao(Model model) {
		model.addAttribute("gerentes", usuarioService.listarGerentes());
		model.addAttribute("clientes", clienteService.listar());
		return "projeto/edicao";
	}
	
	@GetMapping(value = "/projeto/{id}")
	public String consultar(Model model, @PathVariable Integer id) {
		model.addAttribute("gerentes", usuarioService.listarGerentes());
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("projeto", projetoService.consultarPorId(id));
		return "projeto/edicao";
	}
	
	@PostMapping(value = "/projeto/salvar") 
	public String salvar(Model model, Projeto projeto, @SessionAttribute("usuarioLogado") Usuario usuario) {
		if (usuario.getPerfil().isGerente()) {
			projeto.setGerente(usuario);
		}
		
		String mensagem = null;
		if (projeto.getId() != null) {
			mensagem = "Projeto alterado com sucesso.";
		} else {
			mensagem = "Projeto incluído com sucesso.";
		}
		projetoService.salvar(projeto);
		model.addAttribute("mensagem", mensagem);
		return "redirect:/projeto";
	}
	
	@GetMapping(value = "/projeto/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		projetoService.excluir(id);
		model.addAttribute("mensagem", "Projeto excluído com sucesso.");
		return "redirect:/projeto";
	}
	
	@GetMapping(value = "/projeto/{id}/iniciar")
	public String iniciar(Model model, @PathVariable Integer id, @SessionAttribute("usuarioLogado") Usuario usuario) {
		projetoService.iniciar(id);
		listarInterno(model, usuario);
		model.addAttribute("mensagem", "Projeto iniciado com sucesso.");
		return "redirect:/projeto";
	}
	
	@GetMapping(value = "/projeto/{id}/tarefa")
	public String tarefas(Model model, @PathVariable Integer id) {
		model.addAttribute("idProjeto", id);
		model.addAttribute("lista", tarefaService.listarPorProjeto(id));
		return "tarefa/lista";
	}
	
	@GetMapping(value = "/projeto/{id}/recurso")
	public String recursos(Model model, @PathVariable Integer id) {
		model.addAttribute("idProjeto", id);
		model.addAttribute("funcionarios", usuarioService.listarFuncionarios());
		model.addAttribute("lista", usuarioService.listarPorProjeto(id));
		return "recurso/lista";
	}
	
	@PostMapping(value = "/projeto/{idProjeto}/recurso/associar")
	public String associarRecurso(Model model, @PathVariable Integer idProjeto, Integer idRecurso) {
		projetoService.associarRecurso(idProjeto, idRecurso);
		model.addAttribute("idProjeto", idProjeto);
		model.addAttribute("funcionarios", usuarioService.listarFuncionarios());
		model.addAttribute("lista", usuarioService.listarPorProjeto(idProjeto));
		return "recurso/lista";
	}
	
	@GetMapping(value = "/projeto/{idProjeto}/recurso/{idRecurso}/excluir")
	public String excluir(Model model, @PathVariable Integer idProjeto, @PathVariable Integer idRecurso) {
		projetoService.excluirRecurso(idProjeto, idRecurso);
		model.addAttribute("idProjeto", idProjeto);
		model.addAttribute("funcionarios", usuarioService.listarFuncionarios());
		model.addAttribute("lista", usuarioService.listarPorProjeto(idProjeto));
		return "recurso/lista";
	}
}