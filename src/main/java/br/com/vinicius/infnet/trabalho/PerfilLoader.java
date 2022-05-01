package br.com.vinicius.infnet.trabalho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.vinicius.infnet.trabalho.model.domain.Perfil;
import br.com.vinicius.infnet.trabalho.model.service.PerfilService;

@Order(1)
@Component
public class PerfilLoader implements ApplicationRunner {
	
	@Autowired
	private PerfilService perfilService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (perfilService.listar().size() == 0) {
			perfilService.salvar(new Perfil(1, "Administrador"));
			perfilService.salvar(new Perfil(2, "Gerente de Projeto"));
			perfilService.salvar(new Perfil(3, "Funcionário"));
		}
	}
}