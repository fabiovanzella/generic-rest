package br.com.exemplo.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.exemplo.entity.Usuario;
import br.com.exemplo.repository.UsuarioRepository;

@Service
public class UsuarioService extends AbstractService<Usuario, Long>{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	protected JpaRepository<Usuario, Long> getRepository() {		
		return usuarioRepository;
	}
}