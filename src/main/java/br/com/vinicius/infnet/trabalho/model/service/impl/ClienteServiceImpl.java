package br.com.vinicius.infnet.trabalho.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Cliente;
import br.com.vinicius.infnet.trabalho.model.repository.ClienteRepository;
import br.com.vinicius.infnet.trabalho.model.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	@Override
	public Cliente consultarPorId(Integer id) {
		return clienteRepository.findById(id).orElseGet(null);
	}
	
	@Override
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@Override
	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}
}