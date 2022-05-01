package br.com.vinicius.infnet.trabalho.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.repository.UsuarioRepository;
import br.com.vinicius.infnet.trabalho.model.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario validar(String email, String senha) {
		return usuarioRepository.validarUsuario(email, senha);
	}
	
	@Override
	public List<Usuario> listar() {
		return usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	@Override
	public List<Usuario> listarPorProjeto(Integer id) {
		return usuarioRepository.findByProjetosId(id);
	}
	
	@Override
	public List<Usuario> listarGerentes() {
		return usuarioRepository.findByPerfilId(2);
	}
	
	@Override
	public List<Usuario> listarFuncionarios() {
		return usuarioRepository.findByPerfilId(3);
	}
	
	@Override
	public Usuario consultarPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			return null;
		}
	}
	
	@Override
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@Override
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}
}