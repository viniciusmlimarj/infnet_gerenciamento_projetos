package br.com.vinicius.infnet.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.PerfilService;
import br.com.vinicius.infnet.trabalho.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping(value = "/usuario")
	public String listar(Model model) {
		model.addAttribute("lista", usuarioService.listar());
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario/novo")
	public String exibirInclusao(Model model) {
		model.addAttribute("perfis", perfilService.listar());
		return "usuario/edicao";
	}
	
	@GetMapping(value = "/usuario/{id}")
	public String consultar(Model model, @PathVariable Integer id) {
		model.addAttribute("perfis", perfilService.listar());
		model.addAttribute("usuario", usuarioService.consultarPorId(id));
		return "usuario/edicao";
	}
	
	@PostMapping(value = "/usuario/salvar") 
	public String salvar(Model model, Usuario usuario) {
		String mensagem;
		if (usuario.getId() != null) {
			mensagem = "Usuário alterado com sucesso.";
		} else {
			mensagem = "Usuário incluído com sucesso.";
		}
		usuarioService.salvar(usuario);
		model.addAttribute("mensagem", mensagem);
		return "redirect:/usuario";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		usuarioService.excluir(id);
		model.addAttribute("mensagem", "Usuário excluído com sucesso.");
		return "redirect:/usuario";
	}
}