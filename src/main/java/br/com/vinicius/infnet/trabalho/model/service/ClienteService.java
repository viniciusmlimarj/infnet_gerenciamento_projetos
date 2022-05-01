package br.com.vinicius.infnet.trabalho.model.service;

import java.util.List;

import br.com.vinicius.infnet.trabalho.model.domain.Cliente;

public interface ClienteService {
	List<Cliente> listar();
	Cliente consultarPorId(Integer id);
	void salvar(Cliente usuario);
	void excluir(Integer id);
}