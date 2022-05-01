package br.com.vinicius.infnet.trabalho.model.service;

import java.util.List;

import br.com.vinicius.infnet.trabalho.model.domain.Perfil;

public interface PerfilService {
	List<Perfil> listar();
	Perfil consultarPorId(Integer id);
	void salvar(Perfil perfil);
}