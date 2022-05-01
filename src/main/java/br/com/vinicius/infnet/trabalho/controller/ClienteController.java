package br.com.vinicius.infnet.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.vinicius.infnet.trabalho.model.domain.Cliente;
import br.com.vinicius.infnet.trabalho.model.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/cliente")
	public String listar(Model model) {
		model.addAttribute("lista", clienteService.listar());
		return "cliente/lista";
	}
	
	@GetMapping(value = "/cliente/novo")
	public String exibirInclusao(Model model) {
		return "cliente/edicao";
	}
	
	@GetMapping(value = "/cliente/{id}")
	public String consultar(Model model, @PathVariable Integer id) {
		model.addAttribute("cliente", clienteService.consultarPorId(id));
		return "cliente/edicao";
	}
	
	@PostMapping(value = "/cliente/salvar") 
	public String salvar(Model model, Cliente cliente) {
		String mensagem;
		if (cliente.getId() != null) {
			mensagem = "Cliente alterado com sucesso.";
		} else {
			mensagem = "Cliente incluído com sucesso.";
		}
		clienteService.salvar(cliente);
		model.addAttribute("mensagem", mensagem);
		return "redirect:/cliente";
	}
	
	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		clienteService.excluir(id);
		model.addAttribute("mensagem", "Cliente excluído com sucesso.");
		return "redirect:/cliente";
	}
}