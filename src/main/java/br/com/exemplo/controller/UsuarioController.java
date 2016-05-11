package br.com.exemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.entity.Usuario;
import br.com.exemplo.sevice.AbstractService;
import br.com.exemplo.sevice.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends AbstractController<Usuario, Long>{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	protected AbstractService<Usuario, Long> getService() {
		return usuarioService;		
	}
}