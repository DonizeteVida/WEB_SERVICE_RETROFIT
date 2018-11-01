package br.com.donizete.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.donizete.services.ProdutoService;
import br.com.donizete.services.UsuarioService;

public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<>();
		recursos.add(ProdutoService.class);
		recursos.add(UsuarioService.class);
		return recursos;
	}
}
