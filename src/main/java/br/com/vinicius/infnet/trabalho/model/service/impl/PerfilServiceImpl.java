package br.com.vinicius.infnet.trabalho.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Perfil;
import br.com.vinicius.infnet.trabalho.model.repository.PerfilRepository;
import br.com.vinicius.infnet.trabalho.model.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Override
	public List<Perfil> listar() {
		return perfilRepository.findAll(Sort.by("nome"));
	}
	
	@Override
	public Perfil consultarPorId(Integer id) {
		return perfilRepository.findById(id).orElseGet(null);
	}

	@Override
	public void salvar(Perfil perfil) {
		perfilRepository.save(perfil);
	}
}