package br.com.vinicius.infnet.trabalho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.PerfilService;
import br.com.vinicius.infnet.trabalho.model.service.UsuarioService;

@Order(2)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		String email = "vinicius.lima@al.infnet.edu.br";
		String senha = "P@ssw0rd";
		
		if (usuarioService.validar(email, senha) == null) {
			Usuario usuario = new Usuario();
			usuario.setPerfil(perfilService.consultarPorId(1));
			usuario.setEmail(email);
			usuario.setNome("Vinicius Mello Lima");
			usuario.setSenha(senha);
			usuarioService.salvar(usuario);
		}		
	}
}